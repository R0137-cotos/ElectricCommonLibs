package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.ContractUnit;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.LowPressureType;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentLowPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = EntryContentLowPressure.class, repository = EntryContentLowPressureRepository.class)
public class EntryContentLowPressureDto extends DtoBase {

	/**
	 * 契約容量(従量電灯)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約容量(従量電灯)", required = false, position = 3, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電流", required = false, position = 5, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

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
	@Size(max = 255)
	@ApiModelProperty(value = "基本検針日(低圧)", required = true, position = 9, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

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
	@ApiModelProperty(value = "低圧種別", required = true, position = 11, allowableValues = "従量電灯1(\"1\"), 従量電灯2(\"2\"), 動力(\"3\")", example = "1")
	private LowPressureType lowPressureType;

	/**
	 * 契約単位
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約単位", required = true, position = 12, allowableValues = "A(\"1\"), KvA(\"2\"), 契約(\"3\"),　kW(\"4\")", example = "1")
	private ContractUnit contractUnit;

}
