package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "契約ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

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
	@Schema(description = "案件名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 変更希望日
	 */
	@Size(max = 255)
	@Schema(description = "変更希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String changePreferredDate;

	/**
	 * 解約日
	 */
	@Size(max = 255)
	@Schema(description = "解約日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cancellationDate;

	/**
	 * 解約指定時刻
	 */
	@Size(max = 255)
	@Schema(description = "解約指定時刻", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cancellationSpecifiedTime;

	/**
	 * 連携パターン
	 */
	@Size(max = 255)
	@Schema(description = "連携パターン", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cooperationPattern;

	/**
	 * 契約(電力)
	 */
	@Valid
	@NotNull
	@Schema(description = "契約(電力)", requiredMode = Schema.RequiredMode.REQUIRED)
	private RegisterArrangementResultContractElectricExtDto contractElectric;

	/**
	 * 顧客
	 */
	@Valid
	@NotNull
	@Schema(description = "顧客", requiredMode = Schema.RequiredMode.REQUIRED)
	private RegisterArrangementResultCustomerContractExtDto customerContract;

	/**
	 * 契約担当者メールアドレス
	 */
	@Valid
	@Schema(description = "契約担当者メールアドレス", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<RegisterArrangementResultMailAddressInfoExtDto> contractPersonMailAddressList;

	/**
	 * 請求先メールアドレスリスト
	 */
	@Valid
	@Schema(description = "請求先メールアドレスリスト", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<RegisterArrangementResultBillingMailAddressInfoExtDto> billingMailAddressList;

	/**
	 * 契約担当SA社員
	 */
	@Valid
	@NotNull
	@Schema(description = "契約担当SA社員", requiredMode = Schema.RequiredMode.REQUIRED)
	private RegisterArrangementResultContractPicSaEmpExtDto contractPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private RegisterArrangementResultElectricExpertContractExtDto electricExpertContract;

	/**
	 * 追加編集者
	 */
	@Valid
	@Schema(description = "追加編集者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<RegisterArrangementResultContractAddedEditorEmpExtDto> contractAddedEditorEmpList;

	/**
	 * 販売店情報
	 */
	@Valid
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private RegisterArrangementResultElectricDealerContractExtDto electricDealerContract;
}
