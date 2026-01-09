package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationHead;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = FeeSimulationHead.class, repository = FeeSimulationHeadRepository.class)
public class FeeSimulationHeadDto extends DtoBase {

	/**
	 * 作成日
	 */
	@Schema(description = "作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	/**
	 * 年間電力料金 - 現状
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "年間電力料金 - 現状", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal annualElectricityRateCurrent;

	/**
	 * 年間電力料金 - 変更後
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "年間電力料金 - 変更後", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal annualElectricityRateAfter;

	/**
	 * 削減額
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "削減額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal reductionAmount;

	/**
	 * 削減率（％）
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "削減率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal reductionRate;

	/**
	 * 総合単価１
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "総合単価１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal overallPrice1;

	/**
	 * 総合単価２
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "総合単価２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal overallPrice2;

	/**
	 * 総合単価３
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "総合単価３", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal overallPrice3;

	/**
	 * 負荷率（％）
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "負荷率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本料金_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateSellingPrice;

	/**
	 * 基本料金_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateBankPriceBusiness;

	/**
	 * 基本料金_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateBankPriceRj;

	/**
	 * 従量料金_夏季_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金_夏季_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceBusiness;

	/**
	 * 従量料金_夏季_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerBankPriceRj;

	/**
	 * 従量料金_その他季_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 従量料金_その他季_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceBusiness;

	/**
	 * 従量料金_その他季_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonBankPriceRj;

	/**
	 * オプション_予備線_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLineSellingPrice;

	/**
	 * オプション_予備線_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLineBankPriceBusiness;

	/**
	 * オプション_予備線_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLineBankPriceRj;

	/**
	 * オプション_予備電源_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備電源_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerSellingPrice;

	/**
	 * オプション_予備電源_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備電源_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerBankPriceBusiness;

	/**
	 * オプション_予備電源_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備電源_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerBankPriceRj;

	/**
	 * オプション_アンシラリー_売価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillarySellingPrice;

	/**
	 * オプション_アンシラリー_仕切価格（営業）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー_仕切価格（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillaryBankPriceBusiness;

	/**
	 * オプション_アンシラリー_仕切価格（ＲＪ）
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー_仕切価格（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillaryBankPriceRj;

	/**
	 * 媒介手数料 定額（円：税込）
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "媒介手数料　定額（円：税込）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal feeFixedAmountInTax;

	/**
	 * 媒介手数料 定率（％）
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "媒介手数料　定率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal feeFixedRate;

	/**
	 * 電力料金（営業）
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "電力料金（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal electricityChargeBusiness;

	/**
	 * 粗利額（営業）
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "粗利額（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal grossMarginBusiness;

	/**
	 * 粗利率（％）（営業）
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "粗利率（％）（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal grossProfitMarginBusiness;

	/**
	 * 電力料金（ＲＪ）
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "電力料金（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal electricityChargeRj;

	/**
	 * 粗利額（ＲＪ）
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "粗利額（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal grossMarginRj;

	/**
	 * 粗利率（％）（ＲＪ）
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "粗利率（％）（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal grossProfitMarginRj;

	/**
	 * 定価
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicRateListPrice;

	/**
	 * SIM番号(主)
	 */
	@Size(max = 255)
	@Schema(description = "SIM番号(主)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Size(max = 255)
	@Schema(description = "SIM番号(従)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * 取次手数料額
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次手数料額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal agencyFeeAmount;

	/**
	 * 取次手数料率（％）
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次手数料率（％）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 取次割引率
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次割引率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal agencyDiscountRate;

	/**
	 * 取次割引単価
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次割引単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal agencyDiscountPrice;

	/**
	 * 長期割引率
	 */
	@DecimalMin("-999.99")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "長期割引率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-999.99,999.99]")
	private BigDecimal longtermDiscountRate;

	/**
	 * 長期割引単価
	 */
	@DecimalMin("-99999999999999999.99")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "長期割引単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	private BigDecimal longtermDiscountPrice;
}
