package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class LongtermDiscountEstimationInformationExtDto {

	/**
	 * 長期割引率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "長期割引率", required = false, position = 1, allowableValues = "range[0,999.99]")
	private BigDecimal longtermDiscountRate;

	/**
	 * 長期割引単価
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "長期割引単価", required = false, position = 2, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal longtermDiscountPrice;

}
