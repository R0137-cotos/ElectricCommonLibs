package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 契約（電力）に紐づく計上実績をリスト取得するためのDtoです。<br/>
 * このクラスを使用してDBへの保存を行うことは出来ません。
 */
@Entity
@Data
public class AppropriationSearchResult {

	/**
	 * No.
	 */
	@Id
	@Schema(description = "No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private long no;

	/**
	 * 請求年月
	 */
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String billingYearMonth;

	/**
	 * お客様識別番号
	 */
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String feedPointNumber;

	/**
	 * 上流顧客コード
	 */
	@Schema(description = "上流顧客コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String clientCode;

	/**
	 * 企業・事業所
	 */
	@Schema(description = "企業・事業所", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String companyName;

	/**
	 * 契約者・需要場所
	 */
	@Schema(description = "契約者・需要場所", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String customerName;

	/**
	 * 販売店名
	 */
	@Schema(description = "販売店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String dealerName;

	/**
	 * 請求金額(税抜)
	 */
	@Schema(description = "請求金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proceedsOutTax;

	/**
	 * 消費税額
	 */
	@Schema(description = "消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proceedsTax;

	/**
	 * 請求金額(税込)
	 */
	@Schema(description = "請求金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal proceedsInTax;

	/**
	 * 契約電力kW
	 */
	@Schema(description = "契約電力kW", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal basicPowerAmount;

	/**
	 * 使用電力夏季kWh
	 */
	@Schema(description = "使用電力夏季kWh", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal monthlyTotalpowerAmountSummer;

	/**
	 * 使用電力他季kWh
	 */
	@Schema(description = "使用電力他季kWh", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal monthlyTotalpowerAmountOtherSeason;

	/**
	 * 使用電力従量kWh
	 */
	@Schema(description = "使用電力従量kWh", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal monthlyTotalpowerAmountCommon;

	/**
	 * 仕入金額(税抜)
	 */
	@Schema(description = "仕入金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserTotalChargeOutTax;

	/**
	 * 仕入金額(税額)
	 */
	@Schema(description = "仕入金額(税額)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserTax;

	/**
	 * 仕入金額(税込)
	 */
	@Schema(description = "仕入金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal purchaserTotalChargeInTax;

	/**
	 * 仲介区分
	 */
	@Schema(description = "仲介区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String paymentDiv;

	/**
	 * 手数料率
	 */
	@Schema(description = "手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal tradingCompanyFeeFixedRate;

	/**
	 * 手数料金額
	 */
	@Schema(description = "手数料金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal tradingCompanyFeeFixedAmountInTax;

	/**
	 * 支社粗利
	 */
	@Schema(description = "支社粗利", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal rjGrossProfit;

	/**
	 * SA粗利
	 */
	@Schema(description = "SA粗利", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal salesSectionGrossProfit;

	/**
	 * 本部粗利
	 */
	@Schema(description = "本部粗利", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal headofficeGrossProfit;

	/**
	 * 取次手数料金率
	 */
	@Schema(description = "取次手数料金率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyFeeRate;

	/**
	 * 取次手数料金額
	 */
	@Schema(description = "取次手数料金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal agencyFeeAmount;

	/**
	 * 供給年月
	 */
	@Schema(description = "供給年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String supplyYearMonth;
}
