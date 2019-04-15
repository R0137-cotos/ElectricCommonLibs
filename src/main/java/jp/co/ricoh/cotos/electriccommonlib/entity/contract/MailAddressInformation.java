package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Mailアドレス情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "mail_address_information")
public class MailAddressInformation extends EntityBase {
	
	public enum MailIdentification {

		契約担当("1"), ピークアラート担当("2");

		private final String text;

		private MailIdentification(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static MailIdentification fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mail_address_information_seq")
	@SequenceGenerator(name = "mail_address_information_seq", sequenceName = "mail_address_information_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;
	
	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;
	
	/**
	 * Mail識別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "Mail識別", required = true, position = 3, allowableValues = "契約担当者(\"1\"), ピークアラート担当者(\"2\")", example = "1")
	private MailIdentification mailIdentification;
	
	/**
	 * 氏名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "氏名", required = true, position = 4, allowableValues = "range[0,255]")
	private String name;
	
	/**
	 * メールアドレス
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールアドレス", required = true, position = 5, allowableValues = "range[0,255]")
	private String mailAddress;
}
