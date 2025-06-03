package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricChangePlanExtInputDto {

	/**
	 * 変更元契約ID(プラン変更で使用)
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "変更元契約ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

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
	 * 得意先コード(契約(電力))
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "得意先コード", required = true, position = 4, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 変更希望日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "変更希望日", required = false, position = 5, allowableValues = "range[0,255]")
	private String changePreferredDate;

	/**
	 * 契約(電力)
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約(電力)", required = true, position = 6)
	private ContractElectricChangePlanExtDto contractElectric;

	/**
	 * 顧客
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "顧客", required = true, position = 7)
	private CustomerContractChangePlanExtDto customerContract;

	/**
	 * 契約担当者メールアドレス
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約担当者メールアドレス", required = true, position = 8)
	private List<MailAddressInformationChangePlanExtDto> contractPersonMailAddressList;

	/**
	 * 請求先メールアドレスリスト
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "請求先メールアドレスリスト", required = true, position = 9)
	private List<BillingMailAddressInformationChangePlanExtDto> billingMailAddressList;

	/**
	 * 契約担当SA社員
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約担当SA社員", required = true, position = 10)
	private ContractPicSaEmpChangePlanExtDto contractPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "電力専任情報", required = true, position = 11)
	private ElectricExpertContractChangePlanExtDto electricExpertContract;

	/**
	 * 追加編集者
	 */
	@Valid
	@ApiModelProperty(value = "追加編集者", required = false, position = 12)
	private List<ContractAddedEditorEmpChangePlanExtDto> contractAddedEditorEmpList;

	/**
	 * 重要項目説明者
	 */
	@Valid
	@ApiModelProperty(value = "重要項目説明者", required = true, position = 13)
	private ImportantPointExplainerChangePlanExtDto importantPointExplainer;

	/**
	 * 販売店情報
	 */
	@Valid
	@ApiModelProperty(value = "販売店情報", required = false, position = 14)
	private ElectricDealerContractChangePlanExtDto electricDealerContract;

	/**
	 * 料金シュミレーション
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "料金シュミレーション", required = true, position = 15)
	private FeeSimulationHeadChangePlanExtDto feeSimulationHead;

}
