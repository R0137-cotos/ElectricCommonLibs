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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
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

		未受信("1"), 未回収("2"), 回収済("3");

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
	 * 請求年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "請求年月", required = true, position = 3, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上年月日", required = false, position = 4, allowableValues = "range[0,255]")
	private String salesDate;

	/**
	 * 高圧請求計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "高圧請求計上日時", required = false, position = 5)
	@Temporal(TemporalType.DATE)
	private Date highClaimAppropriationDay;

	/**
	 * 手数料計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手数料計上日時", required = false, position = 6)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 請求金額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "請求金額(税込)", required = false, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimAmountInTax;

	/**
	 * 請求消費税額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "請求消費税額", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimTax;

	/**
	 * 請求金額(税抜)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "請求金額(税抜)", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimAmountOutTax;

	/**
	 * 引落予定日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "引落予定日", required = false, position = 10, allowableValues = "range[0,255]")
	private String debitScheduleDay;

	/**
	 * 未収区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未収区分", required = false, position = 11, allowableValues = "未受信(\"1\"), 未回収(\"2\"), 回収済(\"3\")", example = "1")
	private AccruedSection accruedSection;

	/**
	 * 未収事由
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未収事由", required = false, position = 12, allowableValues = "range[0,255]")
	private String accruedReason;

	/**
	 * 手数料計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手数料計上日時", required = false, position = 13)
	@Temporal(TemporalType.DATE)
	private Date accuredJudgeDay;

	/**
	 * 請求NO
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求NO", required = false, position = 14, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 計上実績
	 */
	@OneToMany
	@ApiModelProperty(value = "計上実績", required = false, position = 15)
	private List<ElectricAppropriation> electricAppropriation;
	
	/**
	 * No.
	 */
	@Column(nullable = true)
	@Max(99999)
	@ApiModelProperty(value = "No.", required = false, position = 16, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;
	
	/**
	 * 未回収フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 17, allowableValues = "range[0,9]")
	private Integer accruedFlg;
	
	/**
	 * 未回収分回収日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "未回収分回収日", required = false, position = 18)
	@Temporal(TemporalType.DATE)
	private Date accruedCollectionDate;
	
	/**
	 * ファイル名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ファイル名", required = false, position = 19, allowableValues = "range[0,255]")
	private String fileName;
	
	/**
	 * ファイルパス
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ファイルパス", required = false, position = 19, allowableValues = "range[0,1023]")
	private String filePath;
	
	/**
	 * 請求書発送区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書発送区分", required = false, position = 20, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;
	
	/**
	 * 請求書出力フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 21, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;
}
