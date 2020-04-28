package jp.co.ricoh.cotos.electriccommonlib.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.LowPressureType;
import jp.co.ricoh.cotos.electriccommonlib.util.CalclateBasicChargeUtility.CalclateParameter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalclateBasicChargeUtilityTest {

	@Autowired
	private CalclateBasicChargeUtility testTarget;

	@Test
	public void 基本料金計算テスト() throws ParseException {
		CalclateParameter param = testTarget.createParameter();

		/* 高圧 */

		/* 電力使用量 = 0, 日割り = 1 */
		param.setBasicPrice(new BigDecimal("1800.12"));
		param.setBasicPowerAmount(new BigDecimal("1650.45"));

		param.setFeeClcStrDatTim(createDate("2020/01/01"));
		param.setFeeClcEndDatTim(createDate("2020/01/30"));
		param.setFeeClcStrYmd("20191220");
		param.setFeeClcEndYmd("20200118");
		param.setVoltageCategory(VoltageCategory.高圧);
		param.setUseAmount(new BigDecimal("0"));

		BigDecimal result = null;
		result = testTarget.calculateBasicCharge(param);
		// 計算結果①：基本単価×基本電力量×日割り×0.5 = 1,485,504.027
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("1485504.02").setScale(2), result);

		/* 電力使用量 = 0, 日割り = 0.9 */
		param.setDailyRate(new BigDecimal("90"));
		result = testTarget.calculateBasicCharge(param);
		// 計算結果①：基本単価×基本電力量×日割り×0.5 = 1,336,953.6243
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("1336953.62").setScale(2), result);

		/* 電力使用量 = 0, 日割り = 0.5 */
		param.setDailyRate(null);
		param.setFeeClcEndDatTim(createDate("2020/01/15"));
		param.setFeeClcStrYmd("2020/01/01");
		param.setFeeClcEndYmd("2020/01/30");
		result = testTarget.calculateBasicCharge(param);
		// 計算結果①：基本単価×基本電力量×日割り×0.5 = 742,752.0135
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("742752.01").setScale(2), result);

		/* 電力使用量 != 0, 日割り = 0.5, 商流区分 != 取次 */
		param.setPowerRate(new BigDecimal(90));

		param.setUseAmount(new BigDecimal("2048"));
		result = testTarget.calculateBasicCharge(param);
		// 計算結果②：A1)基本単価×基本電力量×日割り（小数第3位四捨五入）
		//             ＋ A1 × ((85 - 力率) ÷ 100)（小数第3位四捨五入） = 1,411,228.82
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("1411228.82").setScale(2), result);

		/* 低圧 */
		/* 電力使用量 != 0, 日割り = 0.5 */
		param.setBasicPrice(new BigDecimal("1200.12"));
		param.setBasicPowerAmount(new BigDecimal("30.45"));

		param.setVoltageCategory(VoltageCategory.低圧);
		param.setLowPressureType(LowPressureType.従量電灯1);
		result = testTarget.calculateBasicCharge(param);
		// 計算結果⑤:基本単価×日割り = 600.06
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("600.06").setScale(2), result);

		/* 電力使用量 != 0, 日割り = 0.5 */
		param.setLowPressureType(LowPressureType.従量電灯2);
		result = testTarget.calculateBasicCharge(param);
		// 計算結果⑥:基本単価×基本電力量×日割り = 18,271.827
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("18271.82").setScale(2), result);

		/* 電力使用量 = 0, 日割り = 0.5 */
		param.setLowPressureType(LowPressureType.従量電灯1);
		param.setUseAmount(new BigDecimal("0"));
		result = testTarget.calculateBasicCharge(param);
		// 計算結果⑦:計算結果⑤×0.5
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("300.03").setScale(2), result);

		/* 電力使用量 = 0, 日割り = 0.5 */
		param.setLowPressureType(LowPressureType.動力);
		param.setUseAmount(new BigDecimal("0"));
		result = testTarget.calculateBasicCharge(param);
		// 計算結果⑧:計算結果⑥×0.5 = 9,135.9135‬
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("9135.91").setScale(2), result);

		/* 電力使用量 = 0, 日割り = 0.5（日数計算） */
		param.setLowPressureType(LowPressureType.動力);
		param.setUseAmount(new BigDecimal("0"));
		param.setDailyRate(null);
		param.setChargeCalcDays(10);
		param.setChargeCalcTargetDays(20);
		result = testTarget.calculateBasicCharge(param);
		// 計算結果⑧:計算結果⑥×0.5 = 9,135.9135‬
		Assert.assertEquals("計算結果が期待値通りであること", new BigDecimal("9135.91").setScale(2), result);
	}

	/**
	 * 日付型変換
	 *
	 * @param str
	 *            日付文字列
	 * @return Date
	 * @throws ParseException
	 */
	private Date createDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.parse(str);
	}
}
