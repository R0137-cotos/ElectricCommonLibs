package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class FeeSimulationHeadCreateExtDto {

	/**
	 * 作成日
	 */
	@Size(max = 255)
	@Schema(description = "作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String createdDate;

	/**
	 * 基本料金_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "基本料金_定価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicListPrice;

	/**
	 * 基本料金_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "基本料金_売価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicSellingPrice;

	/**
	 * 基本料金_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "基本料金_仕切価格(営業)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicBankPriceBusiness;

	/**
	 * 基本料金_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_売価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicBankPriceRj;

	/**
	 * 従量料金(従量電灯)_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_定価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal peruseLightListPrice;

	/**
	 * 従量料金(従量電灯)_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_売価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightSellingPrice;

	/**
	 * 従量料金(従量電灯)_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_仕切価格(営業)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightBankPriceBusiness;

	/**
	 * 従量料金(従量電灯)_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_仕切価格(RJ)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightBankPriceRj;

	/**
	 * 従量料金(動力)_夏季_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_夏季_定価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerListPrice;

	/**
	 * 従量料金(動力)_夏季_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_夏季_売価", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金(動力)_夏季_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_夏季_仕切価格(営業)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceBusiness;

	/**
	 * 従量料金(動力)_夏季_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_夏季_仕切価格(RJ)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceRj;

	/**
	 * 従量料金(動力)_その他季_定価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_その他季_定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonListPrice;

	/**
	 * 従量料金(動力)_その他季_売価
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_その他夏季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 従量料金(動力)_その他季_仕切価格(営業)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_その他季_仕切価格(営業)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

	/**
	 * 従量料金(動力)_その他季_仕切価格(RJ)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "従量料金(動力)_その他季_仕切価格(RJ)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceRj;
}
