package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求基本情報ID
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "billing_basic_information_id", referencedColumnName = "id")
	@ApiModelProperty(value = "請求基本情報ID", required = true, position = 2)
	@JsonIgnore
	private BillingBasicInformation billingBasicInformation;

	/**
	 * No.
	 */
	@Column(nullable = true)
	@Max(99999)
	@ApiModelProperty(value = "No.", required = false, position = 3, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 請求NO
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求NO", required = false, position = 4, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "請求年月", required = true, position = 5, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上年月日", required = false, position = 6, allowableValues = "range[0,255]")
	private String salesDate;

	/**
	 * 手数料計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手数料計上日時", required = false, position = 7)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 請求金額(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "請求金額(税込)", required = false, position = 8)
	private BigDecimal claimAmountInTax;

	/**
	 * 請求消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "請求消費税額", required = false, position = 9)
	private BigDecimal claimTax;

	/**
	 * 請求金額(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "請求金額(税抜)", required = false, position = 10)
	private BigDecimal claimAmountOutTax;

	/**
	 * 引落予定日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "引落予定日", required = false, position = 11, allowableValues = "range[0,255]")
	private String debitScheduleDay;

	/**
	 * 未収区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未収区分", required = false, position = 12, allowableValues = "未受信(\"1\"), 未回収(\"2\"), 回収済(\"3\")", example = "1")
	private AccruedSection accruedSection;

	/**
	 * 未収事由
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未収事由", required = false, position = 13, allowableValues = "range[0,255]")
	private String accruedReason;

	/**
	 * 未収判定日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未収判定日時", required = false, position = 14)
	@Temporal(TemporalType.DATE)
	private Date accuredJudgeDay;

	/**
	 * 未回収フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未回収分回収日", required = false, position = 16)
	@Temporal(TemporalType.DATE)
	private Date accruedCollectionDate;

	/**
	 * 請求書発送区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書発送区分", required = false, position = 17, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求書出力フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 18, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

	/**
	 * 電力請求添付ファイル
	 */
	@OneToMany(mappedBy = "billingHistory")
	@ApiModelProperty(value = "電力請求添付ファイル", required = true, position = 19)
	private List<ElectricBillingAttachedFile> electricBillingAttachedFileList;

	/**
	 * 引落前連絡
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "引落前連絡", required = false, position = 20, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private BeforeDebitContact beforeDebitContact;

	/**
	 * MyRicoh送信
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "MyRicoh送信", required = false, position = 21, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMyRicoh sendMyRicoh;

	/**
	 * 供給期間(開始)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給期間(開始)", required = false, position = 22)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdStart;

	/**
	 * 供給期間(終了)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給期間(終了)", required = false, position = 23)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdEnd;

	/**
	 * 請求書作成区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書作成区分", required = false, position = 24, allowableValues = "未作成(\"0\"), 作成済(\"1\"), 社内利用(\"9\")", example = "0")
	private InvoiceCreateDiv invoiceCreateDiv;

	/**
	 * メール送信
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メール送信", required = false, position = 25, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMail sendMail;

	/**
	 * 請求書様式
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書様式", required = false, position = 26, allowableValues = "単一(\"1\"), 複数(\"2\")", example = "1")
	private InvoiceForm invoiceForm;

	/**
	 * 電力区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力区分", required = false, position = 27, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

}
