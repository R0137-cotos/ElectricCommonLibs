package jp.co.ricoh.cotos.electriccommonlib.entity.nishiki;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 制限中止割引情報（高圧）
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "lim_dsc_info_high_volt")
public class LimDscInfoHighVolt extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lim_dsc_info_high_volt_seq")
	@SequenceGenerator(name = "lim_dsc_info_high_volt_seq", sequenceName = "lim_dsc_info_high_volt_seq", allocationSize = 1)
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
	 * 契約番号
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約番号", required = true, position = 3)
	@JsonProperty("契約番号")
	private String ctctBn;
	
	/**
	 * 料金計算対象年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金計算対象年月", required = true, position = 4)
	@JsonProperty("料金計算対象年月")
	private String feeClcYm;
	
	/**
	 * 料金メニューコード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "料金メニューコード", required = true, position = 5)
	@JsonProperty("料金メニューコード")
	private String feeMnuCd;
	
	/**
	 * 託送対象年月
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "託送対象年月", required = true, position = 6)
	@JsonProperty("託送対象年月")
	private String csAplyYm;
	
	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true, name = "sply_point_idnt_bn")
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 7)
	@JsonProperty("供給地点特定番号")
	private String splyPointIdntBn;
	
	/**
	 * 算定期間開始日
	 */
	@Column(nullable = true, name = "estm_str_date")
	@ApiModelProperty(value = "算定期間開始日", required = false, position = 8)
	@JsonProperty("算定期間開始日")
	private Long estmStrDate;
	
	/**
	 * 算定期間終了日
	 */
	@Column(nullable = true, name = "estm_end_date")
	@ApiModelProperty(value = "算定期間終了日", required = false, position = 9)
	@JsonProperty("算定期間終了日")
	private Long estmEndDate;
	
	/**
	 * 割引対象コード
	 */
	@Column(nullable = true, name = "dsc_obj_cd")
	@ApiModelProperty(value = "割引対象コード", required = false, position = 10)
	@JsonProperty("割引対象コード")
	private Long dscObjCd;
	
	/**
	 * 割引対象時間数
	 */
	@Column(nullable = true, name = "dsc_obj_time")
	@ApiModelProperty(value = "割引対象時間数", required = false, position = 11)
	@JsonProperty("割引対象時間数")
	private Long dscObjTime;
	
	/**
	 * 割引対象日数
	 */
	@Column(nullable = true, name = "dsc_obj_days")
	@ApiModelProperty(value = "割引対象日数", required = false, position = 12)
	@JsonProperty("割引対象日数")
	private Long dscObjDays;
	
	/**
	 * 制限中止割引額
	 */
	@Column(nullable = true, name = "lmt_dscntn_mny")
	@ApiModelProperty(value = "制限中止割引額", required = false, position = 13)
	@JsonProperty("制限中止割引額")
	private BigDecimal lmtDscntnMny;
	
}
