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
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ContractArticleMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約書条文マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "contract_article_master")
@CotosComplementTarget(entity = ContractArticleMaster.class, repository = ContractArticleMasterRepository.class)
public class ContractArticleMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_article_master_seq")
	@SequenceGenerator(name = "contract_article_master_seq", sequenceName = "contract_article_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 商流区分
	 */
	@Column
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "直売(\"1\"), 代売(\"2\"), RJ社内供給用(\"3\"), 取次(\"4\")")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 条文パターンID
	 */
	@Column(nullable = false)
	@Schema(description = "条文パターンID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long articlePatternId;

	/**
	 * 帳票項目ID
	 */
	@Column(nullable = false)
	@Schema(description = "帳票項目ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String formItemId;

	/**
	 * 文言
	 */
	@Column(nullable = false)
	@Schema(description = "文言", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String itemText;

}
