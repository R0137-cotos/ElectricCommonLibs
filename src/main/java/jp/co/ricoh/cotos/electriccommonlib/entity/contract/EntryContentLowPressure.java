package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
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

		 A("1"), KvA("2"), 契約("3"), kW("4");

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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 契約容量(従量電灯)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約容量(従量電灯)", required = false, position = 3, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電流", required = false, position = 5, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力", required = false, position = 7, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 負荷率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 8, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "基本検針日(低圧)", required = true, position = 9, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "備考", required = false, position = 10, allowableValues = "range[0,4000]")
	private String notes;
	
	/**
	 * 低圧種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "低圧種別", required = true, position = 11, allowableValues = "従量電灯1(\"1\"), 従量電灯2(\"2\"), 動力(\"3\")", example = "1")
	private LowPressureType lowPressureType;
	
	/**
	 * 契約単位
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約単位", required = true, position = 12, allowableValues = "A(\"1\"), KvA(\"2\"), 契約(\"3\"),　kW(\"4\")", example = "1")
	private ContractUnit contractUnit;
}
