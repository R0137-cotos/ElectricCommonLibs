package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MailAddressInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Mailアドレス情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "mail_address_information")
@CotosComplementTarget(entity = MailAddressInformation.class, repository = MailAddressInformationRepository.class)
public class MailAddressInformation extends EntityBase {

	public enum MailIdentification {

		契約担当("1"), ピークアラート担当("2"), 請求先担当("3"), すべて("4");

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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * Mail識別
	 */
	@Column(nullable = false)
	@Schema(description = "Mail識別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "契約担当者(\"1\"), ピークアラート担当者(\"2\"), 請求先担当(\"3\"), すべて(\"4\")", example = "1")
	private MailIdentification mailIdentification;

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
	 * ピークアラートしきい値
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "ピークアラートしきい値", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal peakAlertThreshold;
}
