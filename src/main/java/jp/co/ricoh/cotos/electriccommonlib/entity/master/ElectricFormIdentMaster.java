package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormIdentMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力帳票識別マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_form_ident_master")
@CotosComplementTarget(entity = ElectricFormIdentMaster.class, repository = ElectricFormIdentMasterRepository.class)
public class ElectricFormIdentMaster extends EntityBaseMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_form_ident_master_seq")
	@SequenceGenerator(name = "electric_form_ident_master_seq", sequenceName = "electric_form_ident_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 帳票コード
	 */
	@Column(nullable = false)
	@Schema(description = "帳票コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String formCode;

	/**
	 * 添付対象帳票名
	 */
	@Column(nullable = false)
	@Schema(description = "添付対象帳票名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String targetFormName;

	/**
	 * 帳票出力テンプレート
	 */
	@Column(nullable = false)
	@Schema(description = "帳票出力テンプレート", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String templateFormName;
	
	/**
	 * 添付必須フラグ
	 */
	@Column(nullable = false)
	@Schema(description = "添付必須フラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int targetRequiredFlg;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@Schema(description = "説明", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String description;
	
	/**
	 * 帳票テンプレート管理マスタID
	 */
	@Column(nullable = false)
	@Schema(description = "帳票テンプレート管理マスタID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private Long reportTemplateMasterId;

	@ManyToMany(mappedBy = "electricFormIdentMasterList")
	@Schema(description = "電力帳票マスタ", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<ElectricFormMaster> electricFormMasterList;
}