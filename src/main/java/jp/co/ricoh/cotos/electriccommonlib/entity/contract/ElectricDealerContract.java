package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricDealerContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 販売店情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_dealer_contract")
@CotosComplementTarget(entity = ElectricDealerContract.class, repository = ElectricDealerContractRepository.class)
public class ElectricDealerContract extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_dealer_contract_seq")
	@SequenceGenerator(name = "electric_dealer_contract_seq", sequenceName = "electric_dealer_contract_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 企業ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "企業ID", required = true, position = 3, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "販売店企業名", required = true, position = 4, allowableValues = "range[0,1000]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "事業所電話番号", required = true, position = 5, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "郵便番号", required = true, position = 6, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "住所", required = true, position = 7, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールアドレス1", required = true, position = 8, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * 支払区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "支払区分", required = true, position = 9, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールアドレス1", required = true, position = 10, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールアドレス3", required = true, position = 11, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 1ショット支払済フラグ
	 */
	@Column(nullable = false)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "1ショット支払済フラグ", required = false, position = 12, allowableValues = "range[0,9]")
	private Integer oneShotPaidFlg;

	/**
	 * 支払間隔
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払間隔", required = false, position = 13, allowableValues = "range[0,2]")
	private String shhriKnkk;

	/**
	 * 支払期間
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払期間", required = false, position = 14, allowableValues = "range[0,2]")
	private String shhriKkn;

	/**
	 * 帳票区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "帳票区分", required = false, position = 15, allowableValues = "range[0,1]")
	private String tyohyoKbn;
}
