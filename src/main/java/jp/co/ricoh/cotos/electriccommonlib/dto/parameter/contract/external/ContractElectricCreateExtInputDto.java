package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricCreateExtInputDto {

	/**
	 * 案件番号
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 得意先コード(契約(電力))
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "得意先コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 変更希望日
	 */
	@Size(max = 255)
	@Schema(description = "変更希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String changePreferredDate;

	/**
	 * 契約(電力)
	 */
	@Valid
	@NotNull
	@Schema(description = "契約(電力)", requiredMode = Schema.RequiredMode.REQUIRED)
	private ContractElectricCreateExtDto contractElectric;

	/**
	 * 顧客
	 */
	@Valid
	@NotNull
	@Schema(description = "顧客", requiredMode = Schema.RequiredMode.REQUIRED)
	private CustomerContractCreateExtDto customerContract;

	/**
	 * 契約担当者メールアドレス
	 */
	@Valid
	@NotNull
	@Schema(description = "契約担当者メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<MailAddressInformationCreateExtDto> contractPersonMailAddressList;

	/**
	 * 請求先メールアドレスリスト
	 */
	@Valid
	@NotNull
	@Schema(description = "請求先メールアドレスリスト", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<BillingMailAddressInformationCreateExtDto> billingMailAddressList;

	/**
	 * 契約担当SA社員
	 */
	@Valid
	@NotNull
	@Schema(description = "契約担当SA社員", requiredMode = Schema.RequiredMode.REQUIRED)
	private ContractPicSaEmpCreateExtDto contractPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricExpertContractCreateExtDto electricExpertContract;

	/**
	 * 追加編集者
	 */
	@Valid
	@Schema(description = "追加編集者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ContractAddedEditorEmpCreateExtDto> contractAddedEditorEmpList;

	/**
	 * 重要項目説明者
	 */
	@Valid
	@Schema(description = "重要項目説明者", requiredMode = Schema.RequiredMode.REQUIRED)
	private ImportantPointExplainerCreateExtDto importantPointExplainer;

	/**
	 * 販売店情報
	 */
	@Valid
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricDealerContractCreateExtDto electricDealerContract;

	/**
	 * 料金シュミレーション
	 */
	@Valid
	@NotNull
	@Schema(description = "料金シュミレーション", requiredMode = Schema.RequiredMode.REQUIRED)
	private FeeSimulationHeadCreateExtDto feeSimulationHead;

}
