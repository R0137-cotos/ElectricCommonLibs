package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerContractCreateExtDto {

	/**
	 * MoM企事部ID
	 */
	@NotNull
	@Size(max = 255)
	@Column(nullable = false)
	@Schema(description = "MoM企事部ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String momCustId;

	/**
	 * MoM企業ID
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "MoM企業ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * MoM事業所ID
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "MoM事業所ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String officeId;

	/**
	 * MoM非連携_担当者氏名
	 */
	@Size(max = 255)
	@Schema(description = "MoM非連携_担当者氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picName;

	/**
	 * MoM非連携_担当者氏名（カナ）
	 */
	@Size(max = 255)
	@Schema(description = "MoM非連携_担当者氏名（カナ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picNameKana;

	/**
	 * MoM非連携_担当者部署
	 */
	@Size(max = 255)
	@Schema(description = "MoM非連携_担当者部署", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picDeptName;

	/**
	 * MoM非連携_担当者電話番号
	 */
	@Size(max = 255)
	@Schema(description = "MoM非連携_担当者電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picPhoneNumber;

	/**
	 * MoM非連携_担当者FAX番号
	 */
	@Size(max = 255)
	@Schema(description = "MoM非連携_担当者FAX番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picFaxNumber;

	/**
	 * MoM非連携_担当者メールアドレス
	 */
	@Size(max = 255)
	@Schema(description = "MoM非連携_担当者メールアドレス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picMailAddress;
}
