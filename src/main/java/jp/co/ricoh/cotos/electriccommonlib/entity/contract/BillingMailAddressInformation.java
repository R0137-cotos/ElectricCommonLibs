package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 得意先情報M_ID
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "client_master_id", referencedColumnName = "id")
	@ApiModelProperty(value = "得意先情報M_ID", required = true, position = 2)
	@JsonIgnore
	private ClientMaster clientMaster;

	/**
	 * 氏名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "氏名", required = true, position = 3, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールアドレス", required = true, position = 4, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * MyRICOHユーザーID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "MyRICOHユーザーID", required = true, position = 5, allowableValues = "range[0,255]")
	private String myricohId;

}
