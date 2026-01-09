package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ImportantPointExplainerCreateExtDto {

	/**
	 * 説明者名
	 */
	@Size(max = 255)
	@Schema(description = "説明者名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String descriptionName;

	/**
	 * 所属組織名1
	 */
	@Size(max = 255)
	@Schema(description = "所属組織名1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String organizationName1;

	/**
	 * 所属組織名2
	 */
	@Size(max = 255)
	@Schema(description = "所属組織名2", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String organizationName2;
}
