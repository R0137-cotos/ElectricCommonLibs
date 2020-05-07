package jp.co.ricoh.cotos.electriccommonlib.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

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

		// 日割り率 ＞ 日割り率計算用（日数指定） ＞ 日割り率計算用（日時指定）のいずれか必須
		/** 日割り率(%). */
		BigDecimal dailyRate;

		// 日割り率計算用（日数指定）
		/** 料金計算日数. */
		Integer chargeCalcDays;
		/** 料金計算対象日数. */
		Integer chargeCalcTargetDays;

		// 日割り率計算用（日時指定）
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

			if (param.getChargeCalcDays() != null && param.getChargeCalcTargetDays() != null) {
				// 日数指定されている場合、料金計算日数÷料金計算対象日数
				dailyRate = BigDecimal.valueOf(param.getChargeCalcDays()).divide(BigDecimal.valueOf(param.getChargeCalcTargetDays()), 9, BigDecimal.ROUND_HALF_UP);
			} else {
				// 日時指定の場合、日数を計算の上日割り率計算
				dailyRate = calculateDailyRate(param.getFeeClcStrDatTim(), param.getFeeClcEndDatTim(), param.getFeeClcStrYmd(), param.getFeeClcEndYmd());
			}
		} else {
			dailyRate = dailyRate.divide(BigDecimal.valueOf(100));
		}

		if (VoltageCategory.高圧.equals(param.getVoltageCategory())) {
			// 高圧の場合
			if (BigDecimal.ZERO.equals(param.getUseAmount())) {
				// 料金計算数量が0の場合
				// 基本単価×基本電力量×日割り×0.5（小数第3位切捨て　※端数処理は後続処理）
				khnRyokin = param.getBasicPrice().multiply(param.getBasicPowerAmount()).multiply(dailyRate).multiply(BigDecimal.valueOf(0.5));
			} else {
				// 料金計算数量が0以外の場合

				// A1. 基本単価×基本電力量×日割り（小数第3位切捨て）
				BigDecimal a1 = param.getBasicPrice().multiply(param.getBasicPowerAmount()).multiply(dailyRate).setScale(2, BigDecimal.ROUND_DOWN);

				// A2. A1 × ((85 - 力率) ÷ 100)（小数第3位切捨て）
				BigDecimal a2 = a1.multiply(((BigDecimal.valueOf(85).subtract(param.getPowerRate())).divide(BigDecimal.valueOf(100)))).setScale(2, BigDecimal.ROUND_DOWN);

				// A1 ＋ A2
				khnRyokin = a1.add(a2);

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
	public BigDecimal calculateDailyRate(Date startDate, Date endDate, String targetStartDate, String targetEndDate) throws ParseException {

		// 日割計算対象日数の算出
		int nissu1 = dateDiff(startDate, endDate);

		// 計量期間日数の算出
		int nissu2 = dateDiff(targetStartDate, targetEndDate);
		BigDecimal dailyRate = BigDecimal.valueOf(nissu1).divide(BigDecimal.valueOf(nissu2), 9, BigDecimal.ROUND_HALF_UP);
		return dailyRate;
	}

	/**
	 * 日付の日数計算
	 *
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 * @throws ParseException
	 */
	public int dateDiff(Date dateFrom, Date dateTo) throws ParseException {

		// 差分の日数を計算
		long dateTimeFrom = dateFrom.getTime();
		long dateTimeTo = dateTo.getTime();
		long dayDiff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);

		// 返却値は日数の為、差分に＋1する
		return (int) dayDiff + 1;

	}

	/**
	 * 日付の日数計算
	 *
	 * @param dateFromStrig
	 * @param dateToString
	 * @return
	 * @throws ParseException
	 */
	public int dateDiff(String dateFromStrig, String dateToString) throws ParseException {

		if (!dateFromStrig.contains("/")) {
			dateFromStrig = dateFromStrig.substring(0, 4) + "/" + dateFromStrig.substring(4, 6) + "/" + dateFromStrig.substring(6, 8);
		}
		if (!dateToString.contains("/")) {
			dateToString = dateToString.substring(0, 4) + "/" + dateToString.substring(4, 6) + "/" + dateToString.substring(6, 8);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);

		// Date型に変換
		Date dateFrom = sdf.parse(dateFromStrig);
		Date dateTo = sdf.parse(dateToString);

		// 返却値は日数の為、差分に＋1する
		return dateDiff(dateFrom, dateTo);
	}

}
