package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationElectricExtDto extends DtoBase {

	/**RAIDEN外部キー情報*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "RAIDEN外部キー情報", required = true, position = 3, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**商流区分*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分", required = true, position = 4, allowableValues = "range[0,255]")
	private String electricCommercialFlowDiv;

	/**商流区分コード*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分コード", required = true, position = 5, allowableValues = "range[0,255]")
	private String electricCommercialFlowDivCode;

	/**電力エリア*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力エリア", required = true, position = 6, allowableValues = "range[0,255]")
	private String electricArea;

	/**電力会社*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社", required = true, position = 7, allowableValues = "range[0,255]")
	private String electricCompany;

	/**電力会社コード*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = true, position = 8, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**電力区分*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力区分", required = true, position = 9, allowableValues = "range[0,255]")
	private String voltageCategory;

	/**電力メニュー*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニュー", required = true, position = 10, allowableValues = "range[0,255]")
	private String electricMenu;

	/**電力メニューコード*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニューコード", required = true, position = 11, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**CO2排出メニュー*/
	@NotNull
	@Column(name = "co2_emission_menu")
	@ApiModelProperty(value = "CO2排出メニュー", required = true, position = 12, allowableValues = "range[0,255]")
	private ElectricPlan co2EmissionMenu;

	/**CO2排出係数*/
	@NotNull
	@Size(max = 255)
	@Column(name = "co2_emission_factor")
	@ApiModelProperty(value = "CO2排出係数", required = true, position = 13, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/**品種コード*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "品種コード", required = true, position = 14, allowableValues = "range[0,255]")
	private String itemCode;

	/**契約電力*/
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力", required = true, position = 15, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractPower;

	/**規模*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "規模", required = true, position = 16, allowableValues = "range[0,255]")
	private String scale;

	/**力率*/
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "力率", required = true, position = 17, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**負荷率*/
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = true, position = 18, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**供給開始予定日*/
	@NotNull
	@ApiModelProperty(value = "供給開始予定日", required = true, position = 19, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**電源サイクル*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電源サイクル", required = true, position = 20, allowableValues = "range[0,255]")
	private String powerSupplyCycle;

	/**契約数量*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "契約数量", required = true, position = 21, allowableValues = "range[0,255]")
	private String contractQuantity;

	/**契約形態*/
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "契約形態", required = true, position = 22, allowableValues = "range[0,255]")
	private String typeOfContract;

	/**部分供給*/
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "部分供給", required = true, position = 23, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**ベース部*/
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "ベース部", required = true, position = 24, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal basePart;

	/**変動部*/
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "変動部", required = true, position = 25, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal fluctuatingPart;

	/**予備線*/
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備線", required = true, position = 26, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/**予備電源*/
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備電源", required = true, position = 27, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/**アンシラリーサービス*/
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アンシラリーサービス", required = true, position = 28, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

}
