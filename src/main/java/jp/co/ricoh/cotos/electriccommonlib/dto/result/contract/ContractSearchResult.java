package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.ContractType;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.LifecycleStatus;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.WorkflowStatus;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import lombok.Data;

/**
 * 契約（電力）をリスト取得するためのDtoです。<br/>
 * 一覧を取得するためには、こちらのクラスを使ってください。 <br/>
 * このクラスを使用してDBへの保存を行うことは出来ません。
 */
@Entity
@Data
public class ContractSearchResult {

	@Id
	@Schema(description = "連番", requiredMode = Schema.RequiredMode.REQUIRED)
	private long seqNo;

	/**
	 * 契約ID
	 */
	@Schema(description = "契約ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 契約番号
	 */
	@Schema(description = "契約番号<br />" + "契約番号 + \"-\" + 契約番号枝番", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,18]")
	private String contractNumber;

	/**
	 * 契約種別
	 */
	@Schema(description = "契約種別<br />" + "新規, プラン変更, 解約などの契約種別を表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ContractType contractType;

	/**
	 * 商品名称
	 */
	@Schema(description = "商品名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String productName;

	/**
	 * お客様企業名
	 */
	@Schema(description = "お客様企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyName;

	/**
	 * お客様事業所名
	 */
	@Schema(description = "お客様事業所名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String officeName;

	/**
	 * お客様部門名
	 */
	@Schema(description = "お客様部門名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String departmentName;

	/**
	 * 担当支社名
	 */
	@Schema(description = "担当支社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesCompanyName;

	/**
	 * 担当営業氏名
	 */
	@Schema(description = "担当営業氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String employeeName;

	/**
	 * 担当営業所属
	 */
	@Schema(description = "担当営業所属", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String orgName;

	/**
	 * 担当SS氏名
	 */
	@Schema(description = "担当SS氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String serviceOrgName;

	/**
	 * 担当CE氏名
	 */
	@Schema(description = "担当CE氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String employeeCeName;

	/**
	 * 契約ステータス
	 */
	@Schema(description = "契約ステータス<br />" + "状態遷移上のワークフローステータスを表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private WorkflowStatus workflowStatus;

	/**
	 * 契約状態
	 */
	@Schema(description = "契約状態<br />" + "状態遷移上のライフサイクル状態を表す。", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private LifecycleStatus lifecycleStatus;

	/**
	 * 見積番号
	 */
	@Schema(description = "見積番号<br />" + "見積番号 + \"-\" + 見積番号枝番", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,18]")
	private String estimationNumber;

	/**
	 * 見積件名
	 */
	@Schema(description = "見積件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 見積ID
	 */
	@Schema(description = "見積ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long estimationId;

	/**
	 * 案件番号
	 */
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@Schema(description = "案件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * SIM番号
	 */
	@Schema(description = "SIM番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumber;

	/**
	 * 契約書最終作成日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Tokyo")
	@Schema(description = "契約書最終作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractLastCreationDate;

	/**
	 * 請求開始月
	 */
	@Schema(description = "請求開始月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String billingDate;

	/**
	 * サービス開始
	 */
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Tokyo")
	@Schema(description = "サービス開始", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractYmdStart;

	/**
	 * サービス終了
	 */
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Tokyo")
	@Schema(description = "サービス終了", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractYmdEnd;

	/**
	 * 電力区分
	 */
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private VoltageCategory voltageCategory;

	/**
	 * お客様識別番号
	 */
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 電力会社
	 */
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電気主任技術者
	 */
	@Schema(description = "電気主任技術者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者_電話番号
	 */
	@Schema(description = "電気主任技術者_電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者_所属名
	 */
	@Schema(description = "電気主任技術者_所属名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 電力専任
	 */
	@Schema(description = "電力専任", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String name;

	/**
	 * 電力専任 所属
	 */
	@Schema(description = "電力専任　所属", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Schema(description = "原子力立地給付金フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 商流区分
	 */
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private ElectricCommercialFlowDiv commercialFlowDiv;

	/**
	 * 得意先CD
	 */
	@Schema(description = "得意先CD", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求No
	 */
	@Schema(description = "請求No", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 請求書発送区分
	 */
	@Schema(description = "請求書発送区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求書出力フラグ
	 */
	@Schema(description = "請求書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	private Integer invoiceOutputFlg;

	/**
	 * 未回収フラグ
	 */
	@Schema(description = "未回収フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	private Integer accruedFlg;

	/**
	 * 手数料金額
	 */
	@Schema(description = "手数料金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String tradingCompanyMediationFeeAmountInTax;

	/**
	 * 販売店ID
	 */
	@Schema(description = "販売店ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店名
	 */
	@Schema(description = "販売店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyBusinessName;

	/**
	 * 解約月
	 */
	@Schema(description = "解約月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cancellationDate;

	/**
	 * 解約金請求
	 */
	@Schema(description = "解約金請求", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	private Integer cancellationBillingFlg;

	/**
	 * 解約金額
	 */
	@Schema(description = "解約金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,20]")
	private String cancellationAmount;

	/**
	 * 電力メニュー
	 */
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	@PrePersist
	public void prePersist() {
		throw new IllegalAccessError();
	}
}