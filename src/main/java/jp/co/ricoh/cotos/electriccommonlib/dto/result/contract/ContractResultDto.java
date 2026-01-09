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

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
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
	@Schema(description = "契約ID(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]", accessMode = AccessMode.READ_ONLY)
	private long id;

	/**
	 * 契約種別
	 */
	@Column(nullable = true)
	@Schema(description = "契約種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "新規(\"1\"), 契約変更(\"2\"), 情報変更(\"3\")")
	private ContractType contractType;

	/**
	 * 商品グループマスタID
	 */
	@Min(0)
	@Schema(description = "商品グループマスタID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long productGrpMasterId;

	/**
	 * ライフサイクル状態
	 */
	@Column(nullable = true)
	@Schema(description = "ライフサイクル状態(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "作成中(\"1\"), 作成完了(\"2\"), キャンセル手続き中(\"3\"), 破棄(\"4\"), 予定日待ち(\"5\"), 締結中(\"6\"), 解約手続き中(\"7\"), 解約予定日待ち(\"8\"), 解約(\"9\"), 旧契約(\"10\")", example = "1", accessMode = AccessMode.READ_ONLY)
	private LifecycleStatus lifecycleStatus;

	/**
	 * ワークフロー状態
	 */
	@Column(nullable = true)
	@Schema(description = "ワークフロー状態(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "作成中(\"1\"), 承認依頼中(\"2\"), 承認済(\"3\"), 業務依頼中(\"4\"), 業務処理完了(\"5\"), キャンセル申請中(\"6\"), 売上可能(\"7\"), 解約申請中(\"8\")", example = "1", accessMode = AccessMode.READ_ONLY)
	private WorkflowStatus workflowStatus;

	/**
	 * 恒久契約識別番号
	 */
	@Schema(description = "恒久契約識別番号(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]", accessMode = AccessMode.READ_ONLY)
	private String immutableContIdentNumber;

	/**
	 * 案件番号
	 */
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@Size(max = 255)
	private String caseNumber;

	/**
	 * 案件名
	 */
	@Size(max = 255)
	@Schema(description = "案件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 契約番号
	 */
	@Column(nullable = true)
	@Schema(description = "契約番号(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]", accessMode = AccessMode.READ_ONLY)
	private String contractNumber;

	/**
	 * 契約番号枝番
	 */
	@Column(nullable = true)
	@Schema(description = "契約番号枝番(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99]", accessMode = AccessMode.READ_ONLY)
	private int contractBranchNumber;

	/**
	 * 契約件名
	 */
	@Size(max = 255)
	@Schema(description = "契約件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractTitle;

	/**
	 * 変更元契約番号
	 */
	@Size(max = 255)
	@Schema(description = "変更元契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String originContractNumber;

	/**
	 * 変更元契約番号枝番
	 */
	@Max(99)
	@Min(0)
	@Schema(description = "変更元契約番号枝番", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99]")
	private Integer originContractBranchNumber;

	/**
	 * 変更元契約ID
	 */
	@Min(0)
	@Schema(description = "変更元契約ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private Long originContractId;

	/**
	 * 変更希望日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "変更希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date changePreferredDate;

	/**
	 * 契約日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "契約日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractDate;

	/**
	 * 売上計上フラグ
	 */
	@Column(nullable = true)
	@Schema(description = "売上計上フラグ(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]", accessMode = AccessMode.READ_ONLY)
	private int accountSalesFlg;

	/**
	 * 請求開始日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "請求開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date billingDate;

	/**
	 * サービス開始日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "サービス開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date serviceTermStart;

	/**
	 * サービス終了日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "サービス終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date serviceTermEnd;

	/**
	 * 解約予定日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "解約予定日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancelScheduledDate;

	/**
	 * 見積番号
	 */
	@Size(max = 255)
	@Schema(description = "見積番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String estimationNumber;

	/**
	 * 見積番号枝番
	 */
	@Max(99)
	@Min(0)
	@Schema(description = "見積番号枝番", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99]")
	private Integer estimationBranchNumber;

	/**
	 * 見積ID
	 */
	@Min(0)
	@Schema(description = "見積ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private Long estimationId;

	/**
	 * 見積件名
	 */
	@Size(max = 255)
	@Schema(description = "見積件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 商流区分
	 */
	@Size(max = 255)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String commercialFlowDiv;

	/**
	 * 発行書式
	 */
	@Size(max = 255)
	@Schema(description = "発行書式", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String issueFormat;

	/**
	 * 得意先コード
	 */
	@Size(max = 255)
	@Schema(description = "得意先コード<br/>※POST時「MoM請求売上先サイト情報マスタ」存在チェック実施", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingCustomerSpCode;

	/**
	 * 得意先宛先名
	 */
	@Size(max = 255)
	@Schema(description = "得意先宛先名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingCustomerSpName;

	/**
	 * 支払条件
	 */
	@Size(max = 255)
	@Schema(description = "支払条件", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String paymentTerms;

	/**
	 * 支払方法
	 */
	@Size(max = 255)
	@Schema(description = "支払方法", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String paymentMethod;

	/**
	 * 解約理由
	 */
	@Size(max = 255)
	@Schema(description = "解約理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cancelReason;

	/**
	 * その他解約理由
	 */
	@Size(max = 1000)
	@Schema(description = "その他解約理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String cancelReasonEtc;

	/**
	 * 拡張項目
	 */
	@Schema(description = "拡張項目", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Lob
	private String extendsParameter;

	/**
	 * web受注注文番号
	 */
	@Size(max = 255)
	@Schema(description = "web受注注文番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String webOrderNumber;

	/**
	 * RJ管理番号
	 */
	@Size(max = 255)
	@Schema(description = "RJ管理番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String rjManageNumber;

	/**
	 * 課金開始日(ランニング)
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "課金開始日(ランニング)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date billingStartDate;

	/**
	 * 解約注文番号
	 */
	@Size(max = 255)
	@Schema(description = "解約注文番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cancelOrderNo;

	/**
	 * サービス利用希望日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "サービス利用希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date conclusionPreferredDate;

	/**
	 * IFS連携用CSV作成状態
	 */
	@Schema(description = "IFS連携用CSV作成状態", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未作成(\"0\"), 作成済み(\"1\"), 作成対象外(\"2\"), 作成エラー(\"3\")")
	private IfsLinkageCsvCreateStatus ifsLinkageCsvCreateStatus;

	/**
	 * IFS連携用CSV作成日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "IFS連携用CSV作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date ifsLinkageCsvCreateDate;

	/**
	 * お問い合わせ番号
	 */
	@Size(max = 255)
	@Schema(description = "お問い合わせ番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactNo;

	/**
	 * S&S作業依頼作成状態
	 */
	@Schema(description = "S&S作業依頼作成状態", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未作成(\"0\"),作成済み(\"1\"),作成エラー(\"2\")")
	private SsWorkRequestCreateStatus ssWorkRequestCreateStatus;

	/**
	 * 帳票用消費税率区分
	 */
	@Size(max = 255)
	@Schema(description = "帳票用消費税率区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String issueTaxCodeValue;

	/**
	 * 申込日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date applicationDate;

	/**
	 * 契約明細
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "契約明細", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ContractDetail> contractDetailList;

	/**
	 * 契約チェック結果
	 */
	@OneToMany(mappedBy = "contract")
	@OrderBy("displayOrder ASC")
	@Schema(description = "契約チェック結果(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ContractCheckResult> contractCheckResultList;

	/**
	 * 契約承認ルート
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "契約承認ルート(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ContractApprovalRoute> contractApprovalRouteList;

	/**
	 * 契約添付ファイル
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "契約添付ファイル(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ContractAttachedFile> contractAttachedFileList;

	/**
	 * 契約担当SA社員
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約担当SA社員", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ContractPicSaEmp contractPicSaEmp;

	/**
	 * 契約追加編集者社員
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "契約追加編集者社員(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ContractAddedEditorEmp> contractAddedEditorEmpList;

	/**
	 * 販売店(契約用)
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "販売店(契約用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<DealerContract> dealerContractList;

	/**
	 * 顧客(契約用)
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "顧客(契約用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CustomerContract customerContract;

	/**
	 * 契約操作履歴
	 */
	@OneToMany(mappedBy = "contract")
	@OrderBy("operatedAt ASC")
	@Schema(description = "契約操作履歴(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ContractOperationLog> contractOperationLogList;

	/**
	 * 商品(契約用)
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "商品(契約用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ProductContract> productContractList;

	/**
	 * 契約保守担当CE社員
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約保守担当CE社員(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private ContractPicMntCeEmp contractPicMntCeEmp;

	/**
	 * 契約保守担当SS組織
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約保守担当SS組織(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private ContractPicMntSsOrg contractPicMntSsOrg;

	/**
	 * 契約受付担当SS組織
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約受付担当SS組織(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private ContractPicAccSsOrg contractPicAccSsOrg;

	/**
	 * 契約導入担当SS組織
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約導入担当SS組織(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private ContractPicIntSsOrg contractPicIntSsOrg;

	/**
	 * 契約添付ファイル履歴
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "契約添付ファイル履歴(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ContractAttachedFileHistory> contractAttachedFileHistoryList;

	/**
	 * 契約受付担当CE社員
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約受付担当CE社員(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private ContractPicAccCeEmp contractPicAccCeEmp;

	/**
	 * 契約導入担当CE社員
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "契約導入担当CE社員(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private ContractPicIntCeEmp contractPicIntCeEmp;

	/**
	 * 契約機種
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "契約機種(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ContractEquipment> contractEquipmentList;

	/**
	 * 見積明細管理
	 */
	@OneToMany(mappedBy = "contract")
	@Schema(description = "見積明細管理", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ManagedEstimationDetail> managedEstimationDetailList;

	/**
	 * 設置先(契約用)
	 */
	@OneToOne(mappedBy = "contract")
	@Schema(description = "設置先(契約用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ContractInstallationLocation contractInstallationLocation;

	/**
	 * アプリケーションID
	 */
	@Size(max = 255)
	@Schema(description = "アプリケーションID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String appId;

	/**
	 * 契約自動更新日
	 */
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "契約自動更新日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractAutoUpdateDate;

	/**
	 * 届先コード
	 */
	@Column
	@Schema(description = "届先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,]")
	private String deliveryCd;

	/**
	 * 届先名
	 */
	@Column
	@Schema(description = "届先名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,]")
	private String deliveryName;

	/**
	 * 検収日
	 */
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Tokyo")
	@Schema(description = "検収日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date acceptanceDate;

	/**
	 * 契約(標準)
	 */
	@Schema(description = "契約(標準)", requiredMode = Schema.RequiredMode.REQUIRED)
	private Contract contract;

	/**
	 * 契約(電力)
	 */
	@Schema(description = "契約(電力)", requiredMode = Schema.RequiredMode.REQUIRED)
	private ContractElectric contractElectric;

	/**
	 * 請求基本情報
	 */
	@Schema(description = "請求基本情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BillingBasicInformation billingBasicInformation;
	
	/**
	 * お申込み内容(高圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "お申込み内容(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EntryContentHighPressure entryContentHighPressure;

	/**
	 * お申込み内容(低圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "お申込み内容(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EntryContentLowPressure entryContentLowPressure;

	/**
	 * 解約情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "解約情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationInformation cancellationInformation;

	/**
	 * 電力専任情報
	 */
	@OneToOne(mappedBy = "contractElectric", optional = false)
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricExpertContract electricExpertContract;

	/**
	 * 販売店情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricDealerContract electricDealerContract;

	/**
	 * Mailアドレス情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "Mailアドレス情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<MailAddressInformation> mailAddressInformationList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "契約(電力)添付ファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ContractElectricAttachedFile> contractElectricAttachedFileList;

	/**
	 * 単価情報(高圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "単価情報(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<UnitPriceHighPressure> unitPriceHighPressureList;

	/**
	 * 単価情報(低圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "単価情報(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<UnitPriceLowPressure> unitPriceLowPressureList;

	/**
	 * 得意先情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "得意先情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ClientInformation> clientInformationList;
	
	/**
	 * 重要事項説明者
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "重要事項説明者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ImportantPointExplainer importantPointExplainer;
	
	/**
	 * 取次情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "取次情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private AgencyContractInformation agencyContractInformation;
}
