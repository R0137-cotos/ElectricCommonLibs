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
	 * 供給地点特定番号
	 */
	@Column(nullable = false)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("供給地点特定番号")
	private String splyPointIdntBn;

	/**
	 * 料金計算対象年月日
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算対象年月日", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算対象年月日")
	private String feeClcYmd;

	/**
	 * 時刻01_30分電力量
	 */
	@Column(nullable = true, name = "t01_minu30_elc_uss")
	@Schema(description = "時刻01_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻01_30分電力量")
	private BigDecimal t01Minu30ElcUss;

	/**
	 * 時刻02_30分電力量
	 */
	@Column(nullable = true, name = "t02_minu30_elc_uss")
	@Schema(description = "時刻02_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻02_30分電力量")
	private BigDecimal t02Minu30ElcUss;

	/**
	 * 時刻03_30分電力量
	 */
	@Column(nullable = true, name = "t03_minu30_elc_uss")
	@Schema(description = "時刻03_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻03_30分電力量")
	private BigDecimal t03Minu30ElcUss;

	/**
	 * 時刻04_30分電力量
	 */
	@Column(nullable = true, name = "t04_minu30_elc_uss")
	@Schema(description = "時刻04_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻04_30分電力量")
	private BigDecimal t04Minu30ElcUss;

	/**
	 * 時刻05_30分電力量
	 */
	@Column(nullable = true, name = "t05_minu30_elc_uss")
	@Schema(description = "時刻05_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻05_30分電力量")
	private BigDecimal t05Minu30ElcUss;

	/**
	 * 時刻06_30分電力量
	 */
	@Column(nullable = true, name = "t06_minu30_elc_uss")
	@Schema(description = "時刻06_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻06_30分電力量")
	private BigDecimal t06Minu30ElcUss;

	/**
	 * 時刻07_30分電力量
	 */
	@Column(nullable = true, name = "t07_minu30_elc_uss")
	@Schema(description = "時刻07_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻07_30分電力量")
	private BigDecimal t07Minu30ElcUss;

	/**
	 * 時刻08_30分電力量
	 */
	@Column(nullable = true, name = "t08_minu30_elc_uss")
	@Schema(description = "時刻08_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻08_30分電力量")
	private BigDecimal t08Minu30ElcUss;

	/**
	 * 時刻09_30分電力量
	 */
	@Column(nullable = true, name = "t09_minu30_elc_uss")
	@Schema(description = "時刻09_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻09_30分電力量")
	private BigDecimal t09Minu30ElcUss;

	/**
	 * 時刻10_30分電力量
	 */
	@Column(nullable = true, name = "t10_minu30_elc_uss")
	@Schema(description = "時刻10_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻10_30分電力量")
	private BigDecimal t10Minu30ElcUss;

	/**
	 * 時刻11_30分電力量
	 */
	@Column(nullable = true, name = "t11_minu30_elc_uss")
	@Schema(description = "時刻11_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻11_30分電力量")
	private BigDecimal t11Minu30ElcUss;

	/**
	 * 時刻12_30分電力量
	 */
	@Column(nullable = true, name = "t12_minu30_elc_uss")
	@Schema(description = "時刻12_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻12_30分電力量")
	private BigDecimal t12Minu30ElcUss;

	/**
	 * 時刻13_30分電力量
	 */
	@Column(nullable = true, name = "t13_minu30_elc_uss")
	@Schema(description = "時刻13_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻13_30分電力量")
	private BigDecimal t13Minu30ElcUss;

	/**
	 * 時刻14_30分電力量
	 */
	@Column(nullable = true, name = "t14_minu30_elc_uss")
	@Schema(description = "時刻14_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻14_30分電力量")
	private BigDecimal t14Minu30ElcUss;

	/**
	 * 時刻15_30分電力量
	 */
	@Column(nullable = true, name = "t15_minu30_elc_uss")
	@Schema(description = "時刻15_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻15_30分電力量")
	private BigDecimal t15Minu30ElcUss;

	/**
	 * 時刻16_30分電力量
	 */
	@Column(nullable = true, name = "t16_minu30_elc_uss")
	@Schema(description = "時刻16_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻16_30分電力量")
	private BigDecimal t16Minu30ElcUss;

	/**
	 * 時刻17_30分電力量
	 */
	@Column(nullable = true, name = "t17_minu30_elc_uss")
	@Schema(description = "時刻17_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻17_30分電力量")
	private BigDecimal t17Minu30ElcUss;

	/**
	 * 時刻18_30分電力量
	 */
	@Column(nullable = true, name = "t18_minu30_elc_uss")
	@Schema(description = "時刻18_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻18_30分電力量")
	private BigDecimal t18Minu30ElcUss;

	/**
	 * 時刻19_30分電力量
	 */
	@Column(nullable = true, name = "t19_minu30_elc_uss")
	@Schema(description = "時刻19_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻19_30分電力量")
	private BigDecimal t19Minu30ElcUss;

	/**
	 * 時刻20_30分電力量
	 */
	@Column(nullable = true, name = "t20_minu30_elc_uss")
	@Schema(description = "時刻20_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻20_30分電力量")
	private BigDecimal t20Minu30ElcUss;

	/**
	 * 時刻21_30分電力量
	 */
	@Column(nullable = true, name = "t21_minu30_elc_uss")
	@Schema(description = "時刻21_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻21_30分電力量")
	private BigDecimal t21Minu30ElcUss;

	/**
	 * 時刻22_30分電力量
	 */
	@Column(nullable = true, name = "t22_minu30_elc_uss")
	@Schema(description = "時刻22_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻22_30分電力量")
	private BigDecimal t22Minu30ElcUss;

	/**
	 * 時刻23_30分電力量
	 */
	@Column(nullable = true, name = "t23_minu30_elc_uss")
	@Schema(description = "時刻23_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻23_30分電力量")
	private BigDecimal t23Minu30ElcUss;

	/**
	 * 時刻24_30分電力量
	 */
	@Column(nullable = true, name = "t24_minu30_elc_uss")
	@Schema(description = "時刻24_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻24_30分電力量")
	private BigDecimal t24Minu30ElcUss;

	/**
	 * 時刻25_30分電力量
	 */
	@Column(nullable = true, name = "t25_minu30_elc_uss")
	@Schema(description = "時刻25_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻25_30分電力量")
	private BigDecimal t25Minu30ElcUss;

	/**
	 * 時刻26_30分電力量
	 */
	@Column(nullable = true, name = "t26_minu30_elc_uss")
	@Schema(description = "時刻26_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻26_30分電力量")
	private BigDecimal t26Minu30ElcUss;

	/**
	 * 時刻27_30分電力量
	 */
	@Column(nullable = true, name = "t27_minu30_elc_uss")
	@Schema(description = "時刻27_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻27_30分電力量")
	private BigDecimal t27Minu30ElcUss;

	/**
	 * 時刻28_30分電力量
	 */
	@Column(nullable = true, name = "t28_minu30_elc_uss")
	@Schema(description = "時刻28_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻28_30分電力量")
	private BigDecimal t28Minu30ElcUss;

	/**
	 * 時刻29_30分電力量
	 */
	@Column(nullable = true, name = "t29_minu30_elc_uss")
	@Schema(description = "時刻29_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻29_30分電力量")
	private BigDecimal t29Minu30ElcUss;

	/**
	 * 時刻30_30分電力量
	 */
	@Column(nullable = true, name = "t30_minu30_elc_uss")
	@Schema(description = "時刻30_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻30_30分電力量")
	private BigDecimal t30Minu30ElcUss;

	/**
	 * 時刻31_30分電力量
	 */
	@Column(nullable = true, name = "t31_minu30_elc_uss")
	@Schema(description = "時刻31_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻31_30分電力量")
	private BigDecimal t31Minu30ElcUss;

	/**
	 * 時刻32_30分電力量
	 */
	@Column(nullable = true, name = "t32_minu30_elc_uss")
	@Schema(description = "時刻32_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻32_30分電力量")
	private BigDecimal t32Minu30ElcUss;

	/**
	 * 時刻33_30分電力量
	 */
	@Column(nullable = true, name = "t33_minu30_elc_uss")
	@Schema(description = "時刻33_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻33_30分電力量")
	private BigDecimal t33Minu30ElcUss;

	/**
	 * 時刻34_30分電力量
	 */
	@Column(nullable = true, name = "t34_minu30_elc_uss")
	@Schema(description = "時刻34_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻34_30分電力量")
	private BigDecimal t34Minu30ElcUss;

	/**
	 * 時刻35_30分電力量
	 */
	@Column(nullable = true, name = "t35_minu30_elc_uss")
	@Schema(description = "時刻35_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻35_30分電力量")
	private BigDecimal t35Minu30ElcUss;

	/**
	 * 時刻36_30分電力量
	 */
	@Column(nullable = true, name = "t36_minu30_elc_uss")
	@Schema(description = "時刻36_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻36_30分電力量")
	private BigDecimal t36Minu30ElcUss;

	/**
	 * 時刻37_30分電力量
	 */
	@Column(nullable = true, name = "t37_minu30_elc_uss")
	@Schema(description = "時刻37_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻37_30分電力量")
	private BigDecimal t37Minu30ElcUss;

	/**
	 * 時刻38_30分電力量
	 */
	@Column(nullable = true, name = "t38_minu30_elc_uss")
	@Schema(description = "時刻38_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻38_30分電力量")
	private BigDecimal t38Minu30ElcUss;

	/**
	 * 時刻39_30分電力量
	 */
	@Column(nullable = true, name = "t39_minu30_elc_uss")
	@Schema(description = "時刻39_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻39_30分電力量")
	private BigDecimal t39Minu30ElcUss;

	/**
	 * 時刻40_30分電力量
	 */
	@Column(nullable = true, name = "t40_minu30_elc_uss")
	@Schema(description = "時刻40_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻40_30分電力量")
	private BigDecimal t40Minu30ElcUss;

	/**
	 * 時刻41_30分電力量
	 */
	@Column(nullable = true, name = "t41_minu30_elc_uss")
	@Schema(description = "時刻41_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻41_30分電力量")
	private BigDecimal t41Minu30ElcUss;

	/**
	 * 時刻42_30分電力量
	 */
	@Column(nullable = true, name = "t42_minu30_elc_uss")
	@Schema(description = "時刻42_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻42_30分電力量")
	private BigDecimal t42Minu30ElcUss;

	/**
	 * 時刻43_30分電力量
	 */
	@Column(nullable = true, name = "t43_minu30_elc_uss")
	@Schema(description = "時刻43_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻43_30分電力量")
	private BigDecimal t43Minu30ElcUss;

	/**
	 * 時刻44_30分電力量
	 */
	@Column(nullable = true, name = "t44_minu30_elc_uss")
	@Schema(description = "時刻44_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻44_30分電力量")
	private BigDecimal t44Minu30ElcUss;

	/**
	 * 時刻45_30分電力量
	 */
	@Column(nullable = true, name = "t45_minu30_elc_uss")
	@Schema(description = "時刻45_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻45_30分電力量")
	private BigDecimal t45Minu30ElcUss;

	/**
	 * 時刻46_30分電力量
	 */
	@Column(nullable = true, name = "t46_minu30_elc_uss")
	@Schema(description = "時刻46_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻46_30分電力量")
	private BigDecimal t46Minu30ElcUss;

	/**
	 * 時刻47_30分電力量
	 */
	@Column(nullable = true, name = "t47_minu30_elc_uss")
	@Schema(description = "時刻47_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻47_30分電力量")
	private BigDecimal t47Minu30ElcUss;

	/**
	 * 時刻48_30分電力量
	 */
	@Column(nullable = true, name = "t48_minu30_elc_uss")
	@Schema(description = "時刻48_30分電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時刻48_30分電力量")
	private BigDecimal t48Minu30ElcUss;

}