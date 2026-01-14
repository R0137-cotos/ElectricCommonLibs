package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricArea;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.Scale;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 見積(電力用)
 */
@Entity
@EqualsAndHashCode(callSuper = true, exclude={"electricExpertEstimation", "electricDealerEstimation", "feeSimulationHead", "agencyEstimationInformation"})
@ToString(callSuper = true, exclude = {"electricExpertEstimation", "electricDealerEstimation", "feeSimulationHead", "agencyEstimationInformation"})
@Data
@Table(name = "estimation_electric")
@CotosComplementTarget(entity = EstimationElectric.class, repository = EstimationElectricRepository.class)
public class EstimationElectric extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estimation_electric_seq")
	@SequenceGenerator(name = "estimation_electric_seq", sequenceName = "estimation_electric_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 見積ID
	 */
	@Column(nullable = false)
	@Schema(description = "見積ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long estimationId;

	/**
	 * 電力エリア
	 */
	@Column(nullable = true)
	@Schema(description = "電力エリア", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "北日本(\"1\"), 首都圏(\"2\"), 中部(\"3\"), 関西(\"4\"), 西日本(\"5\")", example = "1")
	private ElectricArea electricArea;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricCompany;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Column(nullable = true)
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約電力
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "契約電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal contractPower;

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
	 * 供給開始予定月
	 */
	@Column(nullable = true)
	@Schema(description = "供給開始予定月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String notes;

	@OneToOne(mappedBy = "estimationElectric")
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricExpertEstimation electricExpertEstimation;

	@OneToOne(mappedBy = "estimationElectric")
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricDealerEstimation electricDealerEstimation;

	@OneToOne(mappedBy = "estimationElectric")
	@Schema(description = "料金シュミレーション(本部用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private FeeSimulationHead feeSimulationHead;

	/**
	 * 電源サイクル
	 */
	@Column(nullable = true)
	@Schema(description = "電源サイクル", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerSupplyCycle;

	/**
	 * 契約数量
	 */
	@Column(nullable = true)
	@Schema(description = "契約数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractQuantity;

	/**
	 * 契約形態
	 */
	@Column(nullable = true)
	@Schema(description = "契約形態", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String typeOfContract;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "直売(\"1\"), 媒介(\"2\"), 社内(\"3\"), 取次(\"4\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 品種コード
	 */
	@Column(nullable = true)
	@Schema(description = "品種コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 部分供給
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "部分供給", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**
	 * ベース部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "ベース部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal basePart;

	/**
	 * 変動部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "変動部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal fluctuatingPart;

	/**
	 * 外部キー情報
	 */
	@Column(nullable = true)
	@Schema(description = "外部キー情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

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
	 * お客様識別番号
	 */
	@Column(nullable = true)
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Column(nullable = true, name = "co2_emission_menu")
	@Schema(description = "CO2排出メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "CO2フリー(\"1\"), それ以外(\"2\")", example = "1")
	private ElectricPlan co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * CO2排出係数
	 */
	@Column(nullable = true, name = "co2_emission_factor")
	@Schema(description = "CO2排出係数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/**
	 * アンシラリーサービス契約容量(高圧)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "アンシラリーサービス契約容量(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal ancillaryCapacityHighPressure;

	/**
	 * 契約期間
	 */
	@Column(nullable = true)
	@Schema(description = "契約期間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractPeriod;

	/**
	 * 承認ルート名
	 */
	@Column(nullable = true)
	@Schema(description = "承認ルート名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String approvalRouteName;

	@OneToOne(mappedBy = "estimationElectric")
	@Schema(description = "取次情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private AgencyEstimationInformation agencyEstimationInformation;
}
