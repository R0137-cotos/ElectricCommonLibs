package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "契約ID", required = false, position = 2)
	private long contractId;

	/**
	 * 案件番号
	 */
	@ApiModelProperty(value = "案件番号", required = false, position = 3)
	private String caseNumber;

	/**
	 * 契約番号
	 */
	@ApiModelProperty(value = "契約番号", required = false, position = 4)
	private String contractNumber;

	/**
	 * 契約番号枝番
	 */
	@ApiModelProperty(value = "契約番号枝番", required = false, position = 5)
	private int contractBranchNumber;

	/**
	 * 計上実績リスト
	 */
	@ApiModelProperty(value = "計上実績リスト", required = false, position = 6)
	private List<ElectricAppropriationResultDto> accountingDetailList;

}
