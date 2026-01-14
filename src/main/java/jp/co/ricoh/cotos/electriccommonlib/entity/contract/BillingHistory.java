package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.BeforeDebitContact;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendMyRicoh;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingHistoryRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 請求実績を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "billing_history")
@CotosComplementTarget(entity = BillingHistory.class, repository = BillingHistoryRepository.class)
public class BillingHistory extends EntityBase {

	public enum AccruedSection {

		未受信("1"), 未回収("2"), 回収済("3"), 振込("4");

		private final String text;

		private AccruedSection(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static AccruedSection fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum InvoiceCreateDiv {

		未作成("0"), 作成済("1"), 社内利用("9");

		private final String text;

		private InvoiceCreateDiv(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static InvoiceCreateDiv fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum SendMail {

		未送信("0"), 送信済("1"), 送信対象外("9");

		private final String text;

		private SendMail(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static SendMail fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum InvoiceForm {

		単一("1"), 複数("2");

		private final String text;

		private InvoiceForm(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static InvoiceForm fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_history_seq")
	@SequenceGenerator(name = "billing_history_seq", sequenceName = "billing_history_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求基本情報ID
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "billing_basic_information_id", referencedColumnName = "id")
	@Schema(description = "請求基本情報ID", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private BillingBasicInformation billingBasicInformation;

	/**
	 * No.
	 */
	@Column(nullable = true)
	@Max(99999)
	@Schema(description = "No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 請求NO
	 */
	@Column(nullable = true)
	@Schema(description = "請求NO", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@Column(nullable = false)
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@Column(nullable = true)
	@Schema(description = "売上年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesDate;

	/**
	 * 手数料計上日時
	 */
	@Column(nullable = true)
	@Schema(description = "手数料計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 請求金額(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "請求金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal claimAmountInTax;

	/**
	 * 請求消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "請求消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal claimTax;

	/**
	 * 請求金額(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "請求金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal claimAmountOutTax;

	/**
	 * 引落予定日
	 */
	@Column(nullable = true)
	@Schema(description = "引落予定日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String debitScheduleDay;

	/**
	 * 未収区分
	 */
	@Column(nullable = true)
	@Schema(description = "未収区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未受信(\"1\"), 未回収(\"2\"), 回収済(\"3\")", example = "1")
	private AccruedSection accruedSection;

	/**
	 * 未収事由
	 */
	@Column(nullable = true)
	@Schema(description = "未収事由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String accruedReason;

	/**
	 * 未収判定日時
	 */
	@Column(nullable = true)
	@Schema(description = "未収判定日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date accuredJudgeDay;

	/**
	 * 未回収フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "未回収フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@Column(nullable = true)
	@Schema(description = "未回収分回収日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date accruedCollectionDate;

	/**
	 * 請求書発送区分
	 */
	@Column(nullable = true)
	@Schema(description = "請求書発送区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求書出力フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "請求書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

	/**
	 * 電力請求添付ファイル
	 */
	@OneToMany(mappedBy = "billingHistory")
	@Schema(description = "電力請求添付ファイル", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<ElectricBillingAttachedFile> electricBillingAttachedFileList;

	/**
	 * 引落前連絡
	 */
	@Column(nullable = true)
	@Schema(description = "引落前連絡", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private BeforeDebitContact beforeDebitContact;

	/**
	 * MyRicoh送信
	 */
	@Column(nullable = true)
	@Schema(description = "MyRicoh送信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMyRicoh sendMyRicoh;

	/**
	 * 供給期間(開始)
	 */
	@Column(nullable = true)
	@Schema(description = "供給期間(開始)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdStart;

	/**
	 * 供給期間(終了)
	 */
	@Column(nullable = true)
	@Schema(description = "供給期間(終了)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdEnd;

	/**
	 * 請求書作成区分
	 */
	@Column(nullable = true)
	@Schema(description = "請求書作成区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未作成(\"0\"), 作成済(\"1\"), 社内利用(\"9\")", example = "0")
	private InvoiceCreateDiv invoiceCreateDiv;

	/**
	 * メール送信
	 */
	@Column(nullable = true)
	@Schema(description = "メール送信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMail sendMail;

	/**
	 * 請求書様式
	 */
	@Column(nullable = true)
	@Schema(description = "請求書様式", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "単一(\"1\"), 複数(\"2\")", example = "1")
	private InvoiceForm invoiceForm;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 請求書発行年月日
	 */
	@Column(nullable = true)
	@Schema(description = "請求書発行年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date invoiceIssueDate;

	/**
	 * 請求メール送信日時
	 */
	@Column(nullable = true)
	@Schema(description = "請求メール送信日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceSendMailAt;
}
