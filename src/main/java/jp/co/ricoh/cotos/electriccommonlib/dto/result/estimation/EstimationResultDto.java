package jp.co.ricoh.cotos.electriccommonlib.dto.result.estimation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jp.co.ricoh.cotos.commonlib.entity.estimation.CustomerEstimation;
import jp.co.ricoh.cotos.commonlib.entity.estimation.DealerEstimation;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation.EstimationType;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation.LifecycleStatus;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation.WorkflowStatus;
import jp.co.ricoh.cotos.commonlib.entity.estimation.EstimationAddedEditorEmp;
import jp.co.ricoh.cotos.commonlib.entity.estimation.EstimationApprovalRoute;
import jp.co.ricoh.cotos.commonlib.entity.estimation.EstimationAttachedFile;
import jp.co.ricoh.cotos.commonlib.entity.estimation.EstimationCheckResult;
import jp.co.ricoh.cotos.commonlib.entity.estimation.EstimationDetail;
import jp.co.ricoh.cotos.commonlib.entity.estimation.EstimationPicSaEmp;
import jp.co.ricoh.cotos.commonlib.entity.estimation.OperationLog;
import jp.co.ricoh.cotos.commonlib.entity.estimation.ProductEstimation;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationResultDto {

	/**
	 * RAIDENとのオブジェクト構成の調整のためContractの中身を書き出す
	 */
	@Id
	@Schema(description = "見積ID(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]", accessMode = AccessMode.READ_ONLY)
	private long id;

	/**
	 * 商品グループマスタID
	 */
	@Min(0)
	@Column(nullable = true)
	@Schema(description = "商品グループマスタID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long productGrpMasterId;

	/**
	 * ライフサイクル状態
	 */
	@Column(nullable = true)
	@Schema(description = "ライフサイクル状態(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "作成中(\"1\"), 作成完了(\"2\"), 受注(\"3\"), 失注(\"4\"), 破棄(\"5\")", example = "1", accessMode = AccessMode.READ_ONLY)
	private LifecycleStatus lifecycleStatus;

	/**
	 * ワークフロー状態
	 */
	@Column(nullable = true)
	@Schema(description = "ワークフロー状態(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "作成中(\"1\"), 業務依頼中(\"2\"), 業務処理完了(\"3\"), 承認依頼中(\"4\"), 承認済(\"5\"), 顧客提示済(\"6\")", example = "1", accessMode = AccessMode.READ_ONLY)
	private WorkflowStatus workflowStatus;

	/**
	 * 恒久契約識別番号
	 */
	@Schema(description = "恒久契約識別番号(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]", accessMode = AccessMode.READ_ONLY)
	private String immutableContIdentNumber;

	/**
	 * 案件番号
	 */
	@Size(max = 255)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@Size(max = 255)
	@Schema(description = "案件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 見積番号
	 */
	@Column(nullable = true)
	@Schema(description = "見積番号(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]", accessMode = AccessMode.READ_ONLY)
	private String estimationNumber;

	/**
	 * 見積番号枝番
	 */
	@Column(nullable = true)
	@Schema(description = "見積番号枝番(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99]", accessMode = AccessMode.READ_ONLY)
	private int estimationBranchNumber;

	/**
	 * 見積件名
	 */
	@Size(max = 255)
	@Schema(description = "見積件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 見積種別
	 */
	@Column(nullable = true)
	@Schema(description = "見積種別(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "新規(\"1\"), 契約変更(\"2\")", example = "1", accessMode = AccessMode.READ_ONLY)
	private EstimationType estimationType;

	/**
	 * 見積作成元システム区分
	 */
	@Size(max = 255)
	@Schema(description = "見積作成元システム区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String estimatedSystemDiv;

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
	 * 帳票用見積件名
	 */
	@Size(max = 255)
	@Schema(description = "帳票用見積件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String issueEstimationTitle;

	/**
	 * 帳票用顧客企業名
	 */
	@Size(max = 255)
	@Schema(description = "帳票用顧客企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String issueCustomerCorpName;

	/**
	 * 見積有効期限
	 */
	@Schema(description = "見積有効期限", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date estimationLimit;

	/**
	 * 見積鑑用企業名
	 */
	@Size(max = 255)
	@Schema(description = "見積鑑用企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String coverCompanyName;

	/**
	 * 見積鑑用敬称
	 */
	@Size(max = 255)
	@Schema(description = "見積鑑用敬称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String coverTitle;

	/**
	 * 見積鑑用見積件名
	 */
	@Size(max = 255)
	@Schema(description = "見積鑑用見積件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String coverEstimationSubject;

	/**
	 * 見積鑑用支払条件
	 */
	@Size(max = 255)
	@Schema(description = "見積鑑用支払条件", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String coverPaymentTerms;

	/** 見積鑑用納期 */
	@Schema(description = "見積鑑用納期", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date coverDeliveryDate;

	/**
	 * 見積鑑用有効期限
	 */
	@Schema(description = "見積鑑用有効期限", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date coverExpirationDate;

	/**
	 * 見積鑑用備考
	 */
	@Size(max = 255)
	@Schema(description = "見積鑑用備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String coverRemarks;

	/**
	 * 見積鑑用見積提示日
	 */
	@Schema(description = "見積鑑用見積提示日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date coverPresentationDate;

	/**
	 * 見積発行元会社名
	 */
	@Size(max = 255)
	@Schema(description = "見積発行元会社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String publishCompany;

	/**
	 * 見積発行元所属
	 */
	@Size(max = 255)
	@Schema(description = "見積発行元所属", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String publishDepartment;

	/**
	 * 見積発行元郵便番号
	 */
	@Size(max = 255)
	@Schema(description = "見積発行元郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String publishPostNumber;

	/**
	 * 見積発行元住所
	 */
	@Size(max = 1000)
	@Schema(description = "見積発行元住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String publishAddress;

	/**
	 * 見積発行元電話番号
	 */
	@Size(max = 255)
	@Schema(description = "見積発行元電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String publishTel;

	/**
	 * 見積発行元FAX番号
	 */
	@Size(max = 255)
	@Schema(description = "見積発行元FAX番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String publishFax;

	/**
	 * 見積発行元担当者名
	 */
	@Size(max = 255)
	@Schema(description = "見積発行元担当者名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String publishEmployee;

	/**
	 * 特価希望理由
	 */
	@Size(max = 255)
	@Schema(description = "特価希望理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String spPriceApplyReason;

	/**
	 * 特価希望理由テキスト
	 */
	@Size(max = 255)
	@Schema(description = "特価希望理由テキスト", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String spPriceApplyReasonText;

	/**
	 * 主競合先名称
	 */
	@Size(max = 255)
	@Schema(description = "主競合先名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mainCompetitorName;

	/**
	 * 競合情報
	 */
	@Size(max = 255)
	@Schema(description = "競合情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String competitionInfo;

	/**
	 * 競合先契約種別
	 */
	@Size(max = 255)
	@Schema(description = "競合先契約種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String competitionContractDiv;

	/**
	 * 競合先基本料金
	 */
	@Digits(integer = 19, fraction = 2)
	@DecimalMin("0.00")
	@Schema(description = "競合先基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal competitionAmount;

	/**
	 * 拡張項目
	 */
	@Schema(description = "拡張項目", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String extendsParameter;

	/**
	 * 帳票用消費税率区分
	 */
	@Size(max = 255)
	@Schema(description = "帳票用消費税率区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String issueTaxCodeValue;

	/**
	 * 見積ワークID
	 */
	@Size(max = 255)
	@Schema(description = "見積ワークID(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]", accessMode = AccessMode.READ_ONLY)
	private String estimationWorkId;

	/**
	 * V-UP連携フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "V-UP連携フラグ(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]", accessMode = AccessMode.READ_ONLY)
	private Integer vupLinkageFlg;

	/**
	 * 見積承認ルート
	 */
	@OneToOne(mappedBy = "estimation")
	@Schema(description = "見積承認ルート(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private EstimationApprovalRoute estimationApprovalRoute;

	/**
	 * 見積操作履歴
	 */
	@OneToMany(mappedBy = "estimation")
	@OrderBy("operatedAt ASC")
	@Schema(description = "見積操作履歴(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<OperationLog> operationLogList;

	/**
	 * 見積添付ファイル
	 */
	@OneToMany(mappedBy = "estimation")
	@Schema(description = "見積添付ファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<EstimationAttachedFile> estimationAttachedFileList;

	/**
	 * 見積担当SA社員
	 */
	@OneToOne(mappedBy = "estimation")
	@Schema(description = "見積担当SA社員", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EstimationPicSaEmp estimationPicSaEmp;

	/**
	 * 見積追加編集者社員
	 */
	@OneToMany(mappedBy = "estimation")
	@Schema(description = "見積追加編集者社員", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<EstimationAddedEditorEmp> estimationAddedEditorEmpList;

	/**
	 * 販売店（見積用）
	 */
	@OneToMany(mappedBy = "estimation")
	@Schema(description = "販売店(見積用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<DealerEstimation> dealerEstimationList;

	/**
	 * 顧客（見積用）
	 */
	@OneToOne(mappedBy = "estimation")
	@Schema(description = "顧客(見積用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CustomerEstimation customerEstimation;

	/**
	 * 見積チェック結果
	 */
	@OneToMany(mappedBy = "estimation")
	@OrderBy("displayOrder ASC")
	@Schema(description = "見積チェック結果(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<EstimationCheckResult> estimationCheckResultList;

	/**
	 * 見積明細
	 */
	@OneToMany(mappedBy = "estimation")
	@Schema(description = "見積明細", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<EstimationDetail> estimationDetailList;

	/**
	 * 商品（見積用）
	 */
	@OneToMany(mappedBy = "estimation")
	@Schema(description = "商品（見積用）(作成時不要)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private List<ProductEstimation> productEstimationList;

	/**
	 * アプリケーションID
	 */
	@Size(max = 255)
	@Schema(description = "アプリケーションID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String appId;

	/**
	 * RJ管理番号
	 */
	@Column
	@Schema(description = "RJ管理番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String rjManageNumber;

	/**
	 * 見積(標準)
	 */
	@Schema(description = "見積(標準)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Estimation estimation;

	/**
	 * 見積(電力)
	 */
	@Schema(description = "見積(電力)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EstimationElectric estimationElectric;

}