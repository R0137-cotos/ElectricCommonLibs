package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ImportantPointExplainerCreateExtDto {

	/**
	 * 説明者名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "説明者名", required = false, position = 1, allowableValues = "range[0,255]")
	private String descriptionName;

	/**
	 * 所属組織名1
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属組織名1", required = false, position = 2, allowableValues = "range[0,255]")
	private String organizationName1;

	/**
	 * 所属組織名2
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属組織名2", required = false, position = 3, allowableValues = "range[0,255]")
	private String organizationName2;
}
