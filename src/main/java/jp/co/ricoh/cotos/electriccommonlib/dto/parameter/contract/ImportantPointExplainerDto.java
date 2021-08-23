package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ImportantPointExplainer;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ImportantPointExplainerRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ImportantPointExplainer.class, repository = ImportantPointExplainerRepository.class)
public class ImportantPointExplainerDto extends DtoBase {

	/**
	 * 説明者名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "説明者名", required = false, position = 3, allowableValues = "range[0,255]")
	private String descriptionName;

	/**
	 * 所属組織名1
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属組織名1", required = false, position = 4, allowableValues = "range[0,255]")
	private String organizationName1;

	/**
	 * 所属組織名2
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属組織名2", required = false, position = 5, allowableValues = "range[0,255]")
	private String organizationName2;

	/**
	 * 連絡先
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "連絡先", required = false, position = 6, allowableValues = "range[0,255]")
	private String contactInformation;

	/**
	 * 会社名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "会社名", required = false, position = 7, allowableValues = "range[0,255]")
	private String companyName;
}
