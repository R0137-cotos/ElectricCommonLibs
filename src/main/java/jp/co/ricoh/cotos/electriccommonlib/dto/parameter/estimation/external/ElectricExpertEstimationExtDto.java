package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricExpertEstimationExtDto {

	/**
	 * MoM社員ID
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM社員ID", required = true, position = 3, allowableValues = "range[0,255]")
	private String momEmployeeId;

	/**
	 * 所属課所コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属課所コード", required = true, position = 4, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 修正時振替先コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "修正時振替先コード", required = true, position = 5, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;
	
}
