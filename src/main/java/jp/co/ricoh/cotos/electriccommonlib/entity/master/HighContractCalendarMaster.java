package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 高圧契約締日カレンダーマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "high_contract_calendar_master")
public class HighContractCalendarMaster extends EntityBaseMaster {

	public enum DetermineCondition {

		契約電力500kW以上("1"), 部分供給_付帯外契約等("2"), 契約電力500kW未満("3"), 新電力から切替("4"), 計量日("5");

		private final String text;

		private DetermineCondition(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static DetermineCondition fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "high_contract_calendar_master_seq")
	@SequenceGenerator(name = "high_contract_calendar_master_seq", sequenceName = "high_contract_calendar_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力会社名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力会社名", required = true, position = 2, allowableValues = "range[0,255]")
	private String electricCompanyName;

	/**
	 * 供給開始月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "供給開始月", required = true, position = 3, allowableValues = "range[0,255]")
	private String supplyStartYm;

	/**
	 * 条件判定順
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "条件判定順 ", required = true, position = 4, allowableValues = "range[0,999]")
	private int condDetermineOrder;

	/**
	 * 判定条件
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "判定条件", required = true, position = 5, allowableValues = "契約電力500kW以上(\"1\"), 部分供給_付帯外契約等(\"2\"), 契約電力500kW未満(\"3\"), 新電力から切替(\"4\"), 計量日(\"5\")", example = "1")
	private DetermineCondition determineCondition;

	/**
	 * 計量日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "計量日 ", required = false, position = 6, allowableValues = "range[0,99999]")
	private int measurementDate;

	/**
	 * 電力会社申込期日
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力会社申込期日", required = true, position = 7)
	@Temporal(TemporalType.DATE)
	private Date electricCompanyApplyDate;

}
