package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 契約（電力）に紐づく請求情報をリスト取得するためのDtoです。<br/>
 * このクラスを使用してDBへの保存を行うことは出来ません。
 */
@Data
public class BillingInformationSearchResult {

	/**
	 * 契約ID
	 */
	@Schema(description = "契約ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private long contractId;

	/**
	 * 案件番号
	 */
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String caseNumber;

	/**
	 * 契約番号
	 */
	@Schema(description = "契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String contractNumber;

	/**
	 * 契約番号枝番
	 */
	@Schema(description = "契約番号枝番", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private int contractBranchNumber;

	/**
	 * 計上実績リスト
	 */
	@Schema(description = "計上実績リスト", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ElectricAppropriationResultDto> accountingDetailList;

}
