package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 制限中止割引情報（高圧）
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "lim_dsc_info_high_volt")
public class LimDscInfoHighVolt extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lim_dsc_info_high_volt_seq")
	@SequenceGenerator(name = "lim_dsc_info_high_volt_seq", sequenceName = "lim_dsc_info_high_volt_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;
	
	/**
	 * 全体番号
	 */
	@Column(nullable = false)
	@Schema(description = "全体番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("全体番号")
	private String feeClcAllBn;
	
	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@Schema(description = "契約番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("契約番号")
	private String ctctBn;
	
	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算対象年月", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;
	
	/**
	 * 料金メニューコード
	 */
	@Column(nullable = false)
	@Schema(description = "料金メニューコード", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;
	
	/**
	 * 託送対象年月
	 */
	@Column(nullable = false)
	@Schema(description = "託送対象年月", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("託送対象年月")
	private String csAplyYm;
	
	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("供給地点特定番号")
	private String splyPointIdntBn;
	
	/**
	 * 算定期間開始日
	 */
	@Column(nullable = true)
	@Schema(description = "算定期間開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("算定期間開始日")
	private Long estmStrDate;
	
	/**
	 * 算定期間終了日
	 */
	@Column(nullable = true)
	@Schema(description = "算定期間終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("算定期間終了日")
	private Long estmEndDate;
	
	/**
	 * 割引対象コード
	 */
	@Column(nullable = true)
	@Schema(description = "割引対象コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("割引対象コード")
	private Long dscObjCd;
	
	/**
	 * 割引対象時間数
	 */
	@Column(nullable = true)
	@Schema(description = "割引対象時間数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("割引対象時間数")
	private Long dscObjTime;
	
	/**
	 * 割引対象日数
	 */
	@Column(nullable = true)
	@Schema(description = "割引対象日数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("割引対象日数")
	private Long dscObjDays;
	
	/**
	 * 制限中止割引額
	 */
	@Column(nullable = true)
	@Schema(description = "制限中止割引額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("制限中止割引額")
	private BigDecimal lmtDscntnMny;
	
}
