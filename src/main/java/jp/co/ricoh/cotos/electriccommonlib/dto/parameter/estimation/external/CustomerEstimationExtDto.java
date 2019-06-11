package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerEstimationExtDto {

	/**
	 * MoM企事部ID
	 */
	@NotNull
	@Size(max = 255)
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
	 * 顧客名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "顧客名", required = true, position = 5, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * 企業名
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "企業名", required = false, position = 6, allowableValues = "range[0,255]")
	private String companyName;

	/**
	 * 企業名（カナ）
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "企業名（カナ）", required = false, position = 7, allowableValues = "range[0,255]")
	private String companyNameKana;

	/**
	 * 事業所名
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "事業所名", required = false, position = 8, allowableValues = "range[0,255]")
	private String officeName;

	/**
	 * 部門名
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "部門名", required = false, position = 9, allowableValues = "range[0,255]")
	private String departmentName;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "郵便番号", required = false, position = 10, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Size(max = 1000)
	@NotNull
	@ApiModelProperty(value = "住所", required = false, position = 11, allowableValues = "range[0,1000]")
	private String address;

	/**
	 * 電話番号
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "電話番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * FAX番号
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "FAX番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String faxNumber;

	/**
	 * 企業代表者名
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "企業代表者名", required = false, position = 14, allowableValues = "range[0,255]")
	private String companyRepresentativeName;

	/**
	 * MoM非連携_担当者氏名
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "MoM非連携_担当者氏名", required = false, position = 15, allowableValues = "range[0,255]")
	private String picName;

	/**
	 * MoM非連携_担当者氏名（カナ）
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "MoM非連携_担当者氏名（カナ）", required = false, position = 16, allowableValues = "range[0,255]")
	private String picNameKana;

	/**
	 * MoM非連携_担当者部署
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "MoM非連携_担当者部署", required = false, position = 17, allowableValues = "range[0,255]")
	private String picDeptName;

	/**
	 * MoM非連携_担当者電話番号
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "MoM非連携_担当者電話番号", required = false, position = 18, allowableValues = "range[0,255]")
	private String picPhoneNumber;

	/**
	 * MoM非連携_担当者FAX番号
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "MoM非連携_担当者FAX番号", required = false, position = 19, allowableValues = "range[0,255]")
	private String picFaxNumber;

	/**
	 * MoM非連携_担当者メールアドレス
	 */
	@Size(max = 255)
	@NotNull
	@ApiModelProperty(value = "MoM非連携_担当者メールアドレス", required = false, position = 20, allowableValues = "range[0,255]")
	private String picMailAddress;

}
