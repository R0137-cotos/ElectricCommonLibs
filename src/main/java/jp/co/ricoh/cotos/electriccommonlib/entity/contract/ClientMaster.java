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

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 得意先CD
	 */
	@Column(nullable = false)
	@Schema(description = "得意先CD", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求先Mailアドレス情報
	 */
	@OneToMany(mappedBy = "clientMaster")
	@Schema(description = "請求先Mailアドレス情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<BillingMailAddressInformation> billingMailAddressInformationList;
}
