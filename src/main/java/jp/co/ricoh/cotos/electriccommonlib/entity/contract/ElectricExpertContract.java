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
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricExpertContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力専任情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_expert_contract")
@CotosComplementTarget(entity = ElectricExpertContract.class, repository = ElectricExpertContractRepository.class)
public class ElectricExpertContract extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_expert_contract_seq")
	@SequenceGenerator(name = "electric_expert_contract_seq", sequenceName = "electric_expert_contract_seq", allocationSize = 1)
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
	 * 氏名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "氏名", required = true, position = 3, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールアドレス", required = true, position = 4, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * 電話番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電話番号", required = true, position = 5, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 所属課所コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "所属課所コード", required = true, position = 6, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 所属
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "所属", required = true, position = 7, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * 修正時振替先コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "修正時振替先コード", required = true, position = 8, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * 修正時振替課所名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "修正時振替課所名", required = true, position = 9, allowableValues = "range[0,255]")
	private String fixTransferSectionName;
}
