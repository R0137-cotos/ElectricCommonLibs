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
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricProviderMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電気事業者マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_provider_master")
@CotosComplementTarget(entity = ElectricProviderMaster.class, repository = ElectricProviderMasterRepository.class)
public class ElectricProviderMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_provider_master_seq")
	@SequenceGenerator(name = "electric_provider_master_seq", sequenceName = "electric_provider_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 登録番号
	 */
	@Column(nullable = true)
	@Schema(description = "登録番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String registrationNumber;

	/**
	 * 氏名又は名称
	 */
	@Column(nullable = true)
	@Schema(description = "氏名又は名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String providerName;
}
