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

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
public class ElectricAppropriationResultDto {

	@Id
	@JsonIgnore
	@Schema(description = "連番", requiredMode = Schema.RequiredMode.REQUIRED)
	private long seqNo;

	/**
	 * ID
	 */
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 登録日時
	 */
	@Schema(description = "登録日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date createdAt;

	/**
	 * 登録者
	 */
	@Schema(description = "登録者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String createdUserId;

	/**
	 * 更新日時
	 */
	@Schema(description = "更新日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date updatedAt;

	/**
	 * 更新者
	 */
	@Schema(description = "更新者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String updatedUserId;

	/**
	 * version
	 */
	@Schema(description = "version", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long version;

	/**
	 * 契約（電力）ID
	 */
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long contractElectricId;

	/**
	 * 請求基本情報ID
	 */
	@Schema(description = "請求基本情報ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private long billingBasicInformationId;

	/**
	 * 請求年月
	 */
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * お客様識別番号
	 */
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 料金計算実行番号
	 */
	@Schema(description = "料金計算実行番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String calcExecNumber;

	/**
	 * NISHIKI契約番号
	 */
	@Schema(description = "NISHIKI契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 販社コード
	 */
	@Schema(description = "販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 所轄課所コード
	 */
	@Schema(description = "所轄課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 仕入取引先コード
	 */
	@Schema(description = "仕入取引先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String purchaserCode;

	/**
	 * リコー品種コード
	 */
	@Schema(description = "リコー品種コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String ricohItemCode;

	/**
	 * リコー電力商品名
	 */
	@Schema(description = "リコー電力商品名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String ricohElectricItemName;

	/**
	 * 電力販売店会社ID
	 */
	@Schema(description = "電力販売店会社ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricTradingCompanyId;

	/**
	 * 売上仕入計上日時
	 */
	@Schema(description = "売上仕入計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date purchaserAppropriationDay;

	/**
	 * 振替計上日時
	 */
	@Schema(description = "振替計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date transferAppropriationDay;

	/**
	 * 手数料計上日時
	 */
	@Schema(description = "手数料計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 高圧請求計上日時
	 */
	@Schema(description = "高圧請求計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date highClaimAppropriationDay;

	/**
	 * 売上金額(税込)
	 */
	@Schema(description = "売上金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal proceedsInTax;

	/**
	 * 売上消費税額
	 */
	@Schema(description = "売上消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal proceedsTax;

	/**
	 * 売上金額(税抜)
	 */
	@Schema(description = "売上金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal proceedsOutTax;

	/**
	 * 力率
	 */
	@Schema(description = "力率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**
	 * 基本電力量
	 */
	@Schema(description = "基本電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal basicPowerAmount;

	/**
	 * 月間合計電力量(夏季)
	 */
	@Schema(description = "月間合計電力量(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal monthlyTotalpowerAmountSummer;

	/**
	 * 月間合計電力量(その他季)
	 */
	@Schema(description = "月間合計電力量(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal monthlyTotalpowerAmountOtherSeason;

	/**
	 * 月間合計電力量(共通)
	 */
	@Schema(description = "月間合計電力量(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal monthlyTotalpowerAmountCommon;

	/**
	 * 仕入基本単価
	 */
	@Schema(description = "仕入基本単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserBasicPrice;

	/**
	 * 仕入従量単価(夏季)
	 */
	@Schema(description = "仕入従量単価(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserUsagePriceSummer;

	/**
	 * 仕入従量単価(その他季)
	 */
	@Schema(description = "仕入従量単価(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserUsagePriceOtherSeason;

	/**
	 * 仕入従量単価(共通)
	 */
	@Schema(description = "仕入従量単価(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserUsagePriceCommon;

	/**
	 * 仕切基本単価
	 */
	@Schema(description = "仕切基本単価)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionBasicPrice;

	/**
	 * 仕切従量単価(夏季)
	 */
	@Schema(description = "仕切従量単価(夏季))", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionUsagePriceSummer;

	/**
	 * 仕切従量単価(その他季)
	 */
	@Schema(description = "仕切従量単価(その他季))", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionUsagePriceOtherSeason;

	/**
	 * 仕切従量単価(共通)
	 */
	@Schema(description = "仕切従量単価(共通))", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionUsagePriceCommon;

	/**
	 * 仕入基本料金
	 */
	@Schema(description = "仕入基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserBasicCharge;

	/**
	 * 仕入電力量料金(夏季)
	 */
	@Schema(description = "仕入電力量料金(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeSummer;

	/**
	 * 仕入電力量料金(その他季)
	 */
	@Schema(description = "仕入電力量料金(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeOtherSeason;

	/**
	 * 仕入電力量料金(共通)
	 */
	@Schema(description = "仕入電力量料金(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserPowerAmountChargeCommon;

	/**
	 * 仕入合計料金(税込)
	 */
	@Schema(description = "仕入合計料金(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserTotalChargeInTax;

	/**
	 * 仕入消費税額
	 */
	@Schema(description = "仕入消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserTax;

	/**
	 * 仕入合計料金(税抜)
	 */
	@Schema(description = "仕入合計料金(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal purchaserTotalChargeOutTax;

	/**
	 * 仕切基本料金
	 */
	@Schema(description = "仕切基本料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionBasicCharge;

	/**
	 * 仕切電力両料金(夏季)
	 */
	@Schema(description = "仕切電力両料金(夏季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeSummer;

	/**
	 * 仕切電力両料金(その他季)
	 */
	@Schema(description = "仕切電力両料金(その他季)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeOtherSeason;

	/**
	 * 仕切電力両料金(共通)
	 */
	@Schema(description = "仕切電力両料金(共通)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionPowerAmountChargeCommon;

	/**
	 * 仕切合計料金(税込)
	 */
	@Schema(description = "仕切合計料金(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionTotalChargeInTax;

	/**
	 * 仕切消費税額
	 */
	@Schema(description = "仕切消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionTax;

	/**
	 * 仕切合計料金(税抜)
	 */
	@Schema(description = "仕切合計料金(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal partitionTotalChargeOutTax;

	/**
	 * RJ粗利金額
	 */
	@Schema(description = "RJ粗利金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal rjGrossProfit;

	/**
	 * 営業区粗利金額
	 */
	@Schema(description = "営業区粗利金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal salesSectionGrossProfit;

	/**
	 * 本部粗利金額
	 */
	@Schema(description = "本部粗利金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal headofficeGrossProfit;

	/**
	 * 売上課所コード
	 */
	@Schema(description = "売上課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String proceedsOfficeCode;

	/**
	 * 営業区粗利分配先販社コード
	 */
	@Schema(description = "営業区粗利分配先販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareTradingConpanyCode;

	/**
	 * 営業区粗利分配先課所コード
	 */
	@Schema(description = "営業区粗利分配先販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareOfficeCode;

	/**
	 * 営業区粗利分配先社員コード
	 */
	@Schema(description = "営業区粗利分配先販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesSectionGrossProfitShareEmployeeCode;

	/**
	 * 想定年間電力料金
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "想定年間電力料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal assumptionYearlyPowerCharge;

	/**
	 * 販売店手数料定率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "販売店手数料定率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal tradingCompanyFeeFixedRate;

	/**
	 * 販売店手数料定額(税込)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "販売店手数料定額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal tradingCompanyFeeFixedAmountInTax;

	/**
	 * 販売店仲介手数料額(税込)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "販売店仲介手数料額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal tradingCompanyMediationFeeAmountInTax;

	/**
	 * 支払通知書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "支払通知書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer paymentOutputFlg;

	/**
	 * 料金計算対象年月
	 */
	@Schema(description = "料金計算対象年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String calcDate;

	/**
	 * No.
	 */
	@Max(99999)
	@Schema(description = "No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 供給地点特定番号
	 */
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 企業・事業所
	 */
	@Schema(description = "企業・事業所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyAndOffice;

	/**
	 * 契約者・需要場所
	 */
	@Schema(description = "契約者・需要場所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerAndDemandPlace;

	/**
	 * 供給年月
	 */
	@Schema(description = "供給年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplyYearMonth;

	/**
	 * 使用電力従量kWh
	 */
	@Schema(description = "使用電力従量kWh", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricPowerConsumptionUsageFee;

	@PrePersist
	public void prePersist() {
		throw new IllegalAccessError();
	}

}
