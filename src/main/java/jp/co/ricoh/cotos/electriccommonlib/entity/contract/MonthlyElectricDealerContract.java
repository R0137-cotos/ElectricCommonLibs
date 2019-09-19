package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MonthlyElectricDealerContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 月次販売店情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "monthly_electric_dealer_contract")
@CotosComplementTarget(entity = MonthlyElectricDealerContract.class, repository = MonthlyElectricDealerContractRepository.class)
public class MonthlyElectricDealerContract extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monthly_electric_dealer_contract_seq")
	@SequenceGenerator(name = "monthly_electric_dealer_contract_seq", sequenceName = "monthly_electric_dealer_contract_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 企業ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "企業ID", required = true, position = 2, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店企業名", required = false, position = 3, allowableValues = "range[0,1000]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所電話番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "郵便番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所", required = false, position = 6, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 7, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 8, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 9, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 支払区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払区分", required = false, position = 10, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

}
