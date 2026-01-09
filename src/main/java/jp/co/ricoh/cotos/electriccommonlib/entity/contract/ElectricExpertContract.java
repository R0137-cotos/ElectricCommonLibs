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

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 氏名
	 */
	@Column(nullable = true)
	@Schema(description = "氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@Schema(description = "電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 所属課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "所属課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 所属
	 */
	@Column(nullable = true)
	@Schema(description = "所属", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * 修正時振替先コード
	 */
	@Column(nullable = true)
	@Schema(description = "修正時振替先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * 修正時振替課所名
	 */
	@Column(nullable = true)
	@Schema(description = "修正時振替課所名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fixTransferSectionName;
	
	/**
	 * MoM社員ID
	 */
	@Column(nullable = true)
	@Schema(description = "MoM社員ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String momEmpId;
}
