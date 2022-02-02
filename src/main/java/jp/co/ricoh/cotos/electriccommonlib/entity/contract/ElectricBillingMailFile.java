package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricBillingMailFileRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 請求書通知メールファイルを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_billing_mail_file")
@CotosComplementTarget(entity = ElectricBillingMailFile.class, repository = ElectricBillingMailFileRepository.class)
public class ElectricBillingMailFile extends EntityBase {

	@Id
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求実績ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "請求実績ID", required = true, position = 2)
	private Long billingHistoryId;

	/**
	 * メールテンプレートマスターID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールテンプレートマスターID", required = true, position = 3)
	private Long mailTemplateMasterId;

	/**
	 * メール件名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メール件名", required = false, position = 4, allowableValues = "range[0,255]")
	private String mailSubject;

	/**
	 * メールファイルパス
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールファイルパス", required = false, position = 5, allowableValues = "range[0,255]")
	private String mailPath;
}
