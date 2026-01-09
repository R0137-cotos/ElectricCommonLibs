package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.HighContractCalendarMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 高圧契約締日カレンダーマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "high_contract_calendar_master")
@CotosComplementTarget(entity = HighContractCalendarMaster.class, repository = HighContractCalendarMasterRepository.class)
public class HighContractCalendarMaster extends EntityBaseMaster {

	public enum DetermineCondition {

		契約電力500kW以上("1"), 部分供給_付帯外契約等("2"), 契約電力500kW未満("3"), 新電力から切替("4"), 計量日("5"), 取次協議性_契約電力増加("6");

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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力会社名
	 */
	@Column(nullable = false)
	@Schema(description = "電力会社名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyName;

	/**
	 * 供給開始月
	 */
	@Column(nullable = false)
	@Schema(description = "供給開始月", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartYm;

	/**
	 * 条件判定順
	 */
	@Column(nullable = false)
	@Schema(description = "条件判定順 ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,999]")
	private int condDetermineOrder;

	/**
	 * 判定条件
	 */
	@Column(nullable = false)
	@Schema(description = "判定条件", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "契約電力500kW以上(\"1\"), 部分供給_付帯外契約等(\"2\"), 契約電力500kW未満(\"3\"), 新電力から切替(\"4\"), 計量日(\"5\")", example = "1")
	private DetermineCondition determineCondition;

	/**
	 * 計量日
	 */
	@Column(nullable = true)
	@Schema(description = "計量日 ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Integer measurementDate;

	/**
	 * 電力会社申込期日
	 */
	@Column(nullable = false)
	@Schema(description = "電力会社申込期日", requiredMode = Schema.RequiredMode.REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date electricCompanyApplyDate;

}
