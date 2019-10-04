package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractAddedEditorEmpCreateExtDto {

	/**
	 * MoM社員ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "MoM社員ID", required = false, position = 1, allowableValues = "range[0,255]")
	private String momEmployeeId;
}
