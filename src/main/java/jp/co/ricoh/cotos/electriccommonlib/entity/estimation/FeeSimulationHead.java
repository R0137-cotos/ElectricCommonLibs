package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 料金シミュレーション（本部用）
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "fee_simulation_head")
@CotosComplementTarget(entity = FeeSimulationHead.class, repository = FeeSimulationHeadRepository.class)
public class FeeSimulationHead extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_simulation_head_seq")
	@SequenceGenerator(name = "fee_simulation_head_seq", sequenceName = "fee_simulation_head_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 見積（電力）ID
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "estimationElectricId", referencedColumnName = "id")
	@Schema(description = "見積（電力）ID", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private EstimationElectric estimationElectric;

	/**
	 * 作成日
	 */
	@Column(nullable = true)
	@Schema(description = "作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date createdDate;

	/**
	 * 年間電力料金 - 現状
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "年間電力料金 - 現状", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal annualElectricityRateCurrent;

	/**
	 * 年間電力料金 - 変更後
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "年間電力料金 - 変更後", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal annualElectricityRateAfter;

	/**
	 * 削減額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "削減額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal reductionAmount;

	/**
	 * 削減率（％）
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "削減率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal reductionRate;

	/**
	 * 総合単価１
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "総合単価１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal overallPrice1;

	/**
	 * 総合単価２
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "総合単価２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal overallPrice2;

	/**
	 * 総合単価３
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "総合単価３", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal overallPrice3;

	/**
	 * 負荷率（％）
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "負荷率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal loadFactor;

	/**
	 * 基本料金_売価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateSellingPrice;

	/**
	 * 基本料金_仕切価格（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateBankPriceBusiness;

	/**
	 * 基本料金_仕切価格（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateBankPriceRj;

	/**
	 * 従量料金_夏季_売価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金_夏季_仕切価格（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceBusiness;

	/**
	 * 従量料金_夏季_仕切価格（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceRj;

	/**
	 * 従量料金_その他季_売価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 従量料金_その他季_仕切価格（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

	/**
	 * 従量料金_その他季_仕切価格（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceRj;

	/**
	 * オプション_予備線_売価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLineSellingPrice;

	/**
	 * オプション_予備線_仕切価格（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLineBankPriceBusiness;

	/**
	 * オプション_予備線_仕切価格（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLineBankPriceRj;

	/**
	 * オプション_予備電源_売価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備電源_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerSellingPrice;

	/**
	 * オプション_予備電源_仕切価格（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備電源_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerBankPriceBusiness;

	/**
	 * オプション_予備電源_仕切価格（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備電源_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerBankPriceRj;

	/**
	 * オプション_アンシラリー_売価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillarySellingPrice;

	/**
	 * オプション_アンシラリー_仕切価格（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillaryBankPriceBusiness;

	/**
	 * オプション_アンシラリー_仕切価格（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillaryBankPriceRj;

	/**
	 * 媒介手数料 定額（円：税込）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "媒介手数料　定額（円：税込）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal feeFixedAmountInTax;

	/**
	 * 媒介手数料 定率（％）
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "媒介手数料　定率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal feeFixedRate;

	/**
	 * 電力料金（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "電力料金（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal electricityChargeBusiness;

	/**
	 * 粗利額（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "粗利額（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal grossMarginBusiness;

	/**
	 * 粗利率（％）（営業）
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "粗利率（％）（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal grossProfitMarginBusiness;

	/**
	 * 電力料金（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "電力料金（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal electricityChargeRj;

	/**
	 * 粗利額（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "粗利額（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal grossMarginRj;

	/**
	 * 粗利率（％）（ＲＪ）
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "粗利率（％）（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal grossProfitMarginRj;

	/**
	 * 定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateListPrice;

	/**
	 * SIM番号(主)
	 */
	@Column(nullable = true)
	@Schema(description = "SIM番号(主)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Column(nullable = true)
	@Schema(description = "SIM番号(従)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * 取次手数料額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次手数料額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyFeeAmount;

	/**
	 * 取次手数料率（％）
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次手数料率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyFeeRate;

	/**
	 * 取次割引率
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次割引率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyDiscountRate;

	/**
	 * 取次割引単価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次割引単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyDiscountPrice;

	/**
	 * 長期割引率
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "長期割引率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal longtermDiscountRate;

	/**
	 * 長期割引単価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "長期割引単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal longtermDiscountPrice;

}
