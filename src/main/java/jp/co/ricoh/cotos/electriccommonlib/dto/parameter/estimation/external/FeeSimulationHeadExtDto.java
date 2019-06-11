package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FeeSimulationHeadExtDto {

	/**
	 * SIM番号(主)
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(主)", required = false, position = 3, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(従)", required = true, position = 4, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * 作成日
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "作成日", required = true, position = 5, allowableValues = "range[0,255]")
	private String createdDate;

	/**
	 * 年間電力料金 - 現状
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "年間電力料金 - 現状", required = true, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal annualElectricityRateCurrent;

	/**
	 * 年間電力料金 - 変更後
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "年間電力料金 - 変更後", required = true, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal annualElectricityRateAfter;

	/**
	 * 削減額
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "削減額", required = true, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal reductionAmount;

	/**
	 * 削減率（％）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "削減率（％）", required = true, position = 9, allowableValues = "range[0.00,99999.99]")
	private BigDecimal reductionRate;

	/**
	 * 総合単価１
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "総合単価１", required = true, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal overallPrice1;

	/**
	 * 総合単価２
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "総合単価２", required = true, position = 11, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal overallPrice2;

	/**
	 * 総合単価３
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "総合単価３", required = true, position = 12, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal overallPrice3;

	/**
	 * 負荷率（％）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率（％）", required = true, position = 13, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本料金_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = true, position = 14, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateSellingPrice;

	/**
	 * 基本料金_仕切価格（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_仕切価格（営業）", required = true, position = 15, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateBankPriceBusiness;

	/**
	 * 基本料金_仕切価格（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_仕切価格（ＲＪ）", required = true, position = 16, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateBankPriceRj;

	/**
	 * 従量料金_夏季_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季_売価", required = true, position = 17, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金_夏季_仕切価格（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季_仕切価格（営業）", required = true, position = 18, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceBusiness;

	/**
	 * 従量料金_夏季_仕切価格（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季_仕切価格（ＲＪ）", required = true, position = 19, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceRj;

	/**
	 * 従量料金_その他季_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季_売価", required = true, position = 20, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 従量料金_その他季_仕切価格（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季_仕切価格（営業）", required = true, position = 21, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

	/**
	 * 従量料金_その他季_仕切価格（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季_仕切価格（ＲＪ）", required = true, position = 22, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceRj;

	/**
	 * オプション_予備線_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線_売価", required = true, position = 23, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineSellingPrice;

	/**
	 * オプション_予備線_仕切価格（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線_仕切価格（営業）", required = true, position = 24, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineBankPriceBusiness;

	/**
	 * オプション_予備線_仕切価格（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線_仕切価格（ＲＪ）", required = true, position = 25, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineBankPriceRj;

	/**
	 * オプション_予備電源_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備電源_売価", required = true, position = 26, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerSellingPrice;

	/**
	 * オプション_予備電源_仕切価格（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備電源_仕切価格（営業）", required = true, position = 27, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerBankPriceBusiness;

	/**
	 * オプション_予備電源_仕切価格（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備電源_仕切価格（ＲＪ）", required = true, position = 28, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerBankPriceRj;

	/**
	 * オプション_アンシラリー_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー_売価", required = true, position = 29, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillarySellingPrice;

	/**
	 * オプション_アンシラリー_仕切価格（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー_仕切価格（営業）", required = true, position = 30, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillaryBankPriceBusiness;

	/**
	 * オプション_アンシラリー_仕切価格（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー_仕切価格（ＲＪ）", required = true, position = 31, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillaryBankPriceRj;

	/**
	 * 媒介手数料 定額（円：税込）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "媒介手数料　定額（円：税込）", required = true, position = 32, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal feeFixedAmountInTax;

	/**
	 * 媒介手数料 定率（％）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "媒介手数料　定率（％）", required = true, position = 33, allowableValues = "range[0.00,99999.99]")
	private BigDecimal feeFixedRate;

	/**
	 * 電力料金（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "電力料金（営業）", required = true, position = 34, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal electricityChargeBusiness;

	/**
	 * 粗利額（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "粗利額（営業）", required = true, position = 35, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal grossMarginBusiness;

	/**
	 * 粗利率（％）（営業）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "粗利率（％）（営業）", required = true, position = 36, allowableValues = "range[0.00,99999.99]")
	private BigDecimal grossProfitMarginBusiness;

	/**
	 * 電力料金（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "電力料金（ＲＪ）", required = true, position = 37, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal electricityChargeRj;

	/**
	 * 粗利額（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "粗利額（ＲＪ）", required = true, position = 38, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal grossMarginRj;

	/**
	 * 粗利率（％）（ＲＪ）
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "粗利率（％）（ＲＪ）", required = true, position = 39, allowableValues = "range[0.00,99999.99]")
	private BigDecimal grossProfitMarginRj;

	/**
	 * 基本料金_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_定価", required = true, position = 40, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateListPrice;
}
