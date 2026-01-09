package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.Scale;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentHighPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * お申込み内容(高圧)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "entry_content_high_pressure")
@CotosComplementTarget(entity = EntryContentHighPressure.class, repository = EntryContentHighPressureRepository.class)
public class EntryContentHighPressure extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_content_high_pressure_seq")
	@SequenceGenerator(name = "entry_content_high_pressure_seq", sequenceName = "entry_content_high_pressure_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 計量日(高圧)
	 */
	@Max(99999)
	@Min(0)
	@Column(nullable = true)
	@Schema(description = "計量日(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Integer measureDateHigh;

	/**
	 * 契約電力(高圧)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "契約電力(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal contractPowerHigh;

	/**
	 * 規模
	 */
	@Column(nullable = true)
	@Schema(description = "規模", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "500kw未満(\"1\"), 500kw以上(\"2\")", example = "1")
	private Scale scale;

	/**
	 * 力率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "力率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal powerRate;

	/**
	 * 負荷率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal loadFactor;

	/**
	 * 予備線
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "予備電源", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "アンシラリーサービス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

	/**
	 * 蓄熱計量器継続
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "蓄熱計量器継続", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer thermalStorageMeterFlg;

	/**
	 * 再エネ賦課金減免措置
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "再エネ賦課金減免措置", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer renewableEnergyExemptionFlg;

	/**
	 * 需要地内転売契約
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "需要地内転売契約", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer demandPlaceResales;

	/**
	 * 部分供給
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "部分供給", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**
	 * その他
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "その他", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer otherFlg;

	/**
	 * 部分供給 設定値
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "部分供給 設定値", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal partialSupplySettingValue;

	/**
	 * ベース部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "ベース部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal base;

	/**
	 * 変動部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "変動部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal variable;

	/**
	 * アンシラリーサービス契約容量(高圧)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "アンシラリーサービス契約容量(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal ancillaryCapacityHighPressure;

	/**
	 * 該当なし
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "該当なし", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer notApplicableFlg;

	/**
	 * 東北取次（新規）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "東北取次（新規）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer tohokuAgencyNewFlg;

	/**
	 * 東北取次（RJ電力からの切り替え）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "東北取次（RJ電力からの切り替え）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer tohokuAgencySwitchFlg;

	/**
	 * 協議制で契約電力増加の場合
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "協議制で契約電力増加の場合", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer increaseElectricPowerFlg;

	/**
	 * 取次手数料額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次手数料額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal agencyFeeAmount;

	/**
	 * 取次手数料率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notes;

}
