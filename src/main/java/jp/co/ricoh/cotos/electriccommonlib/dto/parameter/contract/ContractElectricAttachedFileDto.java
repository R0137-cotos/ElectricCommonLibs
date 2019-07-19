package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile.ElectricDispFileType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricAttachedFileDto extends DtoBase {

	/**
	 * ファイル名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ファイル名", required = false, position = 3, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ファイル種類", required = false, position = 4, allowableValues = "range[0,255]")
	private String fileKind;

	/**
	 * 添付ファイルID
	 */
	@ApiModelProperty(value = "添付ファイルID", required = false, position = 5, allowableValues = "range[0,9223372036854775807]")
	private Long attachedFileId;

	/**
	 * コメント
	 */
	@Size(max = 1000)
	@ApiModelProperty(value = "コメント", required = false, position = 6, allowableValues = "range[0,1000]")
	private String attachedComment;

	/**
	 * 添付者MoM社員ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "添付者MoM社員ID", required = false, position = 7, allowableValues = "range[0,255]")
	private String attachedEmpId;

	/**
	 * 添付者氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "添付者氏名", required = false, position = 8, allowableValues = "range[0,255]")
	private String attachedEmpName;

	/**
	 * 添付者組織名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "添付者組織名", required = false, position = 9, allowableValues = "range[0,255]")
	private String attachedOrgName;

	/**
	 * 添付日時
	 */
	@ApiModelProperty(value = "添付日時", required = false, position = 10)
	@Temporal(TemporalType.TIMESTAMP)
	private Date attachedAt;

	/**
	 * 電力用ファイル種別
	 */
	@NotNull
	@ApiModelProperty(value = "電力用ファイル種別", required = true, position = 11, allowableValues = "新規(\"1\"), 変更(\"2\"), 解約(\"3\"),その他(\"99\")", example = "1")
	private ElectricDispFileType electricFileType;

	/**
	 * 添付必須フラグ
	 */
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "添付必須フラグ", required = true, position = 12, allowableValues = "range[0,9]")
	private int targetRequiredFlg;

	/**
	 * アクティブflg
	 */
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アクティブflg", required = true, position = 13, allowableValues = "range[0,9]")
	private int activeFlg;

	/**
	 * 書類名称
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "書類名称", required = true, position = 14, allowableValues = "range[0,255]")
	private String documentName;
}
