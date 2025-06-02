package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 計器情報(高圧)
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "instrument_info_high_volt")
public class InstrumentInfoHighVolt extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instrument_info_high_volt_seq")
	@SequenceGenerator(name = "instrument_info_high_volt_seq", sequenceName = "instrument_info_high_volt_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = false, position = 1)
	private long id;

	/**
	 * 全体番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "全体番号", required = true, position = 2)
	@JsonProperty("全体番号")
	private String feeClcAllBn;
	
	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "供給地点特定番号", required = true, position = 3)
	@JsonProperty("供給地点特定番号")
	private String splyPointIdntBn;
	
	/**
	 * 仕訳コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕訳コード", required = false, position = 4)
	@JsonProperty("仕訳コード")
	private String jrnlCd;
	
	/**
	 * 託送対象年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "託送対象年月", required = true, position = 5)
	@JsonProperty("託送対象年月")
	private String csAplyYm;
	
	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約番号", required = true, position = 6)
	@JsonProperty("契約番号")
	private String ctctBn;
	
	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算対象年月", required = true, position = 7)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;
	
	/**
	 * 計器管理番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "計器管理番号", required = false, position = 8)
	@JsonProperty("計器管理番号")
	private String keikiMngBn;
	
	/**
	 * 計器区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "計器区分", required = false, position = 9)
	@JsonProperty("計器区分")
	private String keikiKbn;
	
	/**
	 * 乗率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "乗率", required = false, position = 10)
	@JsonProperty("乗率")
	private Long multiplFctr;
	
	/**
	 * 電力損失補正率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力損失補正率", required = false, position = 11)
	@JsonProperty("電力損失補正率")
	private BigDecimal elcLossCrctFct;
	
	/**
	 * 電力量損失補正率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力量損失補正率", required = false, position = 12)
	@JsonProperty("電力量損失補正率")
	private BigDecimal elcNumLossCrctFct;
	
	/**
	 * 最大需要電力
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "最大需要電力", required = false, position = 13)
	@JsonProperty("最大需要電力")
	private Long maxDmdElc;
	
	/**
	 * 最大需要電力当月指示数
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "最大需要電力当月指示数", required = false, position = 14)
	@JsonProperty("最大需要電力当月指示数")
	private BigDecimal maxDmdElcThsMnthIdctNuMm;
	
	/**
	 * 時間帯01_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t01_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯01_全日電力量前月指示数", required = false, position = 15)
	@JsonProperty("時間帯01_全日電力量前月指示数")
	private BigDecimal t01AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯01_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t01_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯01_全日電力量当月指示数", required = false, position = 16)
	@JsonProperty("時間帯01_全日電力量当月指示数")
	private BigDecimal t01AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯02_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t02_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯02_全日電力量前月指示数", required = false, position = 17)
	@JsonProperty("時間帯02_全日電力量前月指示数")
	private BigDecimal t02AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯02_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t02_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯02_全日電力量当月指示数", required = false, position = 18)
	@JsonProperty("時間帯02_全日電力量当月指示数")
	private BigDecimal t02AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯03_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t03_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯03_全日電力量前月指示数", required = false, position = 19)
	@JsonProperty("時間帯03_全日電力量前月指示数")
	private BigDecimal t03AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯03_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t03_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯03_全日電力量当月指示数", required = false, position = 20)
	@JsonProperty("時間帯03_全日電力量当月指示数")
	private BigDecimal t03AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯04_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t04_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯04_全日電力量前月指示数", required = false, position = 21)
	@JsonProperty("時間帯04_全日電力量前月指示数")
	private BigDecimal t04AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯04_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t04_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯04_全日電力量当月指示数", required = false, position = 22)
	@JsonProperty("時間帯04_全日電力量当月指示数")
	private BigDecimal t04AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯05_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t05_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯05_全日電力量前月指示数", required = false, position = 23)
	@JsonProperty("時間帯05_全日電力量前月指示数")
	private BigDecimal t05AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯05_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t05_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯05_全日電力量当月指示数", required = false, position = 24)
	@JsonProperty("時間帯05_全日電力量当月指示数")
	private BigDecimal t05AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯06_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t06_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯06_全日電力量前月指示数", required = false, position = 25)
	@JsonProperty("時間帯06_全日電力量前月指示数")
	private BigDecimal t06AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯06_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t06_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯06_全日電力量当月指示数", required = false, position = 26)
	@JsonProperty("時間帯06_全日電力量当月指示数")
	private BigDecimal t06AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯07_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t07_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯07_全日電力量前月指示数", required = false, position = 27)
	@JsonProperty("時間帯07_全日電力量前月指示数")
	private BigDecimal t07AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯07_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t07_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯07_全日電力量当月指示数", required = false, position = 28)
	@JsonProperty("時間帯07_全日電力量当月指示数")
	private BigDecimal t07AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯08_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t08_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯08_全日電力量前月指示数", required = false, position = 29)
	@JsonProperty("時間帯08_全日電力量前月指示数")
	private BigDecimal t08AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯08_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t08_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯08_全日電力量当月指示数", required = false, position = 30)
	@JsonProperty("時間帯08_全日電力量当月指示数")
	private BigDecimal t08AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯09_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t09_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯09_全日電力量前月指示数", required = false, position = 31)
	@JsonProperty("時間帯09_全日電力量前月指示数")
	private BigDecimal t09AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯09_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t09_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯09_全日電力量当月指示数", required = false, position = 32)
	@JsonProperty("時間帯09_全日電力量当月指示数")
	private BigDecimal t09AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯10_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t10_adays_elc_num_lst_mnth_idct_num")
	@ApiModelProperty(value = "時間帯10_全日電力量前月指示数", required = false, position = 33)
	@JsonProperty("時間帯10_全日電力量前月指示数")
	private BigDecimal t10AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯10_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t10_adays_elc_num_ths_mnth_idct_num")
	@ApiModelProperty(value = "時間帯10_全日電力量当月指示数", required = false, position = 34)
	@JsonProperty("時間帯10_全日電力量当月指示数")
	private BigDecimal t10AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 力測有効電量前月指示数
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力測有効電量前月指示数", required = false, position = 35)
	@JsonProperty("力測有効電量前月指示数")
	private BigDecimal pompMsrEfcElcNumLstMnthIdctNum;
	
	/**
	 * 力測有効電量当月指示数
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力測有効電量当月指示数", required = false, position = 36)
	@JsonProperty("力測有効電量当月指示数")
	private BigDecimal pompMsrEfcElcNumThsMnthIdctNum;
	
	/**
	 * 力測無効電量前月指示数
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力測無効電量前月指示数", required = false, position = 37)
	@JsonProperty("力測無効電量前月指示数")
	private BigDecimal pompMsrIvdElcNumLstMnthIdctNum;
	
	/**
	 * 力測無効電量当月指示数
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力測無効電量当月指示数", required = false, position = 38)
	@JsonProperty("力測無効電量当月指示数")
	private BigDecimal pompMsrIvdElcNumThsMnthIdctNum;
	
	/**
	 * 仕訳後最大需要電力
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕訳後最大需要電力", required = false, position = 39)
	@JsonProperty("仕訳後最大需要電力")
	private Long jrnlMaxDmdElc;
	
	/**
	 * 仕訳後力測有効電量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕訳後力測有効電量", required = false, position = 40)
	@JsonProperty("仕訳後力測有効電量")
	private Long jrnlPompMsrEfcElcNum;
	
	/**
	 * 仕訳後力測無効電量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕訳後力測無効電量", required = false, position = 41)
	@JsonProperty("仕訳後力測無効電量")
	private Long jrnlPompMsrIvdElcNum;
	
	/**
	 * 力測有効電力量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力測有効電力量", required = false, position = 42)
	@JsonProperty("力測有効電力量")
	private BigDecimal pompMsrEfcElcNum;
	
	/**
	 * 力測無効電力量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "力測無効電力量", required = false, position = 43)
	@JsonProperty("力測無効電力量")
	private BigDecimal pompMsrIvdElcNum;

}