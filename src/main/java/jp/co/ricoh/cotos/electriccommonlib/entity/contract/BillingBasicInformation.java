package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販社コード
	 */
	@Column(nullable = true)
	@Schema(description = "販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 得意先CD
	 */
	@Column(nullable = false)
	@Schema(description = "得意先CD", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求書発送区分
	 */
	@Column(nullable = true)
	@Schema(description = "請求書発送区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求先名
	 */
	@Column(nullable = true)
	@Schema(description = "請求先名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String billingName;

	/**
	 * 敬称
	 */
	@Column(nullable = true)
	@Schema(description = "敬称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "御中(\"1\")", example = "1")
	private Honorific honorific;

	/**
	 * 請求先郵便番号
	 */
	@Column(nullable = true)
	@Schema(description = "請求先郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingZipCode;

	/**
	 * 請求先住所
	 */
	@Column(nullable = true)
	@Schema(description = "請求先住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingAddress;

	/**
	 * サイト番号
	 */
	@Column(nullable = true)
	@Schema(description = "サイト番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String siteNumber;

	/**
	 * 回収方法
	 */
	@Column(nullable = true)
	@Schema(description = "回収方法", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "自振(RL)(\"1\")", example = "1")
	private String collectMethod;

	/**
	 * 回収条件
	 */
	@Column(nullable = true)
	@Schema(description = "回収条件", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String collectCondition;

	/**
	 * お客様口座番号
	 */
	@Column(nullable = true)
	@Schema(description = "お客様口座番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerAccountNumber;

	/**
	 * 銀行番号
	 */
	@Column(nullable = true)
	@Schema(description = "銀行番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bankNumber;

	/**
	 * 銀行名
	 */
	@Column(nullable = true)
	@Schema(description = "銀行名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bankName;

	/**
	 * 支店番号
	 */
	@Column(nullable = true)
	@Schema(description = "支店番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String branchNumber;

	/**
	 * 支店名
	 */
	@Column(nullable = true)
	@Schema(description = "支店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String branchName;

	/**
	 * 口座名義人名カナ
	 */
	@Column(nullable = true)
	@Schema(description = "口座名義人名カナ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String accountHolderKana;

	/**
	 * 部門/バーチャル口座番号
	 */
	@Column(nullable = true)
	@Schema(description = "部門/バーチャル口座番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String vertualAccountNumber;

	/**
	 * 銀行コード
	 */
	@Column(nullable = true)
	@Schema(description = "銀行コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bankCode;

	/**
	 * 本支店コード
	 */
	@Column(nullable = true)
	@Schema(description = "本支店コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String branchCode;

	/**
	 * 口座種別
	 */
	@Column(nullable = true)
	@Schema(description = "口座種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String accountType;

	/**
	 * 売上課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "売上課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesDivisionCode;

	/**
	 * 請求実績
	 */
	@OneToMany(mappedBy = "billingBasicInformation")
	@Schema(description = "請求実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<BillingHistory> billingHistoryList;

	/**
	 * 計上実績
	 */
	@OneToMany(mappedBy = "billingBasicInformation")
	@Schema(description = "計上実績", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ElectricAppropriation> electricAppropriationList;

	/**
	 * 請求先分類
	 */
	@Column(nullable = true)
	@Schema(description = "請求先分類", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingDiv;

	/**
	 * 口座引落前連絡メール配信
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "口座引落前連絡メール配信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * RJ部門名
	 */
	@Column(nullable = true)
	@Schema(description = "RJ部門名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String rjDepartmentName;

	/**
	 * 振込先銀行名
	 */
	@Column(nullable = true)
	@Schema(description = "振込先銀行名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String transferBankName;

	/**
	 * 振込先銀行支店名
	 */
	@Column(nullable = true)
	@Schema(description = "振込先銀行支店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String transferBranchName;

	/**
	 * 自振口座_口座種別
	 */
	@Column(nullable = true)
	@Schema(description = "自振口座_口座種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String debitBankAccountType;

}
