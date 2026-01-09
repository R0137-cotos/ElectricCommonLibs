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

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@Column(nullable = false)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long contractElectricId;

	/**
	 * 請求基本情報
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "billing_basic_information_id", referencedColumnName = "id")
	@Schema(description = "請求基本情報", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private BillingBasicInformation billingBasicInformation;

	/**
	 * 請求年月
	 */
	@Column(nullable = false)
	@JoinColumn(name = "billing_year_month")
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * お客様識別番号
	 */
	@Column(nullable = false)
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算実行番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String calcExecNumber;

	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@Schema(description = "NISHIKI契約番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 販社コード
	 */
	@Column(nullable = false)
	@Schema(description = "販社コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 所轄課所コード
	 */
	@Column(nullable = false)
	@Schema(description = "所轄課所コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 仕入取引先コード
	 */
	@Column(nullable = false)
	@Schema(description = "仕入取引先コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String purchaserCode;

	/**
	 * リコー品種コード
	 */
	@Column(nullable = false)
	@Schema(description = "リコー品種コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String ricohItemCode;

	/**
	 * リコー電力商品名
	 */
	@Column(nullable = false)
	@Schema(description = "リコー電力商品名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String ricohElectricItemName;

	/**
	 * 電力販売店会社ID
	 */
	@Column(nullable = true)
	@JoinColumn(name = "electric_trading_company_id")
	@Schema(description = "電力販売店会社ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricTradingCompanyId;

	/**
	 * 売上仕入計上日時
	 */
	@Column(nullable = true)
	@Schema(description = "売上仕入計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date purchaserAppropriationDay;

	/**
	 * 振替計上日時
	 */
	@Column(nullable = true)
	@Schema(description = "振替計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date transferAppropriationDay;

	/**
	 * 手数料計上日時
	 */
	@Column(nullable = true)
	@Schema(description = "手数料計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 高圧請求計上日時
	 */
	@Column(nullable = true)
	@Schema(description = "高圧請求計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date highClaimAppropriationDay;

	/**
	 * 売上金額(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proceedsInTax;

	/**
	 * 売上消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proceedsTax;

	/**
	 * 売上金額(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proceedsOutTax;

	/**
	 * 力率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "力率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal powerRate;

	/**
	 * 基本電力量
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "基本電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal basicPowerAmount;

	/**
	 * 月間合計電力量(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "月間合計電力量(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal monthlyTotalpowerAmountSummer;

	/**
	 * 月間合計電力量(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "月間合計電力量(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal monthlyTotalpowerAmountOtherSeason;

	/**
	 * 月間合計電力量(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "月間合計電力量(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999999.99]")
	private BigDecimal monthlyTotalpowerAmountCommon;

	/**
	 * 仕入基本単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入基本単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserBasicPrice;

	/**
	 * 仕入従量単価(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入従量単価(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserUsagePriceSummer;

	/**
	 * 仕入従量単価(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入従量単価(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserUsagePriceOtherSeason;

	/**
	 * 仕入従量単価(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入従量単価(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserUsagePriceCommon;

	/**
	 * 仕切基本単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切基本単価)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionBasicPrice;

	/**
	 * 仕切従量単価(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切従量単価(夏季))", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionUsagePriceSummer;

	/**
	 * 仕切従量単価(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切従量単価(その他季))", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionUsagePriceOtherSeason;

	/**
	 * 仕切従量単価(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切従量単価(共通))", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionUsagePriceCommon;

	/**
	 * 仕入基本料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserBasicCharge;

	/**
	 * 仕入電力量料金(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入電力量料金(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeSummer;

	/**
	 * 仕入電力量料金(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入電力量料金(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeOtherSeason;

	/**
	 * 仕入電力量料金(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入電力量料金(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeCommon;

	/**
	 * 仕入合計料金(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入合計料金(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserTotalChargeInTax;

	/**
	 * 仕入消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserTax;

	/**
	 * 仕入合計料金(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入合計料金(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserTotalChargeOutTax;

	/**
	 * 仕切基本料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionBasicCharge;

	/**
	 * 仕切電力量料金(夏季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切電力量料金(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeSummer;

	/**
	 * 仕切電力量料金(その他季)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切電力量料金(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeOtherSeason;

	/**
	 * 仕切電力量料金(共通)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切電力量料金(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeCommon;

	/**
	 * 仕切合計料金(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切合計料金(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionTotalChargeInTax;

	/**
	 * 仕切消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionTax;

	/**
	 * 仕切合計料金(税抜)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切合計料金(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal partitionTotalChargeOutTax;

	/**
	 * RJ粗利金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "RJ粗利金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal rjGrossProfit;

	/**
	 * 営業区粗利金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "営業区粗利金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal salesSectionGrossProfit;

	/**
	 * 本部粗利金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "本部粗利金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal headofficeGrossProfit;

	/**
	 * 売上課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "売上課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String proceedsOfficeCode;

	/**
	 * 営業区粗利分配先販社コード
	 */
	@Column(nullable = true)
	@Schema(description = "営業区粗利分配先販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareTradingConpanyCode;

	/**
	 * 営業区粗利分配先課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "営業区粗利分配先販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareOfficeCode;

	/**
	 * 営業区粗利分配先社員コード
	 */
	@Column(nullable = true)
	@Schema(description = "営業区粗利分配先販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareEmployeeCode;

	/**
	 * 想定年間電力料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "想定年間電力料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal assumptionYearlyPowerCharge;

	/**
	 * 販売店手数料定率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "販売店手数料定率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal tradingCompanyFeeFixedRate;

	/**
	 * 販売店手数料定額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "販売店手数料定額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal tradingCompanyFeeFixedAmountInTax;

	/**
	 * 販売店仲介手数料額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "販売店仲介手数料額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal tradingCompanyMediationFeeAmountInTax;

	/**
	 * 支払通知書出力フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "支払通知書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer paymentOutputFlg;

	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算対象年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String calcDate;

	/**
	 * No.
	 */
	@Column(nullable = true)
	@Max(99999)
	@Schema(description = "No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 企業・事業所
	 */
	@Column(nullable = true)
	@Schema(description = "企業・事業所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyAndOffice;

	/**
	 * 契約者・需要場所
	 */
	@Column(nullable = true)
	@Schema(description = "契約者・需要場所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerAndDemandPlace;

	/**
	 * 供給年月
	 */
	@Column(nullable = true)
	@Schema(description = "供給年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplyYearMonth;

	/**
	 * 使用電力従量kWh
	 */
	@Column(nullable = true)
	@Schema(description = "使用電力従量kWh", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricPowerConsumptionUsageFee;

	/**
	 * 請求データ作成年月
	 */
	@Column(nullable = true)
	@Schema(description = "請求データ作成年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingDataCreateYm;

	/**
	 * 取次手数料金率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "取次手数料金率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,999.99]")
	private BigDecimal agencyFeeRate;

	/**
	 * 取次手数料金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次手数料金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal agencyFeeAmount;

	/**
	 * 日割り率.
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "日割り率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proratedRate;

	/**
	 * 取次割引単価.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "取次割引単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyDiscountPrice;

	/**
	 * 長期割引率.
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "長期割引率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal longtermDiscountRate;

	/**
	 * 超過電力.
	 */
	@Column(nullable = true)
	@Digits(integer = 6, fraction = 2)
	@Schema(description = "超過電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal excessPower;

	/**
	 * 燃料費調整額単価.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "燃調費調整額単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal fuelAdjustmentPrice;

	/**
	 * 再エネ賦課金単価.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "再エネ賦課金単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal renewableLevyPrice;

	/**
	 * 燃料費調整額.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "燃料費調整額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal fuelAdjustmentCost;

	/**
	 * 再エネ賦課金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "再エネ賦課金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal renewableLevyCost;

	/**
	 * 制限中止割引.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "制限中止割引", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal restrictionCancelDiscount;

	/**
	 * その他.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "その他", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal otherCost;

	/**
	 * 仕入契約超過金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入契約超過金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserContractExcess;

	/**
	 * 仕入前月調整.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入前月調整", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserAdjustment;

	/**
	 * 仕入アンシラリー.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入アンシラリー", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserAncillary;

	/**
	 * 仕入予備線.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserSpareLine;

	/**
	 * 仕入予備電源.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入予備電源", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserSparePower;

	/**
	 * 仕切契約超過金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切契約超過金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal partitionContractExcess;

	/**
	 * 仕切前月調整.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切前月調整", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal partitionAdjustment;

	/**
	 * 仕切アンシラリー.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切アンシラリー", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal partitionAncillary;

	/**
	 * 仕切予備線.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal partitionSpareLine;

	/**
	 * 仕切予備電源.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切予備電源", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal partitionSparePower;

	/**
	 * 料金計算日数.
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算日数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Integer chargeCalcDays;

	/**
	 * 料金計算対象日数.
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算対象日数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Integer chargeCalcTargetDays;

	/**
	 * 販売店電力料金.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "販売店電力料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal tradingCompanyElectricCharge;

	/**
	 * 負荷率(動力).
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal loadFactor;

	/**
	 * 再エネ賦課金減免額.
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "再エネ賦課金減免額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal reExemptionAmount;

	/**
	 * 再エネ賦課金減免率.
	 */
	@Column(nullable = true)
	@Digits(integer = 3, fraction = 2)
	@Schema(description = "再エネ賦課金減免率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal reExemptionRate;
}
