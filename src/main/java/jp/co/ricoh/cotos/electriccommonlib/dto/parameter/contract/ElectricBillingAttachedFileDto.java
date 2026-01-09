package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricBillingAttachedFile;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricBillingAttachedFile.FileKind;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricBillingAttachedFileRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ElectricBillingAttachedFile.class, repository = ElectricBillingAttachedFileRepository.class)
public class ElectricBillingAttachedFileDto extends DtoBase {

	/**
	 * ファイル名
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "ファイル名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@NotNull
	@Schema(description = "ファイル種類", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "請求書(\"1\"), 日別電力量明細表PDF(\"2\"), 日別電力量明細表Excel(\"3\")", example = "1")
	private FileKind fileKind;

	/**
	 * 物理ファイル名
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "物理ファイル名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String filePhysicsName;

	/**
	 * ファイルサイズ
	 */
	@NotNull
	@Min(0)
	@Schema(description = "ファイルサイズ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long fileSize;

	/**
	 * コンテンツタイプ
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "コンテンツタイプ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String contentType;

	/**
	 * サーバーパス
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "サーバーパス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,1000]")
	private String savedPath;

}
