package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import java.math.BigDecimal;
import java.util.Date;

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
 * 料金シミュレーション（本部用）
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "fee_simulation_head")
public class FeeSimulationHead extends EntityBase {

/**
 * ID
 */
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_simulation_head_seq")
@SequenceGenerator(name = "fee_simulation_head_seq", sequenceName = "fee_simulation_head_seq", allocationSize = 1)
@ApiModelProperty(value = "ID", required = true, position = 1)
private long id;

/**
 * 見積（電力）ID
 */
@OneToOne(optional = false)
@JoinColumn(name = "estimationElectricId", referencedColumnName = "id")
@JsonIgnore
private EstimationElectric estimationElectric;

/**
 * SIM番号
 */
@Column(nullable = true)
@ApiModelProperty(value = "SIM番号", required = false, position = 2, allowableValues = "range[0,]")
private String simNumber;

/**
 * 作成日
 */
@Column(nullable = true)
@ApiModelProperty(value = "作成日", required = false, position = 3)
private Date createdDate;

/**
 * 年間電力料金 - 現状
 */
@Column(nullable = true)
@ApiModelProperty(value = "年間電力料金 - 現状", required = false, position = 4)
private BigDecimal annualElectricityRateCurrent;

/**
 * 年間電力料金 - 変更後
 */
@Column(nullable = true)
@ApiModelProperty(value = "年間電力料金 - 変更後", required = false, position = 5)
private BigDecimal annualElectricityRateAfter;

/**
 * 削減額
 */
@Column(nullable = true)
@ApiModelProperty(value = "削減額", required = false, position = 6)
private BigDecimal reductionAmount;

/**
 * 削減率（％）
 */
@Column(nullable = true)
@ApiModelProperty(value = "削減率（％）", required = false, position = 7)
private BigDecimal reductionRate;

/**
 * 総合単価１
 */
@Column(nullable = true)
@ApiModelProperty(value = "総合単価１", required = false, position = 8)
private BigDecimal overallPrice1;

/**
 * 総合単価２
 */
@Column(nullable = true)
@ApiModelProperty(value = "総合単価２", required = false, position = 9)
private BigDecimal overallPrice2;

/**
 * 総合単価３
 */
@Column(nullable = true)
@ApiModelProperty(value = "総合単価３", required = false, position = 10)
private BigDecimal overallPrice3;

/**
 * 負荷率（％）
 */
@Column(nullable = true)
@ApiModelProperty(value = "負荷率（％）", required = false, position = 11)
private BigDecimal loadFactor;

/**
 * 基本料金_売価
 */
@Column(nullable = true)
@ApiModelProperty(value = "基本料金_売価", required = false, position = 12)
private BigDecimal basicRateSellingPrice;

/**
 * 基本料金_仕切価格（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "基本料金_仕切価格（営業）", required = false, position = 13)
private BigDecimal basicRateBankPriceBusiness;

/**
 * 基本料金_仕切価格（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "基本料金_仕切価格（ＲＪ）", required = false, position = 14)
private BigDecimal basicRateBankPriceRj;

/**
 * 従量料金_夏季_売価
 */
@Column(nullable = true)
@ApiModelProperty(value = "従量料金_夏季_売価", required = false, position = 15)
private BigDecimal usageFeeSummerSellingPrice;

/**
 * 従量料金_夏季_仕切価格（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "従量料金_夏季_仕切価格（営業）", required = false, position = 16)
private BigDecimal usageFeeSummerBankPriceBusiness;

/**
 * 従量料金_夏季_仕切価格（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "従量料金_夏季_仕切価格（ＲＪ）", required = false, position = 17)
private BigDecimal usageFeeSummerBankPriceRj;

/**
 * 従量料金_その他季_売価
 */
@Column(nullable = true)
@ApiModelProperty(value = "従量料金_その他季_売価", required = false, position = 18)
private BigDecimal usageFeeOtherSeasonSellingPrice;

/**
 * 従量料金_その他季_仕切価格（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "従量料金_その他季_仕切価格（営業）", required = false, position = 19)
private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

/**
 * 従量料金_その他季_仕切価格（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "従量料金_その他季_仕切価格（ＲＪ）", required = false, position = 20)
private BigDecimal usageFeeOtherSeasonBankPriceRj;

/**
 * オプション_予備線_売価
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_予備線_売価", required = false, position = 21)
private BigDecimal spareLineSellingPrice;

/**
 * オプション_予備線_仕切価格（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_予備線_仕切価格（営業）", required = false, position = 22)
private BigDecimal spareLineBankPriceBusiness;

/**
 * オプション_予備線_仕切価格（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_予備線_仕切価格（ＲＪ）", required = false, position = 23)
private BigDecimal spareLineBankPriceRj;

/**
 * オプション_予備電源_売価
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_予備電源_売価", required = false, position = 24)
private BigDecimal sparePowerSellingPrice;

/**
 * オプション_予備電源_仕切価格（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_予備電源_仕切価格（営業）", required = false, position = 25)
private BigDecimal sparePowerBankPriceBusiness;

/**
 * オプション_予備電源_仕切価格（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_予備電源_仕切価格（ＲＪ）", required = false, position = 26)
private BigDecimal sparePowerBankPriceRj;

/**
 * オプション_アンシラリー_売価
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_アンシラリー_売価", required = false, position = 27)
private BigDecimal ancillarySellingPrice;

/**
 * オプション_アンシラリー_仕切価格（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_アンシラリー_仕切価格（営業）", required = false, position = 28)
private BigDecimal ancillaryBankPriceBusiness;

/**
 * オプション_アンシラリー_仕切価格（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "オプション_アンシラリー_仕切価格（ＲＪ）", required = false, position = 29)
private BigDecimal ancillaryBankPriceRj;

/**
 * 媒介手数料　定額（円：税込）
 */
@Column(nullable = true)
@ApiModelProperty(value = "媒介手数料　定額（円：税込）", required = false, position = 30)
private BigDecimal feeFixedAmountInTax;

/**
 * 媒介手数料　定率（％）
 */
@Column(nullable = true)
@ApiModelProperty(value = "媒介手数料　定率（％）", required = false, position = 31)
private BigDecimal feeFixedRate;

/**
 * 電力料金（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "電力料金（営業）", required = false, position = 32)
private BigDecimal electricityChargeBusiness;

/**
 * 粗利額（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "粗利額（営業）", required = false, position = 33)
private BigDecimal grossMarginBusiness;

/**
 * 粗利率（％）（営業）
 */
@Column(nullable = true)
@ApiModelProperty(value = "粗利率（％）（営業）", required = false, position = 34)
private BigDecimal grossProfitMarginBusiness;

/**
 * 電力料金（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "電力料金（ＲＪ）", required = false, position = 35)
private BigDecimal electricityChargeRj;

/**
 * 粗利額（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "粗利額（ＲＪ）", required = false, position = 36)
private BigDecimal grossMarginRj;

/**
 * 粗利率（％）（ＲＪ）
 */
@Column(nullable = true)
@ApiModelProperty(value = "粗利率（％）（ＲＪ）", required = false, position = 37)
private BigDecimal grossProfitMarginRj;

}

