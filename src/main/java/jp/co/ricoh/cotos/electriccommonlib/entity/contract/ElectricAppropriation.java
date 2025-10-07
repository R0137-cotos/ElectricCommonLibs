package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricAppropriationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 計上実績を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_appropriation")
@CotosComplementTarget(entity = ElectricAppropriation.class, repository = ElectricAppropriationRepository.class)
public class ElectricAppropriation extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_appropriation_seq")
	@SequenceGenerator(name = "electric_appropriation_seq", sequenceName = "electric_appropriation_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ID", required = true, position = 2, allowableValues = "range[0,9223372036854775807]")
	private long contractElectricId;

	/**
	 * 請求基本情報
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "billing_basic_information_id", referencedColumnName = "id")
	@ApiModelProperty(value = "請求基本情報", required = true, position = 3)
	@JsonIgnore
	private BillingBasicInformation billingBasicInformation;

	/**
	 * 請求年月
	 */
	@Column(nullable = false)
	@JoinColumn(name = "billing_year_month")
	@ApiModelProperty(value = "請求年月", required = true, position = 4, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * お客様識別番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "お客様識別番号", required = true, position = 5, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算実行番号", required = true, position = 6, allowableValues = "range[0,255]")
	private String calcExecNumber;

	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "NISHIKI契約番号", required = true, position = 7, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 販社コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "販社コード", required = true, position = 8, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 所轄課所コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "所轄課所コード", required = true, position = 9, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 仕入取引先コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "仕入取引先コード", required = true, position = 10, allowableValues = "range[0,255]")
	private String purchaserCode;

	/**
	 * リコー品種コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "リコー品種コード", required = true, position = 11, allowableValues = "range[0,255]")
	private String ricohItemCode;

	/**
	 * リコー電力商品名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "リコー電力商品名", required = true, position = 12, allowableValues = "range[0,255]")
	private String ricohElectricItemName;

	/**
	 * 電力販売店会社ID
	 */
	@Column(nullable = true)
	@JoinColumn(name = "electric_trading_company_id")
	@ApiModelProperty(value = "電力販売店会社ID", required = false, position = 13, allowableValues = "range[0,255]")
	private String electricTradingCompanyId;

	/**
	 * 売上仕入計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上仕入計上日時", required = false, position = 14)
	@Temporal(TemporalType.DATE)
	private Date purchaserAppropriationDay;

	/**
	 * 振替計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "振替計上日時", required = false, position = 15)
	@Temporal(TemporalType.DATE)
	private Date transferAppropriationDay;

	/**
	 * 手数料計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手数料計上日時", required = false, position = 16)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 高圧請求計上日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "高圧請求計上日時", required = false, position = 17)
	@Temporal(TemporalType.DATE)
	private Date highClaimAppropriationDay;

	/**
	 * 売上金額(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "売上金額(税込)", required = false, position = 18)
	private BigDecimal proceedsInTax;

	/**
	 * 売上消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "売上消費税額", required = false, position = 19)
	private BigDecimal proceedsTax;

	/**
	 * 売上金額(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "売上金額(税抜)", required = false, position = 20)
	private BigDecimal proceedsOutTax;

	/**
	 * 力率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "力率", required = false, position = 21, allowableValues = "range[0.00,999.99]")
	private BigDecimal powerRate;

	/**
	 * 基本電力量
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@ApiModelProperty(value = "基本電力量", required = false, position = 22, allowableValues = "range[0.00,999999.99]")
	private BigDecimal basicPowerAmount;

	/**
	 * 月間合計電力量(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@ApiModelProperty(value = "月間合計電力量(夏季)", required = false, position = 23, allowableValues = "range[0.00,999999.99]")
	private BigDecimal monthlyTotalpowerAmountSummer;

	/**
	 * 月間合計電力量(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@ApiModelProperty(value = "月間合計電力量(その他季)", required = false, position = 24, allowableValues = "range[0.00,999999.99]")
	private BigDecimal monthlyTotalpowerAmountOtherSeason;

	/**
	 * 月間合計電力量(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@ApiModelProperty(value = "月間合計電力量(共通)", required = false, position = 25, allowableValues = "range[0.00,999999.99]")
	private BigDecimal monthlyTotalpowerAmountCommon;

	/**
	 * 仕入基本単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入基本単価", required = false, position = 26, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserBasicPrice;

	/**
	 * 仕入従量単価(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入従量単価(夏季)", required = false, position = 27, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserUsagePriceSummer;

	/**
	 * 仕入従量単価(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入従量単価(その他季)", required = false, position = 28, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserUsagePriceOtherSeason;

	/**
	 * 仕入従量単価(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入従量単価(共通)", required = false, position = 29, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserUsagePriceCommon;

	/**
	 * 仕切基本単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切基本単価)", required = false, position = 30, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionBasicPrice;

	/**
	 * 仕切従量単価(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切従量単価(夏季))", required = false, position = 31, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionUsagePriceSummer;

	/**
	 * 仕切従量単価(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切従量単価(その他季))", required = false, position = 32, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionUsagePriceOtherSeason;

	/**
	 * 仕切従量単価(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切従量単価(共通))", required = false, position = 33, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionUsagePriceCommon;

	/**
	 * 仕入基本料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入基本料金", required = false, position = 34, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserBasicCharge;

	/**
	 * 仕入電力量料金(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入電力量料金(夏季)", required = false, position = 35, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeSummer;

	/**
	 * 仕入電力量料金(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入電力量料金(その他季)", required = false, position = 36, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeOtherSeason;

	/**
	 * 仕入電力量料金(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入電力量料金(共通)", required = false, position = 37, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeCommon;

	/**
	 * 仕入合計料金(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入合計料金(税込)", required = false, position = 38)
	private BigDecimal purchaserTotalChargeInTax;

	/**
	 * 仕入消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入消費税額", required = false, position = 39)
	private BigDecimal purchaserTax;

	/**
	 * 仕入合計料金(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入合計料金(税抜)", required = false, position = 40)
	private BigDecimal purchaserTotalChargeOutTax;

	/**
	 * 仕切基本料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切基本料金", required = false, position = 41, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionBasicCharge;

	/**
	 * 仕切電力量料金(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切電力量料金(夏季)", required = false, position = 42, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeSummer;

	/**
	 * 仕切電力量料金(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切電力量料金(その他季)", required = false, position = 43, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeOtherSeason;

	/**
	 * 仕切電力量料金(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切電力量料金(共通)", required = false, position = 44, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeCommon;

	/**
	 * 仕切合計料金(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切合計料金(税込)", required = false, position = 45, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionTotalChargeInTax;

	/**
	 * 仕切消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切消費税額", required = false, position = 46, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionTax;

	/**
	 * 仕切合計料金(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切合計料金(税抜)", required = false, position = 47, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionTotalChargeOutTax;

	/**
	 * RJ粗利金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "RJ粗利金額", required = false, position = 48)
	private BigDecimal rjGrossProfit;

	/**
	 * 営業区粗利金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "営業区粗利金額", required = false, position = 49)
	private BigDecimal salesSectionGrossProfit;

	/**
	 * 本部粗利金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "本部粗利金額", required = false, position = 50)
	private BigDecimal headofficeGrossProfit;

	/**
	 * 売上課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上課所コード", required = false, position = 51, allowableValues = "range[0,255]")
	private String proceedsOfficeCode;

	/**
	 * 営業区粗利分配先販社コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "営業区粗利分配先販社コード", required = false, position = 52, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareTradingConpanyCode;

	/**
	 * 営業区粗利分配先課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "営業区粗利分配先販社コード", required = false, position = 53, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareOfficeCode;

	/**
	 * 営業区粗利分配先社員コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "営業区粗利分配先販社コード", required = false, position = 54, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareEmployeeCode;

	/**
	 * 想定年間電力料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "想定年間電力料金", required = false, position = 55, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal assumptionYearlyPowerCharge;

	/**
	 * 販売店手数料定率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "販売店手数料定率", required = false, position = 56, allowableValues = "range[0.00,999.99]")
	private BigDecimal tradingCompanyFeeFixedRate;

	/**
	 * 販売店手数料定額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "販売店手数料定額(税込)", required = false, position = 57, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal tradingCompanyFeeFixedAmountInTax;

	/**
	 * 販売店仲介手数料額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "販売店仲介手数料額(税込)", required = false, position = 58, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal tradingCompanyMediationFeeAmountInTax;

	/**
	 * 支払通知書出力フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "支払通知書出力フラグ", required = false, position = 59, allowableValues = "range[0,9]")
	private Integer paymentOutputFlg;

	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算対象年月", required = false, position = 60, allowableValues = "range[0,255]")
	private String calcDate;

	/**
	 * No.
	 */
	@Column(nullable = true)
	@Max(99999)
	@ApiModelProperty(value = "No.", required = false, position = 61, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 62, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 企業・事業所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企業・事業所", required = false, position = 63, allowableValues = "range[0,255]")
	private String companyAndOffice;

	/**
	 * 契約者・需要場所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約者・需要場所", required = false, position = 64, allowableValues = "range[0,255]")
	private String customerAndDemandPlace;

	/**
	 * 供給年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給年月", required = false, position = 65, allowableValues = "range[0,255]")
	private String supplyYearMonth;

	/**
	 * 使用電力従量kWh
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "使用電力従量kWh", required = false, position = 66, allowableValues = "range[0,255]")
	private String electricPowerConsumptionUsageFee;

	/**
	 * 請求データ作成年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求データ作成年月", required = false, position = 67, allowableValues = "range[0,255]")
	private String billingDataCreateYm;

	/**
	 * 取次手数料金率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "取次手数料金率", required = false, position = 68, allowableValues = "range[0.00,999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 取次手数料金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "取次手数料金額", required = false, position = 69, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal agencyFeeAmount;

	/**
	 * 日割り率.
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "日割り率", required = false, position = 70)
	private BigDecimal proratedRate;

	/**
	 * 取次割引単価.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "取次割引単価", required = false, position = 71)
	private BigDecimal agencyDiscountPrice;

	/**
	 * 長期割引率.
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "長期割引率", required = false, position = 72)
	private BigDecimal longtermDiscountRate;

	/**
	 * 超過電力.
	 */
	@Column(nullable = true)
	@Digits(integer = 6, fraction = 2)
	@ApiModelProperty(value = "超過電力", required = false, position = 73)
	private BigDecimal excessPower;

	/**
	 * 燃料費調整額単価.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "燃調費調整額単価", required = false, position = 74)
	private BigDecimal fuelAdjustmentPrice;

	/**
	 * 再エネ賦課金単価.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "再エネ賦課金単価", required = false, position = 75)
	private BigDecimal renewableLevyPrice;

	/**
	 * 燃料費調整額.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "燃料費調整額", required = false, position = 76)
	private BigDecimal fuelAdjustmentCost;

	/**
	 * 再エネ賦課金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "再エネ賦課金", required = false, position = 77)
	private BigDecimal renewableLevyCost;

	/**
	 * 制限中止割引.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "制限中止割引", required = false, position = 78)
	private BigDecimal restrictionCancelDiscount;

	/**
	 * その他.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "その他", required = false, position = 79)
	private BigDecimal otherCost;

	/**
	 * 仕入契約超過金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入契約超過金", required = false, position = 80)
	private BigDecimal purchaserContractExcess;

	/**
	 * 仕入前月調整.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入前月調整", required = false, position = 81)
	private BigDecimal purchaserAdjustment;

	/**
	 * 仕入アンシラリー.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入アンシラリー", required = false, position = 82)
	private BigDecimal purchaserAncillary;

	/**
	 * 仕入予備線.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入予備線", required = false, position = 83)
	private BigDecimal purchaserSpareLine;

	/**
	 * 仕入予備電源.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕入予備電源", required = false, position = 84)
	private BigDecimal purchaserSparePower;

	/**
	 * 仕切契約超過金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切契約超過金", required = false, position = 85)
	private BigDecimal partitionContractExcess;

	/**
	 * 仕切前月調整.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切前月調整", required = false, position = 86)
	private BigDecimal partitionAdjustment;

	/**
	 * 仕切アンシラリー.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切アンシラリー", required = false, position = 87)
	private BigDecimal partitionAncillary;

	/**
	 * 仕切予備線.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切予備線", required = false, position = 88)
	private BigDecimal partitionSpareLine;

	/**
	 * 仕切予備電源.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "仕切予備電源", required = false, position = 89)
	private BigDecimal partitionSparePower;

	/**
	 * 料金計算日数.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算日数", required = false, position = 90, allowableValues = "range[0,99999]")
	private Integer chargeCalcDays;

	/**
	 * 料金計算対象日数.
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算対象日数", required = false, position = 91, allowableValues = "range[0,99999]")
	private Integer chargeCalcTargetDays;

	/**
	 * 販売店電力料金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "販売店電力料金", required = false, position = 92)
	private BigDecimal tradingCompanyElectricCharge;

	/**
	 * 負荷率(動力).
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 93)
	private BigDecimal loadFactor;

	/**
	 * 再エネ賦課金減免額.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "再エネ賦課金減免額", required = false, position = 94)
	private BigDecimal reExemptionAmount;

	/**
	 * 再エネ賦課金減免率.
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@ApiModelProperty(value = "再エネ賦課金減免率", required = false, position = 95)
	private BigDecimal reExemptionRate;
}
