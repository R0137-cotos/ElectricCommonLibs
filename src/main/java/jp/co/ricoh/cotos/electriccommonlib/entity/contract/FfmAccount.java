package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
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
@JsonPropertyOrder({ "データ作成日", "データ作成時間", "FFM会社コード", "契約種類区分", "作成データパターン", "勘定識別", "データ種別", "赤黒区分", "債権債務照合キー", "NSPユニークキー", "案件番号", "契約書番号", "契約番号", "契約明細番号", "請求明細番号", "お問合せ番号", "お問合せ明細番号", "手配時の案件番号", "手配時の問合せ番号", "赤伝理由", "元契約番号", "元請求明細番号", "請求条件", "請求分割回数", "契約締結日", "契約期間(開始)", "契約期間(終了)", "契約ＳＳコード", "契約ＳＳ社員コード", "振替先課所コード", "振替先社員コード", "保守契約／リース/レンタルＮｏ", "契約金額", "仕切前計上金額", "仕切前消費税額", "商品コード", "機種略号", "機番", "見積時の入力商品名", "原価計上商品コード", "仕入区分", "仕入値引区分", "仕入購買区分", "仕入取引日", "他社商品区分", "仕入取引先コード", "仕入課所設定区分", "仕入課所コード", "仕入責任得意先コード", "在庫区コード", "特価番号", "仕入数量", "仕入単価", "仕入単価(税込)", "仕入金額", "仕入金額(税込)", "仕入消費税区分", "仕入消費税率区分", "仕入消費税額", "仕入先請求ＮＯ", "商品名(支払通知書用)", "売上区分", "売上値引区分", "売上取引日(納品日)", "得意先コード", "売上課所設定区分", "売上課所コード", "売上社員設定区分", "売上社員コード", "値引番号", "伝票番号", "売上数量", "売上単価", "売上単価(税込)", "売上金額", "売上金額(税込)", "売上消費税区分", "売上消費税率区分", "売上消費税額", "契約区分", "売上原価金額", "振替金額", "代直区分(販売店データリンク・売上用)", "販売店売上単価", "販売店税抜金額", "販売店消費税区分", "販売店消費税率区分", "請求書明細識別コード", "納品書要否区分", "納品書出力パターン", "納品書出力形式", "請求書発行システム", "商品名パターン番号(納品書・請求書用)", "商品名(納品書・請求書用)", "業務への連絡事項", "備考(納品書・請求書用)", "請求期間(開始)", "請求期間(終了)", "請求年月", "今回の請求回数", "商品名用カウンター情報", "コメント１", "コメント２", "強制フラグ", "機器設置先名", "機器設置先部課名", "RINGS届先コード(3桁)", "OE届先コード(11桁)", "納品場所識別", "届先名１(会社名)", "届先名２(会社部課名)", "顧客名", "届先住所１", "届先住所２", "届先住所３", "届先郵便番号", "届先電話番号", "届先ＦＡＸ番号", "届先名(カナ)", "得意先コード(二次店)", "届先コード(二次店)", "支払利息相当額", "受取利息相当額", "見積番号", "見積明細番号", "本体見積明細番号" })
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
		@Schema(description = "作成データパターン", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
		private String ffmDataPtn;

		/**
		 * NSPユニークキー
		 */
		@Schema(description = "NSPユニークキー", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
		private String ffmNspKey;
	}

	@EmbeddedId
	@JsonIgnore
	private Id id;

	/**
	 * Jackson用
	 * @return 作成データパターン
	 */
	@JsonProperty("作成データパターン")
	public String getFfmDataPtn() {
		return this.id != null ? this.id.getFfmDataPtn() : null;
	}

	/**
	 * Jackson用
	 * @return NSPユニークキー
	 */
	@JsonProperty("NSPユニークキー")
	public String getFfmNspKey() {
		return this.id != null ? this.id.getFfmNspKey() : null;
	}

	/**
	 * データ作成日
	 */
	@Column(nullable = true)
	@Schema(description = "データ作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("データ作成日")
	private String ffmDataCreateDate;

	/**
	 * データ作成時間
	 */
	@Column(nullable = true)
	@Schema(description = "データ作成時間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("データ作成時間")
	private String ffmDataCreateTime;

	/**
	 * FFM会社コード
	 */
	@Column(nullable = true)
	@Schema(description = "FFM会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("FFM会社コード")
	private String ffmCompanyCd;

	/**
	 * 契約種類区分
	 */
	@Column(nullable = true)
	@Schema(description = "契約種類区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約種類区分")
	private String ffmContractTypeKbn;

	/**
	 * 勘定識別
	 */
	@Column(nullable = true)
	@Schema(description = "勘定識別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("勘定識別")
	private String ffmAccountType;

	/**
	 * データ種別
	 */
	@Column(nullable = true)
	@Schema(description = "データ種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("データ種別")
	private String ffmDataType;

	/**
	 * 赤黒区分
	 */
	@Column(nullable = true)
	@Schema(description = "赤黒区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("赤黒区分")
	private String ffmRedBlackType;

	/**
	 * 債権債務照合キー
	 */
	@Column(nullable = true)
	@Schema(description = "債権債務照合キー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("債権債務照合キー")
	private String ffmMatchingKey;

	/**
	 * 案件番号
	 */
	@Column(nullable = true)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("案件番号")
	private String ffmProjectNo;

	/**
	 * 契約書番号
	 */
	@Column(nullable = true)
	@Schema(description = "契約書番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約書番号")
	private String ffmContractDocNo;

	/**
	 * 契約番号
	 */
	@Column(nullable = true)
	@Schema(description = "契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約番号")
	private String ffmContractNo;

	/**
	 * 契約明細番号
	 */
	@Column(nullable = true)
	@Schema(description = "契約明細番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約明細番号")
	private String ffmContractDetailNo;

	/**
	 * 請求明細番号
	 */
	@Column(nullable = true)
	@Schema(description = "請求明細番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求明細番号")
	private String ffmBillingDetailNo;

	/**
	 * お問合せ番号
	 */
	@Column(nullable = true)
	@Schema(description = "お問合せ番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("お問合せ番号")
	private String ffmInqNo;

	/**
	 * お問合せ明細番号
	 */
	@Column(nullable = true)
	@Schema(description = "お問合せ明細番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("お問合せ明細番号")
	private String ffmInqDetailNo;

	/**
	 * 手配時の案件番号
	 */
	@Column(nullable = true)
	@Schema(description = "手配時の案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("手配時の案件番号")
	private String ffmArrProjectNo;

	/**
	 * 手配時の問合せ番号
	 */
	@Column(nullable = true)
	@Schema(description = "手配時の問合せ番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("手配時の問合せ番号")
	private String ffmArrInqNo;

	/**
	 * 赤伝理由
	 */
	@Column(nullable = true)
	@Schema(description = "赤伝理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("赤伝理由")
	private String ffmCancelReason;

	/**
	 * 元契約番号
	 */
	@Column(nullable = true)
	@Schema(description = "元契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("元契約番号")
	private String ffmOrgContractCd;

	/**
	 * 元請求明細番号
	 */
	@Column(nullable = true)
	@Schema(description = "元請求明細番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("元請求明細番号")
	private String ffmOrgContractDetailNo;

	/**
	 * 請求条件
	 */
	@Column(nullable = true)
	@Schema(description = "請求条件", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求条件")
	private String ffmBillingCondition;

	/**
	 * 請求分割回数
	 */
	@Column(nullable = true)
	@Max(99)
	@Schema(description = "請求分割回数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99]")
	@JsonProperty("請求分割回数")
	private Long ffmTotalBillingCount;

	/**
	 * 契約締結日
	 */
	@Column(nullable = true)
	@Schema(description = "契約締結日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約締結日")
	private String ffmContractDate;

	/**
	 * 契約期間(開始)
	 */
	@Column(nullable = true)
	@Schema(description = "契約期間(開始)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約期間(開始)")
	private String ffmContractPeriodStart;

	/**
	 * 契約期間(終了)
	 */
	@Column(nullable = true)
	@Schema(description = "契約期間(終了)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約期間(終了)")
	private String ffmContractPeriodEnd;

	/**
	 * 契約ＳＳコード
	 */
	@Column(nullable = true)
	@Schema(description = "契約ＳＳコード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約ＳＳコード")
	private String ffmContractSscd;

	/**
	 * 契約ＳＳ社員コード
	 */
	@Column(nullable = true)
	@Schema(description = "契約ＳＳ社員コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約ＳＳ社員コード")
	private String ffmContractSspiccd;

	/**
	 * 振替先課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "振替先課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("振替先課所コード")
	private String ffmTrnsLocationCd;

	/**
	 * 振替先社員コード
	 */
	@Column(nullable = true)
	@Schema(description = "振替先社員コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("振替先社員コード")
	private String ffmTrnsPicCd;

	/**
	 * 保守契約／リース/レンタルＮｏ
	 */
	@Column(nullable = true)
	@Schema(description = "保守契約／リース/レンタルＮｏ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("保守契約／リース/レンタルＮｏ")
	private String ffmMntLeaseNo;

	/**
	 * 契約金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "契約金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("契約金額")
	private BigDecimal ffmContractPrice;

	/**
	 * 仕切前計上金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切前計上金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕切前計上金額")
	private BigDecimal ffmPriceBeforeInvoice;

	/**
	 * 仕切前消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕切前消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕切前消費税額")
	private BigDecimal ffmTaxPriceBeforeInvoice;

	/**
	 * 商品コード
	 */
	@Column(nullable = true)
	@Schema(description = "商品コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("商品コード")
	private String ffmProdactCd;

	/**
	 * 機種略号
	 */
	@Column(nullable = true)
	@Schema(description = "機種略号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("機種略号")
	private String ffmModelId;

	/**
	 * 機番
	 */
	@Column(nullable = true)
	@Schema(description = "機番", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("機番")
	private String ffmSerialId;

	/**
	 * 見積時の入力商品名
	 */
	@Column(nullable = true)
	@Schema(description = "見積時の入力商品名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("見積時の入力商品名")
	private String ffmQuotationProdactName;

	/**
	 * 原価計上商品コード
	 */
	@Column(nullable = true)
	@Schema(description = "原価計上商品コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("原価計上商品コード")
	private String ffmCostProdactName;

	/**
	 * 仕入区分
	 */
	@Column(nullable = true)
	@Schema(description = "仕入区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入区分")
	private String ffmPurchaseType;

	/**
	 * 仕入値引区分
	 */
	@Column(nullable = true)
	@Schema(description = "仕入値引区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入値引区分")
	private String ffmPurchaseDiscntType;

	/**
	 * 仕入購買区分
	 */
	@Column(nullable = true)
	@Schema(description = "仕入購買区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入購買区分")
	private String ffmPurchaseClassType;

	/**
	 * 仕入取引日
	 */
	@Column(nullable = true)
	@Schema(description = "仕入取引日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入取引日")
	private String ffmPurchaseDate;

	/**
	 * 他社商品区分
	 */
	@Column(nullable = true, name = "ffm_non_r_item_cd")
	@Schema(description = "他社商品区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("他社商品区分")
	private String ffmNonRItemCd;

	/**
	 * 仕入取引先コード
	 */
	@Column(nullable = true)
	@Schema(description = "仕入取引先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入取引先コード")
	private String ffmSupplierCd;

	/**
	 * 仕入課所設定区分
	 */
	@Column(nullable = true)
	@Schema(description = "仕入課所設定区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入課所設定区分")
	private String ffmDeptAssortType;

	/**
	 * 仕入課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "仕入課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入課所コード")
	private String ffmPurchaseLocationCd;

	/**
	 * 仕入責任得意先コード
	 */
	@Column(nullable = true)
	@Schema(description = "仕入責任得意先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入責任得意先コード")
	private String ffmPurchaseRespClientCd;

	/**
	 * 在庫区コード
	 */
	@Column(nullable = true)
	@Schema(description = "在庫区コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("在庫区コード")
	private String ffmRdStrctInventoryCd;

	/**
	 * 特価番号
	 */
	@Column(nullable = true)
	@Schema(description = "特価番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("特価番号")
	private String ffmDealsNo;

	/**
	 * 仕入数量
	 */
	@Column(nullable = true)
	@Max(99999)
	@Schema(description = "仕入数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	@JsonProperty("仕入数量")
	private Long ffmPurchaseCnt;

	/**
	 * 仕入単価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕入単価")
	private BigDecimal ffmPurchasePrice;

	/**
	 * 仕入単価(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入単価(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕入単価(税込)")
	private BigDecimal ffmPurchasePriceInTax;

	/**
	 * 仕入金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕入金額")
	private BigDecimal ffmPurchaseAmt;

	/**
	 * 仕入金額(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕入金額(税込)")
	private BigDecimal ffmPurchaseAmtInTax;

	/**
	 * 仕入消費税区分
	 */
	@Column(nullable = true)
	@Schema(description = "仕入消費税区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入消費税区分")
	private String ffmRjPurchaseTaxType;

	/**
	 * 仕入消費税率区分
	 */
	@Column(nullable = true)
	@Schema(description = "仕入消費税率区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入消費税率区分")
	private String ffmRjPurchaseTaxRate;

	/**
	 * 仕入消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "仕入消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("仕入消費税額")
	private BigDecimal ffmRjPurchaseTaxPrice;

	/**
	 * 仕入先請求ＮＯ
	 */
	@Column(nullable = true)
	@Schema(description = "仕入先請求ＮＯ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("仕入先請求ＮＯ")
	private String ffmSupplierBillingNo;

	/**
	 * 商品名(支払通知書用)
	 */
	@Column(nullable = true)
	@Schema(description = "商品名(支払通知書用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("商品名(支払通知書用)")
	private String ffmProdactName;

	/**
	 * 売上区分
	 */
	@Column(nullable = true)
	@Schema(description = "売上区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上区分")
	private String ffmSalesType;

	/**
	 * 売上値引区分
	 */
	@Column(nullable = true)
	@Schema(description = "売上値引区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上値引区分")
	private String ffmSalesDiscountType;

	/**
	 * 売上取引日(納品日)
	 */
	@Column(nullable = true)
	@Schema(description = "売上取引日(納品日)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上取引日(納品日)")
	private String ffmSalesTradeDate;

	/**
	 * 得意先コード
	 */
	@Column(nullable = true)
	@Schema(description = "得意先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("得意先コード")
	private String ffmClientCd;

	/**
	 * 売上課所設定区分
	 */
	@Column(nullable = true)
	@Schema(description = "売上課所設定区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上課所設定区分")
	private String ffmSalesLocationType;

	/**
	 * 売上課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "売上課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上課所コード")
	private String ffmSalesLocationCd;

	/**
	 * 売上社員設定区分
	 */
	@Column(nullable = true)
	@Schema(description = "売上社員設定区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上社員設定区分")
	private String ffmSalesEmpType;

	/**
	 * 売上社員コード
	 */
	@Column(nullable = true)
	@Schema(description = "売上社員コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上社員コード")
	private String ffmSalesEmpCd;

	/**
	 * 値引番号
	 */
	@Column(nullable = true)
	@Schema(description = "値引番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("値引番号")
	private String ffmDiscntNo;

	/**
	 * 伝票番号
	 */
	@Column(nullable = true)
	@Schema(description = "伝票番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("伝票番号")
	private String ffmSlipNo;

	/**
	 * 売上数量
	 */
	@Column(nullable = true)
	@Max(99999)
	@Schema(description = "売上数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	@JsonProperty("売上数量")
	private Long ffmUserSalesCnt;

	/**
	 * 売上単価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("売上単価")
	private BigDecimal ffmUserSalesPrice;

	/**
	 * 売上単価(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上単価(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("売上単価(税込)")
	private BigDecimal ffmUserSalesPriceInTax;

	/**
	 * 売上金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("売上金額")
	private BigDecimal ffmUserSalesAmt;

	/**
	 * 売上金額(税込)
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("売上金額(税込)")
	private BigDecimal ffmUserSalesAmtInTax;

	/**
	 * 売上消費税率区分
	 */
	@Column(nullable = true)
	@Schema(description = "売上消費税率区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上消費税区分")
	private String ffmUserSalesTaxType;

	/**
	 * 売上消費税率区分
	 */
	@Column(nullable = true)
	@Schema(description = "売上消費税率区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("売上消費税率区分")
	private String ffmUserSalesTaxRate;

	/**
	 * 売上消費税額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("売上消費税額")
	private BigDecimal ffmUserSalesTaxPrice;

	/**
	 * 契約区分
	 */
	@Column(nullable = true)
	@Schema(description = "契約区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("契約区分")
	private String ffmContractType;

	/**
	 * 売上原価金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "売上原価金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("売上原価金額")
	private BigDecimal ffmRevenueCostprice;

	/**
	 * 振替金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "振替金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,9999999999999999.99]")
	@JsonProperty("振替金額")
	private BigDecimal ffmTrnsPrice;

	/**
	 * 代直区分(販売店データリンク・売上用)
	 */
	@Column(nullable = true)
	@Schema(description = "代直区分(販売店データリンク・売上用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("代直区分(販売店データリンク・売上用)")
	private String ffmDistType;

	/**
	 * 販売店売上単価
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "販売店売上単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("販売店売上単価")
	private BigDecimal ffmShopSalesPrice;

	/**
	 * 販売店税抜金額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "販売店税抜金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("販売店税抜金額")
	private BigDecimal ffmShopSalesAmt;

	/**
	 * 販売店消費税区分
	 */
	@Column(nullable = true)
	@Schema(description = "販売店消費税区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("販売店消費税区分")
	private String ffmShopSalesTaxType;

	/**
	 * 販売店消費税率区分
	 */
	@Column(nullable = true)
	@Schema(description = "販売店消費税率区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("販売店消費税率区分")
	private String ffmShopSalesTaxRate;

	/**
	 * 請求書明細識別コード
	 */
	@Column(nullable = true)
	@Schema(description = "請求書明細識別コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求書明細識別コード")
	private String ffmBillDetailCd;

	/**
	 * 納品書要否区分
	 */
	@Column(nullable = true)
	@Schema(description = "納品書要否区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("納品書要否区分")
	private String ffmBillOutputFlg;

	/**
	 * 納品書出力パターン
	 */
	@Column(nullable = true)
	@Schema(description = "納品書出力パターン", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("納品書出力パターン")
	private String ffmBillOutputPtn;

	/**
	 * 納品書出力形式
	 */
	@Column(nullable = true)
	@Schema(description = "納品書出力形式", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("納品書出力形式")
	private String ffmBillOutputFmt;

	/**
	 * 請求書発行システム
	 */
	@Column(nullable = true)
	@Schema(description = "請求書発行システム", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求書発行システム")
	private String ffmBillOutputSystem;

	/**
	 * 商品名パターン番号(納品書・請求書用)
	 */
	@Column(nullable = true)
	@Schema(description = "商品名パターン番号(納品書・請求書用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("商品名パターン番号(納品書・請求書用)")
	private String ffmProdactPtnNo;

	/**
	 * 商品名(納品書・請求書用)
	 */
	@Column(nullable = true)
	@Schema(description = "商品名(納品書・請求書用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("商品名(納品書・請求書用)")
	private String ffmProdactNameForBill;

	/**
	 * 業務への連絡事項
	 */
	@Column(nullable = true)
	@Schema(description = "業務への連絡事項", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("業務への連絡事項")
	private String ffmMessageForBiz;

	/**
	 * 備考(納品書・請求書用)
	 */
	@Column(nullable = true)
	@Schema(description = "備考(納品書・請求書用)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("備考(納品書・請求書用)")
	private String ffmRemarkForBill;

	/**
	 * 請求期間(開始)
	 */
	@Column(nullable = true, name = "ffm_r_billing_period_start")
	@Schema(description = "請求期間(開始)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求期間(開始)")
	private String ffmRBillingPeriodStart;

	/**
	 * 請求期間(終了)
	 */
	@Column(nullable = true, name = "ffm_r_billing_period_end")
	@Schema(description = "請求期間(終了)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求期間(終了)")
	private String ffmRBillingPeriodEnd;

	/**
	 * 請求年月
	 */
	@Column(nullable = true)
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("請求年月")
	private String ffmBillingYm;

	/**
	 * 今回の請求回数
	 */
	@Column(nullable = true)
	@Max(99999)
	@Schema(description = "今回の請求回数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	@JsonProperty("今回の請求回数")
	private Long ffmThisBillingCnt;

	/**
	 * 商品名用カウンター情報
	 */
	@Column(nullable = true)
	@Schema(description = "商品名用カウンター情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("商品名用カウンター情報")
	private String ffmCounter;

	/**
	 * コメント１
	 */
	@Column(nullable = true)
	@Schema(description = "コメント１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("コメント１")
	private String ffmOutputComment1;

	/**
	 * コメント２
	 */
	@Column(nullable = true)
	@Schema(description = "コメント２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("コメント２")
	private String ffmOutputComment2;

	/**
	 * 強制フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "強制フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	@JsonProperty("強制フラグ")
	private Integer ffmForcedFlg;

	/**
	 * 機器設置先名
	 */
	@Column(nullable = true)
	@Schema(description = "機器設置先名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("機器設置先名")
	private String ffmInstalltionName;

	/**
	 * 機器設置先部課名
	 */
	@Column(nullable = true)
	@Schema(description = "機器設置先部課名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("機器設置先部課名")
	private String ffmInstalltionDptName;

	/**
	 * RINGS届先コード(3桁)
	 */
	@Column(nullable = true)
	@Schema(description = "RINGS届先コード(3桁)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("RINGS届先コード(3桁)")
	private String ffmRingsDstCd;

	/**
	 * OE届先コード(11桁)
	 */
	@Column(nullable = true)
	@Schema(description = "OE届先コード(11桁)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("OE届先コード(11桁)")
	private String ffmOeDstCd;

	/**
	 * 納品場所識別
	 */
	@Column(nullable = true)
	@Schema(description = "納品場所識別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("納品場所識別")
	private String ffmDstType;

	/**
	 * 届先名１(会社名)
	 */
	@Column(nullable = true)
	@Schema(description = "届先名１(会社名)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先名１(会社名)")
	private String ffmDstName1;

	/**
	 * 届先名２(会社部課名)
	 */
	@Column(nullable = true)
	@Schema(description = "届先名２(会社部課名)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先名２(会社部課名)")
	private String ffmDstName2;

	/**
	 * 顧客名
	 */
	@Column(nullable = true)
	@Schema(description = "顧客名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("顧客名")
	private String ffmDstClientName;

	/**
	 * 届先住所１
	 */
	@Column(nullable = true)
	@Schema(description = "届先住所１", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先住所１")
	private String ffmDstAddr1;

	/**
	 * 届先住所２
	 */
	@Column(nullable = true)
	@Schema(description = "届先住所２", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先住所２")
	private String ffmDstAddr2;

	/**
	 * 届先住所３
	 */
	@Column(nullable = true)
	@Schema(description = "届先住所３", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先住所３")
	private String ffmDstAddr3;

	/**
	 * 届先郵便番号
	 */
	@Column(nullable = true)
	@Schema(description = "届先郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先郵便番号")
	private String ffmDstZipCd;

	/**
	 * 届先電話番号
	 */
	@Column(nullable = true)
	@Schema(description = "届先電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先電話番号")
	private String ffmDstTel;

	/**
	 * 届先ＦＡＸ番号
	 */
	@Column(nullable = true)
	@Schema(description = "届先ＦＡＸ番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先ＦＡＸ番号")
	private String ffmDstFax;

	/**
	 * 届先名(カナ)
	 */
	@Column(nullable = true)
	@Schema(description = "届先名(カナ)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先名(カナ)")
	private String ffmDstNameKana;

	/**
	 * 得意先コード(二次店)
	 */
	@Column(nullable = true)
	@Schema(description = "得意先コード(二次店)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("得意先コード(二次店)")
	private String ffmClientCdSec;

	/**
	 * 届先コード(二次店)
	 */
	@Column(nullable = true)
	@Schema(description = "届先コード(二次店)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("届先コード(二次店)")
	private String ffmDstCdSec;

	/**
	 * 支払利息相当額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "支払利息相当額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("支払利息相当額")
	private BigDecimal ffmInterestExpensePrice;

	/**
	 * 受取利息相当額
	 */
	@Column(nullable = true)
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "受取利息相当額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[-99999999999999999.99,99999999999999999.99]")
	@JsonProperty("受取利息相当額")
	private BigDecimal ffmInterestIncomePrice;

	/**
	 * 見積番号
	 */
	@Column(nullable = true)
	@Schema(description = "見積番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("見積番号")
	private String ffmQuotationCd;

	/**
	 * 見積明細番号
	 */
	@Column(nullable = true)
	@Schema(description = "見積明細番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("見積明細番号")
	private String ffmQuotationDetailCd;

	/**
	 * 本体見積明細番号
	 */
	@Column(nullable = true)
	@Schema(description = "本体見積明細番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("本体見積明細番号")
	private String ffmMainQuotationDetailCd;

	/**
	 * 課金連携フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "課金連携フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	@JsonIgnore
	private Integer ffmBillingCooperationFlg;
}