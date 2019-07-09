package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.CommissionMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 媒介手数料マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "commission_master")
@CotosComplementTarget(entity = CommissionMaster.class, repository = CommissionMasterRepository.class)
public class CommissionMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commission_master_seq")
	@SequenceGenerator(name = "commission_master_seq", sequenceName = "commission_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力区分", required = true, position = 2, allowableValues = "range[0,255]")
	@JsonProperty("DNRYK_KBN")
	private String dnrykKbn;

	/**
	 * 管轄地域電力会社コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "管轄地域電力会社コード", required = true, position = 3, allowableValues = "range[0,255]")
	@JsonProperty("KNKTTIK_DNRYKKISH_CD")
	private String knkttikDnrykkishCd;

	/**
	 * 想定年間電力料金(From)
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "想定年間電力料金(From)", required = true, position = 4, allowableValues = "range[0,99999999999]")
	@JsonProperty("SUTI_NNKN_DNRYK_RYUKN_FROM")
	private Long sutiNnknDnrykRyuknFrom;

	/**
	 * 想定年間電力料金(To)
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "想定年間電力料金(To)", required = true, position = 5, allowableValues = "range[0,99999999999]")
	@JsonProperty("SUTI_NNKN_DNRYK_RYUKN_TO")
	private Long sutiNnknDnrykRyuknTo;

	/**
	 * 媒介手数料額
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "媒介手数料額", required = false, position = 6, allowableValues = "range[0,99999999999]")
	@JsonProperty("BIKI_TSURYU_GK")
	private Long bikiTsuryuGk;

	/**
	 * 適用開始年月日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "適用開始年月日", required = false, position = 7, allowableValues = "range[0,255]")
	@JsonProperty("TKYU_KISH_YMD")
	private String tkyuKishYmd;

	/**
	 * 適用終了年月日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "適用終了年月日", required = false, position = 8, allowableValues = "range[0,255]")
	@JsonProperty("TKYU_SHURYU_YMD")
	private String tkyuShuryuYmd;

}
