package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 登録番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "登録番号", required = false, position = 2, allowableValues = "range[0,255]")
	private String registrationNumber;

	/**
	 * 氏名又は名称
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "氏名又は名称", required = false, position = 3, allowableValues = "range[0,255]")
	private String providerName;
}
