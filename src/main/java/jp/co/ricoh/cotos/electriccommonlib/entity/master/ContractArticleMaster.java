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
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約書条文マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "contract_article_master")
@CotosComplementTarget(entity = ContractArticleMaster.class, repository = ElectricFormMasterRepository.class)
public class ContractArticleMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_article_master_seq")
	@SequenceGenerator(name = "contract_article_master_seq", sequenceName = "contract_article_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 商流区分
	 */
	@Column
	@ApiModelProperty(value = "商流区分", required = false, position = 2, allowableValues = "直売(\"1\"), 代売(\"2\"), RJ社内供給用(\"3\"), 取次(\"4\")")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 条文パターンID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "条文パターンID", required = false, position = 3)
	private Long articlePatternId;

	/**
	 * 帳票項目ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "帳票項目ID", required = false, position = 4)
	private String formItemId;

	/**
	 * 文言
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "文言", required = false, position = 5)
	private String itemText;

}
