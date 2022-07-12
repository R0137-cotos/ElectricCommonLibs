package jp.co.ricoh.cotos.electriccommonlib.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 案件番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "案件番号", required = true, position = 2)
	private String caseNumber;

	/**
	 * 担当SA
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "担当SA", required = false, position = 3, allowableValues = "range[0,255]")
	private String picSa;

	/**
	 * 電力専任
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力専任", required = false, position = 4, allowableValues = "range[0,255]")
	private String electricExpert;

	/**
	 * 追加編集者１
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１", required = false, position = 5, allowableValues = "range[0,255]")
	private String addedEditor1;

	/**
	 * 追加編集者２
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者２", required = false, position = 6, allowableValues = "range[0,255]")
	private String addedEditor2;

	/**
	 * 追加編集者３
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者３", required = false, position = 7, allowableValues = "range[0,255]")
	private String addedEditor3;

	/**
	 * 追加編集者４
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者４", required = false, position = 8, allowableValues = "range[0,255]")
	private String addedEditor4;

	/**
	 * 追加編集者５
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者５", required = false, position = 9, allowableValues = "range[0,255]")
	private String addedEditor5;

	/**
	 * 追加編集者６
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者６", required = false, position = 10, allowableValues = "range[0,255]")
	private String addedEditor6;

	/**
	 * 追加編集者７
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者７", required = false, position = 11, allowableValues = "range[0,255]")
	private String addedEditor7;

	/**
	 * 追加編集者８
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者８", required = false, position = 12, allowableValues = "range[0,255]")
	private String addedEditor8;

	/**
	 * 追加編集者９
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者９", required = false, position = 13, allowableValues = "range[0,255]")
	private String addedEditor9;

	/**
	 * 追加編集者１０
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１０", required = false, position = 14, allowableValues = "range[0,255]")
	private String addedEditor10;

	/**
	 * 追加編集者１１
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１１", required = false, position = 15, allowableValues = "range[0,255]")
	private String addedEditor11;

	/**
	 * 追加編集者１２
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１２", required = false, position = 16, allowableValues = "range[0,255]")
	private String addedEditor12;

	/**
	 * 追加編集者１３
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１３", required = false, position = 17, allowableValues = "range[0,255]")
	private String addedEditor13;

	/**
	 * 追加編集者１４
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１４", required = false, position = 18, allowableValues = "range[0,255]")
	private String addedEditor14;

	/**
	 * 追加編集者１５
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１５", required = false, position = 19, allowableValues = "range[0,255]")
	private String addedEditor15;

	/**
	 * 追加編集者１６
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１６", required = false, position = 20, allowableValues = "range[0,255]")
	private String addedEditor16;

	/**
	 * 追加編集者１７
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１７", required = false, position = 21, allowableValues = "range[0,255]")
	private String addedEditor17;

	/**
	 * 追加編集者１８
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１８", required = false, position = 22, allowableValues = "range[0,255]")
	private String addedEditor18;

	/**
	 * 追加編集者１９
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者１９", required = false, position = 23, allowableValues = "range[0,255]")
	private String addedEditor19;

	/**
	 * 追加編集者２０
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加編集者２０", required = false, position = 24, allowableValues = "range[0,255]")
	private String addedEditor20;

}
