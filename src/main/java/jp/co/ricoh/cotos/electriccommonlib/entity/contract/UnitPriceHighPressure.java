package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 単価情報(高圧)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "unit_price_high_pressure")
public class UnitPriceHighPressure extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_price_high_pressure_seq")
	@SequenceGenerator(name = "unit_price_high_pressure_seq", sequenceName = "unit_price_high_pressure_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 単価種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "単価種別", required = true, position = 3, allowableValues = "単価(\"1\"), 仕切価格(営業)(\"2\"), 仕切価格(RJ)(\"3\")", example = "1")
	private UnitPriceType unitPriceType;

	/**
	 * 変更回数
	 */
	@Column(nullable = true)
	@Max(99999)
	@Min(0)
	@ApiModelProperty(value = "変更回数", required = false, position = 4, allowableValues = "range[0,99999]")
	private Integer numberOfChanges;

	/**
	 * 基本料金_定額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_定額", required = false, position = 5, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicListPrice;

	/**
	 * 基本料金_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = false, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicSellingPrice;

	/**
	 * 従量料金_夏季
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_夏季", required = false, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerPrice;

	/**
	 * 従量料金_その他季
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金_その他季", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonPrice;

	/**
	 * オプション_予備線
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLinePrice;

	/**
	 * オプション_予備電源
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_予備線", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerPrice;

	/**
	 * オプション_アンシラリー
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "オプション_アンシラリー", required = false, position = 11, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillaryPrice;

	/**
	 * 登録者名
	 */
}
