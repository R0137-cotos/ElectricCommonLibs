package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "No.", required = false, position = 1)
	private long no;

	/**
	 * 請求No.
	 */
	@ApiModelProperty(value = "請求No.", required = false, position = 2)
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@ApiModelProperty(value = "請求年月", required = false, position = 3)
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@ApiModelProperty(value = "売上年月日", required = false, position = 4)
	private String salesDate;

	/**
	 * 請求先 上流顧客コード
	 */
	@ApiModelProperty(value = "請求先 上流顧客コード", required = false, position = 5)
	private String clientCode;

	/**
	 * 請求金額(税抜)
	 */
	@ApiModelProperty(value = "請求金額(税抜)", required = false, position = 6)
	private BigDecimal claimAmountOutTax;

	/**
	 * 消費税額
	 */
	@ApiModelProperty(value = "消費税額", required = false, position = 7)
	private BigDecimal claimTax;

	/**
	 * 請求金額(税込)
	 */
	@ApiModelProperty(value = "請求金額(税込)", required = false, position = 8)
	private BigDecimal claimAmountInTax;

	/**
	 * 請求書PDF
	 */
	@ApiModelProperty(value = "請求書PDF", required = false, position = 9)
	private Long fileBillId;

	/**
	 * 請求書PDF
	 */
	@ApiModelProperty(value = "請求書PDF", required = false, position = 10)
	private String fileBillPhysicsName;

	/**
	 * 日別電力量 明細表PDF
	 */
	@ApiModelProperty(value = "日別電力量 明細表PDF", required = false, position = 11)
	private Long filePdfId;

	/**
	 * 日別電力量 明細表PDF
	 */
	@ApiModelProperty(value = "日別電力量 明細表PDF", required = false, position = 12)
	private String filePdfPhysicsName;

	/**
	 * 日別電力量 明細表Excel
	 */
	@ApiModelProperty(value = "日別電力量 明細表Excel", required = false, position = 13)
	private Long fileExcelId;

	/**
	 * 日別電力量 明細表Excel
	 */
	@ApiModelProperty(value = "日別電力量 明細表Excel", required = false, position = 14)
	private String fileExcelPhysicsName;

	/**
	 * 未回収フラグ
	 */
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 15)
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = "未回収分回収日", required = false, position = 16)
	private Date accruedCollectionDate;

	/**
	 * 請求実績ID
	 */
	@ApiModelProperty(value = "請求実績ID", required = false, position = 17)
	private Long billingHistoryId;

	/**
	 * 請求書出力フラグ
	 */
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 18)
	private Integer invoiceOutputFlg;

	/**
	 * 未収区分
	 */
	@ApiModelProperty(value = "未収区分", required = false, position = 19)
	private AccruedSection accruedSection;

	/**
	 * 請求メール送信日時
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = "請求メール送信日時", required = false, position = 20)
	private Date invoiceSendMailAt;

	/**
	 * 請求書通知メールファイルID
	 */
	@ApiModelProperty(value = "請求書通知メールファイルID", required = false, position = 21)
	private Long electricBillingMailFileId;

	/**
	 * パスワード通知メールファイルID
	 */
	@ApiModelProperty(value = "パスワード通知メールファイルID", required = false, position = 22)
	private Long electricPasswordMailFileId;

	/**
	 * 請求書通知メールファイル
	 */
	@ApiModelProperty(value = "請求書通知メールファイル", required = false, position = 23)
	private String billingMailPhysicsName;

	/**
	 * パスワード通知メールファイル
	 */
	@ApiModelProperty(value = "パスワード通知メールファイルル", required = false, position = 24)
	private String passwordMailPhysicsName;

}
