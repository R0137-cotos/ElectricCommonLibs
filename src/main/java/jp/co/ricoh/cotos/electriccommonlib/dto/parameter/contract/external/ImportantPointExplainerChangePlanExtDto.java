package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ImportantPointExplainerChangePlanExtDto {

	/**
	 * 説明者名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "説明者名", required = true, position = 1, allowableValues = "range[0,255]")
	private String descriptionName;

	/**
	 * 所属組織名1
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属組織名1", required = true, position = 2, allowableValues = "range[0,255]")
	private String organizationName1;

	/**
	 * 所属組織名2
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属組織名2", required = true, position = 3, allowableValues = "range[0,255]")
	private String organizationName2;
}
