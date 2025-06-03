package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 得意先情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "client_master")
@CotosComplementTarget(entity = ClientMaster.class, repository = ClientMasterRepository.class)
public class ClientMaster extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_master_seq")
	@SequenceGenerator(name = "client_master_seq", sequenceName = "client_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 得意先CD
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "得意先CD", required = true, position = 2, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求先Mailアドレス情報
	 */
	@OneToMany(mappedBy = "clientMaster")
	@ApiModelProperty(value = "請求先Mailアドレス情報", required = false, position = 3)
	private List<BillingMailAddressInformation> billingMailAddressInformationList;
}
