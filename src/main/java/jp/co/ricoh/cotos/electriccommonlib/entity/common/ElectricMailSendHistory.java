package jp.co.ricoh.cotos.electriccommonlib.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "電力メール送信履歴ID", required = true, position = 1, allowableValues = "range[0,9999999999999999999]")
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
	 * 対象データID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "対象データID", required = false, position = 3)
	private Long targetDataId;

	/**
	 * 宛先To
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "宛先To", required = false, position = 4, allowableValues = "range[0,255]")
	private String contactMailTo;

	/**
	 * 宛先Cc
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "宛先Cc", required = false, position = 5, allowableValues = "range[0,255]")
	private String contactMailCc;

	/**
	 * 宛先Bcc
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "宛先Bcc", required = false, position = 6, allowableValues = "range[0,255]")
	private String contactMailBcc;

	/**
	 * メール送信区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メール送信区分", required = false, allowableValues = "未送信(\"0\"), 完了(\"1\"), エラー(\"2\")", example = "1", position = 7)
	private MailSendType mailSendType;

	/**
	 * 送信日時
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@ApiModelProperty(value = "実施日時", required = false, position = 8, readOnly = true)
	private Date sendedAt;

}
