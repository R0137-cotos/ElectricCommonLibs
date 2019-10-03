package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricCreateExtDto {

	/**
	 * RAIDEN外部キー情報
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "RAIDEN外部キー情報", required = true, position = 1, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * SIM番号(主)
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(主)", required = true, position = 2, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(従)", required = true, position = 3, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * 申込番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "申込番号", required = true, position = 4, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * ご契約者名（法人名）
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名（法人名）", required = false, position = 5, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名（カナ）
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名（カナ）", required = false, position = 6, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 使用場所 郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　郵便番号", required = false, position = 7, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 使用場所 都道府県
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　都道府県", required = false, position = 8, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 使用場所 市区町村
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　市区町村", required = false, position = 9, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 使用場所 番地
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　番地", required = false, position = 10, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 使用場所 建物名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　建物名", required = false, position = 11, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 使用場所 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　電話番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "旧契約名義", required = false, position = 13, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "旧需要場所", required = false, position = 14, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 現在の電力会社種別
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の電力会社種別", required = false, position = 15, allowableValues = "range[0,255]")
	private String currentElectricCompanyDiv;

	/**
	 * 現在の電力会社
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の電力会社", required = false, position = 16, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 現在の契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の契約番号", required = false, position = 17, allowableValues = "range[0,255]")
	private String currentContractNumber;

	/**
	 * 申込日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "申込日", required = false, position = 18, allowableValues = "range[0,255]")
	private String entryDate;

	/**
	 * 商流区分
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分", required = true, position = 19, allowableValues = "range[0,255]")
	private String electricCommercialFlowDiv;

	/**
	 * 商流区分コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分コード", required = true, position = 20, allowableValues = "range[0,255]")
	private String electricCommercialFlowDivCd;

	/**
	 * 電力エリア
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力エリア", required = false, position = 21, allowableValues = "range[0,255]")
	private String powerArea;

	/**
	 * 電力会社
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社", required = true, position = 22, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電力会社コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = true, position = 23, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力区分
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力区分", required = true, position = 24, allowableValues = "range[0,255]")
	private String voltageCategory;

	/**
	 * 電力メニュー
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニュー", required = true, position = 25, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 電力メニューコード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニューコード", required = true, position = 26, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 品種コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "品種コード", required = true, position = 27, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 電源サイクル
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電源サイクル", required = false, position = 28, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 契約数量
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "契約数量", required = false, position = 29, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 供給開始予定日
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "供給開始予定日", required = true, position = 30, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**
	 * 契約容量(従量電灯)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約容量(従量電灯)", required = false, position = 31, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電流", required = false, position = 32, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力(動力)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力(動力)", required = false, position = 33, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 契約単位
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "契約単位", required = true, position = 34, allowableValues = "range[0,255]")
	private String contractUnit;

	/**
	 * 負荷率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = false, position = 35, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "基本検針日(低圧)", required = false, position = 36, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

	/**
	 * 修正時振替先コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "修正時振替先コード", required = false, position = 37, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * ご契約者情報 供給地点特定番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者情報　供給地点特定番号", required = false, position = 38, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * ご契約者情報 簡略名称
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者情報　簡略名称", required = false, position = 39, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * 電気主任技術者 - 氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 氏名", required = false, position = 40, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 - 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 電話番号", required = false, position = 41, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 - 所属名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 所属名", required = false, position = 42, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 供給開始月
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "供給開始月", required = false, position = 43, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "振込フラグチェック(業務区)", required = false, position = 44, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 契約期間
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "契約期間", required = true, position = 45, allowableValues = "range[0,255]")
	private String contractPeriod;

}
