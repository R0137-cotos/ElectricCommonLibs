package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.UnitPriceHighPressure;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceHighPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = UnitPriceHighPressure.class, repository = UnitPriceHighPressureRepository.class)
public class UnitPriceHighPressureDto extends DtoBase {

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
	 * 基本料金_定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_定価", required = false, position = 5, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicListPrice;

	/**
	 * 基本料金_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = false, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicSellingPrice;

	/**
	 * 従量料金_夏季
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季", required = false, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerPrice;

	/**
	 * 従量料金_その他季
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonPrice;

	/**
	 * オプション_予備線
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLinePrice;

	/**
	 * オプション_予備電源
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerPrice;

	/**
	 * オプション_アンシラリー
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー", required = false, position = 11, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillaryPrice;

	/**
	 * 登録者名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "登録者名", required = false, position = 12, allowableValues = "range[0,255]")
	private String createdUserName;
}
