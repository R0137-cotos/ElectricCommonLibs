package jp.co.ricoh.cotos.electriccommonlib.entity.common;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.entity.common.MailSendHistory.MailSendType;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricMailControlMaster;
import jp.co.ricoh.cotos.electriccommonlib.repository.common.ElectricMailSendHistoryRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力メール送信履歴情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_mail_send_history")
@CotosComplementTarget(entity = ElectricMailSendHistory.class, repository = ElectricMailSendHistoryRepository.class)
public class ElectricMailSendHistory extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_mail_send_history_seq")
	@SequenceGenerator(name = "electric_mail_send_history_seq", sequenceName = "electric_mail_send_history_seq", allocationSize = 1)
	@Schema(description = "電力メール送信履歴ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9999999999999999999]")
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
	 * 対象データID
	 */
	@Column(nullable = true)
	@Schema(description = "対象データID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long targetDataId;

	/**
	 * 宛先To
	 */
	@Column(nullable = true)
	@Schema(description = "宛先To", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactMailTo;

	/**
	 * 宛先Cc
	 */
	@Column(nullable = true)
	@Schema(description = "宛先Cc", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactMailCc;

	/**
	 * 宛先Bcc
	 */
	@Column(nullable = true)
	@Schema(description = "宛先Bcc", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactMailBcc;

	/**
	 * メール送信区分
	 */
	@Column(nullable = true)
	@Schema(description = "メール送信区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 完了(\"1\"), エラー(\"2\")", example = "1")
	private MailSendType mailSendType;

	/**
	 * 送信日時
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Schema(description = "実施日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_ONLY)
	private Date sendedAt;

}
