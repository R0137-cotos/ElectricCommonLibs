package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.MailConvertValueMaster.SubjectVodyType;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricMailConvertValueMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力通知メール変換値マスタを表すEntity
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "electric_mail_convert_value_master")
@CotosComplementTarget(entity = ElectricMailConvertValueMaster.class, repository = ElectricMailConvertValueMasterRepository.class)
public class ElectricMailConvertValueMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_mail_convert_value_master_seq")
	@SequenceGenerator(name = "electric_mail_convert_value_master_seq", sequenceName = "electric_mail_convert_value_master_seq", allocationSize = 1)
	@Schema(description = "電力通知メール変換値マスタID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 電力通知メール制御マスタ
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "electric_mail_control_master_id", referencedColumnName = "id")
	@JsonIgnore
	@Schema(description = "電力通知メール制御マスタ", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricMailControlMaster electricMailControlMaster;

	/**
	 * 件名/本文区分
	 */
	@Column(nullable = true)
	@Schema(description = "件名/本文区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "件名(\"0\"), 本文(\"1\")", example = "1")
	private SubjectVodyType subjectBodyType;

	/**
	 * 置換変数番号
	 */
	@Column(nullable = true)
	@Schema(description = "置換変数番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer replaceVariableNumber;

	/**
	 * 置換値エンティティ名
	 */
	@Column(nullable = true)
	@Schema(description = "置換値エンティティ名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String replaceEntityName;

	/**
	 * 置換値フィールド名
	 */
	@Column(nullable = true)
	@Schema(description = "置換値フィールド名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String replaceFieldName;
}
