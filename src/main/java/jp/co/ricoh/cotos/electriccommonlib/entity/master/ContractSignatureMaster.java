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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 検索キー
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "検索キー", required = true, position = 2, allowableValues = "range[0,255]")
	private String searchKey;

	/**
	 * 住所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所", required = false, position = 3, allowableValues = "range[0,255]")
	private String companyAddress;

	/**
	 * 会社名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "会社名", required = false, position = 4, allowableValues = "range[0,255]")
	private String companyName;

	/**
	 * 組織１
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "組織１", required = false, position = 5, allowableValues = "range[0,255]")
	private String orgName1;

	/**
	 * 組織２
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "組織２", required = false, position = 6, allowableValues = "range[0,255]")
	private String orgName2;

	/**
	 * 組織３
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "組織３", required = false, position = 7, allowableValues = "range[0,255]")
	private String orgName3;

	/**
	 * 役職
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "役職", required = false, position = 8, allowableValues = "range[0,255]")
	private String position;

	/**
	 * 氏名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "氏名", required = false, position = 9, allowableValues = "range[0,255]")
	private String name;

}
