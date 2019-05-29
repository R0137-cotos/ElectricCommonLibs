package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricExpertEstimationExtDto extends DtoBase {

	/**
	 * MoM社員ID
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM社員ID", required = true, position = 3, allowableValues = "range[0,255]")
	private String momEmployeeId;

}
