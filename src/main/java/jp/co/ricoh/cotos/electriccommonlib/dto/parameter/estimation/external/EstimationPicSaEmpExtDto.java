package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationPicSaEmpExtDto {

	/**
	 * MoM社員ID
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "MoM社員ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String momEmployeeId;

}
