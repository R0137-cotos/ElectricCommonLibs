package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.ContractType;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.IfsLinkageCsvCreateStatus;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.LifecycleStatus;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.SsWorkRequestCreateStatus;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.WorkflowStatus;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractAddedEditorEmp;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractApprovalRoute;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractAttachedFile;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractAttachedFileHistory;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractCheckResult;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractDetail;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractEquipment;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractInstallationLocation;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractOperationLog;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicAccCeEmp;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicAccSsOrg;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicIntCeEmp;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicIntSsOrg;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicMntCeEmp;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicMntSsOrg;
import jp.co.ricoh.cotos.commonlib.entity.contract.ContractPicSaEmp;
import jp.co.ricoh.cotos.commonlib.entity.contract.CustomerContract;
import jp.co.ricoh.cotos.commonlib.entity.contract.DealerContract;
import jp.co.ricoh.cotos.commonlib.entity.contract.ManagedEstimationDetail;
import jp.co.ricoh.cotos.commonlib.entity.contract.ProductContract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.AgencyContractInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricDealerContract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricExpertContract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentHighPressure;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ImportantPointExplainer;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MailAddressInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.UnitPriceHighPressure;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.UnitPriceLowPressure;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractResultDto {

	/**
	 * RAIDENとのオブジェクト構成の調整のためContractの中身を書き出す
	 */
	@ApiModelProperty(value = "契約ID(作成時不要)", required = false, position = 1, allowableValues = "range[0,9223372036854775807]", readOnly = true)
	private long id;

	/**
	 * 契約種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約種別", required = false, allowableValues = "新規(\"1\"), 契約変更(\"2\"), 情報変更(\"3\")", position = 2)
	private ContractType contractType;

	/**
	 * 商品グループマスタID
	 */
	@Min(0)
	@ApiModelProperty(value = "商品グループマスタID", required = false, position = 3, allowableValues = "range[0,9223372036854775807]")
	private long productGrpMasterId;

	/**
	 * ライフサイクル状態
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ライフサイクル状態(作成時不要)", required = false, allowableValues = "作成中(\"1\"), 作成完了(\"2\"), キャンセル手続き中(\"3\"), 破棄(\"4\"), 予定日待ち(\"5\"), 締結中(\"6\"), 解約手続き中(\"7\"), 解約予定日待ち(\"8\"), 解約(\"9\"), 旧契約(\"10\")", example = "1", position = 4, readOnly = true)
	private LifecycleStatus lifecycleStatus;

	/**
	 * ワークフロー状態
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ワークフロー状態(作成時不要)", required = false, allowableValues = "作成中(\"1\"), 承認依頼中(\"2\"), 承認済(\"3\"), 業務依頼中(\"4\"), 業務処理完了(\"5\"), キャンセル申請中(\"6\"), 売上可能(\"7\"), 解約申請中(\"8\")", example = "1", position = 5, readOnly = true)
	private WorkflowStatus workflowStatus;

	/**
	 * 恒久契約識別番号
	 */
	@ApiModelProperty(value = "恒久契約識別番号(作成時不要)", required = false, position = 6, allowableValues = "range[0,255]", readOnly = true)
	private String immutableContIdentNumber;

	/**
	 * 案件番号
	 */
	@ApiModelProperty(value = "案件番号", required = false, position = 7, allowableValues = "range[0,255]")
	@Size(max = 255)
	private String caseNumber;

	/**
	 * 案件名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "案件名", required = false, position = 8, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約番号(作成時不要)", required = false, position = 9, allowableValues = "range[0,255]", readOnly = true)
	private String contractNumber;

	/**
	 * 契約番号枝番
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約番号枝番(作成時不要)", required = false, position = 10, allowableValues = "range[0,99]", readOnly = true)
	private int contractBranchNumber;

	/**
	 * 契約件名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "契約件名", required = false, position = 11, allowableValues = "range[0,255]")
	private String contractTitle;

	/**
	 * 変更元契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "変更元契約番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String originContractNumber;

	/**
	 * 変更元契約番号枝番
	 */
	@Max(99)
	@Min(0)
	@ApiModelProperty(value = "変更元契約番号枝番", required = false, position = 13, allowableValues = "range[0,99]")
	private Integer originContractBranchNumber;

	/**
	 * 変更元契約ID
	 */
	@Min(0)
	@ApiModelProperty(value = "変更元契約ID", required = false, position = 14, allowableValues = "range[0,9223372036854775807]")
	private Long originContractId;

	/**
	 * 変更希望日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "変更希望日", required = false, position = 15)
	private Date changePreferredDate;

	/**
	 * 契約日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "契約日", required = false, position = 16)
	private Date contractDate;

	/**
	 * 売上計上フラグ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上計上フラグ(作成時不要)", required = false, position = 17, allowableValues = "range[0,9]", readOnly = true)
	private int accountSalesFlg;

	/**
	 * 請求開始日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "請求開始日", required = false, position = 18)
	private Date billingDate;

	/**
	 * サービス開始日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "サービス開始日", required = false, position = 19)
	private Date serviceTermStart;

	/**
	 * サービス終了日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "サービス終了日", required = false, position = 20)
	private Date serviceTermEnd;

	/**
	 * 解約予定日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "解約予定日", required = false, position = 21)
	private Date cancelScheduledDate;

	/**
	 * 見積番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "見積番号", required = false, position = 22, allowableValues = "range[0,255]")
	private String estimationNumber;

	/**
	 * 見積番号枝番
	 */
	@Max(99)
	@Min(0)
	@ApiModelProperty(value = "見積番号枝番", required = false, position = 23, allowableValues = "range[0,99]")
	private Integer estimationBranchNumber;

	/**
	 * 見積ID
	 */
	@Min(0)
	@ApiModelProperty(value = "見積ID", required = false, position = 24, allowableValues = "range[0,9223372036854775807]")
	private Long estimationId;

	/**
	 * 見積件名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "見積件名", required = false, position = 25, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 商流区分
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分", required = false, position = 26, allowableValues = "range[0,255]")
	private String commercialFlowDiv;

	/**
	 * 発行書式
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "発行書式", required = false, position = 27, allowableValues = "range[0,255]")
	private String issueFormat;

	/**
	 * 得意先コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "得意先コード<br/>※POST時「MoM請求売上先サイト情報マスタ」存在チェック実施", required = false, position = 28, allowableValues = "range[0,255]")
	private String billingCustomerSpCode;

	/**
	 * 得意先宛先名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "得意先宛先名", required = false, position = 29, allowableValues = "range[0,255]")
	private String billingCustomerSpName;

	/**
	 * 支払条件
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "支払条件", required = false, position = 30, allowableValues = "range[0,255]")
	private String paymentTerms;

	/**
	 * 支払方法
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "支払方法", required = false, position = 31, allowableValues = "range[0,255]")
	private String paymentMethod;

	/**
	 * 解約理由
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "解約理由", required = false, position = 32, allowableValues = "range[0,255]")
	private String cancelReason;

	/**
	 * その他解約理由
	 */
	@Size(max = 1000)
	@ApiModelProperty(value = "その他解約理由", required = false, position = 33, allowableValues = "range[0,1000]")
	private String cancelReasonEtc;

	/**
	 * 拡張項目
	 */
	@ApiModelProperty(value = "拡張項目", required = false, position = 34)
	@Lob
	private String extendsParameter;

	/**
	 * web受注注文番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "web受注注文番号", required = false, position = 35, allowableValues = "range[0,255]")
	private String webOrderNumber;

	/**
	 * RJ管理番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "RJ管理番号", required = false, position = 36, allowableValues = "range[0,255]")
	private String rjManageNumber;

	/**
	 * 課金開始日(ランニング)
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "課金開始日(ランニング)", required = false, position = 37)
	private Date billingStartDate;

	/**
	 * 解約注文番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "解約注文番号", required = false, position = 38, allowableValues = "range[0,255]")
	private String cancelOrderNo;

	/**
	 * サービス利用希望日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "サービス利用希望日", required = false, position = 39)
	private Date conclusionPreferredDate;

	/**
	 * IFS連携用CSV作成状態
	 */
	@ApiModelProperty(value = "IFS連携用CSV作成状態", required = false, position = 40, allowableValues = "未作成(\"0\"), 作成済み(\"1\"), 作成対象外(\"2\"), 作成エラー(\"3\")")
	private IfsLinkageCsvCreateStatus ifsLinkageCsvCreateStatus;

	/**
	 * IFS連携用CSV作成日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "IFS連携用CSV作成日", required = false, position = 41)
	private Date ifsLinkageCsvCreateDate;

	/**
	 * お問い合わせ番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "お問い合わせ番号", required = false, position = 42, allowableValues = "range[0,255]")
	private String contactNo;

	/**
	 * S&S作業依頼作成状態
	 */
	@ApiModelProperty(value = "S&S作業依頼作成状態", required = false, position = 43, allowableValues = "未作成(\"0\"),作成済み(\"1\"),作成エラー(\"2\")")
	private SsWorkRequestCreateStatus ssWorkRequestCreateStatus;

	/**
	 * 帳票用消費税率区分
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "帳票用消費税率区分", required = false, position = 44, allowableValues = "range[0,255]")
	private String issueTaxCodeValue;

	/**
	 * 申込日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "申込日", required = false, position = 45)
	private Date applicationDate;

	/**
	 * 契約明細
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "契約明細", required = false, position = 46)
	private List<ContractDetail> contractDetailList;

	/**
	 * 契約チェック結果
	 */
	@OneToMany(mappedBy = "contract")
	@OrderBy("displayOrder ASC")
	@ApiModelProperty(value = "契約チェック結果(作成時不要)", required = false, position = 47, readOnly = true)
	private List<ContractCheckResult> contractCheckResultList;

	/**
	 * 契約承認ルート
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "契約承認ルート(作成時不要)", required = false, position = 48, readOnly = true)
	private List<ContractApprovalRoute> contractApprovalRouteList;

	/**
	 * 契約添付ファイル
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "契約添付ファイル(作成時不要)", required = false, position = 49, readOnly = true)
	private List<ContractAttachedFile> contractAttachedFileList;

	/**
	 * 契約担当SA社員
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約担当SA社員", required = false, position = 50)
	private ContractPicSaEmp contractPicSaEmp;

	/**
	 * 契約追加編集者社員
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "契約追加編集者社員(作成時不要)", required = false, position = 51, readOnly = true)
	private List<ContractAddedEditorEmp> contractAddedEditorEmpList;

	/**
	 * 販売店(契約用)
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "販売店(契約用)", required = false, position = 52)
	private List<DealerContract> dealerContractList;

	/**
	 * 顧客(契約用)
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "顧客(契約用)", required = false, position = 53)
	private CustomerContract customerContract;

	/**
	 * 契約操作履歴
	 */
	@OneToMany(mappedBy = "contract")
	@OrderBy("operatedAt ASC")
	@ApiModelProperty(value = "契約操作履歴(作成時不要)", required = false, position = 54, readOnly = true)
	private List<ContractOperationLog> contractOperationLogList;

	/**
	 * 商品(契約用)
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "商品(契約用)", required = false, position = 55)
	private List<ProductContract> productContractList;

	/**
	 * 契約保守担当CE社員
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約保守担当CE社員(作成時不要)", required = false, position = 56, readOnly = true)
	private ContractPicMntCeEmp contractPicMntCeEmp;

	/**
	 * 契約保守担当SS組織
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約保守担当SS組織(作成時不要)", required = false, position = 57, readOnly = true)
	private ContractPicMntSsOrg contractPicMntSsOrg;

	/**
	 * 契約受付担当SS組織
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約受付担当SS組織(作成時不要)", required = false, position = 58, readOnly = true)
	private ContractPicAccSsOrg contractPicAccSsOrg;

	/**
	 * 契約導入担当SS組織
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約導入担当SS組織(作成時不要)", required = false, position = 59, readOnly = true)
	private ContractPicIntSsOrg contractPicIntSsOrg;

	/**
	 * 契約添付ファイル履歴
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "契約添付ファイル履歴(作成時不要)", required = false, position = 60)
	private List<ContractAttachedFileHistory> contractAttachedFileHistoryList;

	/**
	 * 契約受付担当CE社員
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約受付担当CE社員(作成時不要)", required = false, position = 61, readOnly = true)
	private ContractPicAccCeEmp contractPicAccCeEmp;

	/**
	 * 契約導入担当CE社員
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "契約導入担当CE社員(作成時不要)", required = false, position = 62, readOnly = true)
	private ContractPicIntCeEmp contractPicIntCeEmp;

	/**
	 * 契約機種
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "契約機種(作成時不要)", required = false, position = 63, readOnly = true)
	private List<ContractEquipment> contractEquipmentList;

	/**
	 * 見積明細管理
	 */
	@OneToMany(mappedBy = "contract")
	@ApiModelProperty(value = "見積明細管理", required = false, position = 64)
	private List<ManagedEstimationDetail> managedEstimationDetailList;

	/**
	 * 設置先(契約用)
	 */
	@OneToOne(mappedBy = "contract")
	@ApiModelProperty(value = "設置先(契約用)", required = false, position = 65)
	private ContractInstallationLocation contractInstallationLocation;

	/**
	 * アプリケーションID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "アプリケーションID", required = false, position = 66, allowableValues = "range[0,255]")
	private String appId;

	/**
	 * 契約自動更新日
	 */
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "契約自動更新日", required = false, position = 67)
	private Date contractAutoUpdateDate;

	/**
	 * 届先コード
	 */
	@Column
	@ApiModelProperty(value = "届先コード", required = false, position = 68, allowableValues = "range[0,]")
	private String deliveryCd;

	/**
	 * 届先名
	 */
	@Column
	@ApiModelProperty(value = "届先名", required = false, position = 69, allowableValues = "range[0,]")
	private String deliveryName;

	/**
	 * 検収日
	 */
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@ApiModelProperty(value = "検収日", required = false, position = 70)
	private Date acceptanceDate;

	/**
	 * 契約(標準)
	 */
	@ApiModelProperty(value = "契約(標準)", required = true, position = 71)
	private Contract contract;

	/**
	 * 契約(電力)
	 */
	@ApiModelProperty(value = "契約(電力)", required = true, position = 72)
	private ContractElectric contractElectric;

	/**
	 * 請求基本情報
	 */
	@ApiModelProperty(value = "請求基本情報", required = false, position = 73)
	private BillingBasicInformation billingBasicInformation;
	
	/**
	 * お申込み内容(高圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "お申込み内容(高圧)", required = false, position = 74)
	private EntryContentHighPressure entryContentHighPressure;

	/**
	 * お申込み内容(低圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "お申込み内容(低圧)", required = false, position = 75)
	private EntryContentLowPressure entryContentLowPressure;

	/**
	 * 解約情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "解約情報", required = false, position = 76)
	private CancellationInformation cancellationInformation;

	/**
	 * 電力専任情報
	 */
	@OneToOne(mappedBy = "contractElectric", optional = false)
	@ApiModelProperty(value = "電力専任情報", required = true, position = 77)
	private ElectricExpertContract electricExpertContract;

	/**
	 * 販売店情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "販売店情報", required = false, position = 78)
	private ElectricDealerContract electricDealerContract;

	/**
	 * Mailアドレス情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "Mailアドレス情報", required = false, position = 79)
	private List<MailAddressInformation> mailAddressInformationList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "契約(電力)添付ファイル", required = false, position = 80)
	private List<ContractElectricAttachedFile> contractElectricAttachedFileList;

	/**
	 * 単価情報(高圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "単価情報(高圧)", required = false, position = 81)
	private List<UnitPriceHighPressure> unitPriceHighPressureList;

	/**
	 * 単価情報(低圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "単価情報(低圧)", required = false, position = 82)
	private List<UnitPriceLowPressure> unitPriceLowPressureList;

	/**
	 * 得意先情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "得意先情報", required = false, position = 83)
	private List<ClientInformation> clientInformationList;
	
	/**
	 * 重要事項説明者
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "重要事項説明者", required = false, position = 84)
	private ImportantPointExplainer importantPointExplainer;
	
	/**
	 * 取次情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "取次情報", required = false, position = 85)
	private AgencyContractInformation agencyContractInformation;
}
