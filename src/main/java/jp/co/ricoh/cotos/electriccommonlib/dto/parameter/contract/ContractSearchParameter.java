package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 契約を検索するためのキー項目クラスを表します。
 */
@Data
public class ContractSearchParameter {

	/**
	 * お客様企業名
	 */
	@ApiParam(value = "お客様企業名:部分一致", required = false)
	@ApiModelProperty(value = "お客様企業名:部分一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[2,255]")
	private String likeSearchCustomerName;

	/**
	 * お客様事業所名
	 */
	@ApiParam(value = "お客様事業所名:部分一致", required = false)
	@ApiModelProperty(value = "お客様事業所名:部分一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[2,255]")
	private String likeSearchOfficeName;

	/**
	 * お客様部門名
	 */
	@ApiParam(value = "お客様部門名:部分一致", required = false)
	@ApiModelProperty(value = "お客様部門名:部分一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[2,255]")
	private String likeSearchDepartmentName;

	/**
	 * お客様企事部ID
	 */
	@ApiParam(value = "お客様企事部ID", required = false)
	@ApiModelProperty(value = "お客様企事部ID", required = false, allowableValues = "range[0,255]")
	private String customerId;

	/**
	 * 得意先コード
	 */
	@ApiParam(value = "得意先コード", required = false)
	@ApiModelProperty(value = "得意先コード", required = false, allowableValues = "range[0,255]")
	private String billingCustomerSpCode;

	/**
	 * 担当者
	 */
	@ApiParam(value = "担当者：MoM社員IDを指定", required = false)
	@ApiModelProperty(value = "担当者<br />担当者にはMoM社員IDを指定する。", required = false, allowableValues = "range[0,255]")
	private String picEmptxId;

	/**
	 * 担当支社
	 */
	@ApiParam(value = "第1階層", required = false)
	@ApiModelProperty(value = "第1階層<br />" //
			+ "設定値はMoM組織ID。", //
			required = false, allowableValues = "range[0,255]") //
	private String picAffiliateId;

	/**
	 * 担当部門
	 */
	@ApiParam(value = "第2階層", required = false)
	@ApiModelProperty(value = "第2階層<br />" //
			+ "設定値はMoM組織ID。", //
			required = false, allowableValues = "range[0,255]") //
	private String picDepartmentId;

	/**
	 * 担当課所
	 */
	@ApiParam(value = "第3階層", required = false)
	@ApiModelProperty(value = "第3階層<br />" //
			+ "設定値はMoM組織ID。", //
			required = false, allowableValues = "range[0,255]") //
	private String picDivisionId;

	/**
	 * 契約ステータス
	 */
	@ApiParam(value = "契約ステータス", required = false)
	@ApiModelProperty(value = "契約ステータス<br />状態遷移上のワークフローステータスを表す。", required = false)
	private String workflowStatus;

	/**
	 * 契約番号
	 */
	@ApiParam(value = "契約番号", required = false)
	@ApiModelProperty(value = "契約番号", required = false, allowableValues = "range[0,15]")
	private String contractNumber;

	/**
	 * 電力区分
	 */
	@ApiParam(value = "電力区分", required = false)
	@ApiModelProperty(value = "電力区分", required = false)
	private String voltageCategory;

	/**
	 * 商品名称
	 */
	@ApiParam(value = "商品名称:部分一致", required = false)
	@ApiModelProperty(value = "商品名称:部分一致<br />条件入力時、最低2文字以上の入力とする。", required = false)
	private String likeSearchElectricMenu;

	/**
	 * 見積番号
	 */
	@ApiParam(value = "見積番号", required = false)
	@ApiModelProperty(value = "見積番号", required = false, allowableValues = "range[0,15]")
	private String estimationNumber;

	/**
	 * 見積件名
	 */
	@ApiParam(value = "見積件名:部分一致", required = false)
	@ApiModelProperty(value = "見積件名:部分一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[2,255]")
	private String likeSearchEstimationTitle;

	/**
	 * 案件番号
	 */
	@ApiParam(value = "案件番号", required = false)
	@ApiModelProperty(value = "案件番号", required = false, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@ApiParam(value = "案件名:部分一致", required = false)
	@ApiModelProperty(value = "案件名:部分一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[2,255]")
	private String likeSearchCaseTitle;

	/**
	 * 契約状態
	 */
	@ApiParam(value = "契約状態", required = false)
	@ApiModelProperty(value = "契約状態<br />状態遷移上のライフサイクル状態を表す。", required = false)
	private String lifecycleStatus;

	/**
	 * サービス開始日(前)
	 */
	@ApiParam(value = "サービス開始日(前)", required = false)
	@ApiModelProperty(value = "サービス開始日(前)<br />日付フォーマット:yyyy/MM/dd", required = false)
	private Date serviceTermStartFrom;

	/**
	 * サービス開始日(後)
	 */
	@ApiParam(value = "サービス開始日(後)", required = false)
	@ApiModelProperty(value = "サービス開始日(後)<br />日付フォーマット:yyyy/MM/dd", required = false)
	private Date serviceTermStartTo;

	/**
	 * サービス終了日(前)
	 */
	@ApiParam(value = "サービス終了日(前)", required = false)
	@ApiModelProperty(value = "サービス終了日(前)<br />日付フォーマット:yyyy/MM/dd", required = false)
	private Date serviceTermEndFrom;

	/**
	 * サービス終了日(後)
	 */
	@ApiParam(value = "サービス終了日(後)", required = false)
	@ApiModelProperty(value = "サービス終了日(後)<br />日付フォーマット:yyyy/MM/dd", required = false)
	private Date serviceTermEndTo;

	/**
	 * 審査／承認者
	 */
	@ApiParam(value = "審査／承認者：MoM社員IDを指定", required = false)
	@ApiModelProperty(value = "審査／承認者<br />審査／承認者にはMoM社員IDを指定する。", required = false, allowableValues = "range[0,255]")
	private String approvalEmptxId;

	/**
	 * 協力者
	 */
	@ApiParam(value = "協力者：MoM社員IDを指定", required = false)
	@ApiModelProperty(value = "協力者<br />協力者にはMoM社員IDを指定する。", required = false, allowableValues = "range[0,255]")
	private String collaborationEmptxId;

	/**
	 * お客様識別番号
	 */
	@ApiParam(value = "お客様識別番号", required = false)
	@ApiModelProperty(value = "お客様識別番号", required = false, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@ApiParam(value = "供給地点特定番号", required = false)
	@ApiModelProperty(value = "供給地点特定番号", required = false, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 電力会社
	 */
	@ApiParam(value = "電力会社:前方一致", required = false)
	@ApiModelProperty(value = "電力会社:前方一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[0,255]")
	private String likeSearchPowerCompany;

	/**
	 * 電力専任 - 氏名
	 */
	@ApiParam(value = "電力専任 - 氏名:前方一致", required = false)
	@ApiModelProperty(value = "電力専任 - 氏名:前方一致<br />条件入力時、最低2文字以上の入力とする。", required = false, allowableValues = "range[0,255]")
	private String likeSearchElectricExpertName;

	/**
	 * 請求書発送区分
	 */
	@ApiParam(value = "請求書発送区分", required = false)
	@ApiModelProperty(value = "請求書発送区分", required = false)
	private String sendInvoiceDiv;

	/**
	 * 請求No
	 */
	@ApiParam(value = "請求No", required = false)
	@ApiModelProperty(value = "請求No", required = false, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求月
	 */
	@ApiParam(value = "請求月", required = false)
	@ApiModelProperty(value = "請求月<br />日付フォーマット：yyyy/MM", required = false)
	private String billingYearMonth;

	/**
	 * 商流区分
	 */
	@ApiParam(value = "商流区分", required = false)
	@ApiModelProperty(value = "商流区分", required = false)
	private String commercialFlowDiv;

	/**
	 * 未回収フラグ
	 */
	@ApiParam(value = "未回収フラグ", required = false)
	@ApiModelProperty(value = "未回収フラグ", required = false)
	private Integer accruedFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@ApiParam(value = "原子力立地給付金フラグ", required = false)
	@ApiModelProperty(value = "原子力立地給付金フラグ", required = false)
	private Integer atomicPaymentFlg;

	/**
	 * 解約年月日(前)
	 */
	@ApiParam(value = "解約年月日(前)", required = false)
	@ApiModelProperty(value = "解約年月日(前)<br />日付フォーマット:yyyy/MM/dd", required = false)
	private Date cancellationDateFrom;

	/**
	 * 解約年月日(後)
	 */
	@ApiParam(value = "解約年月日(後)", required = false)
	@ApiModelProperty(value = "解約年月日(後)<br />日付フォーマット:yyyy/MM/dd", required = false)
	private Date cancellationDateTo;

	/**
	 * 解約金請求フラグ
	 */
	@ApiParam(value = "解約金請求フラグ", required = false)
	@ApiModelProperty(value = "解約金請求フラグ", required = false)
	private Integer cancellationBillingFlg;

	/**
	 * メールアドレス区分
	 */
	@ApiParam(value = "メールアドレス区分", required = false)
	@ApiModelProperty(value = "メールアドレス区分", required = false)
	private String mailAddressInformationMailIdentification;

	/**
	 * メールアドレス
	 */
	@ApiParam(value = "メールアドレス", required = false)
	@ApiModelProperty(value = "メールアドレス", required = false, allowableValues = "range[0,255]")
	private String mailAddressInformationMailAddress;

	/**
	 * Mailアドレス情報 - 氏名
	 */
	@ApiParam(value = "Mailアドレス情報 - 氏名", required = false)
	@ApiModelProperty(value = "Mailアドレス情報 - 氏名", required = false, allowableValues = "range[0,255]")
	private String mailAddressInformationName;

	/**
	 * 契約情報更新日(前)
	 */
	@ApiParam(value = "契約情報更新日(前)", required = false)
	@ApiModelProperty(value = "契約情報更新日(前)<br />日付フォーマット:yyyyMMddhhmmss", required = false)
	private String updateFrom;

	/**
	 * 契約情報更新日(後)
	 */
	@ApiParam(value = "契約情報更新日(後)", required = false)
	@ApiModelProperty(value = "契約情報更新日(後)<br />日付フォーマット:yyyyMMddhhmmss", required = false)
	private String updateTo;

	/**
	 * 該当なし
	 */
	@ApiParam(value = "該当なし", required = false)
	@ApiModelProperty(value = "該当なし", required = false)
	private Integer notApplicableFlg;

	/**
	 * 予備線
	 */
	@ApiParam(value = "予備線", required = false)
	@ApiModelProperty(value = "予備線", required = false)
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@ApiParam(value = "予備電源", required = false)
	@ApiModelProperty(value = "予備電源", required = false)
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@ApiParam(value = "アンシラリーサービス", required = false)
	@ApiModelProperty(value = "アンシラリーサービス", required = false)
	private Integer ancillaryFlg;

	/**
	 * 蓄熱計量器継続
	 */
	@ApiParam(value = "蓄熱計量器継続", required = false)
	@ApiModelProperty(value = "蓄熱計量器継続", required = false)
	private Integer thermalStorageMeterFlg;

	/**
	 * 再エネ賦課金減免措置
	 */
	@ApiParam(value = "再エネ賦課金減免措置", required = false)
	@ApiModelProperty(value = "再エネ賦課金減免措置", required = false)
	private Integer renewableEnergyExemptionFlg;

	/**
	 * 需要地内転売契約
	 */
	@ApiParam(value = "需要地内転売契約", required = false)
	@ApiModelProperty(value = "需要地内転売契約", required = false)
	private Integer demandPlaceResales;

	/**
	 * 部分供給
	 */
	@ApiParam(value = "部分供給", required = false)
	@ApiModelProperty(value = "部分供給", required = false)
	private Integer partialSupplyFlg;

	/**
	 * 東北取次（新規）
	 */
	@ApiParam(value = "東北取次（新規）", required = false)
	@ApiModelProperty(value = "東北取次（新規）", required = false)
	private Integer tohokuAgencyNewFlg;

	/**
	 * 東北取次（RJ電力からの切り替え）
	 */
	@ApiParam(value = "東北取次（RJ電力からの切り替え）", required = false)
	@ApiModelProperty(value = "東北取次（RJ電力からの切り替え）", required = false)
	private Integer tohokuAgencySwitchFlg;

	/**
	 * 協議制で契約電力増加の場合
	 */
	@ApiParam(value = "協議制で契約電力増加の場合", required = false)
	@ApiModelProperty(value = "協議制で契約電力増加の場合", required = false)
	private Integer increaseElectricPowerFlg;

	/**
	 * その他
	 */
	@ApiParam(value = "その他", required = false)
	@ApiModelProperty(value = "その他", required = false)
	private Integer otherFlg;

	/**
	 * 契約種別
	 */
	@ApiParam(value = "契約種別", required = false)
	@ApiModelProperty(value = "契約種別", required = false)
	private String contractType;

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