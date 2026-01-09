package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 単価種別
	 */
	@Column(nullable = false)
	@Schema(description = "単価種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "単価(\"1\"), 仕切価格(営業)(\"2\"), 仕切価格(RJ)(\"3\")", example = "1")
	private UnitPriceType unitPriceType;

	/**
	 * 変更回数
	 */
	@Column(nullable = true)
	@Max(99999)
	@Min(0)
	@Schema(description = "変更回数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Integer numberOfChanges;

	/**
	 * 従量料金(従量電灯)_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal perUseLightListPrice;

	/**
	 * 従量料金(従量電灯)_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金(従量電灯)_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal perUseLightSellingPrice;

	/**
	 * 従量料金(動力)_夏季_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金(動力)_夏季_定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerListPrice;

	/**
	 * 従量料金(動力)_夏季_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金(動力)_夏季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金(動力)_その他季_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金(動力)_その他季_定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonListPrice;

	/**
	 * 従量料金(動力)_その他季_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金(動力)_その他夏季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 登録者名
	 */
	@Column(nullable = true)
	@Schema(description = "登録者名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String createdUserName;

	/**
	 * 基本料金_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_定価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicListPrice;

	/**
	 * 基本料金_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "基本料金_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicSellingPrice;

	/**
	 * 作成日
	 */
	@Column(nullable = true)
	@Schema(description = "作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date createdDate;
}
