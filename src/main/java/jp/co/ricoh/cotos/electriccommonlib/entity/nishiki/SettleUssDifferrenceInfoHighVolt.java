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
 * NISHIKI料金計算結果ID
 */
@OneToOne(optional = false)
@JoinColumn(name = "feeCalcInterfaceId", referencedColumnName = "id")
@JsonIgnore
private FeeCalcInterface feeCalcInterface;

/**
 * 全体番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "全体番号", required = true, position = 2)
private String feeClcAllBn;

/**
 * 料金計算実行番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金計算実行番号", required = true, position = 3)
private String feeClcExecBn;

/**
 * 契約番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "契約番号", required = true, position = 4)
private String ctctBn;

/**
 * 料金計算対象年月
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金計算対象年月", required = true, position = 5)
private String feeClcYm;

/**
 * 需要家番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "需要家番号", required = true, position = 6)
private String cstmrBn;

/**
 * 料金メニューコード
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金メニューコード", required = true, position = 7)
private String feeMnuCd;

/**
 * 差異発生年月
 */
@Column(nullable = false)
@ApiModelProperty(value = "差異発生年月", required = true, position = 8)
private String diffOcrrYm;

/**
 * 契約電力差異
 */
@Column(nullable = false)
@ApiModelProperty(value = "契約電力差異", required = true, position = 9)
private long diffCtctElc;

/**
 * 力率差異
 */
@Column(nullable = false)
@ApiModelProperty(value = "力率差異", required = true, position = 10)
private long diffPowp;

/**
 * 使用電力量差異(夏季)
 */
@Column(nullable = false, name = "diff_minu30_elc_uss_summer")
@ApiModelProperty(value = "使用電力量差異(夏季)", required = true, position = 11)
private long diffMinu30ElcUssSummer;

/**
 * 使用電力量差異(その他季)
 */
@Column(nullable = false, name = "diff_minu30_elc_uss_other")
@ApiModelProperty(value = "使用電力量差異(その他季)", required = true, position = 12)
private long diffMinu30ElcUssOther;

}