package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "No.", required = false, position = 1)
	private long no;

	/**
	 * 請求年月
	 */
	@ApiModelProperty(value = "請求年月", required = false, position = 2)
	private String billingYearMonth;

	/**
	 * お客様識別番号
	 */
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 3)
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 4)
	private String feedPointNumber;

	/**
	 * 上流顧客コード
	 */
	@ApiModelProperty(value = "上流顧客コード", required = false, position = 5)
	private String clientCode;

	/**
	 * 企業・事業所
	 */
	@ApiModelProperty(value = "企業・事業所", required = false, position = 6)
	private String companyName;

	/**
	 * 契約者・需要場所
	 */
	@ApiModelProperty(value = "契約者・需要場所", required = false, position = 7)
	private String customerName;

	/**
	 * 販売店名
	 */
	@ApiModelProperty(value = "販売店名", required = false, position = 8)
	private String dealerName;

	/**
	 * 請求金額(税抜)
	 */
	@ApiModelProperty(value = "請求金額(税抜)", required = false, position = 9)
	private BigDecimal proceedsOutTax;

	/**
	 * 消費税額
	 */
	@ApiModelProperty(value = "消費税額", required = false, position = 10)
	private BigDecimal proceedsTax;

	/**
	 * 請求金額(税込)
	 */
	@ApiModelProperty(value = "請求金額(税込)", required = false, position = 11)
	private BigDecimal proceedsInTax;

	/**
	 * 契約電力kW
	 */
	@ApiModelProperty(value = "契約電力kW", required = false, position = 12)
	private BigDecimal basicPowerAmount;

	/**
	 * 使用電力夏季kWh
	 */
	@ApiModelProperty(value = "使用電力夏季kWh", required = false, position = 13)
	private BigDecimal monthlyTotalpowerAmountSummer;

	/**
	 * 使用電力他季kWh
	 */
	@ApiModelProperty(value = "使用電力他季kWh", required = false, position = 14)
	private BigDecimal monthlyTotalpowerAmountOtherSeason;

	/**
	 * 使用電力従量kWh
	 */
	@ApiModelProperty(value = "使用電力従量kWh", required = false, position = 15)
	private BigDecimal monthlyTotalpowerAmountCommon;

	/**
	 * 仕入金額(税抜)
	 */
	@ApiModelProperty(value = "仕入金額(税抜)", required = false, position = 16)
	private BigDecimal partitionTotalChargeOutTax;

	/**
	 * 仕入金額(税額)
	 */
	@ApiModelProperty(value = "仕入金額(税額)", required = false, position = 17)
	private BigDecimal partitionTax;

	/**
	 * 仕入金額(税込)
	 */
	@ApiModelProperty(value = "仕入金額(税込)", required = false, position = 18)
	private BigDecimal partitionTotalChargeInTax;

	/**
	 * 仲介区分
	 */
	@ApiModelProperty(value = "仲介区分", required = false, position = 19)
	private String paymentDiv;

	/**
	 * 手数料率
	 */
	@ApiModelProperty(value = "手数料率", required = false, position = 20)
	private BigDecimal tradingCompanyFeeFixedRate;

	/**
	 * 手数料金額
	 */
	@ApiModelProperty(value = "手数料金額", required = false, position = 21)
	private BigDecimal tradingCompanyFeeFixedAmountInTax;

	/**
	 * 支社粗利
	 */
	@ApiModelProperty(value = "支社粗利", required = false, position = 22)
	private BigDecimal rjGrossProfit;

	/**
	 * SA粗利
	 */
	@ApiModelProperty(value = "SA粗利", required = false, position = 23)
	private BigDecimal salesSectionGrossProfit;

	/**
	 * 本部粗利
	 */
	@ApiModelProperty(value = "本部粗利", required = false, position = 24)
	private BigDecimal headofficeGrossProfit;

	/**
	 * 取次手数料金率
	 */
	@ApiModelProperty(value = "取次手数料金率", required = false, position = 25)
	private BigDecimal agencyFeeRate;

	/**
	 * 取次手数料金額
	 */
	@ApiModelProperty(value = "取次手数料金額", required = false, position = 26)
	private BigDecimal agencyFeeAmount;

	/**
	 * 供給年月
	 */
	@ApiModelProperty(value = "供給年月", required = false, position = 27)
	private String supplyYearMonth;
}
