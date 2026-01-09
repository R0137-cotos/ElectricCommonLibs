package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "計量日(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer measureDateHigh;

	/**
	 * 契約電力(高圧)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電力(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractPowerHigh;

	/**
	 * 規模
	 */
	@Schema(description = "規模", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "500kw未満(\"1\"), 500kw以上(\"2\")", example = "1")
	private Scale scale;

	/**
	 * 力率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "力率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**
	 * 負荷率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 予備線
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "予備電源", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "アンシラリーサービス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

	/**
	 * 蓄熱計量器継続
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "蓄熱計量器継続", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer thermalStorageMeterFlg;

	/**
	 * 再エネ賦課金減免措置
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "再エネ賦課金減免措置", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer renewableEnergyExemptionFlg;

	/**
	 * 需要地内転売契約
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "需要地内転売契約", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer demandPlaceResales;

	/**
	 * 部分供給
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "部分供給", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**
	 * その他
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "その他", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer otherFlg;

	/**
	 * 部分供給 設定値
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "部分供給 設定値", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal partialSupplySettingValue;

	/**
	 * ベース部
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "ベース部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal base;

	/**
	 * 変動部
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "変動部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal variable;

	/**
	 * アンシラリーサービス契約容量(高圧)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "アンシラリーサービス契約容量(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal ancillaryCapacityHighPressure;

	/**
	 * 該当なし
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "該当なし", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer notApplicableFlg;

	/**
	 * 東北取次（新規）
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "東北取次（新規）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer tohokuAgencyNewFlg;

	/**
	 * 東北取次（RJ電力からの切り替え）
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "東北取次（RJ電力からの切り替え）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer tohokuAgencySwitchFlg;

	/**
	 * 協議制で契約電力増加の場合
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "協議制で契約電力増加の場合", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer increaseElectricPowerFlg;

	/**
	 * 取次手数料額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次手数料額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal agencyFeeAmount;

	/**
	 * 取次手数料率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 備考
	 */
	@Size(max = 4000)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notes;
}
