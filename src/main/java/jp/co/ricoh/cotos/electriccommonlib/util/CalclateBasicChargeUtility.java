package jp.co.ricoh.cotos.electriccommonlib.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.LowPressureType;
import lombok.Data;

/**
 * 基本料金計算ユーティリティ.
 */
@Component
public class CalclateBasicChargeUtility {

	/**
	 * 基本料金計算パラメータ.
	 */
	@Data
	public class CalclateParameter {
		/** 電力区分. */
		VoltageCategory voltageCategory;
		/** 低圧種別. */
		LowPressureType lowPressureType;
		/** 使用電力量. */
		BigDecimal useAmount;
		/** 基本料金単価. */
		BigDecimal basicPrice;
		/** 基本電力量. */
		BigDecimal basicPowerAmount;
		/** 力率(%). */
		BigDecimal powerRate;
		/** 日割り率(%). */
		BigDecimal dailyRate;
		/** 商流区分. */
		ElectricCommercialFlowDiv electricCommercialFlowDiv;
		/** 取次割引単価. */
		BigDecimal agencyDiscountPrice;
		/** 品種コード. */
		String itemCode;
		/** 長期割引率(%). */
		BigDecimal longtermDiscountRate;

		// 日割り率未指定時の計算用
		/** 料金計算開始日時. */
		Date feeClcStrDatTim;
		/** 料金計算終了日時. */
		Date feeClcEndDatTim;
		/** 料金計算対象開始日. */
		String feeClcStrYmd;
		/** 料金計算対象終了日. */
		String feeClcEndYmd;
	}

	/**
	 * パラメータインスタンス生成
	 * @return パラメータインスタンス
	 */
	public CalclateParameter createParameter() {
		return new CalclateParameter();
	}

	/**
	 * 基本料金計算.
	 * <pre>
	 * 仕入、仕切で使う値が異なるだけで計算式は同じ
	 * </pre>
	 *
	 * @param param
	 *            基本料金計算パラメータ
	 * @return 基本料金計算(小数第3位切捨)
	 * @throws ParseException
	 */
	public BigDecimal calculateBasicCharge(CalclateParameter param) throws ParseException {
		BigDecimal khnRyokin = BigDecimal.valueOf(0);
		BigDecimal dailyRate = param.getDailyRate();

		// 日割り率が未計算の場合は計算する
		if (dailyRate == null) {
			dailyRate = calculateDailyRate(param.getFeeClcStrDatTim(), param.getFeeClcEndDatTim(), param.getFeeClcStrYmd(), param.getFeeClcEndYmd());
		} else {
			dailyRate = dailyRate.divide(BigDecimal.valueOf(100));
		}

		if (VoltageCategory.高圧.equals(param.getVoltageCategory())) {
			// 高圧の場合
			if (BigDecimal.ZERO.equals(param.getUseAmount())) {
				// 料金計算数量が0の場合
				// 基本単価×基本電力量×日割り×0.5（小数第3位四捨五入）
				khnRyokin = param.getBasicPrice().multiply(param.getBasicPowerAmount()).multiply(dailyRate).multiply(BigDecimal.valueOf(0.5));
			} else {
				// 料金計算数量が0以外の場合
				// 基本単価×基本電力量×(1-(力率/100 - 0.85))×日割り
				BigDecimal tmp1 = param.getPowerRate().divide(BigDecimal.valueOf(100)).subtract(BigDecimal.valueOf(0.85));
				BigDecimal tmp2 = BigDecimal.valueOf(1).subtract(tmp1);
				khnRyokin = param.getBasicPrice().multiply(param.getBasicPowerAmount()).multiply(tmp2).multiply(dailyRate);
				// （１）商流区分＝４(取次)の場合
				if (ElectricCommercialFlowDiv.取次.equals(param.getElectricCommercialFlowDiv())) {
					// 計算結果、基本電力量、基本単価、基本電力量、取次割引単価、長期割引率、品種コード
					khnRyokin = calculateBasicFeeForAgency(khnRyokin, param.getBasicPowerAmount(), param.getBasicPrice(), param.getAgencyDiscountPrice(), param.getLongtermDiscountRate(), param.getItemCode());
				}
			}
		} else {
			// 低圧の場合
			if (LowPressureType.従量電灯1.equals(param.getLowPressureType())) {
				// 従量電灯1の場合
				// 基本単価×日割り
				khnRyokin = param.getBasicPrice().multiply(dailyRate);
			} else {
				// 従量電灯2,動力の場合
				// 基本単価×基本電力量×日割り
				khnRyokin = param.getBasicPrice().multiply(param.getBasicPowerAmount()).multiply(dailyRate);
			}
			if (BigDecimal.ZERO.equals(param.getUseAmount())) {
				// 料金計算数量が0の場合
				// 上記値×0.5
				khnRyokin = khnRyokin.multiply(BigDecimal.valueOf(0.5));
			}
		}
		return khnRyokin.setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * Date型をString型の日付に変換
	 *
	 * @param date
	 * @return
	 */
	public String convertDate(Date date) {
		String strDate = new SimpleDateFormat("yyyy/MM/dd").format(date);
		return strDate;
	}

	/**
	 * 日割りの値取得
	 *
	 * @param startDate
	 *            料金計算開始日時
	 * @param endDate
	 *            料金計算終了日時
	 * @param targetStartDate
	 *            料金計算対象開始日
	 * @param targetEndDate
	 *            料金計算対象終了日
	 * @return 日割り
	 * @throws ParseException
	 */
	private BigDecimal calculateDailyRate(Date startDate, Date endDate, String targetStartDate, String targetEndDate) throws ParseException {

		// 日割計算対象日数の算出
		int nissu1 = dateDiff(convertDate(startDate), convertDate(endDate));
		if (!targetStartDate.contains("/")) {
			targetStartDate = targetStartDate.substring(0, 4) + "/" + targetStartDate.substring(4, 6) + "/" + targetStartDate.substring(6, 8);
		}
		if (!targetEndDate.contains("/")) {
			targetEndDate = targetEndDate.substring(0, 4) + "/" + targetEndDate.substring(4, 6) + "/" + targetEndDate.substring(6, 8);
		}
		// 計量期間日数の算出
		int nissu2 = dateDiff(targetStartDate, targetEndDate);
		BigDecimal dailyRate = BigDecimal.valueOf(nissu1).divide(BigDecimal.valueOf(nissu2), 2, BigDecimal.ROUND_HALF_UP);
		return dailyRate;
	}

	/**
	 * 日付の日数計算
	 *
	 * @param dateFromStrig
	 * @param dateToString
	 * @return
	 * @throws ParseException
	 */
	private int dateDiff(String dateFromStrig, String dateToString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);

		Date dateTo = null;
		Date dateFrom = null;

		// Date型に変換
		dateFrom = sdf.parse(dateFromStrig);
		dateTo = sdf.parse(dateToString);

		// 差分の日数を計算
		long dateTimeTo = dateTo.getTime();
		long dateTimeFrom = dateFrom.getTime();
		long dayDiff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);

		// 返却値は日数の為、差分に＋1する
		return (int) dayDiff + 1;
	}

	/**
	 * 取次の基本料金計算
	 *
	 * @param calcRet
	 *            【処理１】の結果
	 * @param calcElem1
	 *            基本電力量
	 * @param calcElem2
	 *            基本単価
	 * @param agencyDiscountPrice
	 *            取次割引単価
	 * @param longtermDiscountRate
	 *            長期割引率
	 * @param Itemcode
	 *            品種コード
	 * @return 取次時の基本料金
	 */
	private BigDecimal calculateBasicFeeForAgency(BigDecimal calcRet, BigDecimal calcElem1, BigDecimal calcElem2, BigDecimal agencyDiscountPrice, BigDecimal longtermDiscountRate, String itemcode) {
		BigDecimal result = null;
		// 【処理１】の結果 －calcElem1 × 取次割引単価
		result = calcRet.subtract(calcElem1.multiply(agencyDiscountPrice.negate()));
		if (StringUtils.equals(itemcode, "915793") || StringUtils.equals(itemcode, "915794")) {
			// 上記の結果 －calcElem2 × calcElem1 × (長期割引率/100)
			result = result.subtract(calcElem2.multiply(calcElem1.multiply(longtermDiscountRate.divide(BigDecimal.valueOf(100)))));
		}
		return result;
	}

}
