package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

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
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingMailAddressInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 請求先Mailアドレス情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "billing_mail_address_information")
@CotosComplementTarget(entity = BillingMailAddressInformation.class, repository = BillingMailAddressInformationRepository.class)
public class BillingMailAddressInformation extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_mail_address_information_seq")
	@SequenceGenerator(name = "billing_mail_address_information_seq", sequenceName = "billing_mail_address_information_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 得意先情報M_ID
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "client_master_id", referencedColumnName = "id")
	@Schema(description = "得意先情報M_ID", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ClientMaster clientMaster;

	/**
	 * 氏名
	 */
	@Column(nullable = false)
	@Schema(description = "氏名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Column(nullable = false)
	@Schema(description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * MyRICOHユーザーID
	 */
	@Column(nullable = true)
	@Schema(description = "MyRICOHユーザーID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String myricohId;

}
