package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingBasicInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 請求基本情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "billing_basic_information")
@CotosComplementTarget(entity = BillingBasicInformation.class, repository = BillingBasicInformationRepository.class)
public class BillingBasicInformation extends EntityBase {

	public enum Honorific {

		御中("1");

		private final String text;

		private Honorific(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static Honorific fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum CollectMethod {

		自振_RL("1");

		private final String text;

		private CollectMethod(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static CollectMethod fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_basic_information_seq")
	@SequenceGenerator(name = "billing_basic_information_seq", sequenceName = "billing_basic_information_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販社コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販社コード", required = false, position = 2, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 得意先CD
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "得意先CD", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求書発送区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書発送区分", required = false, position = 4, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求先名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求先名", required = false, position = 5, allowableValues = "range[0,4000]")
	private String billingName;

	/**
	 * 敬称
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "敬称", required = false, position = 6, allowableValues = "御中(\"1\")", example = "1")
	private Honorific honorific;

	/**
	 * 請求先郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求先郵便番号", required = false, position = 7, allowableValues = "range[0,255]")
	private String billingZipCode;

	/**
	 * 請求先住所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求先住所", required = false, position = 8, allowableValues = "range[0,255]")
	private String billingAddress;

	/**
	 * サイト番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "サイト番号", required = false, position = 9, allowableValues = "range[0,255]")
	private String siteNumber;

	/**
	 * 回収方法
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "回収方法", required = false, position = 10, allowableValues = "自振(RL)(\"1\")", example = "1")
	private String collectMethod;

	/**
	 * 回収条件
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "回収条件", required = false, position = 11, allowableValues = "range[0,255]")
	private String collectCondition;

	/**
	 * お客様口座番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "お客様口座番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String customerAccountNumber;

	/**
	 * 銀行番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String bankNumber;

	/**
	 * 銀行名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行名", required = false, position = 14, allowableValues = "range[0,255]")
	private String bankName;

	/**
	 * 支店番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店番号", required = false, position = 15, allowableValues = "range[0,255]")
	private String branchNumber;

	/**
	 * 支店名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店名", required = false, position = 16, allowableValues = "range[0,255]")
	private String branchName;

	/**
	 * 口座名義人名カナ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座名義人名カナ", required = false, position = 17, allowableValues = "range[0,255]")
	private String accountHolderKana;

	/**
	 * 部門/バーチャル口座番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "部門/バーチャル口座番号", required = false, position = 18, allowableValues = "range[0,255]")
	private String vertualAccountNumber;

	/**
	 * 銀行コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行コード", required = false, position = 19, allowableValues = "range[0,255]")
	private String bankCode;

	/**
	 * 本支店コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "本支店コード", required = false, position = 20, allowableValues = "range[0,255]")
	private String branchCode;

	/**
	 * 口座種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座種別", required = false, position = 21, allowableValues = "range[0,255]")
	private String accountType;

	/**
	 * 売上課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上課所コード", required = false, position = 22, allowableValues = "range[0,255]")
	private String salesDivisionCode;

	/**
	 * 請求実績
	 */
	@OneToMany(mappedBy = "billingBasicInformation")
	@ApiModelProperty(value = "請求実績", required = false, position = 23)
	private List<BillingHistory> billingHistoryList;

	/**
	 * 計上実績
	 */
	@OneToMany(mappedBy = "billingBasicInformation")
	@ApiModelProperty(value = "計上実績", required = false, position = 24)
	private List<ElectricAppropriation> electricAppropriationList;

	/**
	 * 請求先分類
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求先分類", required = false, position = 25, allowableValues = "range[0,255]")
	private String billingDiv;

	/**
	 * メール配信
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "メール配信", required = false, position = 26, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

}
