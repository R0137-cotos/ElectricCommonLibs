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
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ContractFormArticleJudgeMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約書帳票条文判定マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "contract_form_article_jadge_master")
@CotosComplementTarget(entity = ContractFormArticleJudgeMaster.class, repository = ContractFormArticleJudgeMasterRepository.class)
public class ContractFormArticleJudgeMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_form_article_jadge_master_seq")
	@SequenceGenerator(name = "contract_form_article_jadge_master_seq", sequenceName = "contract_form_article_jadge_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * メニュー名
	 */
	@Column(nullable = false)
	@Schema(description = "メニュー名", requiredMode = Schema.RequiredMode.REQUIRED)
	private String electricMenu;

	/**
	 * 帳票パターンID
	 */
	@Column(nullable = false)
	@Schema(description = "帳票パターンID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long formPatternId;

	/**
	 * 条文パターンID
	 */
	@Column(nullable = false)
	@Schema(description = "条文パターンID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long articlePatternId;

	/**
	 * 判定優先度
	 */
	@Column(nullable = false)
	@Schema(description = "判定優先度", requiredMode = Schema.RequiredMode.REQUIRED)
	private long judgePriority;

}
