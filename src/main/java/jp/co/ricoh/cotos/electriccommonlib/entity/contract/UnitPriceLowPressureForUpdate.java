package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.ContractType;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceLowPressureForUpdateRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * [更新用]単価情報（低圧）を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "unit_price_low_pressure_for_update")
@CotosComplementTarget(entity = UnitPriceLowPressureForUpdate.class, repository = UnitPriceLowPressureForUpdateRepository.class)
public class UnitPriceLowPressureForUpdate extends EntityBase {

	@Id
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 契約(電力用)Id
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約(電力用)ID", required = false, position = 2)
	private Long contractElectricId;

	/**
	 * COTOS契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "COTOS契約番号", required = true, position = 3)
	private String contractNumber;

	/**
	 * RAIDEN案件番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "RAIDEN案件番号", required = false, position = 4)
	private String caseNumber;

	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 5)
	private String feedPointNumber;

	/**
	 * 契約状態
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約状態", required = false, position = 6)
	private String contractStatus;

	/**
	 * 契約種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約種別", required = false, position = 7)
	private ContractType contractType;

	/**
	 * 企業名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企業名", required = false, position = 8)
	private String conpanyName;

	/**
	 * 商流区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商流区分", required = false, position = 9)
	private ElectricCommercialFlowDiv electricCommercialFlow;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社", required = false, position = 10)
	private String powerCompany;

	/**
	 * メニュー名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メニュー名", required = false, position = 11)
	private String electricMenu;

	/**
	 * 電力メニューコード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力メニューコード", required = false, position = 12)
	private String electricMenuCode;

	/**
	 * 需給期間 開始日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需給期間 開始日", required = false, position = 13)
	private String contractYmdStart;

	/**
	 * 需給期間 終了日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需給期間 終了日", required = false, position = 14)
	private String contractYmdEnd;

	/**
	 * 単価種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "単価種別", required = true, position = 15, allowableValues = "単価(\"1\"), 仕切価格(営業)(\"2\"), 仕切価格(RJ)(\"3\")", example = "1")
	private UnitPriceType unitPriceType;

	/**
	 * 従量料金(従量電灯)_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_定価", required = false, position = 16, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal perUseLightListPrice;

	/**
	 * 従量料金(従量電灯)_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "従量料金(従量電灯)_売価", required = false, position = 17, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal perUseLightSellingPrice;

	/**
	 * 従量料金(動力)_夏季_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_定価", required = false, position = 18, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerListPrice;

	/**
	 * 従量料金(動力)_夏季_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_夏季_売価", required = false, position = 19, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金(動力)_その他季_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他季_定価", required = false, position = 20, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonListPrice;

	/**
	 * 従量料金(動力)_その他季_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "従量料金(動力)_その他夏季_売価", required = false, position = 21, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * 基本料金_定価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "基本料金_定価", required = false, position = 22, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicListPrice;

	/**
	 * 基本料金_売価
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "基本料金_売価", required = false, position = 23, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal basicSellingPrice;

	/**
	 * 適用日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "適用日", required = false, position = 24)
	@Temporal(TemporalType.DATE)
	private Date priceLastModified;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "備考", required = false, position = 25, allowableValues = "range[0,4000]")
	private String notes;

}
