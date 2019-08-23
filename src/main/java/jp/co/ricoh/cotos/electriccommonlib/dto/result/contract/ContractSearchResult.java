package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "連番", required = true, position = 1)
	private long seqNo;

	/**
	 * 契約ID
	 */
	@ApiModelProperty(value = "契約ID", required = true, position = 2)
	private long id;

	/**
	 * 契約番号
	 */
	@ApiModelProperty(value = "契約番号<br />" + "契約番号 + \"-\" + 契約番号枝番", required = false, position = 3, allowableValues = "range[0,18]")
	private String contractNumber;

	/**
	 * 契約種別
	 */
	@ApiModelProperty(value = "契約種別<br />" + "新規, プラン変更, 解約などの契約種別を表す。", required = false, position = 4)
	private ContractType contractType;

	/**
	 * 商品名称
	 */
	@ApiModelProperty(value = "商品名称", required = false, position = 5, allowableValues = "range[0,255]")
	private String productName;

	/**
	 * お客様企業名
	 */
	@ApiModelProperty(value = "お客様企業名", required = false, position = 6, allowableValues = "range[0,255]")
	private String companyName;

	/**
	 * お客様事業所名
	 */
	@ApiModelProperty(value = "お客様事業所名", required = false, position = 7, allowableValues = "range[0,255]")
	private String officeName;

	/**
	 * お客様部門名
	 */
	@ApiModelProperty(value = "お客様部門名", required = false, position = 8, allowableValues = "range[0,255]")
	private String departmentName;

	/**
	 * 担当支社名
	 */
	@ApiModelProperty(value = "担当支社名", required = false, position = 9, allowableValues = "range[0,255]")
	private String salesCompanyName;

	/**
	 * 担当営業氏名
	 */
	@ApiModelProperty(value = "担当営業氏名", required = false, position = 10, allowableValues = "range[0,255]")
	private String employeeName;

	/**
	 * 担当営業所属
	 */
	@ApiModelProperty(value = "担当営業所属", required = false, position = 11, allowableValues = "range[0,255]")
	private String orgName;

	/**
	 * 担当SS氏名
	 */
	@ApiModelProperty(value = "担当SS氏名", required = false, position = 12, allowableValues = "range[0,255]")
	private String serviceOrgName;

	/**
	 * 担当CE氏名
	 */
	@ApiModelProperty(value = "担当CE氏名", required = false, position = 13, allowableValues = "range[0,255]")
	private String employeeCeName;

	/**
	 * 契約ステータス
	 */
	@ApiModelProperty(value = "契約ステータス<br />" + "状態遷移上のワークフローステータスを表す。", required = false, position = 14)
	private WorkflowStatus workflowStatus;

	/**
	 * 契約状態
	 */
	@ApiModelProperty(value = "契約状態<br />" + "状態遷移上のライフサイクル状態を表す。", required = false, position = 15)
	private LifecycleStatus lifecycleStatus;

	/**
	 * 見積番号
	 */
	@ApiModelProperty(value = "見積番号<br />" + "見積番号 + \"-\" + 見積番号枝番", required = false, position = 16, allowableValues = "range[0,18]")
	private String estimateNumber;

	/**
	 * 見積件名
	 */
	@ApiModelProperty(value = "見積件名", required = false, position = 17, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 見積件名
	 */
	@ApiModelProperty(value = "見積ID", required = false, position = 18, allowableValues = "range[0,255]")
	private String estimationId;

	/**
	 * 案件番号
	 */
	@ApiModelProperty(value = "案件番号", required = false, position = 19, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@ApiModelProperty(value = "案件名", required = false, position = 20, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * SIM番号
	 */
	@ApiModelProperty(value = "SIM番号", required = false, position = 21, allowableValues = "range[0,255]")
	private String simNumber;

	/**
	 * 契約書初回作成日
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = "契約書初回作成日", required = false, position = 22)
	private Date contractFirstCreationDate;

	/**
	 * 請求開始月
	 */
	@ApiModelProperty(value = "請求開始月", required = false, position = 23)
	private String billingDate;

	/**
	 * サービス開始
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = "サービス開始", required = false, position = 24)
	private Date contractYmdStart;

	/**
	 * サービス終了
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = "サービス終了", required = false, position = 25)
	private Date contractYmdEnd;

	/**
	 * 電力区分
	 */
	@ApiModelProperty(value = "電力区分", required = false, position = 26, allowableValues = "range[0,255]")
	private VoltageCategory voltageCategory;

	/**
	 * お客様識別番号
	 */
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 27, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 28, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 電力会社
	 */
	@ApiModelProperty(value = "電力会社", required = false, position = 29, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電気主任技術者
	 */
	@ApiModelProperty(value = "電気主任技術者", required = false, position = 30, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者_電話番号
	 */
	@ApiModelProperty(value = "電気主任技術者_電話番号", required = false, position = 31, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者_所属名
	 */
	@ApiModelProperty(value = "電気主任技術者_所属名", required = false, position = 32, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 電力専任
	 */
	@ApiModelProperty(value = "電力専任", required = false, position = 33, allowableValues = "range[0,255]")
	private String name;

	/**
	 * 電力専任 所属
	 */
	@ApiModelProperty(value = "電力専任　所属", required = false, position = 34, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * 原子力立地給付金フラグ
	 */
	@ApiModelProperty(value = "原子力立地給付金フラグ", required = false, position = 35, allowableValues = "range[0,1]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@ApiModelProperty(value = "備考", required = false, position = 36, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 商流区分
	 */
	@ApiModelProperty(value = "商流区分", required = false, position = 37, allowableValues = "range[0,255]")
	private ElectricCommercialFlowDiv commercialFlowDiv;

	/**
	 * 請求年月
	 */
	@ApiModelProperty(value = "請求年月", required = false, position = 38, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 請求書発送区分
	 */
	@ApiModelProperty(value = "請求書発送区分", required = false, position = 39, allowableValues = "range[0,255]")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求書出力フラグ
	 */
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 40, allowableValues = "range[0,1]")
	private Integer invoiceOutputFlg;

	/**
	 * 未回収フラグ
	 */
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 41, allowableValues = "range[0,1]")
	private Integer accruedFlg;

	/**
	 * 手数料金額
	 */
	@ApiModelProperty(value = "手数料金額", required = false, position = 42, allowableValues = "range[0,255]")
	private String tradingCompanyMediationFeeAmountInTax;

	/**
	 * 販売店ID
	 */
	@ApiModelProperty(value = "販売店ID", required = false, position = 43, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店名
	 */
	@ApiModelProperty(value = "販売店名", required = false, position = 44, allowableValues = "range[0,255]")
	private String companyBusinessName;

	/**
	 * 解約月
	 */
	@ApiModelProperty(value = "解約月", required = false, position = 45, allowableValues = "range[0,255]")
	private String cancellationDate;

	/**
	 * 解約金請求
	 */
	@ApiModelProperty(value = "解約金請求", required = false, position = 46, allowableValues = "range[0,1]")
	private Integer cancellationBillingFlg;

	/**
	 * 解約金額
	 */
	@ApiModelProperty(value = "解約金額", required = false, position = 47, allowableValues = "range[0,20]")
	private String cancellationAmount;

	@PrePersist
	public void prePersist() {
		throw new IllegalAccessError();
	}
}