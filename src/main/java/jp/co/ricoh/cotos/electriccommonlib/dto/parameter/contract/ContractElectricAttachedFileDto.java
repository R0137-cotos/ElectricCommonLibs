package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile.ElectricDispFileType;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricAttachedFileRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ContractElectricAttachedFile.class, repository = ContractElectricAttachedFileRepository.class)
public class ContractElectricAttachedFileDto extends DtoBase {

	/**
	 * ファイル名
	 */
	@Size(max = 255)
	@Schema(description = "ファイル名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Size(max = 255)
	@Schema(description = "ファイル種類", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fileKind;

	/**
	 * 添付ファイルID
	 */
	@Schema(description = "添付ファイルID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private Long attachedFileId;

	/**
	 * コメント
	 */
	@Size(max = 1000)
	@Schema(description = "コメント", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String attachedComment;

	/**
	 * 添付者MoM社員ID
	 */
	@Size(max = 255)
	@Schema(description = "添付者MoM社員ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String attachedEmpId;

	/**
	 * 添付者氏名
	 */
	@Size(max = 255)
	@Schema(description = "添付者氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String attachedEmpName;

	/**
	 * 添付者組織名
	 */
	@Size(max = 255)
	@Schema(description = "添付者組織名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String attachedOrgName;

	/**
	 * 添付日時
	 */
	@Schema(description = "添付日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.TIMESTAMP)
	private Date attachedAt;

	/**
	 * 電力用ファイル種別
	 */
	@NotNull
	@Schema(description = "電力用ファイル種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "新規(\"1\"), 変更(\"2\"), 解約(\"3\"),その他(\"99\")", example = "1")
	private ElectricDispFileType electricFileType;

	/**
	 * 添付必須フラグ
	 */
	@NotNull
	@Max(9)
	@Min(0)
	@Schema(description = "添付必須フラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int targetRequiredFlg;

	/**
	 * アクティブflg
	 */
	@NotNull
	@Max(9)
	@Min(0)
	@Schema(description = "アクティブflg", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int activeFlg;

	/**
	 * 書類名称
	 */
	@Size(max = 255)
	@Schema(description = "書類名称", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String documentName;

	/**
	 * マスタープリセットフラグ
	 */
	@NotNull
	@Max(9)
	@Min(0)
	@Schema(description = "マスタープリセットフラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int masterPresetFlg;
}
