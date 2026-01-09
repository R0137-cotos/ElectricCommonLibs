package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.AgencyContractInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 取次情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "agency_contract_information")
@CotosComplementTarget(entity = AgencyContractInformation.class, repository = AgencyContractInformationRepository.class)
public class AgencyContractInformation extends EntityBase {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_contract_information_seq")
	@SequenceGenerator(name = "agency_contract_information_seq", sequenceName = "agency_contract_information_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 契約（電力）ID
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contractElectricId", referencedColumnName = "id")
	@Schema(description = "見積（電力）ID", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * MOM顧客ID企業ID
	 */
	@Column(nullable = true)
	@Schema(description = "MOM顧客ID企業ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long momCustomerIdCompanyId;

	/**
	 * 取次会社
	 */
	@Column(nullable = true)
	@Schema(description = "取次会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String agencyName;

	/**
	 * 仕入先CD
	 */
	@Column(nullable = true)
	@Schema(description = "仕入先CD", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplierCode;

	/**
	 * 手数料率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal feeRate;
}