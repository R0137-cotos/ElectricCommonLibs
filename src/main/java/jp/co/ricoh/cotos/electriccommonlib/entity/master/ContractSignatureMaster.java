package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ContractSignatureMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約書署名マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "contract_signature_master")
@CotosComplementTarget(entity = ContractSignatureMaster.class, repository = ContractSignatureMasterRepository.class)
public class ContractSignatureMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_signature_master_seq")
	@SequenceGenerator(name = "contract_signature_master_seq", sequenceName = "contract_signature_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 検索キー
	 */
	@Column(nullable = false)
	@Schema(description = "検索キー", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String searchKey;

	/**
	 * 住所
	 */
	@Column(nullable = true)
	@Schema(description = "住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyAddress;

	/**
	 * 会社名
	 */
	@Column(nullable = true)
	@Schema(description = "会社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyName;

	/**
	 * 組織１
	 */
	@Column(nullable = true)
	@Schema(description = "組織１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String orgName1;

	/**
	 * 組織２
	 */
	@Column(nullable = true)
	@Schema(description = "組織２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String orgName2;

	/**
	 * 組織３
	 */
	@Column(nullable = true)
	@Schema(description = "組織３", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String orgName3;

	/**
	 * 役職
	 */
	@Column(nullable = true)
	@Schema(description = "役職", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String position;

	/**
	 * 氏名
	 */
	@Column(nullable = true)
	@Schema(description = "氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String name;

}
