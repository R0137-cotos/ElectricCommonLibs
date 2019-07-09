package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 精算分電力量差異情報(高圧)
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "settle_uss_differrence_info_high_volt")
public class SettleUssDifferrenceInfoHighVolt extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settle_uss_differrence_info_high_volt_seq")
	@SequenceGenerator(name = "settle_uss_differrence_info_high_volt_seq", sequenceName = "settle_uss_differrence_info_high_volt_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1)
	private long id;

	/**
	 * 全体番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "全体番号", required = true, position = 2)
	@JsonProperty("全体番号")
	private String feeClcAllBn;
	
	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算実行番号", required = true, position = 3)
	@JsonProperty("料金計算実行番号")
	private String feeClcExecBn;
	
	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約番号", required = true, position = 4)
	@JsonProperty("契約番号")
	private String ctctBn;
	
	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算対象年月", required = true, position = 5)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;
	
	/**
	 * 需要家番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "需要家番号", required = true, position = 6)
	@JsonProperty("需要家番号")
	private String cstmrBn;
	
	/**
	 * 料金メニューコード
	 */
	@Column(nullable = true, name = "fee_mnu_cd")
	@ApiModelProperty(value = "料金メニューコード", required = false, position = 7)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;
	
	/**
	 * 差異発生年月
	 */
	@Column(nullable = true, name = "diff_ocrr_ym")
	@ApiModelProperty(value = "差異発生年月", required = false, position = 8)
	@JsonProperty("差異発生年月")
	private String diff_ocrrYm;
	
	/**
	 * 契約電力差異
	 */
	@Column(nullable = true, name = "diff_ctct_elc")
	@ApiModelProperty(value = "契約電力差異", required = false, position = 9)
	@JsonProperty("契約電力差異")
	private Long diffCtctElc;
	
	/**
	 * 力率差異
	 */
	@Column(nullable = true, name = "diff_powp")
	@ApiModelProperty(value = "力率差異", required = false, position = 10)
	@JsonProperty("力率差異")
	private Long diffPowp;
	
	/**
	 * 使用電力量差異（夏季）
	 */
	@Column(nullable = true, name = "diff_minu30_elc_uss_summer")
	@ApiModelProperty(value = "使用電力量差異（夏季）", required = false, position = 11)
	@JsonProperty("使用電力量差異（夏季）")
	private Long diffMinu30ElcUssSummer;
	
	/**
	 * 使用電力量差異（その他季）
	 */
	@Column(nullable = true, name = "diff_minu30_elc_uss_other")
	@ApiModelProperty(value = "使用電力量差異（その他季）", required = false, position = 12)
	@JsonProperty("使用電力量差異（その他季）")
	private Long diffMinu30ElcUssOther;

}