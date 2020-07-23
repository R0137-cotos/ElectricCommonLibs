package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

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
public class FeeSimulationHeadCreateExtDto {

	/**
	 * 作成日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "作成日", required = false, position = 1, allowableValues = "range[0,255]")
	private String createdDate;

	/**
	 * 基本料金_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_定価", required = true, position = 2, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicListPrice;

	/**
	 * 基本料金_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = true, position = 3, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicSellingPrice;

	/**
	 * 基本料金_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_仕切価格(営業)", required = true, position = 4, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicBankPriceBusiness;

	/**
	 * 基本料金_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_売価", required = true, position = 5, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicBankPriceRj;

	/**
	 * 従量料金(従量電灯)_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_定価", required = true, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal peruseLightListPrice;

	/**
	 * 従量料金(従量電灯)_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_売価", required = true, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightSellingPrice;

	/**
	 * 従量料金(従量電灯)_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_仕切価格(営業)", required = true, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightBankPriceBusiness;

	/**
	 * 従量料金(従量電灯)_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_仕切価格(RJ)", required = true, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightBankPriceRj;

	/**
	 * 従量料金(動力)_夏季_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_定価", required = true, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerListPrice;

	/**
	 * 従量料金(動力)_夏季_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_売価", required = true, position = 11, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金(動力)_夏季_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_仕切価格(営業)", required = true, position = 12, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceBusiness;

	/**
	 * 従量料金(動力)_夏季_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_仕切価格(RJ)", required = true, position = 13, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceRj;

	/**
	 * 従量料金(動力)_その他季_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他季_定価", required = false, position = 14, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonListPrice;

	/**
	 * 従量料金(動力)_その他季_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他夏季_売価", required = false, position = 15, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 従量料金(動力)_その他季_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他季_仕切価格(営業)", required = false, position = 16, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

	/**
	 * 従量料金(動力)_その他季_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他季_仕切価格(RJ)", required = false, position = 17, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceRj;
}
