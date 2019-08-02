package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class RegisterArrangementResultExtDto {

	/**
	 * 契約ID
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "契約ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

	/**
	 * 案件番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "案件番号", required = true, position = 2, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "案件名", required = true, position = 3, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 変更希望日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "変更希望日", required = false, position = 4, allowableValues = "range[0,255]")
	private String changePreferredDate;

	/**
	 * 契約(電力)
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約(電力)", required = true, position = 5)
	private RegisterArrangementResultContractElectricExtDto contractElectric;

	/**
	 * 顧客
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "顧客", required = true, position = 6)
	private RegisterArrangementResultCustomerContractExtDto customerContract;

	/**
	 * 契約担当者メールアドレス
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約担当者メールアドレス", required = true, position = 7)
	private List<RegisterArrangementResultMailAddressInfoExtDto> contractPersonMailAddressList;

	/**
	 * 請求先メールアドレスリスト
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "請求先メールアドレスリスト", required = true, position = 8)
	private List<RegisterArrangementResultBillingMailAddressInfoExtDto> billingMailAddressList;

	/**
	 * 契約担当SA社員
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約担当SA社員", required = true, position = 9)
	private RegisterArrangementResultContractPicSaEmpExtDto contractPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "電力専任情報", required = true, position = 10)
	private RegisterArrangementResultElectricExpertContractExtDto electricExpertContract;

	/**
	 * 追加編集者
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "追加編集者", required = true, position = 11)
	private List<RegisterArrangementResultContractAddedEditorEmpExtDto> contractAddedEditorEmpList;

	/**
	 * 販売店情報
	 */
	@Valid
	@ApiModelProperty(value = "販売店情報", required = false, position = 12)
	private RegisterArrangementResultElectricDealerContractExtDto electricDealerContract;
}
