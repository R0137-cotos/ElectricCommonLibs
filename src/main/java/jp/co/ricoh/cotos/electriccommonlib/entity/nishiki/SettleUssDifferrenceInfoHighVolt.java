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
	@Column(nullable = true)
	@ApiModelProperty(value = "料金メニューコード", required = false, position = 7)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;

	/**
	 * 差異発生年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "差異発生年月", required = false, position = 8)
	@JsonProperty("差異発生年月")
	private String diffOcrrYm;

	/**
	 * 契約電力差異
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約電力差異", required = false, position = 9)
	@JsonProperty("契約電力差異")
	private Long diffCtctElc;

	/**
	 * 力率差異
	 */
	@Column(nullable = true)
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

	/**
	 * 処理年月.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "処理年月", required = false, position = 13)
	private String processingDate;

	/**
	 * 確定後_基本電力量.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_基本電力量", required = false, position = 14)
	private BigDecimal confirmPowerRate;

	/**
	 * 確定後_力率.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_力率", required = false, position = 15)
	private BigDecimal confirmBasicPowerAmount;

	/**
	 * 確定後_使用電力量（夏季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_使用電力量（夏季）", required = false, position = 16)
	private BigDecimal confirmAmountSummer;

	/**
	 * 確定後_使用電力量（その他季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_使用電力量（その他季）", required = false, position = 17)
	private BigDecimal confirmAmountOtherSeason;

	/**
	 * 前月_仕入基本料金単価.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_仕入基本料金単価", required = false, position = 18)
	private BigDecimal ultPurchaserBasicPrice;

	/**
	 * 前月_仕入従量単価（夏季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_仕入従量単価（夏季）", required = false, position = 19)
	private BigDecimal ultPurchaserUsagePriceSummer;

	/**
	 * 前月_仕入従量単価（その他季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_仕入従量単価（その他季）", required = false, position = 20)
	private BigDecimal ultPurchaserUsagePriceOtherSeason;

	/**
	 * 前月_仕切基本料金単価.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_仕切基本料金単価", required = false, position = 21)
	private BigDecimal ultPartitionBasicPrice;

	/**
	 * 前月_仕切従量単価（夏季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_仕切従量単価（夏季）", required = false, position = 22)
	private BigDecimal ultPartitionUsagePriceSummer;

	/**
	 * 前月_仕切従量単価（その他季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_仕切従量単価（その他季）", required = false, position = 23)
	private BigDecimal ultPartitionUsagePriceOtherSeason;

	/**
	 * 前月_燃料費調整額単価.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_燃調費調整額単価", required = false, position = 24)
	private BigDecimal ultFuelAdjustmentPrice;

	/**
	 * 前月_再エネ賦課金単価.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_再エネ賦課金単価", required = false, position = 25)
	private BigDecimal ultRenewableLevyPrice;

	/**
	 * 確定後_燃料費調整額.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_燃料費調整額", required = false, position = 26)
	private BigDecimal confirmFuelAdjustmentCost;

	/**
	 * 確定後_再エネ賦課金.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_再エネ賦課金", required = false, position = 27)
	private BigDecimal confirmRenewableLevyCost;

	/**
	 * 確定後_仕入基本料金.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_仕入基本料金", required = false, position = 28)
	private BigDecimal confirmPurchaserBasicCharge;

	/**
	 * 確定後_仕入電力量料金（夏季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_仕入電力量料金（夏季）", required = false, position = 29)
	private BigDecimal confirmPurchaserAmountChargeSummer;

	/**
	 * 確定後_仕入電力量料金（その他季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_仕入電力量料金（その他季）", required = false, position = 30)
	private BigDecimal confirmPurchaserAmountChargeOtherSeason;

	/**
	 * 確定後_仕切基本料金.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_仕切基本料金", required = false, position = 31)
	private BigDecimal confirmPartitionBasicCharge;

	/**
	 * 確定後_仕切電力量料金（夏季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_仕切電力量料金（夏季）", required = false, position = 32)
	private BigDecimal confirmPartitionAmountChargeSummer;

	/**
	 * 確定後_仕切電力量料金（その他季）.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_仕切電力量料金（その他季）", required = false, position = 33)
	private BigDecimal confirmPartitionAmountChargeOtherSeason;

	/**
	 * 仕入前月調整.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入前月調整", required = false, position = 34)
	private BigDecimal purchaserAdjustment;

	/**
	 * 仕切前月調整.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕切前月調整", required = false, position = 35)
	private BigDecimal partitionAdjustment;

	/**
	 * 前月_再エネ賦課金減免率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月_再エネ賦課金減免率", required = false, position = 36)
	private BigDecimal ultReExemptionRate;

	/**
	 * 確定後_再エネ賦課金減免額.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "確定後_再エネ賦課金減免額", required = false, position = 37)
	private BigDecimal confirmReExemptionAmount;

}