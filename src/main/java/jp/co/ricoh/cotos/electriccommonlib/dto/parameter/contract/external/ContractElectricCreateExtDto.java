package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
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
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名（法人名）", required = true, position = 5, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名（カナ）
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名（カナ）", required = true, position = 6, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 使用場所 郵便番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　郵便番号", required = true, position = 7, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 使用場所 都道府県
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　都道府県", required = true, position = 8, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 使用場所 市区町村
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　市区町村", required = true, position = 9, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 使用場所 番地
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　番地", required = true, position = 10, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 使用場所 建物名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　建物名", required = true, position = 11, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 使用場所 電話番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　電話番号", required = true, position = 12, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "旧契約名義", required = true, position = 13, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "旧需要場所", required = true, position = 14, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 現在の電力会社
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "現在の電力会社", required = true, position = 15, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 申込日
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "申込日", required = true, position = 16, allowableValues = "range[0,255]")
	private String entryDate;

	/**
	 * 商流区分
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分", required = true, position = 17, allowableValues = "range[0,255]")
	private String electricCommercialFlowDiv;

	/**
	 * 商流区分コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分コード", required = true, position = 18, allowableValues = "range[0,255]")
	private String electricCommercialFlowDivCd;

	/**
	 * 電力エリア
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力エリア", required = true, position = 19, allowableValues = "range[0,255]")
	private String powerArea;

	/**
	 * 電力会社
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社", required = true, position = 20, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電力会社コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = true, position = 21, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力区分
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力区分", required = true, position = 22, allowableValues = "range[0,255]")
	private String voltageCategory;

	/**
	 * 電力メニュー
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニュー", required = true, position = 23, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 電力メニューコード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニューコード", required = true, position = 24, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * CO2排出メニュー
	 */
	@Column(name = "co2_emission_menu")
	@ApiModelProperty(value = "CO2排出メニュー", required = true, position = 25, allowableValues = "range[0,255]")
	private ElectricPlan co2EmissionMenu;

	/**
	 * CO2排出係数
	 */
	@Size(max = 255)
	@Column(name = "co2_emission_factor")
	@ApiModelProperty(value = "CO2排出係数", required = true, position = 26, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

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
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電源サイクル", required = true, position = 28, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 契約数量
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "契約数量", required = true, position = 29, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 契約容量(従量電灯)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約容量(従量電灯)", required = true, position = 30, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電流", required = true, position = 31, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力(動力)
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力(動力)", required = true, position = 32, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 契約単位
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "契約単位", required = true, position = 33, allowableValues = "range[0,255]")
	private String contractUnit;

	/**
	 * 負荷率
	 */
	@NotNull
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "負荷率", required = true, position = 34, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal loadFactor;

	/**
	 * 基本検針日(低圧)
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "基本検針日(低圧)", required = true, position = 35, allowableValues = "range[0,255]")
	private String basicMeterReadingDate;

	/**
	 * 修正時振替先コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "修正時振替先コード", required = true, position = 36, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * ご契約者情報 供給地点特定番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者情報　供給地点特定番号", required = true, position = 37, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * ご契約者情報 簡略名称
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者情報　簡略名称", required = true, position = 38, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * 電気主任技術者 - 氏名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 氏名", required = true, position = 39, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 - 電話番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 電話番号", required = true, position = 40, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 - 所属名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 所属名", required = true, position = 41, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 需要(供給)期間 開始日
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "需要(供給)期間　開始日", required = true, position = 42, allowableValues = "range[0,255]")
	private String contractYmdStart;

	/**
	 * 供給開始月
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "供給開始月", required = true, position = 43, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 請求書発送区分
	 */
	@NotNull
	@ApiModelProperty(value = "請求書発送区分", required = true, position = 44, allowableValues = "range[0,255]")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@NotNull
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "振込フラグチェック(業務区)", required = true, position = 45, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 現在の契約番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "現在の契約番号", required = true, position = 46, allowableValues = "range[0,255]")
	private String currentContractNumber;

}
