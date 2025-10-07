package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractPicSaEmpChangePlanExtDto {

	/**
	 * MoM社員ID
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM社員ID", required = true, position = 1, allowableValues = "range[0,255]")
	private String momEmployeeId;
}
