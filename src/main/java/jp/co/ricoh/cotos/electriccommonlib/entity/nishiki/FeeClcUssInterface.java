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
 * 料金計算結果電力量
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "fee_clc_uss_interface")
public class FeeClcUssInterface extends EntityBase {

/**
 * ID
 */
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_clc_uss_interface_seq")
@SequenceGenerator(name = "fee_clc_uss_interface_seq", sequenceName = "fee_clc_uss_interface_seq", allocationSize = 1)
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
 * 料金計算対象年月
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金計算対象年月", required = true, position = 3)
private String feeClcYm;

/**
 * 料金計算実行番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金計算実行番号", required = true, position = 4)
private String feeClcExecBn;

/**
 * 供給地点特定番号
 */
@Column(nullable = false)
@ApiModelProperty(value = "供給地点特定番号", required = true, position = 5)
private String splyPointIdntBn;

/**
 * 料金計算対象年月日
 */
@Column(nullable = false)
@ApiModelProperty(value = "料金計算対象年月日", required = true, position = 6)
private String feeClcYmd;

/**
 * 時刻01_30分電力量
 */
@Column(nullable = true, name = "t01_minu30_elc_uss")
@ApiModelProperty(value = "時刻01_30分電力量", required = false, position = 7)
private BigDecimal t01Minu30ElcUss;

/**
 * 時刻02_30分電力量
 */
@Column(nullable = true, name = "t02_minu30_elc_uss")
@ApiModelProperty(value = "時刻02_30分電力量", required = false, position = 8)
private BigDecimal t02Minu30ElcUss;

/**
 * 時刻03_30分電力量
 */
@Column(nullable = true, name = "t03_minu30_elc_uss")
@ApiModelProperty(value = "時刻03_30分電力量", required = false, position = 9)
private BigDecimal t03Minu30ElcUss;

/**
 * 時刻04_30分電力量
 */
@Column(nullable = true, name = "t04_minu30_elc_uss")
@ApiModelProperty(value = "時刻04_30分電力量", required = false, position = 10)
private BigDecimal t04Minu30ElcUss;

/**
 * 時刻05_30分電力量
 */
@Column(nullable = true, name = "t05_minu30_elc_uss")
@ApiModelProperty(value = "時刻05_30分電力量", required = false, position = 11)
private BigDecimal t05Minu30ElcUss;

/**
 * 時刻06_30分電力量
 */
@Column(nullable = true, name = "t06_minu30_elc_uss")
@ApiModelProperty(value = "時刻06_30分電力量", required = false, position = 12)
private BigDecimal t06Minu30ElcUss;

/**
 * 時刻07_30分電力量
 */
@Column(nullable = true, name = "t07_minu30_elc_uss")
@ApiModelProperty(value = "時刻07_30分電力量", required = false, position = 13)
private BigDecimal t07Minu30ElcUss;

/**
 * 時刻08_30分電力量
 */
@Column(nullable = true, name = "t08_minu30_elc_uss")
@ApiModelProperty(value = "時刻08_30分電力量", required = false, position = 14)
private BigDecimal t08Minu30ElcUss;

/**
 * 時刻09_30分電力量
 */
@Column(nullable = true, name = "t09_minu30_elc_uss")
@ApiModelProperty(value = "時刻09_30分電力量", required = false, position = 15)
private BigDecimal t09Minu30ElcUss;

/**
 * 時刻10_30分電力量
 */
@Column(nullable = true, name = "t10_minu30_elc_uss")
@ApiModelProperty(value = "時刻10_30分電力量", required = false, position = 16)
private BigDecimal t10Minu30ElcUss;

/**
 * 時刻11_30分電力量
 */
@Column(nullable = true, name = "t11_minu30_elc_uss")
@ApiModelProperty(value = "時刻11_30分電力量", required = false, position = 17)
private BigDecimal t11Minu30ElcUss;

/**
 * 時刻12_30分電力量
 */
@Column(nullable = true, name = "t12_minu30_elc_uss")
@ApiModelProperty(value = "時刻12_30分電力量", required = false, position = 18)
private BigDecimal t12Minu30ElcUss;

/**
 * 時刻13_30分電力量
 */
@Column(nullable = true, name = "t13_minu30_elc_uss")
@ApiModelProperty(value = "時刻13_30分電力量", required = false, position = 19)
private BigDecimal t13Minu30ElcUss;

/**
 * 時刻14_30分電力量
 */
@Column(nullable = true, name = "t14_minu30_elc_uss")
@ApiModelProperty(value = "時刻14_30分電力量", required = false, position = 20)
private BigDecimal t14Minu30ElcUss;

/**
 * 時刻15_30分電力量
 */
@Column(nullable = true, name = "t15_minu30_elc_uss")
@ApiModelProperty(value = "時刻15_30分電力量", required = false, position = 21)
private BigDecimal t15Minu30ElcUss;

/**
 * 時刻16_30分電力量
 */
@Column(nullable = true, name = "t16_minu30_elc_uss")
@ApiModelProperty(value = "時刻16_30分電力量", required = false, position = 22)
private BigDecimal t16Minu30ElcUss;

/**
 * 時刻17_30分電力量
 */
@Column(nullable = true, name = "t17_minu30_elc_uss")
@ApiModelProperty(value = "時刻17_30分電力量", required = false, position = 23)
private BigDecimal t17Minu30ElcUss;

/**
 * 時刻18_30分電力量
 */
@Column(nullable = true, name = "t18_minu30_elc_uss")
@ApiModelProperty(value = "時刻18_30分電力量", required = false, position = 24)
private BigDecimal t18Minu30ElcUss;

/**
 * 時刻19_30分電力量
 */
@Column(nullable = true, name = "t19_minu30_elc_uss")
@ApiModelProperty(value = "時刻19_30分電力量", required = false, position = 25)
private BigDecimal t19Minu30ElcUss;

/**
 * 時刻20_30分電力量
 */
@Column(nullable = true, name = "t20_minu30_elc_uss")
@ApiModelProperty(value = "時刻20_30分電力量", required = false, position = 26)
private BigDecimal t20Minu30ElcUss;

/**
 * 時刻21_30分電力量
 */
@Column(nullable = true, name = "t21_minu30_elc_uss")
@ApiModelProperty(value = "時刻21_30分電力量", required = false, position = 27)
private BigDecimal t21Minu30ElcUss;

/**
 * 時刻22_30分電力量
 */
@Column(nullable = true, name = "t22_minu30_elc_uss")
@ApiModelProperty(value = "時刻22_30分電力量", required = false, position = 28)
private BigDecimal t22Minu30ElcUss;

/**
 * 時刻23_30分電力量
 */
@Column(nullable = true, name = "t23_minu30_elc_uss")
@ApiModelProperty(value = "時刻23_30分電力量", required = false, position = 29)
private BigDecimal t23Minu30ElcUss;

/**
 * 時刻24_30分電力量
 */
@Column(nullable = true, name = "t24_minu30_elc_uss")
@ApiModelProperty(value = "時刻24_30分電力量", required = false, position = 30)
private BigDecimal t24Minu30ElcUss;

/**
 * 時刻25_30分電力量
 */
@Column(nullable = true, name = "t25_minu30_elc_uss")
@ApiModelProperty(value = "時刻25_30分電力量", required = false, position = 31)
private BigDecimal t25Minu30ElcUss;

/**
 * 時刻26_30分電力量
 */
@Column(nullable = true, name = "t26_minu30_elc_uss")
@ApiModelProperty(value = "時刻26_30分電力量", required = false, position = 32)
private BigDecimal t26Minu30ElcUss;

/**
 * 時刻27_30分電力量
 */
@Column(nullable = true, name = "t27_minu30_elc_uss")
@ApiModelProperty(value = "時刻27_30分電力量", required = false, position = 33)
private BigDecimal t27Minu30ElcUss;

/**
 * 時刻28_30分電力量
 */
@Column(nullable = true, name = "t28_minu30_elc_uss")
@ApiModelProperty(value = "時刻28_30分電力量", required = false, position = 34)
private BigDecimal t28Minu30ElcUss;

/**
 * 時刻29_30分電力量
 */
@Column(nullable = true, name = "t29_minu30_elc_uss")
@ApiModelProperty(value = "時刻29_30分電力量", required = false, position = 35)
private BigDecimal t29Minu30ElcUss;

/**
 * 時刻30_30分電力量
 */
@Column(nullable = true, name = "t30_minu30_elc_uss")
@ApiModelProperty(value = "時刻30_30分電力量", required = false, position = 36)
private BigDecimal t30Minu30ElcUss;

/**
 * 時刻31_30分電力量
 */
@Column(nullable = true, name = "t31_minu30_elc_uss")
@ApiModelProperty(value = "時刻31_30分電力量", required = false, position = 37)
private BigDecimal t31Minu30ElcUss;

/**
 * 時刻32_30分電力量
 */
@Column(nullable = true, name = "t32_minu30_elc_uss")
@ApiModelProperty(value = "時刻32_30分電力量", required = false, position = 38)
private BigDecimal t32Minu30ElcUss;

/**
 * 時刻33_30分電力量
 */
@Column(nullable = true, name = "t33_minu30_elc_uss")
@ApiModelProperty(value = "時刻33_30分電力量", required = false, position = 39)
private BigDecimal t33Minu30ElcUss;

/**
 * 時刻34_30分電力量
 */
@Column(nullable = true, name = "t34_minu30_elc_uss")
@ApiModelProperty(value = "時刻34_30分電力量", required = false, position = 40)
private BigDecimal t34Minu30ElcUss;

/**
 * 時刻35_30分電力量
 */
@Column(nullable = true, name = "t35_minu30_elc_uss")
@ApiModelProperty(value = "時刻35_30分電力量", required = false, position = 41)
private BigDecimal t35Minu30ElcUss;

/**
 * 時刻36_30分電力量
 */
@Column(nullable = true, name = "t36_minu30_elc_uss")
@ApiModelProperty(value = "時刻36_30分電力量", required = false, position = 42)
private BigDecimal t36Minu30ElcUss;

/**
 * 時刻37_30分電力量
 */
@Column(nullable = true, name = "t37_minu30_elc_uss")
@ApiModelProperty(value = "時刻37_30分電力量", required = false, position = 43)
private BigDecimal t37Minu30ElcUss;

/**
 * 時刻38_30分電力量
 */
@Column(nullable = true, name = "t38_minu30_elc_uss")
@ApiModelProperty(value = "時刻38_30分電力量", required = false, position = 44)
private BigDecimal t38Minu30ElcUss;

/**
 * 時刻39_30分電力量
 */
@Column(nullable = true, name = "t39_minu30_elc_uss")
@ApiModelProperty(value = "時刻39_30分電力量", required = false, position = 45)
private BigDecimal t39Minu30ElcUss;

/**
 * 時刻40_30分電力量
 */
@Column(nullable = true, name = "t40_minu30_elc_uss")
@ApiModelProperty(value = "時刻40_30分電力量", required = false, position = 46)
private BigDecimal t40Minu30ElcUss;

/**
 * 時刻41_30分電力量
 */
@Column(nullable = true, name = "t41_minu30_elc_uss")
@ApiModelProperty(value = "時刻41_30分電力量", required = false, position = 47)
private BigDecimal t41Minu30ElcUss;

/**
 * 時刻42_30分電力量
 */
@Column(nullable = true, name = "t42_minu30_elc_uss")
@ApiModelProperty(value = "時刻42_30分電力量", required = false, position = 48)
private BigDecimal t42Minu30ElcUss;

/**
 * 時刻43_30分電力量
 */
@Column(nullable = true, name = "t43_minu30_elc_uss")
@ApiModelProperty(value = "時刻43_30分電力量", required = false, position = 49)
private BigDecimal t43Minu30ElcUss;

/**
 * 時刻44_30分電力量
 */
@Column(nullable = true, name = "t44_minu30_elc_uss")
@ApiModelProperty(value = "時刻44_30分電力量", required = false, position = 50)
private BigDecimal t44Minu30ElcUss;

/**
 * 時刻45_30分電力量
 */
@Column(nullable = true, name = "t45_minu30_elc_uss")
@ApiModelProperty(value = "時刻45_30分電力量", required = false, position = 51)
private BigDecimal t45Minu30ElcUss;

/**
 * 時刻46_30分電力量
 */
@Column(nullable = true, name = "t46_minu30_elc_uss")
@ApiModelProperty(value = "時刻46_30分電力量", required = false, position = 52)
private BigDecimal t46Minu30ElcUss;

/**
 * 時刻47_30分電力量
 */
@Column(nullable = true, name = "t47_minu30_elc_uss")
@ApiModelProperty(value = "時刻47_30分電力量", required = false, position = 53)
private BigDecimal t47Minu30ElcUss;

/**
 * 時刻48_30分電力量
 */
@Column(nullable = true, name = "t48_minu30_elc_uss")
@ApiModelProperty(value = "時刻48_30分電力量", required = false, position = 54)
private BigDecimal t48Minu30ElcUss;

}