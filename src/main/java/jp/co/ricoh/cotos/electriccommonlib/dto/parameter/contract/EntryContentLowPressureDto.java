package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.ContractCapacityUnit;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.ContractElectricCurrentUnit;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.LowPressureType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EntryContentLowPressureDto extends EntityBase {
	
	/**
	 * 契約容量(従量電灯)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約容量(従量電灯)", required = false, position = 3, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約容量単位
	 */
	@NotNull
	@ApiModelProperty(value = "契約容量単位", required = true, position = 4, allowableValues = "kVA(\"1\"))", example = "1")
	private ContractCapacityUnit contractCapacityUnit;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電流", required = false, position = 5, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電流単位
	 */
	@NotNull
	@ApiModelProperty(value = "契約電流単位", required = true, position = 6, allowableValues = "A(\"1\"))", example = "1")
	private ContractElectricCurrentUnit contractElectricCurrentUnit;

	/**
	 * 契約電力
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力", required = false, position = 7, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 負荷率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 8, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@NotNull
	@ApiModelProperty(value = "基本検針日(低圧)", required = true, position = 9)
	@Temporal(TemporalType.DATE)
	private Date basicMeterReadingDate;

	/**
	 * 備考
	 */
	@Size(max = 4000)
	@ApiModelProperty(value = "備考", required = false, position = 10, allowableValues = "range[0,4000]")
	private String notes;
	
	/**
	 * 低圧種別
	 */
	@NotNull
	@ApiModelProperty(value = "低圧種別", required = true, position = 11, allowableValues = "動力(\"1\"), 従量電灯(\"2\")", example = "1")
	private LowPressureType lowPressureType;

}
