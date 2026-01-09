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

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract.ContractType;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceHighPressureForUpdateRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * [更新用]単価情報（高圧）を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "unit_price_high_pressure_for_update")
@CotosComplementTarget(entity = UnitPriceHighPressureForUpdate.class, repository = UnitPriceHighPressureForUpdateRepository.class)
public class UnitPriceHighPressureForUpdate extends EntityBase {

	@Id
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 契約(電力用)Id
	 */
	@Column(nullable = true)
	@Schema(description = "契約(電力用)ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long contractElectricId;

	/**
	 * COTOS契約番号
	 */
	@Column(nullable = true)
	@Schema(description = "COTOS契約番号", requiredMode = Schema.RequiredMode.REQUIRED)
	private String contractNumber;

	/**
	 * RAIDEN案件番号
	 */
	@Column(nullable = true)
	@Schema(description = "RAIDEN案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String caseNumber;

	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String feedPointNumber;

	/**
	 * 契約状態
	 */
	@Column(nullable = true)
	@Schema(description = "契約状態", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String contractStatus;

	/**
	 * 契約種別
	 */
	@Column(nullable = true)
	@Schema(description = "契約種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ContractType contractType;

	/**
	 * 企業名
	 */
	@Column(nullable = true)
	@Schema(description = "企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String conpanyName;

	/**
	 * 商流区分
	 */
	@Column(nullable = true)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricCommercialFlowDiv electricCommercialFlow;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String powerCompany;

	/**
	 * メニュー名
	 */
	@Column(nullable = true)
	@Schema(description = "メニュー名", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String electricMenu;

	/**
	 * 電力メニューコード
	 */
	@Column(nullable = true)
	@Schema(description = "電力メニューコード", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String electricMenuCode;

	/**
	 * 需給期間 開始日
	 */
	@Column(nullable = true)
	@Schema(description = "需給期間 開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String contractYmdStart;

	/**
	 * 需給期間 終了日
	 */
	@Column(nullable = true)
	@Schema(description = "需給期間 終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private String contractYmdEnd;

	/**
	 * 単価種別
	 */
	@Column(nullable = false)
	@Schema(description = "単価種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "単価(\"1\"), 仕切価格(営業)(\"2\"), 仕切価格(RJ)(\"3\")", example = "1")
	private UnitPriceType unitPriceType;

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
	 * 従量料金_夏季
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_夏季", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeSummerPrice;

	/**
	 * 従量料金_その他季
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "従量料金_その他季", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonPrice;

	/**
	 * オプション_予備線
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal spareLinePrice;

	/**
	 * オプション_予備電源
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_予備線", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal sparePowerPrice;

	/**
	 * オプション_アンシラリー
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "オプション_アンシラリー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal ancillaryPrice;

	/**
	 * 適用日
	 */
	@Column(nullable = true)
	@Schema(description = "適用日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date priceLastModified;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notes;

}
