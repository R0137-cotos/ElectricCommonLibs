package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ファイル名", required = true, position = 3, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@NotNull
	@ApiModelProperty(value = "ファイル種類", required = true, position = 4, allowableValues = "請求書(\"1\"), 日別電力量明細表PDF(\"2\"), 日別電力量明細表Excel(\"3\")", example = "1")
	private FileKind fileKind;

	/**
	 * 物理ファイル名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "物理ファイル名", required = true, position = 5, allowableValues = "range[0,255]")
	private String filePhysicsName;

	/**
	 * ファイルサイズ
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "ファイルサイズ", required = true, position = 6, allowableValues = "range[0,9223372036854775807]")
	private long fileSize;

	/**
	 * コンテンツタイプ
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "コンテンツタイプ", required = true, position = 7, allowableValues = "range[0,255]")
	private String contentType;

	/**
	 * サーバーパス
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "サーバーパス", required = true, position = 8, allowableValues = "range[0,1000]")
	private String savedPath;

}
