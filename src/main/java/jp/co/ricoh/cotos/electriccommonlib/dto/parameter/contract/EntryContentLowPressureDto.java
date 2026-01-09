package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "契約容量(従量電灯)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電流", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 負荷率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "基本検針日(低圧)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

	/**
	 * 備考
	 */
	@Size(max = 4000)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notes;

	/**
	 * 低圧種別
	 */
	@NotNull
	@Schema(description = "低圧種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "従量電灯1(\"1\"), 従量電灯2(\"2\"), 動力(\"3\")", example = "1")
	private LowPressureType lowPressureType;

	/**
	 * 契約単位
	 */
	@Column(nullable = false)
	@Schema(description = "契約単位", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "A(\"1\"), KvA(\"2\"), 契約(\"3\"),　kW(\"4\")", example = "1")
	private ContractUnit contractUnit;

}
