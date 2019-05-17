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
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceLowPressureRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 単価情報(低圧)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "unit_price_low_pressure")
@CotosComplementTarget(entity = UnitPriceLowPressure.class, repository = UnitPriceLowPressureRepository.class)
public class UnitPriceLowPressure extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_price_low_pressure_seq")
	@SequenceGenerator(name = "unit_price_low_pressure_seq", sequenceName = "unit_price_low_pressure_seq", allocationSize = 1)
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
	 * 基本料金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "基本料金", required = false, position = 5, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicCharge;

	/**
	 * 従量料金(従量電灯)_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_定価", required = false, position = 6, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightListPrice;

	/**
	 * 従量料金(従量電灯)_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_売価", required = false, position = 7, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal perUseLightSellingPrice;

	/**
	 * 従量料金(動力)_夏季_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_定価", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerListPrice;

	/**
	 * 従量料金(動力)_夏季_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_売価", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金(動力)_その他季_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他季_定価", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonListPrice;

	/**
	 * 従量料金(動力)_その他季_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他夏季_売価", required = false, position = 11, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;
	
	/**
	 * 登録者名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "登録者名", required = false, position = 12, allowableValues = "range[0,255]")
	private String createdUserName;
}
