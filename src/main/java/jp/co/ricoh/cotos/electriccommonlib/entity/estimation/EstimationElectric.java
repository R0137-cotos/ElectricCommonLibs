package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.Scale;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 見積(電力用)
 */
@Entity
@EqualsAndHashCode(callSuper = true)
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
	@ApiModelProperty(value = "ID", required = true, position = 1)
	private long id;

	/**
	 * 見積ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "見積ID", required = true, position = 2, allowableValues = "range[0,9223372036854775807]")
	private long estimationId;

	/**
	 * 電力エリア
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力エリア", required = false, position = 3, allowableValues = "range[0,255]")
	private String electricArea;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社", required = false, position = 4, allowableValues = "range[0,255]")
	private String electricCompany;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力区分", required = true, position = 5, allowableValues = "range[0,255]")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力メニュー", required = false, position = 6, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約電力
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力", required = false, position = 7, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractPower;

	/**
	 * 規模
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "規模", required = false, position = 8, allowableValues = "500kw未満(\"1\"), 500kw以上(\"2\")", example = "1")
	private Scale scale;

	/**
	 * 力率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "力率", required = false, position = 6, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**
	 * 負荷率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 7, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 供給開始予定月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給開始予定月", required = false, position = 11, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "備考", required = false, position = 12, allowableValues = "range[0,255]")
	private String notes;

	@OneToOne(mappedBy = "estimationElectric")
	@ApiModelProperty(value = "電力専任情報", required = false, position = 13)
	private ElectricExpertEstimation electricExpertEstimation;

	@OneToOne(mappedBy = "estimationElectric")
	@ApiModelProperty(value = "販売店情報", required = false, position = 14)
	private ElectricDealerEstimation electricDealerEstimation;

	@OneToOne(mappedBy = "estimationElectric")
	@ApiModelProperty(value = "料金シュミレーション(本部用)", required = false, position = 16)
	private FeeSimulationHead feeSimulationHead;

	/**
	 * 電源サイクル
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電源サイクル", required = false, position = 17, allowableValues = "range[0,255]")
	private String powerSupplyCycle;

	/**
	 * 契約数量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約数量", required = false, position = 18, allowableValues = "range[0,255]")
	private String contractQuantity;

	/**
	 * 契約形態
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約形態", required = false, position = 19, allowableValues = "range[0,255]")
	private String typeOfContract;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "商流区分", required = true, position = 20, allowableValues = "直売(\"1\"), 代売(\"2\"), 社内(\"3\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 品種コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "品種コード", required = false, position = 21, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 部分供給
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "部分供給", required = false, position = 22, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**
	 * ベース部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "ベース部", required = false, position = 23, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal basePart;

	/**
	 * 変動部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "変動部", required = false, position = 24, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal fluctuatingPart;

	/**
	 * 外部キー情報
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "外部キー情報", required = false, position = 25, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * 予備線
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備線", required = false, position = 26, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備電源", required = false, position = 27, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アンシラリーサービス", required = false, position = 28, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

	/**
	 * お客様識別番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 29, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Column(nullable = true, name = "co2_emission_menu")
	@ApiModelProperty(value = "CO2排出メニュー", required = false, position = 30, allowableValues = "CO2フリー(\"1\"), それ以外(\"2\")", example = "1")
	private ElectricPlan co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 31, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 32, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * CO2排出係数
	 */
	@Column(nullable = true, name = "co2_emission_factor")
	@ApiModelProperty(value = "CO2排出係数", required = false, position = 33, allowableValues = "range[0,255]")
	private String co2EmissionFactor;
}
