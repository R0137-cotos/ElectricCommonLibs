package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricDealerMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 承認ルートマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_dealer_master")
@CotosComplementTarget(entity = ElectricDealerMaster.class, repository = ElectricDealerMasterRepository.class)
public class ElectricDealerMaster extends EntityBaseMaster {

	public enum DealerFlowType {

		媒介("1"), 代理("2");

		private final String text;

		private DealerFlowType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static DealerFlowType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum PaymentMethod {

		定率("1"), 定額("2");

		private final String text;

		private PaymentMethod(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static PaymentMethod fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_dealer_master_seq")
	@SequenceGenerator(name = "electric_dealer_master_seq", sequenceName = "electric_dealer_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販売店企業名(カナ)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店企業名(カナ)", required = false, position = 2, allowableValues = "range[0,255]")
	private String companyNameKana;

	/**
	 * 販売店企業名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店企業名", required = false, position = 3, allowableValues = "range[0,255]")
	private String companyName;

	/**
	 * 販売店事業所名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店事業所名", required = false, position = 4, allowableValues = "range[0,255]")
	private String officeName;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電話番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "郵便番号", required = false, position = 6, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所1", required = false, position = 7, allowableValues = "range[0,255]")
	private String address1;

	/**
	 * 住所2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所2", required = false, position = 8, allowableValues = "range[0,255]")
	private String address2;

	/**
	 * 銀行番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行番号", required = false, position = 9, allowableValues = "range[0,255]")
	private String bankNumber;

	/**
	 * 銀行名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行名", required = false, position = 10, allowableValues = "range[0,255]")
	private String bankName;

	/**
	 * 支店コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店コード", required = false, position = 11, allowableValues = "range[0,255]")
	private String bankBranchNumber;

	/**
	 * 支店名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店名", required = false, position = 12, allowableValues = "range[0,255]")
	private String bankBranchName;

	/**
	 * 口座種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座種別", required = false, position = 13, allowableValues = "range[0,255]")
	private String bankAccountType;

	/**
	 * 口座番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座番号", required = false, position = 14, allowableValues = "range[0,255]")
	private String bankAccountNumber;

	/**
	 * 口座名義人名カナ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座名義人名カナ", required = false, position = 15, allowableValues = "range[0,255]")
	private String accountHolderNameKana;

	/**
	 * 口座名義人名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座名義人名", required = false, position = 16, allowableValues = "range[0,255]")
	private String accountHolderName;

	/**
	 * 担当者名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "担当者名", required = false, position = 17, allowableValues = "range[0,255]")
	private String contactPersonName;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 18, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス2", required = false, position = 19, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 20, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 契約期間(自)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(自)", required = false, position = 21, allowableValues = "range[0,255]")
	private Date contractPeriodFrom;

	/**
	 * 契約期間(至)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(至)", required = false, position = 22, allowableValues = "range[0,255]")
	private Date contractPeriodTo;

	/**
	 * 商流
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "商流", required = true, allowableValues = "媒介(\"1\"), 代理(\"2\")", example = "1", position = 23)
	private DealerFlowType dealerFlowType;

	/**
	 * 支払い方法
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払い方法", required = false, position = 24, allowableValues = "range[0,255]")
	private PaymentMethod paymentMethod;

	/**
	 * 手数料割合
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "手数料割合", required = false, position = 25, allowableValues = "range[0.00,99999.99]")
	private BigDecimal commissionRate;

	/**
	 * 支払先コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払先コード", required = false, position = 26, allowableValues = "range[0,255]")
	private String paymentCode;

	/**
	 * 販売店企業ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店企業ID", required = false, position = 27, allowableValues = "range[0,255]")
	private String companyId;
}
