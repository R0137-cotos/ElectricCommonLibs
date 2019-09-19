package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.MailConvertValueMaster.SubjectVodyType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力通知メール変換値マスタを表すEntity
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "electric_mail_convert_value_master")
public class ElectricMailConvertValueMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_mail_convert_value_master_seq")
	@SequenceGenerator(name = "electric_mail_convert_value_master_seq", sequenceName = "electric_mail_convert_value_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "電力通知メール変換値マスタID", required = true, position = 1, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 電力通知メール制御マスタ
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "electric_mail_control_master_id", referencedColumnName = "id")
	@JsonIgnore
	@ApiModelProperty(value = "電力通知メール制御マスタ", required = true, position = 2)
	private ElectricMailControlMaster electricMailControlMaster;

	/**
	 * 件名/本文区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "件名/本文区分", required = false, allowableValues = "件名(\"0\"), 本文(\"1\")", example = "1", position = 3)
	private SubjectVodyType subjectBodyType;

	/**
	 * 置換変数番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "置換変数番号", required = false, position = 4)
	private Integer replaceVariableNumber;

	/**
	 * 置換値エンティティ名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "置換値エンティティ名", required = false, position = 5, allowableValues = "range[0,255]")
	private String replaceEntityName;

	/**
	 * 置換値フィールド名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "置換値フィールド名", required = false, position = 6, allowableValues = "range[0,255]")
	private String replaceFieldName;
}
