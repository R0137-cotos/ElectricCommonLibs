package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 契約を検索するためのキー項目クラスを表します。
 */
@Data
public class ContractSearchParameter {

	/**
	 * お客様企業名
	 */
	@Parameter(description = "お客様企業名:部分一致", required = false)
	@Schema(description = "お客様企業名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchCustomerName;

	/**
	 * お客様事業所名
	 */
	@Parameter(description = "お客様事業所名:部分一致", required = false)
	@Schema(description = "お客様事業所名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchOfficeName;

	/**
	 * お客様部門名
	 */
	@Parameter(description = "お客様部門名:部分一致", required = false)
	@Schema(description = "お客様部門名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchDepartmentName;

	/**
	 * お客様企事部ID
	 */
	@Parameter(description = "お客様企事部ID", required = false)
	@Schema(description = "お客様企事部ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerId;

	/**
	 * 得意先コード
	 */
	@Parameter(description = "得意先コード", required = false)
	@Schema(description = "得意先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingCustomerSpCode;

	/**
	 * 担当者
	 */
	@Parameter(description = "担当者：MoM社員IDを指定", required = false)
	@Schema(description = "担当者<br />担当者にはMoM社員IDを指定する。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picEmptxId;

	/**
	 * 担当支社
	 */
	@Parameter(description = "第1階層", required = false)
	@Schema(description = "第1階層<br />" //
			+ "設定値はMoM組織ID。", //
			requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]") //
	private String picAffiliateId;

	/**
	 * 担当部門
	 */
	@Parameter(description = "第2階層", required = false)
	@Schema(description = "第2階層<br />" //
			+ "設定値はMoM組織ID。", //
			requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]") //
	private String picDepartmentId;

	/**
	 * 担当課所
	 */
	@Parameter(description = "第3階層", required = false)
	@Schema(description = "第3階層<br />" //
			+ "設定値はMoM組織ID。", //
			requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]") //
	private String picDivisionId;

	/**
	 * 契約ステータス
	 */
	@Parameter(description = "契約ステータス", required = false)
	@Schema(description = "契約ステータス<br />状態遷移上のワークフローステータスを表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String workflowStatus;

	/**
	 * 契約番号
	 */
	@Parameter(description = "契約番号", required = false)
	@Schema(description = "契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,15]")
	private String contractNumber;

	/**
	 * 電力区分
	 */
	@Parameter(description = "電力区分", required = false)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String voltageCategory;

	/**
	 * 商品名称
	 */
	@Parameter(description = "商品名称:部分一致", required = false)
	@Schema(description = "商品名称:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String likeSearchElectricMenu;

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
	@Schema(description = "案件名:部分一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[2,255]")
	private String likeSearchCaseTitle;

	/**
	 * 契約状態
	 */
	@Parameter(description = "契約状態", required = false)
	@Schema(description = "契約状態<br />状態遷移上のライフサイクル状態を表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String lifecycleStatus;

	/**
	 * サービス開始日(前)
	 */
	@Parameter(description = "サービス開始日(前)", required = false)
	@Schema(description = "サービス開始日(前)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date serviceTermStartFrom;

	/**
	 * サービス開始日(後)
	 */
	@Parameter(description = "サービス開始日(後)", required = false)
	@Schema(description = "サービス開始日(後)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date serviceTermStartTo;

	/**
	 * サービス終了日(前)
	 */
	@Parameter(description = "サービス終了日(前)", required = false)
	@Schema(description = "サービス終了日(前)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date serviceTermEndFrom;

	/**
	 * サービス終了日(後)
	 */
	@Parameter(description = "サービス終了日(後)", required = false)
	@Schema(description = "サービス終了日(後)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date serviceTermEndTo;

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
	 * お客様識別番号
	 */
	@Parameter(description = "お客様識別番号", required = false)
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Parameter(description = "供給地点特定番号", required = false)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 電力会社
	 */
	@Parameter(description = "電力会社:前方一致", required = false)
	@Schema(description = "電力会社:前方一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String likeSearchPowerCompany;

	/**
	 * 電力専任 - 氏名
	 */
	@Parameter(description = "電力専任 - 氏名:前方一致", required = false)
	@Schema(description = "電力専任 - 氏名:前方一致<br />条件入力時、最低2文字以上の入力とする。", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String likeSearchElectricExpertName;

	/**
	 * 請求書発送区分
	 */
	@Parameter(description = "請求書発送区分", required = false)
	@Schema(description = "請求書発送区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String sendInvoiceDiv;

	/**
	 * 請求No
	 */
	@Parameter(description = "請求No", required = false)
	@Schema(description = "請求No", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求月
	 */
	@Parameter(description = "請求月", required = false)
	@Schema(description = "請求月<br />日付フォーマット：yyyy/MM", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String billingYearMonth;

	/**
	 * 商流区分
	 */
	@Parameter(description = "商流区分", required = false)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String commercialFlowDiv;

	/**
	 * 未回収フラグ
	 */
	@Parameter(description = "未回収フラグ", required = false)
	@Schema(description = "未回収フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer accruedFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Parameter(description = "原子力立地給付金フラグ", required = false)
	@Schema(description = "原子力立地給付金フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer atomicPaymentFlg;

	/**
	 * 解約年月日(前)
	 */
	@Parameter(description = "解約年月日(前)", required = false)
	@Schema(description = "解約年月日(前)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationDateFrom;

	/**
	 * 解約年月日(後)
	 */
	@Parameter(description = "解約年月日(後)", required = false)
	@Schema(description = "解約年月日(後)<br />日付フォーマット:yyyy/MM/dd", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationDateTo;

	/**
	 * 解約金請求フラグ
	 */
	@Parameter(description = "解約金請求フラグ", required = false)
	@Schema(description = "解約金請求フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer cancellationBillingFlg;

	/**
	 * メールアドレス区分
	 */
	@Parameter(description = "メールアドレス区分", required = false)
	@Schema(description = "メールアドレス区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String mailAddressInformationMailIdentification;

	/**
	 * メールアドレス
	 */
	@Parameter(description = "メールアドレス", required = false)
	@Schema(description = "メールアドレス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddressInformationMailAddress;

	/**
	 * Mailアドレス情報 - 氏名
	 */
	@Parameter(description = "Mailアドレス情報 - 氏名", required = false)
	@Schema(description = "Mailアドレス情報 - 氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddressInformationName;

	/**
	 * 契約情報更新日(前)
	 */
	@Parameter(description = "契約情報更新日(前)", required = false)
	@Schema(description = "契約情報更新日(前)<br />日付フォーマット:yyyyMMddhhmmss", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String updateFrom;

	/**
	 * 契約情報更新日(後)
	 */
	@Parameter(description = "契約情報更新日(後)", required = false)
	@Schema(description = "契約情報更新日(後)<br />日付フォーマット:yyyyMMddhhmmss", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String updateTo;

	/**
	 * 該当なし
	 */
	@Parameter(description = "該当なし", required = false)
	@Schema(description = "該当なし", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer notApplicableFlg;

	/**
	 * 予備線
	 */
	@Parameter(description = "予備線", required = false)
	@Schema(description = "予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@Parameter(description = "予備電源", required = false)
	@Schema(description = "予備電源", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@Parameter(description = "アンシラリーサービス", required = false)
	@Schema(description = "アンシラリーサービス", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer ancillaryFlg;

	/**
	 * 蓄熱計量器継続
	 */
	@Parameter(description = "蓄熱計量器継続", required = false)
	@Schema(description = "蓄熱計量器継続", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer thermalStorageMeterFlg;

	/**
	 * 再エネ賦課金減免措置
	 */
	@Parameter(description = "再エネ賦課金減免措置", required = false)
	@Schema(description = "再エネ賦課金減免措置", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer renewableEnergyExemptionFlg;

	/**
	 * 需要地内転売契約
	 */
	@Parameter(description = "需要地内転売契約", required = false)
	@Schema(description = "需要地内転売契約", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer demandPlaceResales;

	/**
	 * 部分供給
	 */
	@Parameter(description = "部分供給", required = false)
	@Schema(description = "部分供給", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer partialSupplyFlg;

	/**
	 * 東北取次（新規）
	 */
	@Parameter(description = "東北取次（新規）", required = false)
	@Schema(description = "東北取次（新規）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer tohokuAgencyNewFlg;

	/**
	 * 東北取次（RJ電力からの切り替え）
	 */
	@Parameter(description = "東北取次（RJ電力からの切り替え）", required = false)
	@Schema(description = "東北取次（RJ電力からの切り替え）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer tohokuAgencySwitchFlg;

	/**
	 * 協議制で契約電力増加の場合
	 */
	@Parameter(description = "協議制で契約電力増加の場合", required = false)
	@Schema(description = "協議制で契約電力増加の場合", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer increaseElectricPowerFlg;

	/**
	 * その他
	 */
	@Parameter(description = "その他", required = false)
	@Schema(description = "その他", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer otherFlg;

	/**
	 * 契約種別
	 */
	@Parameter(description = "契約種別", required = false)
	@Schema(description = "契約種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String contractType;

	/**
	 * 更新案件は除く
	 */
	@Parameter(description = "更新案件は除く", required = false)
	@Schema(description = "更新案件は除く", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer autoUpdateExclude;

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