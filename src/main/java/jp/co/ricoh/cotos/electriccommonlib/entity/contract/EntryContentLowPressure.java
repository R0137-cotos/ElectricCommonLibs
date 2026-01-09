package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentLowPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * お申込み内容(低圧)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "entry_content_low_pressure")
@CotosComplementTarget(entity = EntryContentLowPressure.class, repository = EntryContentLowPressureRepository.class)
public class EntryContentLowPressure extends EntityBase {

	public enum LowPressureType {

		従量電灯1("1"), 従量電灯2("2"), 動力("3");

		private final String text;

		private LowPressureType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static LowPressureType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum ContractUnit {

		A("1"), kVA("2"), 契約("3"), kW("4");

		private final String text;

		private ContractUnit(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ContractUnit fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_content_low_pressure_seq")
	@SequenceGenerator(name = "entry_content_low_pressure_seq", sequenceName = "entry_content_low_pressure_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 契約容量(従量電灯)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "契約容量(従量電灯)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "契約電流", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "契約電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 負荷率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@Column(nullable = false)
	@Schema(description = "基本検針日(低圧)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notes;

	/**
	 * 低圧種別
	 */
	@Column(nullable = false)
	@Schema(description = "低圧種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "従量電灯1(\"1\"), 従量電灯2(\"2\"), 動力(\"3\")", example = "1")
	private LowPressureType lowPressureType;

	/**
	 * 契約単位
	 */
	@Column(nullable = false)
	@Schema(description = "契約単位", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "A(\"1\"), KvA(\"2\"), 契約(\"3\"),　kW(\"4\")", example = "1")
	private ContractUnit contractUnit;
}
