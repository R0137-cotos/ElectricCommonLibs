package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 見積（電力用）を検索するためのキー項目クラスを表します。
 */
@Data
public class EstimationSearchParameter {

	/**
	 * 企業名
	 */
	@Parameter(description = "企業名:部分一致", required = false)
	@Schema(description = "企業名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchCustomerName;

	/**
	 * 事業所名
	 */
	@Parameter(description = "事業所名:部分一致", required = false)
	@Schema(description = "事業所名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchOfficeName;

	/**
	 * 部門名
	 */
	@Parameter(description = "部門名:部分一致", required = false)
	@Schema(description = "部門名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchDepartmentName;

	/**
	 * お客様企事部ID
	 */
	@Parameter(description = "お客様企事部ID", required = false)
	@Schema(description = "お客様企事部ID<br />お客様企事部IDにはMoM企事部IDを指定する。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerId;

	/**
	 * 担当者
	 */
	@Parameter(description = "担当営業：MoM社員IDを指定", required = false)
	@Schema(description = "担当営業<br />担当営業にはMoM社員IDを指定する。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picEmptxId;

	/**
	 * 第1階層： 担当支社
	 */
	@Parameter(description = "第1階層", required = false)
	@Schema(description = "第1階層<br />設定値はMoM組織ID。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picAffiliateId;

	/**
	 * 第2階層： 担当部門
	 */
	@Parameter(description = "第2階層", required = false)
	@Schema(description = "第2階層<br />設定値はMoM組織ID。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picDepartmentId;

	/**
	 * 第3階層： 担当課所
	 */
	@Parameter(description = "第3階層", required = false)
	@Schema(description = "第3階層<br />設定値はMoM組織ID。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picDivisionId;

	/**
	 * 商品名称
	 */
	@Parameter(description = "商品名称:部分一致", required = false)
	@Schema(description = "商品名称:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchElectricMenu;

	/**
	 * 見積ステータス
	 */
	@Parameter(description = "見積ステータス", required = false)
	@Schema(description = "見積ステータス<br />状態遷移上のワークフロー状態を表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String workflowStatus;

	/**
	 * 見積種別
	 */
	@Parameter(description = "見積種別", required = false)
	@Schema(description = "見積種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String estimationType;

	/**
	 * 見積番号
	 */
	@Parameter(description = "見積番号", required = false)
	@Schema(description = "見積番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,15]")
	private String estimationNumber;

	/**
	 * 見積件名
	 */
	@Parameter(description = "見積件名:部分一致", required = false)
	@Schema(description = "見積件名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchEstimationTitle;

	/**
	 * 案件番号
	 */
	@Parameter(description = "案件番号", required = false)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@Parameter(description = "案件名:部分一致", required = false)
	@Schema(description = "案件名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]") //
	private String likeSearchCaseTitle;

	/**
	 * 変更元契約番号
	 */
	@Parameter(description = "変更元契約番号", required = false)
	@Schema(description = "変更元契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,15]")
	private String originContractNumber;

	/**
	 * 変更元契約件名
	 */
	@Parameter(description = "変更元契約件名", required = false)
	@Schema(description = "変更元契約件名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String likeSearchOriginContractTitle;

	/**
	 * サービス識別番号
	 */
	@Parameter(description = "サービス識別番号", required = false)
	@Schema(description = "サービス識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,18]")
	private String serviceIdentificationNumber;

	/**
	 * 見積状態
	 */
	@Parameter(description = "見積状態", required = false)
	@Schema(description = "見積状態<br />状態遷移上のライフサイクル状態を表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String lifecycleStatus;

	/**
	 * 審査／承認者
	 */
	@Parameter(description = "審査／承認者：MoM社員IDを指定", required = false)
	@Schema(description = "審査／承認者<br />審査／承認者にはMoM社員IDを指定する。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String approvalEmptxId;

	/**
	 * 協力者
	 */
	@Parameter(description = "協力者：MoM社員IDを指定", required = false)
	@Schema(description = "協力者<br />協力者にはMoM社員IDを指定する。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String collaborationEmptxId;

	/**
	 * 見積更新日(前)
	 */
	@Parameter(description = "見積更新日(前)", required = false)
	@Schema(description = "見積更新日(前)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date estimationUpdatedFrom;

	/**
	 * 見積更新日(後)
	 */
	@Parameter(description = "見積更新日(後)", required = false)
	@Schema(description = "見積更新日(後)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date estimationUpdatedTo;

	/**
	 * 掲示日(前)
	 */
	@Parameter(description = "掲示日(前)", required = false)
	@Schema(description = "掲示日(前)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date presentationDateFrom;

	/**
	 * 掲示日(後)
	 */
	@Parameter(description = "掲示日(後)", required = false)
	@Schema(description = "掲示日(後)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date presentationDateTo;

	/**
	 * パラメータをMapにする。
	 */
	public Map<String, Object> createParamaterMap() {
		Map<String, Object> retMap = new HashMap<>();

		FieldUtils.getAllFieldsList(this.getClass()).stream().filter(putField -> !putField.getName().startsWith("$")).forEach(field -> {
			try {
				retMap.put(field.getName(), field.get(this));
			} catch (IllegalAccessException e) {
				retMap.put(field.getName(), null);
			}
		});

		return retMap;
	}

}