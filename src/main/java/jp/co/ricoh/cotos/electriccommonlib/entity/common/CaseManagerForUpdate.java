package jp.co.ricoh.cotos.electriccommonlib.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.common.CaseManagerForUpdateRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * [更新用]案件担当者更新用テーブルを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "case_manager_for_update")
@CotosComplementTarget(entity = CaseManagerForUpdate.class, repository = CaseManagerForUpdateRepository.class)
public class CaseManagerForUpdate extends EntityBase {

	@Id
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 案件番号
	 */
	@Column(nullable = false)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.REQUIRED)
	private String caseNumber;

	/**
	 * 担当SA
	 */
	@Column(nullable = true)
	@Schema(description = "担当SA", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picSa;

	/**
	 * 電力専任
	 */
	@Column(nullable = true)
	@Schema(description = "電力専任", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricExpert;

	/**
	 * 追加編集者１
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor1;

	/**
	 * 追加編集者２
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor2;

	/**
	 * 追加編集者３
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者３", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor3;

	/**
	 * 追加編集者４
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者４", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor4;

	/**
	 * 追加編集者５
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者５", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor5;

	/**
	 * 追加編集者６
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者６", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor6;

	/**
	 * 追加編集者７
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者７", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor7;

	/**
	 * 追加編集者８
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者８", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor8;

	/**
	 * 追加編集者９
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者９", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor9;

	/**
	 * 追加編集者１０
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１０", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor10;

	/**
	 * 追加編集者１１
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor11;

	/**
	 * 追加編集者１２
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor12;

	/**
	 * 追加編集者１３
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１３", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor13;

	/**
	 * 追加編集者１４
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１４", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor14;

	/**
	 * 追加編集者１５
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１５", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor15;

	/**
	 * 追加編集者１６
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１６", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor16;

	/**
	 * 追加編集者１７
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１７", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor17;

	/**
	 * 追加編集者１８
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１８", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor18;

	/**
	 * 追加編集者１９
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者１９", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor19;

	/**
	 * 追加編集者２０
	 */
	@Column(nullable = true)
	@Schema(description = "追加編集者２０", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String addedEditor20;

}
