package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationHead;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = FeeSimulationHead.class, repository = FeeSimulationHeadRepository.class)
public class FeeSimulationHeadDto extends DtoBase {

	/**
	 * 作成日
	 */
	@ApiModelProperty(value = "作成日", required = false, position = 3)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	/**
	 * 年間電力料金 - 現状
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "年間電力料金 - 現状", required = false, position = 4, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal annualElectricityRateCurrent;

	/**
	 * 年間電力料金 - 変更後
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "年間電力料金 - 変更後", required = false, position = 5, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal annualElectricityRateAfter;

	/**
	 * 削減額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "削減額", required = false, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal reductionAmount;

	/**
	 * 削減率（％）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "削減率（％）", required = false, position = 7, allowableValues = "range[0.00,99999.99]")
	private BigDecimal reductionRate;

	/**
	 * 総合単価１
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "総合単価１", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal overallPrice1;

	/**
	 * 総合単価２
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "総合単価２", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal overallPrice2;

	/**
	 * 総合単価３
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "総合単価３", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal overallPrice3;

	/**
	 * 負荷率（％）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率（％）", required = false, position = 11, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本料金_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = false, position = 12, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateSellingPrice;

	/**
	 * 基本料金_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_仕切価格（営業）", required = false, position = 13, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateBankPriceBusiness;

	/**
	 * 基本料金_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_仕切価格（ＲＪ）", required = false, position = 14, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateBankPriceRj;

	/**
	 * 従量料金_夏季_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季_売価", required = false, position = 15, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金_夏季_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季_仕切価格（営業）", required = false, position = 16, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceBusiness;

	/**
	 * 従量料金_夏季_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季_仕切価格（ＲＪ）", required = false, position = 17, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceRj;

	/**
	 * 従量料金_その他季_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季_売価", required = false, position = 18, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 従量料金_その他季_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季_仕切価格（営業）", required = false, position = 19, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

	/**
	 * 従量料金_その他季_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季_仕切価格（ＲＪ）", required = false, position = 20, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceRj;

	/**
	 * オプション_予備線_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線_売価", required = false, position = 21, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineSellingPrice;

	/**
	 * オプション_予備線_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線_仕切価格（営業）", required = false, position = 22, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineBankPriceBusiness;

	/**
	 * オプション_予備線_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線_仕切価格（ＲＪ）", required = false, position = 23, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineBankPriceRj;

	/**
	 * オプション_予備電源_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備電源_売価", required = false, position = 24, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerSellingPrice;

	/**
	 * オプション_予備電源_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備電源_仕切価格（営業）", required = false, position = 25, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerBankPriceBusiness;

	/**
	 * オプション_予備電源_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備電源_仕切価格（ＲＪ）", required = false, position = 26, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerBankPriceRj;

	/**
	 * オプション_アンシラリー_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー_売価", required = false, position = 27, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillarySellingPrice;

	/**
	 * オプション_アンシラリー_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー_仕切価格（営業）", required = false, position = 28, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillaryBankPriceBusiness;

	/**
	 * オプション_アンシラリー_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー_仕切価格（ＲＪ）", required = false, position = 29, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillaryBankPriceRj;

	/**
	 * 媒介手数料 定額（円：税込）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "媒介手数料　定額（円：税込）", required = false, position = 30, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal feeFixedAmountInTax;

	/**
	 * 媒介手数料 定率（％）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "媒介手数料　定率（％）", required = false, position = 31, allowableValues = "range[0.00,99999.99]")
	private BigDecimal feeFixedRate;

	/**
	 * 電力料金（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "電力料金（営業）", required = false, position = 32, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal electricityChargeBusiness;

	/**
	 * 粗利額（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "粗利額（営業）", required = false, position = 33, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal grossMarginBusiness;

	/**
	 * 粗利率（％）（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "粗利率（％）（営業）", required = false, position = 34, allowableValues = "range[0.00,99999.99]")
	private BigDecimal grossProfitMarginBusiness;

	/**
	 * 電力料金（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "電力料金（ＲＪ）", required = false, position = 35, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal electricityChargeRj;

	/**
	 * 粗利額（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "粗利額（ＲＪ）", required = false, position = 36, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal grossMarginRj;

	/**
	 * 粗利率（％）（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "粗利率（％）（ＲＪ）", required = false, position = 37, allowableValues = "range[0.00,99999.99]")
	private BigDecimal grossProfitMarginRj;

	/**
	 * 定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "定価", required = false, position = 38, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateListPrice;

	/**
	 * SIM番号(主)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(主)", required = false, position = 39, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(従)", required = false, position = 40, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * 取次手数料額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "取次手数料額", required = false, position = 41, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal agencyFeeAmount;

	/**
	 * 取次手数料率（％）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "取次手数料率（％）", required = false, position = 42, allowableValues = "range[0.00,99999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 取次割引率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "取次割引率", required = false, position = 43, allowableValues = "range[0.00,99999.99]")
	private BigDecimal agencyDiscountRate;

	/**
	 * 取次割引単価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "取次割引単価", required = false, position = 44, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal agencyDiscountPrice;

	/**
	 * 長期割引率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "長期割引率", required = false, position = 45, allowableValues = "range[0.00,99999.99]")
	private BigDecimal longtermDiscountRate;

	/**
	 * 長期割引単価
	 */
	@DecimalMin("-9999999999999999999.99")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "長期割引単価", required = false, position = 46, allowableValues = "range[-9999999999999999999.99,0.00]")
	private BigDecimal longtermDiscountPrice;
}
