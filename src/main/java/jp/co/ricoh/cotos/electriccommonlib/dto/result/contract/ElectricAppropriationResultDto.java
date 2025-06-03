package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
public class ElectricAppropriationResultDto {

	@Id
	@JsonIgnore
	@ApiModelProperty(value = "連番", required = true, position = 1)
	private long seqNo;

	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID", required = true, position = 2)
	private long id;

	/**
	 * 登録日時
	 */
	@ApiModelProperty(value = "登録日時", required = false, position = 3)
	private Date createdAt;

	/**
	 * 登録者
	 */
	@ApiModelProperty(value = "登録者", required = false, position = 4, allowableValues = "range[0,255]")
	private String createdUserId;

	/**
	 * 更新日時
	 */
	@ApiModelProperty(value = "更新日時", required = false, position = 5)
	private Date updatedAt;

	/**
	 * 更新者
	 */
	@ApiModelProperty(value = "更新者", required = false, position = 6, allowableValues = "range[0,255]")
	private String updatedUserId;

	/**
	 * version
	 */
	@ApiModelProperty(value = "version", required = false, position = 7, allowableValues = "range[0,9223372036854775807]")
	private long version;

	/**
	 * 契約（電力）ID
	 */
	@ApiModelProperty(value = "ID", required = false, position = 8, allowableValues = "range[0,9223372036854775807]")
	private long contractElectricId;

	/**
	 * 請求基本情報ID
	 */
	@ApiModelProperty(value = "請求基本情報ID", required = false, position = 9)
	private long billingBasicInformationId;

	/**
	 * 請求年月
	 */
	@ApiModelProperty(value = "請求年月", required = false, position = 10, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * お客様識別番号
	 */
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 11, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 料金計算実行番号
	 */
	@ApiModelProperty(value = "料金計算実行番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String calcExecNumber;

	/**
	 * NISHIKI契約番号
	 */
	@ApiModelProperty(value = "NISHIKI契約番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 販社コード
	 */
	@ApiModelProperty(value = "販社コード", required = false, position = 14, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 所轄課所コード
	 */
	@ApiModelProperty(value = "所轄課所コード", required = false, position = 15, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 仕入取引先コード
	 */
	@ApiModelProperty(value = "仕入取引先コード", required = false, position = 16, allowableValues = "range[0,255]")
	private String purchaserCode;

	/**
	 * リコー品種コード
	 */
	@ApiModelProperty(value = "リコー品種コード", required = false, position = 17, allowableValues = "range[0,255]")
	private String ricohItemCode;

	/**
	 * リコー電力商品名
	 */
	@ApiModelProperty(value = "リコー電力商品名", required = false, position = 18, allowableValues = "range[0,255]")
	private String ricohElectricItemName;

	/**
	 * 電力販売店会社ID
	 */
	@ApiModelProperty(value = "電力販売店会社ID", required = false, position = 19, allowableValues = "range[0,255]")
	private String electricTradingCompanyId;

	/**
	 * 売上仕入計上日時
	 */
	@ApiModelProperty(value = "売上仕入計上日時", required = false, position = 20)
	@Temporal(TemporalType.DATE)
	private Date purchaserAppropriationDay;

	/**
	 * 振替計上日時
	 */
	@ApiModelProperty(value = "振替計上日時", required = false, position = 21)
	@Temporal(TemporalType.DATE)
	private Date transferAppropriationDay;

	/**
	 * 手数料計上日時
	 */
	@ApiModelProperty(value = "手数料計上日時", required = false, position = 22)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 高圧請求計上日時
	 */
	@ApiModelProperty(value = "高圧請求計上日時", required = false, position = 23)
	@Temporal(TemporalType.DATE)
	private Date highClaimAppropriationDay;

	/**
	 * 売上金額(税込)
	 */
	@ApiModelProperty(value = "売上金額(税込)", required = false, position = 24, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal proceedsInTax;

	/**
	 * 売上消費税額
	 */
	@ApiModelProperty(value = "売上消費税額", required = false, position = 25, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal proceedsTax;

	/**
	 * 売上金額(税抜)
	 */
	@ApiModelProperty(value = "売上金額(税抜)", required = false, position = 26, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal proceedsOutTax;

	/**
	 * 力率
	 */
	@ApiModelProperty(value = "力率", required = false, position = 27, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**
	 * 基本電力量
	 */
	@ApiModelProperty(value = "基本電力量", required = false, position = 28, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal basicPowerAmount;

	/**
	 * 月間合計電力量(夏季)
	 */
	@ApiModelProperty(value = "月間合計電力量(夏季)", required = false, position = 29, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal monthlyTotalpowerAmountSummer;

	/**
	 * 月間合計電力量(その他季)
	 */
	@ApiModelProperty(value = "月間合計電力量(その他季)", required = false, position = 30, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal monthlyTotalpowerAmountOtherSeason;

	/**
	 * 月間合計電力量(共通)
	 */
	@ApiModelProperty(value = "月間合計電力量(共通)", required = false, position = 31, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal monthlyTotalpowerAmountCommon;

	/**
	 * 仕入基本単価
	 */
	@ApiModelProperty(value = "仕入基本単価", required = false, position = 32, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserBasicPrice;

	/**
	 * 仕入従量単価(夏季)
	 */
	@ApiModelProperty(value = "仕入従量単価(夏季)", required = false, position = 33, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserUsagePriceSummer;

	/**
	 * 仕入従量単価(その他季)
	 */
	@ApiModelProperty(value = "仕入従量単価(その他季)", required = false, position = 34, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserUsagePriceOtherSeason;

	/**
	 * 仕入従量単価(共通)
	 */
	@ApiModelProperty(value = "仕入従量単価(共通)", required = false, position = 35, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserUsagePriceCommon;

	/**
	 * 仕切基本単価
	 */
	@ApiModelProperty(value = "仕切基本単価)", required = false, position = 36, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionBasicPrice;

	/**
	 * 仕切従量単価(夏季)
	 */
	@ApiModelProperty(value = "仕切従量単価(夏季))", required = false, position = 37, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionUsagePriceSummer;

	/**
	 * 仕切従量単価(その他季)
	 */
	@ApiModelProperty(value = "仕切従量単価(その他季))", required = false, position = 38, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionUsagePriceOtherSeason;

	/**
	 * 仕切従量単価(共通)
	 */
	@ApiModelProperty(value = "仕切従量単価(共通))", required = false, position = 39, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionUsagePriceCommon;

	/**
	 * 仕入基本料金
	 */
	@ApiModelProperty(value = "仕入基本料金", required = false, position = 40, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserBasicCharge;

	/**
	 * 仕入電力量料金(夏季)
	 */
	@ApiModelProperty(value = "仕入電力量料金(夏季)", required = false, position = 41, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeSummer;

	/**
	 * 仕入電力量料金(その他季)
	 */
	@ApiModelProperty(value = "仕入電力量料金(その他季)", required = false, position = 42, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeOtherSeason;

	/**
	 * 仕入電力量料金(共通)
	 */
	@ApiModelProperty(value = "仕入電力量料金(共通)", required = false, position = 43, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeCommon;

	/**
	 * 仕入合計料金(税込)
	 */
	@ApiModelProperty(value = "仕入合計料金(税込)", required = false, position = 44, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserTotalChargeInTax;

	/**
	 * 仕入消費税額
	 */
	@ApiModelProperty(value = "仕入消費税額", required = false, position = 45, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserTax;

	/**
	 * 仕入合計料金(税抜)
	 */
	@ApiModelProperty(value = "仕入合計料金(税抜)", required = false, position = 46, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserTotalChargeOutTax;

	/**
	 * 仕切基本料金
	 */
	@ApiModelProperty(value = "仕切基本料金", required = false, position = 47, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionBasicCharge;

	/**
	 * 仕切電力両料金(夏季)
	 */
	@ApiModelProperty(value = "仕切電力両料金(夏季)", required = false, position = 48, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeSummer;

	/**
	 * 仕切電力両料金(その他季)
	 */
	@ApiModelProperty(value = "仕切電力両料金(その他季)", required = false, position = 49, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeOtherSeason;

	/**
	 * 仕切電力両料金(共通)
	 */
	@ApiModelProperty(value = "仕切電力両料金(共通)", required = false, position = 50, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeCommon;

	/**
	 * 仕切合計料金(税込)
	 */
	@ApiModelProperty(value = "仕切合計料金(税込)", required = false, position = 51, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionTotalChargeInTax;

	/**
	 * 仕切消費税額
	 */
	@ApiModelProperty(value = "仕切消費税額", required = false, position = 52, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionTax;

	/**
	 * 仕切合計料金(税抜)
	 */
	@ApiModelProperty(value = "仕切合計料金(税抜)", required = false, position = 53, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionTotalChargeOutTax;

	/**
	 * RJ粗利金額
	 */
	@ApiModelProperty(value = "RJ粗利金額", required = false, position = 54, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal rjGrossProfit;

	/**
	 * 営業区粗利金額
	 */
	@ApiModelProperty(value = "営業区粗利金額", required = false, position = 55, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal salesSectionGrossProfit;

	/**
	 * 本部粗利金額
	 */
	@ApiModelProperty(value = "本部粗利金額", required = false, position = 56, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal headofficeGrossProfit;

	/**
	 * 売上課所コード
	 */
	@ApiModelProperty(value = "売上課所コード", required = false, position = 57, allowableValues = "range[0,255]")
	private String proceedsOfficeCode;

	/**
	 * 営業区粗利分配先販社コード
	 */
	@ApiModelProperty(value = "営業区粗利分配先販社コード", required = false, position = 58, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareTradingConpanyCode;

	/**
	 * 営業区粗利分配先課所コード
	 */
	@ApiModelProperty(value = "営業区粗利分配先販社コード", required = false, position = 59, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareOfficeCode;

	/**
	 * 営業区粗利分配先社員コード
	 */
	@ApiModelProperty(value = "営業区粗利分配先販社コード", required = false, position = 60, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareEmployeeCode;

	/**
	 * 想定年間電力料金
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "想定年間電力料金", required = false, position = 61, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal assumptionYearlyPowerCharge;

	/**
	 * 販売店手数料定率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "販売店手数料定率", required = false, position = 62, allowableValues = "range[0.00,99999.99]")
	private BigDecimal tradingCompanyFeeFixedRate;

	/**
	 * 販売店手数料定額(税込)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "販売店手数料定額(税込)", required = false, position = 63, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal tradingCompanyFeeFixedAmountInTax;

	/**
	 * 販売店仲介手数料額(税込)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "販売店仲介手数料額(税込)", required = false, position = 64, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal tradingCompanyMediationFeeAmountInTax;

	/**
	 * 支払通知書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "支払通知書出力フラグ", required = false, position = 65, allowableValues = "range[0,9]")
	private Integer paymentOutputFlg;

	/**
	 * 料金計算対象年月
	 */
	@ApiModelProperty(value = "料金計算対象年月", required = false, position = 66, allowableValues = "range[0,255]")
	private String calcDate;

	/**
	 * No.
	 */
	@Max(99999)
	@ApiModelProperty(value = "No.", required = false, position = 67, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 供給地点特定番号
	 */
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 68, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 企業・事業所
	 */
	@ApiModelProperty(value = "企業・事業所", required = false, position = 69, allowableValues = "range[0,255]")
	private String companyAndOffice;

	/**
	 * 契約者・需要場所
	 */
	@ApiModelProperty(value = "契約者・需要場所", required = false, position = 70, allowableValues = "range[0,255]")
	private String customerAndDemandPlace;

	/**
	 * 供給年月
	 */
	@ApiModelProperty(value = "供給年月", required = false, position = 71, allowableValues = "range[0,255]")
	private String supplyYearMonth;

	/**
	 * 使用電力従量kWh
	 */
	@ApiModelProperty(value = "使用電力従量kWh", required = false, position = 72, allowableValues = "range[0,255]")
	private String electricPowerConsumptionUsageFee;

	@PrePersist
	public void prePersist() {
		throw new IllegalAccessError();
	}

}
