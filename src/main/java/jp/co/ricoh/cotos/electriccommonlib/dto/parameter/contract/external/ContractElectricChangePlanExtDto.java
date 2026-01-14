package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricChangePlanExtDto {

	/**
	 * RAIDEN外部キー情報
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "RAIDEN外部キー情報", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * SIM番号(主)
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "SIM番号(主)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "SIM番号(従)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * 申込番号
	 */
	@Size(max = 255)
	@Schema(description = "申込番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * ご契約者名（法人名）
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者名（法人名）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名（カナ）
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者名（カナ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 使用場所 郵便番号
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 使用場所 都道府県
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　都道府県", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 使用場所 市区町村
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　市区町村", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 使用場所 番地
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　番地", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 使用場所 建物名
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　建物名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 使用場所 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@Size(max = 255)
	@Schema(description = "旧契約名義", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@Size(max = 255)
	@Schema(description = "旧需要場所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 現在の電力会社
	 */
	@Size(max = 255)
	@Schema(description = "現在の電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 現在の契約番号
	 */
	@Size(max = 255)
	@Schema(description = "現在の契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String currentContractNumber;

	/**
	 * 申込日
	 */
	@Size(max = 255)
	@Schema(description = "申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String entryDate;

	/**
	 * 商流区分
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCommercialFlowDiv;

	/**
	 * 商流区分コード
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "商流区分コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCommercialFlowDivCode;

	/**
	 * 電力エリア
	 */
	@Size(max = 255)
	@Schema(description = "電力エリア", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerArea;

	/**
	 * 電力会社
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電力会社コード
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力区分
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String voltageCategory;

	/**
	 * 電力メニュー
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 電力メニューコード
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "電力メニューコード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 品種コード
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "品種コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 電源サイクル
	 */
	@Size(max = 255)
	@Schema(description = "電源サイクル", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 契約数量
	 */
	@Size(max = 255)
	@Schema(description = "契約数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 供給開始予定日
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "供給開始予定日", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**
	 * 契約容量(従量電灯)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約容量(従量電灯)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電流", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力(動力)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電力(動力)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 契約単位
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "契約単位", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String contractUnit;

	/**
	 * 負荷率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "負荷率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "基本検針日(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

	/**
	 * 修正時振替先コード
	 */
	@Size(max = 255)
	@Schema(description = "修正時振替先コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * ご契約者情報 供給地点特定番号
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者情報　供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * ご契約者情報 簡略名称
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者情報　簡略名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * 電気主任技術者 - 氏名
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 - 氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 - 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 - 電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 - 所属名
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 - 所属名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "振込フラグチェック(業務区)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 契約期間
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "契約期間", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String contractPeriod;

}
