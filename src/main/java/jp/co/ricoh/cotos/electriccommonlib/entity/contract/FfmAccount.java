package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.FfmAccountRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * FFM計上を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "ffm_account")
@CotosComplementTarget(entity = FfmAccount.class, repository = FfmAccountRepository.class)
public class FfmAccount extends EntityBase {

	@Embeddable
	@Data
	public static class Id implements Serializable {

		/**
		 * シリアルバージョンID
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * 作成データパターン
		 */
		@ApiModelProperty(value = "作成データパターン", required = true, position = 5, allowableValues = "range[0,255]")
		private String ffmDataPtn;

		/**
		 * NSPユニークキー
		 */
		@ApiModelProperty(value = "NSPユニークキー", required = true, position = 10, allowableValues = "range[0,255]")
		private String ffmNspKey;
	}

	@EmbeddedId
	private Id id;

	/**
	 * データ作成日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "データ作成日", required = false, position = 1, allowableValues = "range[0,255]")
	private String ffmDataCreateDate;

	/**
	 * データ作成時間
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "データ作成時間", required = false, position = 2, allowableValues = "range[0,255]")
	private String ffmDataCreateTime;

	/**
	 * FFM会社コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "FFM会社コード", required = false, position = 3, allowableValues = "range[0,255]")
	private String ffmCompanyCd;

	/**
	 * 契約種類区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約種類区分", required = false, position = 4, allowableValues = "range[0,255]")
	private String ffmContractTypeKbn;

	/**
	 * 勘定識別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "勘定識別", required = false, position = 6, allowableValues = "range[0,255]")
	private String ffmAccountType;

	/**
	 * データ種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "データ種別", required = false, position = 7, allowableValues = "range[0,255]")
	private String ffmDataType;

	/**
	 * 赤黒区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "赤黒区分", required = false, position = 8, allowableValues = "range[0,255]")
	private String ffmRedBlackType;

	/**
	 * 債権債務照合キー
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "債権債務照合キー", required = false, position = 9, allowableValues = "range[0,255]")
	private String ffmMatchingKey;

	/**
	 * 案件番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "案件番号", required = false, position = 11, allowableValues = "range[0,255]")
	private String ffmProjectNo;

	/**
	 * 契約書番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約書番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String ffmContractDocNo;

	/**
	 * 契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String ffmContractNo;

	/**
	 * 契約明細番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約明細番号", required = false, position = 14, allowableValues = "range[0,255]")
	private String ffmContractDetailNo;

	/**
	 * 請求明細番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求明細番号", required = false, position = 15, allowableValues = "range[0,255]")
	private String ffmBillingDetailNo;

	/**
	 * お問合せ番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "お問合せ番号", required = false, position = 16, allowableValues = "range[0,255]")
	private String ffmInqNo;

	/**
	 * お問合せ明細番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "お問合せ明細番号", required = false, position = 17, allowableValues = "range[0,255]")
	private String ffmInqDetailNo;

	/**
	 * 手配時の案件番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手配時の案件番号", required = false, position = 18, allowableValues = "range[0,255]")
	private String ffmArrProjectNo;

	/**
	 * 手配時の問合せ番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手配時の問合せ番号", required = false, position = 19, allowableValues = "range[0,255]")
	private String ffmArrInqNo;

	/**
	 * 赤伝理由
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "赤伝理由", required = false, position = 20, allowableValues = "range[0,255]")
	private String ffmCancelReason;

	/**
	 * 元契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "元契約番号", required = false, position = 21, allowableValues = "range[0,255]")
	private String ffmOrgContractCd;

	/**
	 * 元請求明細番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "元請求明細番号", required = false, position = 22, allowableValues = "range[0,255]")
	private String ffmOrgContractDetailNo;

	/**
	 * 請求条件
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求条件", required = false, position = 23, allowableValues = "range[0,255]")
	private String ffmBillingCondition;

	/**
	 * 請求分割回数
	 */
	@Column(nullable = true)
	@Max(99)
	@ApiModelProperty(value = "請求分割回数", required = false, position = 24, allowableValues = "range[0,99]")
	private long ffmTotalBillingCount;

	/**
	 * 契約締結日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約締結日", required = false, position = 25, allowableValues = "range[0,255]")
	private String ffmContractDate;

	/**
	 * 契約期間(開始)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(開始)", required = false, position = 26, allowableValues = "range[0,255]")
	private String ffmContractPeriodStart;

	/**
	 * 契約期間(終了)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(終了)", required = false, position = 27, allowableValues = "range[0,255]")
	private String ffmContractPeriodEnd;

	/**
	 * 契約ＳＳコード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約ＳＳコード", required = false, position = 28, allowableValues = "range[0,255]")
	private String ffmContractSscd;

	/**
	 * 契約ＳＳ社員コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約ＳＳ社員コード", required = false, position = 29, allowableValues = "range[0,255]")
	private String ffmContractSspiccd;

	/**
	 * 振替先課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "振替先課所コード", required = false, position = 30, allowableValues = "range[0,255]")
	private String ffmTrnsLocationCd;

	/**
	 * 振替先社員コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "振替先社員コード", required = false, position = 31, allowableValues = "range[0,255]")
	private String ffmTrnsPicCd;

	/**
	 * 保守契約／リース/レンタルＮｏ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "保守契約／リース/レンタルＮｏ", required = false, position = 32, allowableValues = "range[0,255]")
	private String ffmMntLeaseNo;

	/**
	 * 契約金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "契約金額", required = false, position = 33, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmContractPrice;

	/**
	 * 仕切前計上金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕切前計上金額", required = false, position = 34, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmPriceBeforeInvoice;

	/**
	 * 仕切前消費税額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕切前消費税額", required = false, position = 35, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmTaxPriceBeforeInvoice;

	/**
	 * 商品コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商品コード", required = false, position = 36, allowableValues = "range[0,255]")
	private String ffmProdactCd;

	/**
	 * 機種略号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "機種略号", required = false, position = 37, allowableValues = "range[0,255]")
	private String ffmModelId;

	/**
	 * 機番
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "機番", required = false, position = 38, allowableValues = "range[0,255]")
	private String ffmSerialId;

	/**
	 * 見積時の入力商品名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "見積時の入力商品名", required = false, position = 39, allowableValues = "range[0,255]")
	private String ffmQuotationProdactName;

	/**
	 * 原価計上商品コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "原価計上商品コード", required = false, position = 40, allowableValues = "range[0,255]")
	private String ffmCostProdactName;

	/**
	 * 仕入区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入区分", required = false, position = 41, allowableValues = "range[0,255]")
	private String ffmPurchaseType;

	/**
	 * 仕入値引区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入値引区分", required = false, position = 42, allowableValues = "range[0,255]")
	private String ffmPurchaseDiscntType;

	/**
	 * 仕入購買区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入購買区分", required = false, position = 43, allowableValues = "range[0,255]")
	private String ffmPurchaseClassType;

	/**
	 * 仕入取引日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入取引日", required = false, position = 44, allowableValues = "range[0,255]")
	private String ffmPurchaseDate;

	/**
	 * 他社商品区分
	 */
	@Column(nullable = true, name = "ffm_non_r_item_cd")
	@ApiModelProperty(value = "他社商品区分", required = false, position = 45, allowableValues = "range[0,255]")
	private String ffmNonRItemCd;

	/**
	 * 仕入取引先コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入取引先コード", required = false, position = 46, allowableValues = "range[0,255]")
	private String ffmSupplierCd;

	/**
	 * 仕入課所設定区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入課所設定区分", required = false, position = 47, allowableValues = "range[0,255]")
	private String ffmDeptAssortType;

	/**
	 * 仕入課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入課所コード", required = false, position = 48, allowableValues = "range[0,255]")
	private String ffmPurchaseLocationCd;

	/**
	 * 仕入責任得意先コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入責任得意先コード", required = false, position = 49, allowableValues = "range[0,255]")
	private String ffmPurchaseRespClientCd;

	/**
	 * 在庫区コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "在庫区コード", required = false, position = 50, allowableValues = "range[0,255]")
	private String ffmRdStrctInventoryCd;

	/**
	 * 特価番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "特価番号", required = false, position = 51, allowableValues = "range[0,255]")
	private String ffmDealsNo;

	/**
	 * 仕入数量
	 */
	@Column(nullable = true)
	@Max(99999)
	@ApiModelProperty(value = "仕入数量", required = false, position = 52, allowableValues = "range[0,99999]")
	private long ffmPurchaseCnt;

	/**
	 * 仕入単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕入単価", required = false, position = 53, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmPurchasePrice;

	/**
	 * 仕入単価(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕入単価(税込)", required = false, position = 54, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmPurchasePriceInTax;

	/**
	 * 仕入金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕入金額", required = false, position = 55, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmPurchaseAmt;

	/**
	 * 仕入金額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕入金額(税込)", required = false, position = 56, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmPurchaseAmtInTax;

	/**
	 * 仕入消費税区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入消費税区分", required = false, position = 57, allowableValues = "range[0,255]")
	private String ffmRjPurchaseTaxType;

	/**
	 * 仕入消費税率区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入消費税率区分", required = false, position = 58, allowableValues = "range[0,255]")
	private String ffmRjPurchaseTaxRate;

	/**
	 * 仕入消費税額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "仕入消費税額", required = false, position = 59, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmRjPurchaseTaxPrice;

	/**
	 * 仕入先請求ＮＯ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入先請求ＮＯ", required = false, position = 60, allowableValues = "range[0,255]")
	private String ffmSupplierBillingNo;

	/**
	 * 商品名(支払通知書用)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商品名(支払通知書用)", required = false, position = 61, allowableValues = "range[0,255]")
	private String ffmProdactName;

	/**
	 * 売上区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上区分", required = false, position = 62, allowableValues = "range[0,255]")
	private String ffmSalesType;

	/**
	 * 売上値引区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上値引区分", required = false, position = 63, allowableValues = "range[0,255]")
	private String ffmSalesDiscountType;

	/**
	 * 売上取引日(納品日)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上取引日(納品日)", required = false, position = 64, allowableValues = "range[0,255]")
	private String ffmSalesTradeDate;

	/**
	 * 得意先コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "得意先コード", required = false, position = 65, allowableValues = "range[0,255]")
	private String ffmClientCd;

	/**
	 * 売上課所設定区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上課所設定区分", required = false, position = 66, allowableValues = "range[0,255]")
	private String ffmSalesLocationType;

	/**
	 * 売上課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上課所コード", required = false, position = 67, allowableValues = "range[0,255]")
	private String ffmSalesLocationCd;

	/**
	 * 売上社員設定区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上社員設定区分", required = false, position = 68, allowableValues = "range[0,255]")
	private String ffmSalesEmpType;

	/**
	 * 売上社員コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上社員コード", required = false, position = 69, allowableValues = "range[0,255]")
	private String ffmSalesEmpCd;

	/**
	 * 値引番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "値引番号", required = false, position = 70, allowableValues = "range[0,255]")
	private String ffmDiscntNo;

	/**
	 * 伝票番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "伝票番号", required = false, position = 71, allowableValues = "range[0,255]")
	private String ffmSlipNo;

	/**
	 * 売上数量
	 */
	@Column(nullable = true)
	@Max(99999)
	@ApiModelProperty(value = "売上数量", required = false, position = 72, allowableValues = "range[0,99999]")
	private long ffmUserSalesCnt;

	/**
	 * 売上単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "売上単価", required = false, position = 73, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmUserSalesPrice;

	/**
	 * 売上単価(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "売上単価(税込)", required = false, position = 74, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmUserSalesPriceInTax;

	/**
	 * 売上金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "売上金額", required = false, position = 75, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmUserSalesAmt;

	/**
	 * 売上金額(税込)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "売上金額(税込)", required = false, position = 76, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmUserSalesAmtInTax;

	/**
	 * 売上消費税率区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上消費税率区分", required = false, position = 77, allowableValues = "range[0,255]")
	private String ffmUserSalesTaxType;

	/**
	 * 売上消費税率区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "売上消費税率区分", required = false, position = 78, allowableValues = "range[0,255]")
	private String ffmUserSalesTaxRate;

	/**
	 * 売上消費税額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "売上消費税額", required = false, position = 79, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmUserSalesTaxPrice;

	/**
	 * 契約区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約区分", required = false, position = 80, allowableValues = "range[0,255]")
	private String ffmContractType;

	/**
	 * 売上原価金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "売上原価金額", required = false, position = 81, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmRevenueCostprice;

	/**
	 * 振替金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "振替金額", required = false, position = 82, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmTrnsPrice;

	/**
	 * 代直区分(販売店データリンク・売上用)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "代直区分(販売店データリンク・売上用)", required = false, position = 83, allowableValues = "range[0,255]")
	private String ffmDistType;

	/**
	 * 販売店売上単価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "販売店売上単価", required = false, position = 84, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmShopSalesPrice;

	/**
	 * 販売店税抜金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "販売店税抜金額", required = false, position = 85, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmShopSalesAmt;

	/**
	 * 販売店消費税区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店消費税区分", required = false, position = 86, allowableValues = "range[0,255]")
	private String ffmShopSalesTaxType;

	/**
	 * 販売店消費税率区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店消費税率区分", required = false, position = 87, allowableValues = "range[0,255]")
	private String ffmShopSalesTaxRate;

	/**
	 * 請求書明細識別コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書明細識別コード", required = false, position = 88, allowableValues = "range[0,255]")
	private String ffmBillDetailCd;

	/**
	 * 納品書要否区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "納品書要否区分", required = false, position = 89, allowableValues = "range[0,255]")
	private String ffmBillOutputFlg;

	/**
	 * 納品書出力パターン
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "納品書出力パターン", required = false, position = 90, allowableValues = "range[0,255]")
	private String ffmBillOutputPtn;

	/**
	 * 納品書出力形式
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "納品書出力形式", required = false, position = 91, allowableValues = "range[0,255]")
	private String ffmBillOutputFmt;

	/**
	 * 請求書発行システム
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求書発行システム", required = false, position = 92, allowableValues = "range[0,255]")
	private String ffmBillOutputSystem;

	/**
	 * 商品名パターン番号(納品書・請求書用)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商品名パターン番号(納品書・請求書用)", required = false, position = 93, allowableValues = "range[0,255]")
	private String ffmProdactPtnNo;

	/**
	 * 商品名(納品書・請求書用)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商品名(納品書・請求書用)", required = false, position = 94, allowableValues = "range[0,255]")
	private String ffmProdactNameForBill;

	/**
	 * 業務への連絡事項
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "業務への連絡事項", required = false, position = 95, allowableValues = "range[0,255]")
	private String ffmMessageForBiz;

	/**
	 * 備考(納品書・請求書用)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "備考(納品書・請求書用)", required = false, position = 96, allowableValues = "range[0,255]")
	private String ffmRemarkForBill;

	/**
	 * 請求期間(開始)
	 */
	@Column(nullable = true, name = "ffm_r_billing_period_start")
	@ApiModelProperty(value = "請求期間(開始)", required = false, position = 97, allowableValues = "range[0,255]")
	private String ffmRBillingPeriodStart;

	/**
	 * 請求期間(終了)
	 */
	@Column(nullable = true, name = "ffm_r_billing_period_end")
	@ApiModelProperty(value = "請求期間(終了)", required = false, position = 98, allowableValues = "range[0,255]")
	private String ffmRBillingPeriodEnd;

	/**
	 * 請求年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求年月", required = false, position = 99, allowableValues = "range[0,255]")
	private String ffmBillingYm;

	/**
	 * 今回の請求回数
	 */
	@Column(nullable = true)
	@Max(99999)
	@ApiModelProperty(value = "今回の請求回数", required = false, position = 100, allowableValues = "range[0,99999]")
	private long ffmThisBillingCnt;

	/**
	 * 商品名用カウンター情報
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商品名用カウンター情報", required = false, position = 101, allowableValues = "range[0,255]")
	private String ffmCounter;

	/**
	 * コメント１
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "コメント１", required = false, position = 102, allowableValues = "range[0,255]")
	private String ffmOutputComment1;

	/**
	 * コメント２
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "コメント２", required = false, position = 103, allowableValues = "range[0,255]")
	private String ffmOutputComment2;

	/**
	 * 強制フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "強制フラグ", required = false, position = 104, allowableValues = "range[0,9]")
	private Integer ffmForcedFlg;

	/**
	 * 機器設置先名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "機器設置先名", required = false, position = 105, allowableValues = "range[0,255]")
	private String ffmInstalltionName;

	/**
	 * 機器設置先部課名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "機器設置先部課名", required = false, position = 106, allowableValues = "range[0,255]")
	private String ffmInstalltionDptName;

	/**
	 * RINGS届先コード(3桁)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "RINGS届先コード(3桁)", required = false, position = 107, allowableValues = "range[0,255]")
	private String ffmRingsDstCd;

	/**
	 * OE届先コード(11桁)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "OE届先コード(11桁)", required = false, position = 108, allowableValues = "range[0,255]")
	private String ffmOeDstCd;

	/**
	 * 納品場所識別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "納品場所識別", required = false, position = 109, allowableValues = "range[0,255]")
	private String ffmDstType;

	/**
	 * 届先名１(会社名)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先名１(会社名)", required = false, position = 110, allowableValues = "range[0,255]")
	private String ffmDstName1;

	/**
	 * 届先名２(会社部課名)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先名２(会社部課名)", required = false, position = 111, allowableValues = "range[0,255]")
	private String ffmDstName2;

	/**
	 * 顧客名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "顧客名", required = false, position = 112, allowableValues = "range[0,255]")
	private String ffmDstClientName;

	/**
	 * 届先住所１
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先住所１", required = false, position = 113, allowableValues = "range[0,255]")
	private String ffmDstAddr1;

	/**
	 * 届先住所２
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先住所２", required = false, position = 114, allowableValues = "range[0,255]")
	private String ffmDstAddr2;

	/**
	 * 届先住所３
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先住所３", required = false, position = 115, allowableValues = "range[0,255]")
	private String ffmDstAddr3;

	/**
	 * 届先郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先郵便番号", required = false, position = 116, allowableValues = "range[0,255]")
	private String ffmDstZipCd;

	/**
	 * 届先電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先電話番号", required = false, position = 117, allowableValues = "range[0,255]")
	private String ffmDstTel;

	/**
	 * 届先ＦＡＸ番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先ＦＡＸ番号", required = false, position = 118, allowableValues = "range[0,255]")
	private String ffmDstFax;

	/**
	 * 届先名(カナ)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先名(カナ)", required = false, position = 119, allowableValues = "range[0,255]")
	private String ffmDstNameKana;

	/**
	 * 得意先コード(二次店)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "得意先コード(二次店)", required = false, position = 120, allowableValues = "range[0,255]")
	private String ffmClientCdSec;

	/**
	 * 届先コード(二次店)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "届先コード(二次店)", required = false, position = 121, allowableValues = "range[0,255]")
	private String ffmDstCdSec;

	/**
	 * 支払利息相当額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "支払利息相当額", required = false, position = 122, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmInterestExpensePrice;

	/**
	 * 受取利息相当額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "受取利息相当額", required = false, position = 123, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ffmInterestIncomePrice;

	/**
	 * 見積番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "見積番号", required = false, position = 124, allowableValues = "range[0,255]")
	private String ffmQuotationCd;

	/**
	 * 見積明細番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "見積明細番号", required = false, position = 125, allowableValues = "range[0,255]")
	private String ffmQuotationDetailCd;

	/**
	 * 本体見積明細番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "本体見積明細番号", required = false, position = 126, allowableValues = "range[0,255]")
	private String ffmMainQuotationDetailCd;
}