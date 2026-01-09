package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * NISHIKI料金計算結果
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "fee_calc_interface")
public class FeeCalcInterface extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fee_calc_interface_seq")
	@SequenceGenerator(name = "fee_calc_interface_seq", sequenceName = "fee_calc_interface_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 全体番号
	 */
	@Column(nullable = false)
	@Schema(description = "全体番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("全体番号")
	private String feeClcAllBn;

	/**
	 * 料金区分
	 */
	@Column(nullable = false)
	@Schema(description = "料金区分", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金区分")
	private String feeKbn;

	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算実行番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算実行番号")
	private String feeClcExecBn;

	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@Schema(description = "契約番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("契約番号")
	private String ctctBn;

	/**
	 * 料金計算明細番号
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算明細番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算明細番号")
	private Long feeClcDtlBn;

	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算対象年月", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;

	/**
	 * 需要家番号
	 */
	@Column(nullable = false)
	@Schema(description = "需要家番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("需要家番号")
	private String cstmrBn;

	/**
	 * 料金メニューコード
	 */
	@Column(nullable = false)
	@Schema(description = "料金メニューコード", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;

	/**
	 * 料金名称
	 */
	@Column(nullable = false)
	@Schema(description = "料金名称", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金名称")
	private String feeMnunMs;

	/**
	 * 合計金額
	 */
	@Column(nullable = true)
	@Schema(description = "合計金額", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("合計金額")
	private BigDecimal sumMny;

	/**
	 * 課税対象税抜合計金額
	 */
	@Column(nullable = true)
	@Schema(description = "課税対象税抜合計金額", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("課税対象税抜合計金額")
	private BigDecimal taxObjTaxOutSumMny;

	/**
	 * 税抜合計金額
	 */
	@Column(nullable = true)
	@Schema(description = "税抜合計金額", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("税抜合計金額")
	private BigDecimal feeClcFeeTaxOut;

	/**
	 * 消費税
	 */
	@Column(nullable = true)
	@Schema(description = "消費税", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("消費税")
	private Long taxmny;

	/**
	 * 消費税対象区分
	 */
	@Column(nullable = true)
	@Schema(description = "消費税対象区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("消費税対象区分")
	private String taxAplyKbn;

	/**
	 * 料金計算明細種別コード
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算明細種別コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算明細種別コード")
	private String feeClcDtlClsCd;

	/**
	 * 明細種別名称
	 */
	@Column(nullable = true)
	@Schema(description = "明細種別名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("明細種別名称")
	private String dtlClsNms;

	/**
	 * 料金計算単価
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算単価", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算単価")
	private BigDecimal feeClcUprc;

	/**
	 * 料金計算数量
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算数量")
	private Long feeClcNum;

	/**
	 * 料金計算開始日時
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算開始日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算開始日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "JST")
	private Date feeClcStrDatTim;

	/**
	 * 料金計算終了日時
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算終了日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算終了日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "JST")
	private Date feeClcEndDatTim;

	/**
	 * 前月電力量
	 */
	@Column(nullable = true)
	@Schema(description = "前月電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("前月電力量")
	private Long lstMnthElc;

	/**
	 * 前年同月電力量
	 */
	@Column(nullable = true)
	@Schema(description = "前年同月電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("前年同月電力量")
	private Long lstYearSmnthElcNum;

	/**
	 * 料金計算対象開始日
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算対象開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算対象開始日")
	private String feeClcStrYmd;

	/**
	 * 料金計算対象終了日
	 */
	@Column(nullable = true)
	@Schema(description = "料金計算対象終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("料金計算対象終了日")
	private String feeClcEndYmd;

	/**
	 * 発電種類コード
	 */
	@Column(nullable = true)
	@Schema(description = "発電種類コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("発電種類コード")
	private String pwrGnClsCd;

	/**
	 * 発電種類名
	 */
	@Column(nullable = true)
	@Schema(description = "発電種類名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("発電種類名")
	private String pwrGnClsNm;

	/**
	 * 単価アイテムコード
	 */
	@Column(nullable = true)
	@Schema(description = "単価アイテムコード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("単価アイテムコード")
	private String uprcItemCd;

	/**
	 * 対象年月
	 */
	@Column(nullable = true)
	@Schema(description = "対象年月", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String outputTargetYm;

	/**
	 * 請求書作成済フラグ
	 */
	@Column(nullable = false)
	@Schema(description = "請求書作成済フラグ", requiredMode = Schema.RequiredMode.REQUIRED)
	private long outputFlg;

}
