package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

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
 * 最大需要電力情報(高圧)
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "maximum_demand_power_high_volt")
public class MaximumDemandPowerHighVolt extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maximum_demand_power_high_volt_seq")
	@SequenceGenerator(name = "maximum_demand_power_high_volt_seq", sequenceName = "maximum_demand_power_high_volt_seq", allocationSize = 1)
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
	 * 料金メニューコード
	 */
	@Column(nullable = false)
	@Schema(description = "料金メニューコード", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;
	
	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算対象年月", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;
	
	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算実行番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算実行番号")
	private String feeClcExecBn;
	
	/**
	 * 月間電力量
	 */
	@Column(nullable = true)
	@Schema(description = "月間電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("月間電力量")
	private Long mnthElcNum;
	
	/**
	 * 力率
	 */
	@Column(nullable = true)
	@Schema(description = "力率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力率")
	private Long powp;
	
	/**
	 * 最大需要電力実績年月
	 */
	@Column(nullable = true)
	@Schema(description = "最大需要電力実績年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("最大需要電力実績年月")
	private Long maxDmdElcRsYm;
	
	/**
	 * 最大需要電力
	 */
	@Column(nullable = true)
	@Schema(description = "最大需要電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("最大需要電力")
	private Long maxDmdElc;
	
	/**
	 * 訂正最大需要電力
	 */
	@Column(nullable = true)
	@Schema(description = "訂正最大需要電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("訂正最大需要電力")
	private Long crctMaxDmdElc;
	
	/**
	 * デマンド値
	 */
	@Column(nullable = true)
	@Schema(description = "デマンド値", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("デマンド値")
	private Long dmndNumMaxDmdElc;
	
	/**
	 * 協議デマンド
	 */
	@Column(nullable = true)
	@Schema(description = "協議デマンド", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("協議デマンド")
	private Long cnslDmndMaxDmdElc;

}
