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
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算実行番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算実行番号")
	private String feeClcExecBn;

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
	 * 需要家番号
	 */
	@Column(nullable = false)
	@Schema(description = "需要家番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("需要家番号")
	private String cstmrBn;

	/**
	 * 料金メニューコード
	 */
	@Column(nullable = true)
	@Schema(description = "料金メニューコード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;

	/**
	 * 差異発生年月
	 */
	@Column(nullable = true)
	@Schema(description = "差異発生年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("差異発生年月")
	private String diffOcrrYm;

	/**
	 * 契約電力差異
	 */
	@Column(nullable = true)
	@Schema(description = "契約電力差異", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("契約電力差異")
	private Long diffCtctElc;

	/**
	 * 力率差異
	 */
	@Column(nullable = true)
	@Schema(description = "力率差異", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力率差異")
	private Long diffPowp;

	/**
	 * 使用電力量差異（夏季）
	 */
	@Column(nullable = true, name = "diff_minu30_elc_uss_summer")
	@Schema(description = "使用電力量差異（夏季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("使用電力量差異（夏季）")
	private Long diffMinu30ElcUssSummer;

	/**
	 * 使用電力量差異（その他季）
	 */
	@Column(nullable = true, name = "diff_minu30_elc_uss_other")
	@Schema(description = "使用電力量差異（その他季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("使用電力量差異（その他季）")
	private Long diffMinu30ElcUssOther;

	/**
	 * 処理年月.
	 */
	@Column(nullable = true)
	@Schema(description = "処理年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String processingDate;

	/**
	 * 確定後_基本電力量.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_基本電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPowerRate;

	/**
	 * 確定後_力率.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_力率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmBasicPowerAmount;

	/**
	 * 確定後_使用電力量（夏季）.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_使用電力量（夏季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmAmountSummer;

	/**
	 * 確定後_使用電力量（その他季）.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_使用電力量（その他季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmAmountOtherSeason;

	/**
	 * 前月_仕入基本料金単価.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_仕入基本料金単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultPurchaserBasicPrice;

	/**
	 * 前月_仕入従量単価（夏季）.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_仕入従量単価（夏季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultPurchaserUsagePriceSummer;

	/**
	 * 前月_仕入従量単価（その他季）.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_仕入従量単価（その他季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultPurchaserUsagePriceOtherSeason;

	/**
	 * 前月_仕切基本料金単価.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_仕切基本料金単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultPartitionBasicPrice;

	/**
	 * 前月_仕切従量単価（夏季）.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_仕切従量単価（夏季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultPartitionUsagePriceSummer;

	/**
	 * 前月_仕切従量単価（その他季）.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_仕切従量単価（その他季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultPartitionUsagePriceOtherSeason;

	/**
	 * 前月_燃料費調整額単価.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_燃調費調整額単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultFuelAdjustmentPrice;

	/**
	 * 前月_再エネ賦課金単価.
	 */
	@Column(nullable = true)
	@Schema(description = "前月_再エネ賦課金単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultRenewableLevyPrice;

	/**
	 * 確定後_燃料費調整額.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_燃料費調整額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmFuelAdjustmentCost;

	/**
	 * 確定後_再エネ賦課金.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_再エネ賦課金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmRenewableLevyCost;

	/**
	 * 確定後_仕入基本料金.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_仕入基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPurchaserBasicCharge;

	/**
	 * 確定後_仕入電力量料金（夏季）.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_仕入電力量料金（夏季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPurchaserAmountChargeSummer;

	/**
	 * 確定後_仕入電力量料金（その他季）.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_仕入電力量料金（その他季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPurchaserAmountChargeOtherSeason;

	/**
	 * 確定後_仕切基本料金.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_仕切基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPartitionBasicCharge;

	/**
	 * 確定後_仕切電力量料金（夏季）.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_仕切電力量料金（夏季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPartitionAmountChargeSummer;

	/**
	 * 確定後_仕切電力量料金（その他季）.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_仕切電力量料金（その他季）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmPartitionAmountChargeOtherSeason;

	/**
	 * 仕入前月調整.
	 */
	@Column(nullable = true)
	@Schema(description = "仕入前月調整", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserAdjustment;

	/**
	 * 仕切前月調整.
	 */
	@Column(nullable = true)
	@Schema(description = "仕切前月調整", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal partitionAdjustment;

	/**
	 * 前月_再エネ賦課金減免率
	 */
	@Column(nullable = true)
	@Schema(description = "前月_再エネ賦課金減免率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal ultReExemptionRate;

	/**
	 * 確定後_再エネ賦課金減免額.
	 */
	@Column(nullable = true)
	@Schema(description = "確定後_再エネ賦課金減免額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal confirmReExemptionAmount;

}