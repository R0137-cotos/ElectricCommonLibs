package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricDealerMaster.PaymentMethod;
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
	 * 企業_事業所名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "企業_事業所名", required = true, position = 4, allowableValues = "range[0,1000]")
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
	@ApiModelProperty(value = "支払区分", required = true, position = 9, allowableValues = "定率(\"1\"), 定額(\"2\")", example = "1")
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
}
