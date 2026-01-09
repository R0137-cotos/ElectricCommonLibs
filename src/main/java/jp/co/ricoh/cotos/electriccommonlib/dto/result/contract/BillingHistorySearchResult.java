package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.AccruedSection;
import lombok.Data;

/**
 * 契約（電力）に紐づく請求実績をリスト取得するためのDtoです。<br/>
 * このクラスを使用してDBへの保存を行うことは出来ません。
 */
@Entity
@Data
public class BillingHistorySearchResult {

	/**
	 * No.
	 */
	@Id
	@Schema(description = "No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private long no;

	/**
	 * 請求No.
	 */
	@Schema(description = "請求No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@Schema(description = "売上年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String salesDate;

	/**
	 * 請求先 上流顧客コード
	 */
	@Schema(description = "請求先 上流顧客コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String clientCode;

	/**
	 * 請求金額(税抜)
	 */
	@Schema(description = "請求金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal claimAmountOutTax;

	/**
	 * 消費税額
	 */
	@Schema(description = "消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal claimTax;

	/**
	 * 請求金額(税込)
	 */
	@Schema(description = "請求金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal claimAmountInTax;

	/**
	 * 請求書PDF
	 */
	@Schema(description = "請求書PDF", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long fileBillId;

	/**
	 * 請求書PDF
	 */
	@Schema(description = "請求書PDF", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String fileBillPhysicsName;

	/**
	 * 日別電力量 明細表PDF
	 */
	@Schema(description = "日別電力量 明細表PDF", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long filePdfId;

	/**
	 * 日別電力量 明細表PDF
	 */
	@Schema(description = "日別電力量 明細表PDF", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String filePdfPhysicsName;

	/**
	 * 日別電力量 明細表Excel
	 */
	@Schema(description = "日別電力量 明細表Excel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long fileExcelId;

	/**
	 * 日別電力量 明細表Excel
	 */
	@Schema(description = "日別電力量 明細表Excel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String fileExcelPhysicsName;

	/**
	 * 未回収フラグ
	 */
	@Schema(description = "未回収フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Schema(description = "未回収分回収日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date accruedCollectionDate;

	/**
	 * 請求実績ID
	 */
	@Schema(description = "請求実績ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long billingHistoryId;

	/**
	 * 請求書出力フラグ
	 */
	@Schema(description = "請求書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer invoiceOutputFlg;

	/**
	 * 未収区分
	 */
	@Schema(description = "未収区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private AccruedSection accruedSection;

	/**
	 * 請求メール送信日時
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Schema(description = "請求メール送信日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date invoiceSendMailAt;

	/**
	 * 請求書通知メールファイルID
	 */
	@Schema(description = "請求書通知メールファイルID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long electricBillingMailFileId;

	/**
	 * パスワード通知メールファイルID
	 */
	@Schema(description = "パスワード通知メールファイルID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long electricPasswordMailFileId;

	/**
	 * 請求書通知メールファイル
	 */
	@Schema(description = "請求書通知メールファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String billingMailPhysicsName;

	/**
	 * パスワード通知メールファイル
	 */
	@Schema(description = "パスワード通知メールファイルル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String passwordMailPhysicsName;

}
