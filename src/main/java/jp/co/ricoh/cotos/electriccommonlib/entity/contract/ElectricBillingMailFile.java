package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求実績ID
	 */
	@Column(nullable = false)
	@Schema(description = "請求実績ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long billingHistoryId;

	/**
	 * メールテンプレートマスターID
	 */
	@Column(nullable = false)
	@Schema(description = "メールテンプレートマスターID", requiredMode = Schema.RequiredMode.REQUIRED)
	private Long mailTemplateMasterId;

	/**
	 * メール件名
	 */
	@Column(nullable = true)
	@Schema(description = "メール件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailSubject;

	/**
	 * メールファイルパス
	 */
	@Column(nullable = true)
	@Schema(description = "メールファイルパス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailPath;
}
