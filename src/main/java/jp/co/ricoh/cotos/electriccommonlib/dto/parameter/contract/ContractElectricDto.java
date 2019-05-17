package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric.CurrentElectricCompanyDiv;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricDto extends DtoBase {

	/**
	 * 契約
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "契約ID", required = true, position = 2, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

	/**
	 * SIM番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号", required = false, position = 3, allowableValues = "range[0,255]")
	private String simNumber;

	/**
	 * 申込番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "申込番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * お客様識別番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 6, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 仕入元拠点ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "仕入元拠点ID", required = false, position = 7, allowableValues = "range[0,255]")
	private String supplierCustId;

	/**
	 * ご契約者名(法人名)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名(法人名)", required = false, position = 8, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名(カナ)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名(カナ)", required = false, position = 9, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 簡略名称
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "簡略名称", required = false, position = 10, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * メール配信
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "メール配信", required = true, position = 11, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "郵便番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 都道府県
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "都道府県", required = false, position = 13, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 市区町村
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "市区町村", required = false, position = 14, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 番地
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "番地", required = false, position = 15, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 建物名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "建物名", required = false, position = 16, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電話番号", required = false, position = 17, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "旧契約名義", required = false, position = 18, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "旧需要場所", required = false, position = 19, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 電気主任技術者
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者", required = false, position = 21, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 電話番号", required = false, position = 22, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 所属名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 所属名", required = false, position = 23, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 現在の電力会社
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の電力会社", required = false, position = 24, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 現在の契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の契約番号", required = false, position = 25, allowableValues = "range[0,255]")
	private String currentContractNumber;

	/**
	 * 現在の契約番号 その他
	 */

	/**
	 * 申込日
	 */
	@ApiModelProperty(value = "申込日", required = false, position = 26)
	@Temporal(TemporalType.DATE)
	private Date entryDate;

	/**
	 * 変更希望日
	 */
	@ApiModelProperty(value = "変更希望日", required = false, position = 27)
	@Temporal(TemporalType.DATE)
	private Date changeHopeDate;

	/**
	 * 電力エリア
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力エリア", required = false, position = 28, allowableValues = "range[0,255]")
	private String powerArea;

	/**
	 * 電力会社
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社", required = false, position = 29, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電源サイクル
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電源サイクル", required = false, position = 30, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 需要(供給)期間 開始日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需要(供給)期間　開始日", required = false, position = 31)
	@Temporal(TemporalType.DATE)
	private Date contractYmdStart;

	/**
	 * 需要(供給)期間 終了日
	 */
	@ApiModelProperty(value = "需要(供給)期間　終了日", required = false, position = 32)
	@Temporal(TemporalType.DATE)
	private Date contractYmdEnd;

	/**
	 * 供給開始月
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "供給開始月", required = false, position = 33, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 契約開始日
	 */
	@ApiModelProperty(value = "契約開始日", required = false, position = 34)
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;

	/**
	 * 電力区分
	 */
	@NotNull
	@ApiModelProperty(value = "電力区分", required = true, position = 35, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニュー", required = false, position = 36, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約数量
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "契約数量", required = false, position = 37, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "振込フラグチェック(業務区)", required = false, position = 38, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "原子力立地給付金フラグ", required = false, position = 39, allowableValues = "range[0,9]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "備考", required = false, position = 40, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 外部キー情報
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "外部キー情報", required = false, position = 41, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "NISHIKI契約番号", required = false, position = 42, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 需要家番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "需要家番号", required = false, position = 43, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * お申込み内容(高圧)
	 */
	@OneToOne(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "お申込み内容(高圧)", required = false, position = 44)
	private EntryContentHighPressureDto entryContentHighPressureDto;

	/**
	 * お申込み内容(低圧)
	 */
	@OneToOne(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "お申込み内容(低圧)", required = false, position = 45)
	private EntryContentLowPressureDto entryContentLowPressureDto;

	/**
	 * 解約情報
	 */
	@OneToOne(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "解約情報", required = false, position = 46)
	private CancellationInformationDto cancellationInformationDto;

	/**
	 * 電力専任情報
	 */
	@NotNull
	@OneToOne(mappedBy = "contractElectricDto", optional = false)
	@ApiModelProperty(value = "電力専任情報", required = true, position = 47)
	private ElectricExpertContractDto electricExpertContractDto;

	/**
	 * 販売店情報
	 */
	@OneToOne(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "販売店情報", required = false, position = 48)
	private ElectricDealerContractDto electricDealerContractDto;

	/**
	 * Mailアドレス情報
	 */
	@OneToMany(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "Mailアドレス情報", required = false, position = 49)
	private List<MailAddressInformationDto> mailAddressInformationDtoList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@OneToMany(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "契約(電力)添付ファイル", required = false, position = 50)
	private List<ContractElectricAttachedFileDto> contractElectricAttachedFileDtoList;

	/**
	 * 単価情報(高圧)
	 */
	@OneToMany(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "単価情報(高圧)", required = false, position = 51)
	private List<UnitPriceHighPressureDto> unitPriceHighPressureDtoList;

	/**
	 * 単価情報(低圧)
	 */
	@OneToMany(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "単価情報(低圧)", required = false, position = 52)
	private List<UnitPriceLowPressureDto> unitPriceLowPressureDtoList;

	/**
	 * 得意先情報
	 */
	@OneToMany(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "得意先情報", required = false, position = 53)
	private List<ClientInformationDto> clientInformationDtoList;

	/**
	 * 商流区分
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "商流区分", required = true, position = 54, allowableValues = "直売(\"1\"), 代売(\"2\"), 社内(\"3\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 現在の電力会社種別
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の電力会社種別", required = false, position = 55, allowableValues = "種別1(\"1\")", example = "1")
	private CurrentElectricCompanyDiv currentElectricCompanyDiv;

	/**
	 * 品種コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "品種コード", required = false, position = 56, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 請求開始月
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求開始月", required = false, position = 57, allowableValues = "range[0,255]")
	private String billingStartMonth;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Size(max = 255)
	@Column(name = "co2_emission_menu")
	@ApiModelProperty(value = "CO2排出メニュー", required = false, position = 58, allowableValues = "range[0,255]")
	private String co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 59, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 60, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 重要事項説明者
	 */
	@OneToOne(mappedBy = "contractElectricDto")
	@ApiModelProperty(value = "重要事項説明者", required = false, position = 61)
	private ImportantPointExplainerDto importantPointExplainerDto;
}
