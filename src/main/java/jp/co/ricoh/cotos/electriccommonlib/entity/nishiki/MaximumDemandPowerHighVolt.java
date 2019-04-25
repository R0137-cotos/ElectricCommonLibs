package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1)
	private long id;

	/**
	 * NISHIKI料金計算結果ID
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "fee_calc_interface_id", referencedColumnName = "id")
	@JsonIgnore
	private FeeCalcInterface feeCalcInterface;

	/**
	 * 全体番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "全体番号", required = false, position = 2)
	@JsonProperty("全体番号")
	private String feeClcAllBn;

	/**
	 * 契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約番号", required = false, position = 3)
	@JsonProperty("契約番号")
	private String ctctBn;

	/**
	 * 料金メニューコード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金メニューコード", required = false, position = 4)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;

	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算対象年月", required = false, position = 5)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;

	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算実行番号", required = false, position = 6)
	@JsonProperty("料金計算実行番号")
	private String feeClcExecBn;

	/**
	 * 月間電力量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "月間電力量", required = false, position = 7)
	@JsonProperty("月間電力量")
	private Long mnthElcNum;

	/**
	 * 力率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力率", required = false, position = 8)
	@JsonProperty("力率")
	private Long powp;

	/**
	 * 最大需要電力実績年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "最大需要電力実績年月", required = false, position = 9)
	@JsonProperty("最大需要電力実績年月")
	private String maxDmdElcRsYm;

	/**
	 * 最大需要電力
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "最大需要電力", required = false, position = 10)
	@JsonProperty("最大需要電力")
	private Long maxDmdElc;

	/**
	 * 訂正最大需要電力
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "訂正最大需要電力", required = false, position = 11)
	@JsonProperty("訂正最大需要電力")
	private Long crctMaxDmdElc;

	/**
	 * デマンド値
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "デマンド値", required = false, position = 12)
	@JsonProperty("デマンド値")
	private Long dmndNumMaxDmdElc;

	/**
	 * 協議デマンド
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "協議デマンド", required = false, position = 13)
	@JsonProperty("協議デマンド")
	private Long cnslDmndMaxDmdElc;

}
