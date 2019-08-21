package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.Scale;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentHighPressure;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentHighPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = EntryContentHighPressure.class, repository = EntryContentHighPressureRepository.class)
public class EntryContentHighPressureDto extends DtoBase {

	/**
	 * 計量日(高圧)
	 */
	@Max(99999)
	@Min(0)
	@ApiModelProperty(value = "計量日(高圧)", required = false, position = 3)
	private Integer measureDateHigh;

	/**
	 * 契約電力(高圧)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力(高圧)", required = false, position = 4, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractPowerHigh;

	/**
	 * 規模
	 */
	@ApiModelProperty(value = "規模", required = false, position = 5, allowableValues = "500kw未満(\"1\"), 500kw以上(\"2\")", example = "1")
	private Scale scale;

	/**
	 * 力率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "力率", required = false, position = 6, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**
	 * 負荷率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 7, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 予備線
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備線", required = false, position = 8, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備電源", required = false, position = 9, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アンシラリーサービス", required = false, position = 10, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

	/**
	 * 蓄熱計量器継続
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "蓄熱計量器継続", required = false, position = 11, allowableValues = "range[0,9]")
	private Integer thermalStorageMeterFlg;

	/**
	 * 再エネ賦課金減免措置
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "再エネ賦課金減免措置", required = false, position = 12, allowableValues = "range[0,9]")
	private Integer renewableEnergyExemptionFlg;

	/**
	 * 需要地内転売契約
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "需要地内転売契約", required = false, position = 13, allowableValues = "range[0,9]")
	private Integer demandPlaceResales;

	/**
	 * 部分供給
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "部分供給", required = false, position = 14, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**
	 * その他
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "その他", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer otherFlg;

	/**
	 * 部分供給 設定値
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "部分供給 設定値", required = false, position = 16, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal partialSupplySettingValue;

	/**
	 * ベース部
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "ベース部", required = false, position = 17, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal base;

	/**
	 * 変動部
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "変動部", required = false, position = 18, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal variable;
}
