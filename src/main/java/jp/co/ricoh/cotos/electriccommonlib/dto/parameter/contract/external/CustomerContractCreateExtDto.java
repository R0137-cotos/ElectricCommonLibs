package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "MoM企事部ID", required = true, position = 1, allowableValues = "range[0,255]")
	private String momCustId;
	
	/**
	 * MoM企業ID
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM企業ID", required = true, position = 2, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * MoM事業所ID
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM事業所ID", required = true, position = 3, allowableValues = "range[0,255]")
	private String officeId;
	
	/**
	 * MoM非連携_担当者氏名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM非連携_担当者氏名", required = true, position = 4, allowableValues = "range[0,255]")
	private String picName;

	/**
	 * MoM非連携_担当者氏名（カナ）
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM非連携_担当者氏名（カナ）", required = true, position = 5, allowableValues = "range[0,255]")
	private String picNameKana;

	/**
	 * MoM非連携_担当者部署
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM非連携_担当者部署", required = true, position = 6, allowableValues = "range[0,255]")
	private String picDeptName;

	/**
	 * MoM非連携_担当者電話番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM非連携_担当者電話番号", required = true, position = 7, allowableValues = "range[0,255]")
	private String picPhoneNumber;

	/**
	 * MoM非連携_担当者FAX番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM非連携_担当者FAX番号", required = true, position = 8, allowableValues = "range[0,255]")
	private String picFaxNumber;

	/**
	 * MoM非連携_担当者メールアドレス
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM非連携_担当者メールアドレス", required = true, position = 9, allowableValues = "range[0,255]")
	private String picMailAddress;
}
