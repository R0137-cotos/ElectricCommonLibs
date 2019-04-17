package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import java.math.BigDecimal;

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
 * 契約超過金情報(高圧)
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "excs_charge_info_high_volt")
public class ExcsChargeInfoHighVolt extends EntityBase {

/**
 * ID
 */
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "excs_charge_info_high_volt_seq")
@SequenceGenerator(name = "excs_charge_info_high_volt_seq", sequenceName = "excs_charge_info_high_volt_seq", allocationSize = 1)
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
@Column(nullable = false)
@ApiModelProperty(value = "全体番号", required = true, position = 2)
private String feeClcAllBn;

/**
 * 契約番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "契約番号", required = true, position = 3)
private String ctctBn;

/**
 * 料金計算対象年月
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金計算対象年月", required = true, position = 4)
private String feeClcYm;

/**
 * 料金メニューコード
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金メニューコード", required = true, position = 5)
private String feeMnuCd;

/**
 * 託送対象年月
 */
@Column(nullable = true)
@ApiModelProperty(value = "託送対象年月", required = false, position = 6)
private String csAplyYm;

/**
 * 供給地点特定番号
 */
@Column(nullable = true)
@ApiModelProperty(value = "供給地点特定番号", required = false, position = 7)
private String splyPointIdntBn;

/**
 * 超過電力
 */
@Column(nullable = true)
@ApiModelProperty(value = "超過電力", required = false, position = 8)
private Long excsElc;

/**
 * 契約電力
 */
@Column(nullable = true)
@ApiModelProperty(value = "契約電力", required = false, position = 9)
private Long ctctElc;

/**
 * 契約超過金
 */
@Column(nullable = true)
@ApiModelProperty(value = "契約超過金", required = false, position = 10)
private BigDecimal ctctExcsMny;

}
