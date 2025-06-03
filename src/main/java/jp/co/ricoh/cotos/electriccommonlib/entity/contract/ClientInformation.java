package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 得意先情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "client_information")
@CotosComplementTarget(entity = ClientInformation.class, repository = ClientInformationRepository.class)
public class ClientInformation extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_information_seq")
	@SequenceGenerator(name = "client_information_seq", sequenceName = "client_information_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 得意先CD
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "得意先CD", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 得意先情報M_ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "得意先情報M_ID", required = true, position = 4, allowableValues = "range[0,9223372036854775807]")
	private long clientMasterId;

	/**
	 * アクティブflg
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アクティブflg", required = false, position = 5, allowableValues = "range[0,9]")
	private Integer activeFlg;

}
