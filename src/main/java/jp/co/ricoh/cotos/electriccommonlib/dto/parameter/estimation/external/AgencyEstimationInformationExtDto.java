package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class AgencyEstimationInformationExtDto {

	/** 取次会社名 */
	@Size(max = 255)
	@Schema(description = "取次会社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String agencyName;

	/** 仕入先CD */
	@Size(max = 255)
	@Schema(description = "仕入先CD", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplierCode;

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
	@Schema(description = "取次手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 取次割引単価
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次割引単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal agencyDiscountPrice;

	/**
	 * 取次割引率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次割引率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,999.99]")
	private BigDecimal agencyDiscountRate;
}
