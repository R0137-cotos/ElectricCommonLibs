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

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private long id;

	/**
	 * 全体番号
	 */
	@Column(nullable = false)
	@Schema(description = "全体番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("全体番号")
	private String feeClcAllBn;
	
	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = false)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("供給地点特定番号")
	private String splyPointIdntBn;
	
	/**
	 * 仕訳コード
	 */
	@Column(nullable = true)
	@Schema(description = "仕訳コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("仕訳コード")
	private String jrnlCd;
	
	/**
	 * 託送対象年月
	 */
	@Column(nullable = false)
	@Schema(description = "託送対象年月", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("託送対象年月")
	private String csAplyYm;
	
	/**
	 * 契約番号
	 */
	@Column(nullable = false)
	@Schema(description = "契約番号", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("契約番号")
	private String ctctBn;
	
	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@Schema(description = "料金計算対象年月", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;
	
	/**
	 * 計器管理番号
	 */
	@Column(nullable = true)
	@Schema(description = "計器管理番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("計器管理番号")
	private String keikiMngBn;
	
	/**
	 * 計器区分
	 */
	@Column(nullable = true)
	@Schema(description = "計器区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("計器区分")
	private String keikiKbn;
	
	/**
	 * 乗率
	 */
	@Column(nullable = true)
	@Schema(description = "乗率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("乗率")
	private Long multiplFctr;
	
	/**
	 * 電力損失補正率
	 */
	@Column(nullable = true)
	@Schema(description = "電力損失補正率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("電力損失補正率")
	private BigDecimal elcLossCrctFct;
	
	/**
	 * 電力量損失補正率
	 */
	@Column(nullable = true)
	@Schema(description = "電力量損失補正率", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("電力量損失補正率")
	private BigDecimal elcNumLossCrctFct;
	
	/**
	 * 最大需要電力
	 */
	@Column(nullable = true)
	@Schema(description = "最大需要電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("最大需要電力")
	private Long maxDmdElc;
	
	/**
	 * 最大需要電力当月指示数
	 */
	@Column(nullable = true)
	@Schema(description = "最大需要電力当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("最大需要電力当月指示数")
	private BigDecimal maxDmdElcThsMnthIdctNuMm;
	
	/**
	 * 時間帯01_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t01_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯01_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯01_全日電力量前月指示数")
	private BigDecimal t01AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯01_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t01_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯01_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯01_全日電力量当月指示数")
	private BigDecimal t01AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯02_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t02_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯02_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯02_全日電力量前月指示数")
	private BigDecimal t02AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯02_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t02_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯02_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯02_全日電力量当月指示数")
	private BigDecimal t02AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯03_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t03_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯03_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯03_全日電力量前月指示数")
	private BigDecimal t03AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯03_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t03_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯03_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯03_全日電力量当月指示数")
	private BigDecimal t03AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯04_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t04_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯04_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯04_全日電力量前月指示数")
	private BigDecimal t04AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯04_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t04_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯04_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯04_全日電力量当月指示数")
	private BigDecimal t04AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯05_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t05_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯05_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯05_全日電力量前月指示数")
	private BigDecimal t05AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯05_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t05_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯05_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯05_全日電力量当月指示数")
	private BigDecimal t05AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯06_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t06_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯06_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯06_全日電力量前月指示数")
	private BigDecimal t06AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯06_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t06_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯06_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯06_全日電力量当月指示数")
	private BigDecimal t06AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯07_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t07_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯07_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯07_全日電力量前月指示数")
	private BigDecimal t07AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯07_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t07_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯07_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯07_全日電力量当月指示数")
	private BigDecimal t07AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯08_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t08_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯08_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯08_全日電力量前月指示数")
	private BigDecimal t08AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯08_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t08_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯08_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯08_全日電力量当月指示数")
	private BigDecimal t08AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯09_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t09_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯09_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯09_全日電力量前月指示数")
	private BigDecimal t09AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯09_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t09_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯09_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯09_全日電力量当月指示数")
	private BigDecimal t09AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 時間帯10_全日電力量前月指示数
	 */
	@Column(nullable = true, name = "t10_adays_elc_num_lst_mnth_idct_num")
	@Schema(description = "時間帯10_全日電力量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯10_全日電力量前月指示数")
	private BigDecimal t10AdaysElcNumLstMnthIdctNum;
	
	/**
	 * 時間帯10_全日電力量当月指示数
	 */
	@Column(nullable = true, name = "t10_adays_elc_num_ths_mnth_idct_num")
	@Schema(description = "時間帯10_全日電力量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("時間帯10_全日電力量当月指示数")
	private BigDecimal t10AdaysElcNumThsMnthIdctNum;
	
	/**
	 * 力測有効電量前月指示数
	 */
	@Column(nullable = true)
	@Schema(description = "力測有効電量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力測有効電量前月指示数")
	private BigDecimal pompMsrEfcElcNumLstMnthIdctNum;
	
	/**
	 * 力測有効電量当月指示数
	 */
	@Column(nullable = true)
	@Schema(description = "力測有効電量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力測有効電量当月指示数")
	private BigDecimal pompMsrEfcElcNumThsMnthIdctNum;
	
	/**
	 * 力測無効電量前月指示数
	 */
	@Column(nullable = true)
	@Schema(description = "力測無効電量前月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力測無効電量前月指示数")
	private BigDecimal pompMsrIvdElcNumLstMnthIdctNum;
	
	/**
	 * 力測無効電量当月指示数
	 */
	@Column(nullable = true)
	@Schema(description = "力測無効電量当月指示数", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力測無効電量当月指示数")
	private BigDecimal pompMsrIvdElcNumThsMnthIdctNum;
	
	/**
	 * 仕訳後最大需要電力
	 */
	@Column(nullable = true)
	@Schema(description = "仕訳後最大需要電力", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("仕訳後最大需要電力")
	private Long jrnlMaxDmdElc;
	
	/**
	 * 仕訳後力測有効電量
	 */
	@Column(nullable = true)
	@Schema(description = "仕訳後力測有効電量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("仕訳後力測有効電量")
	private Long jrnlPompMsrEfcElcNum;
	
	/**
	 * 仕訳後力測無効電量
	 */
	@Column(nullable = true)
	@Schema(description = "仕訳後力測無効電量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("仕訳後力測無効電量")
	private Long jrnlPompMsrIvdElcNum;
	
	/**
	 * 力測有効電力量
	 */
	@Column(nullable = true)
	@Schema(description = "力測有効電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力測有効電力量")
	private BigDecimal pompMsrEfcElcNum;
	
	/**
	 * 力測無効電力量
	 */
	@Column(nullable = true)
	@Schema(description = "力測無効電力量", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("力測無効電力量")
	private BigDecimal pompMsrIvdElcNum;

}