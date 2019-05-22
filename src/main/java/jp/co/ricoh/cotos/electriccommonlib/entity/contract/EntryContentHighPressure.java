package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentHighPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * お申込み内容(高圧)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "entry_content_high_pressure")
@CotosComplementTarget(entity = EntryContentHighPressure.class, repository = EntryContentHighPressureRepository.class)
public class EntryContentHighPressure extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_content_high_pressure_seq")
	@SequenceGenerator(name = "entry_content_high_pressure_seq", sequenceName = "entry_content_high_pressure_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 計量日(高圧)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "計量日(高圧)", required = false, position = 3, allowableValues = "range[0,99999]")
	private int measureDateHigh;

	/**
	 * 契約電力(高圧)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力(高圧)", required = false, position = 4, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractPowerHigh;

	/**
	 * 規模
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "規模", required = false, position = 5, allowableValues = "range[0,255]")
	private String scale;

	/**
	 * 力率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "力率", required = false, position = 6, allowableValues = "range[0.00,99999.99]")
	private BigDecimal powerRate;

	/**
	 * 負荷率
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 7, allowableValues = "range[0.00,99999.99]")
	private BigDecimal loadFactor;

	/**
	 * 予備線
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備線", required = false, position = 8, allowableValues = "range[0,9]")
	private Integer spareWireFlg;

	/**
	 * 予備電源
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "予備電源", required = false, position = 9, allowableValues = "range[0,9]")
	private Integer sparePowerFlg;

	/**
	 * アンシラリーサービス
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アンシラリーサービス", required = false, position = 10, allowableValues = "range[0,9]")
	private Integer ancillaryFlg;

	/**
	 * 蓄熱計量器継続
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "蓄熱計量器継続", required = false, position = 11, allowableValues = "range[0,9]")
	private Integer thermalStorageMeterFlg;

	/**
	 * 再エネ賦課金減免措置
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "再エネ賦課金減免措置", required = false, position = 12, allowableValues = "range[0,9]")
	private Integer renewableEnergyExemptionFlg;

	/**
	 * 需要地内転売契約
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "需要地内転売契約", required = false, position = 13, allowableValues = "range[0,9]")
	private Integer demandPlaceResales;

	/**
	 * 部分供給
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "部分供給", required = false, position = 14, allowableValues = "range[0,9]")
	private Integer partialSupplyFlg;

	/**
	 * その他
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "その他", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer otherFlg;

	/**
	 * 部分供給 設定値
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "部分供給 設定値", required = false, position = 16, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal partialSupplySettingValue;

	/**
	 * ベース部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "ベース部", required = false, position = 17, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal base;

	/**
	 * 変動部
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "変動部", required = false, position = 18, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal variable;
}
