package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class UnitPriceLowPressureDto extends DtoBase {

	/**
	 * 単価種別
	 */
	@NotNull
	@ApiModelProperty(value = "単価種別", required = true, position = 3, allowableValues = "単価(\"1\"), 仕切価格(営業)(\"2\"), 仕切価格(RJ)(\"3\")", example = "1")
	private UnitPriceType unitPriceType;

	/**
	 * 変更回数
	 */
	@Max(99999)
	@Min(0)
	@ApiModelProperty(value = "変更回数", required = false, position = 4, allowableValues = "range[0,99999]")
	private Integer numberOfChanges;

	/**
	 * 従量料金(従量電灯)_定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_定価", required = false, position = 5, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightListPrice;

	/**
	 * 従量料金(従量電灯)_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_売価", required = false, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightSellingPrice;

	/**
	 * 従量料金(動力)_夏季_定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_定価", required = false, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerListPrice;

	/**
	 * 従量料金(動力)_夏季_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_売価", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金(動力)_その他季_定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他季_定価", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonListPrice;

	/**
	 * 従量料金(動力)_その他季_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他夏季_売価", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;
	
	/**
	 * 登録者名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "登録者名", required = false, position = 11, allowableValues = "range[0,255]")
	private String createdUserName;
	
	/**
	 * 基本料金_定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_定価", required = false, position = 12, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicListPrice;
	
	/**
	 * 基本料金_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = false, position = 13, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicSellingPrice;
}
