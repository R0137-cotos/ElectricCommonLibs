package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationElectricExtDtoForCreate {

	/** RAIDEN外部キー情報 */
	@Size(max = 255)
	@Schema(description = "RAIDEN外部キー情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/** 商流区分 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCommercialFlowDiv;

	/** 商流区分コード */
	@NotNull
	@Size(max = 255)
	@Schema(description = "商流区分コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCommercialFlowDivCode;

	/** 電力エリア */
	@Size(max = 255)
	@Schema(description = "電力エリア", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricArea;

	/** 電力会社 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String powerCompany;

	/** 電力会社コード */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/** 電力区分 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String voltageCategory;

	/** 電力メニュー */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	/** 電力メニューコード */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力メニューコード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/** CO2排出メニュー */
	@Size(max = 255)
	@Column(name = "co2_emission_menu")
	@Schema(description = "CO2排出メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String co2EmissionMenu;

	/** CO2排出係数 */
	@Size(max = 255)
	@Column(name = "co2_emission_factor")
	@Schema(description = "CO2排出係数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/** 品種コード */
	@NotNull
	@Size(max = 255)
	@Schema(description = "品種コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String itemCode;

	/** 契約電力 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電力", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractPower;

	/** 規模 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "規模", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String scale;

	/** 力率 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "力率", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/** 負荷率 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/** 供給開始予定日 */
	@NotNull
	@Schema(description = "供給開始予定日", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/** 電源サイクル */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電源サイクル", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String powerSupplyCycle;

	/** 契約数量 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "契約数量", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String contractQuantity;

	/** 契約形態 */
	@Size(max = 255)
	@Schema(description = "契約形態", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String typeOfContract;

	/** 部分供給 */
	@Max(9)
	@Min(0)
	@Schema(description = "部分供給", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/** ベース部 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "ベース部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal basePart;

	/** 変動部 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "変動部", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal fluctuatingPart;

	/** 予備線 */
	@NotNull
	@Max(9)
	@Min(0)
	@Schema(description = "予備線", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/** 予備電源 */
	@NotNull
	@Max(9)
	@Min(0)
	@Schema(description = "予備電源", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/** アンシラリーサービス */
	@NotNull
	@Max(9)
	@Min(0)
	@Schema(description = "アンシラリーサービス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

	/** 契約期間 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "契約期間", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String contractPeriod;

	/** アンシラリーサービス契約容量 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "アンシラリーサービス契約容量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal ancillaryCapacityHighPressure;
}
