package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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

	/**
	 * 連絡先
	 */
	@Size(max = 255)
	@Schema(description = "連絡先", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactInformation;

	/**
	 * 会社名
	 */
	@Size(max = 255)
	@Schema(description = "会社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyName;
}
