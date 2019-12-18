package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1)
	private long id;

	/**
	 * 全体番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "全体番号", required = true, position = 2)
	@JsonProperty("全体番号")
	private String feeClcAllBn;

	/**
	 * 料金区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金区分", required = true, position = 3)
	@JsonProperty("料金区分")
	private String feeKbn;

	/**
	 * 料金計算実行番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算実行番号", required = true, position = 4)
	@JsonProperty("料金計算実行番号")
	private String feeClcExecBn;

	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約番号", required = true, position = 5)
	@JsonProperty("契約番号")
	private String ctctBn;

	/**
	 * 料金計算明細番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算明細番号", required = true, position = 6)
	@JsonProperty("料金計算明細番号")
	private Long feeClcDtlBn;

	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算対象年月", required = true, position = 7)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;

	/**
	 * 需要家番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "需要家番号", required = true, position = 8)
	@JsonProperty("需要家番号")
	private String cstmrBn;

	/**
	 * 料金メニューコード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金メニューコード", required = true, position = 9)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;

	/**
	 * 料金名称
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金名称", required = true, position = 10)
	@JsonProperty("料金名称")
	private String feeMnunMs;

	/**
	 * 合計金額
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "合計金額", required = true, position = 11)
	@JsonProperty("合計金額")
	private BigDecimal sumMny;

	/**
	 * 課税対象税抜合計金額
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "課税対象税抜合計金額", required = true, position = 12)
	@JsonProperty("課税対象税抜合計金額")
	private BigDecimal taxObjTaxOutSumMny;

	/**
	 * 税抜合計金額
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "税抜合計金額", required = true, position = 13)
	@JsonProperty("税抜合計金額")
	private BigDecimal feeClcFeeTaxOut;

	/**
	 * 消費税
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "消費税", required = true, position = 14)
	@JsonProperty("消費税")
	private Long taxmny;

	/**
	 * 消費税対象区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "消費税対象区分", required = false, position = 15)
	@JsonProperty("消費税対象区分")
	private String taxAplyKbn;

	/**
	 * 料金計算明細種別コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算明細種別コード", required = false, position = 16)
	@JsonProperty("料金計算明細種別コード")
	private String feeClcDtlClsCd;

	/**
	 * 明細種別名称
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "明細種別名称", required = false, position = 17)
	@JsonProperty("明細種別名称")
	private String dtlClsNms;

	/**
	 * 料金計算単価
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算単価", required = false, position = 18)
	@JsonProperty("料金計算単価")
	private BigDecimal feeClcUprc;

	/**
	 * 料金計算数量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算数量", required = false, position = 19)
	@JsonProperty("料金計算数量")
	private Long feeClcNum;

	/**
	 * 料金計算開始日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算開始日時", required = false, position = 20)
	@JsonProperty("料金計算開始日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "JST")
	private Date feeClcStrDatTim;

	/**
	 * 料金計算終了日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算終了日時", required = false, position = 21)
	@JsonProperty("料金計算終了日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "JST")
	private Date feeClcEndDatTim;

	/**
	 * 前月電力量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前月電力量", required = false, position = 22)
	@JsonProperty("前月電力量")
	private Long lstMnthElc;

	/**
	 * 前年同月電力量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "前年同月電力量", required = false, position = 23)
	@JsonProperty("前年同月電力量")
	private Long lstYearSmnthElcNum;

	/**
	 * 料金計算対象開始日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算対象開始日", required = false, position = 24)
	@JsonProperty("料金計算対象開始日")
	private String feeClcStrYmd;

	/**
	 * 料金計算対象終了日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "料金計算対象終了日", required = false, position = 25)
	@JsonProperty("料金計算対象終了日")
	private String feeClcEndYmd;

	/**
	 * 発電種類コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "発電種類コード", required = false, position = 26)
	@JsonProperty("発電種類コード")
	private String pwrGnClsCd;

	/**
	 * 発電種類名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "発電種類名", required = false, position = 27)
	@JsonProperty("発電種類名")
	private String pwrGnClsNm;

	/**
	 * 単価アイテムコード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "単価アイテムコード", required = false, position = 28)
	@JsonProperty("単価アイテムコード")
	private String uprcItemCd;

	/**
	 * 対象年月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "対象年月", required = false, position = 29)
	private String outputTargetYm;

	/**
	 * 請求書作成済フラグ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "請求書作成済フラグ", required = true, position = 30)
	private long outputFlg;

}
