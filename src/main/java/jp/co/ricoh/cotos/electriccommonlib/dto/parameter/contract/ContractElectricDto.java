package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricArea;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.RequiredIndicationDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric.CurrentElectricCompanyDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ContractElectric.class, repository = ContractElectricRepository.class)
public class ContractElectricDto extends DtoBase {

	/**
	 * 契約
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "契約ID", required = true, position = 2, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

	/**
	 * 申込番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "申込番号", required = false, position = 3, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * お客様識別番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 仕入元拠点ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "仕入元拠点ID", required = false, position = 6, allowableValues = "range[0,255]")
	private String supplierCustId;

	/**
	 * ご契約者名(法人名)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名(法人名)", required = false, position = 7, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名(カナ)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名(カナ)", required = false, position = 8, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 簡略名称
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "簡略名称", required = false, position = 9, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * メール配信
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "メール配信", required = true, position = 10, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "郵便番号", required = false, position = 11, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 都道府県
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "都道府県", required = false, position = 12, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 市区町村
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "市区町村", required = false, position = 13, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 番地
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "番地", required = false, position = 14, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 建物名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "建物名", required = false, position = 15, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電話番号", required = false, position = 16, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "旧契約名義", required = false, position = 17, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "旧需要場所", required = false, position = 18, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 電気主任技術者
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者", required = false, position = 19, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 電話番号", required = false, position = 20, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 所属名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 所属名", required = false, position = 21, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 現在の電力会社
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の電力会社", required = false, position = 22, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 現在の契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "現在の契約番号", required = false, position = 23, allowableValues = "range[0,255]")
	private String currentContractNumber;

	/**
	 * 現在の契約番号 その他
	 */

	/**
	 * 申込日
	 */
	@ApiModelProperty(value = "申込日", required = false, position = 24)
	@Temporal(TemporalType.DATE)
	private Date entryDate;

	/**
	 * 変更希望日
	 */
	@ApiModelProperty(value = "変更希望日", required = false, position = 25)
	@Temporal(TemporalType.DATE)
	private Date changeHopeDate;

	/**
	 * 電力エリア
	 */
	@ApiModelProperty(value = "電力エリア", required = false, position = 26, allowableValues = "北日本(\"1\"), 首都圏(\"2\"), 中部(\"3\"), 関西(\"4\"), 西日本(\"5\")", example = "1")
	private ElectricArea electricArea;

	/**
	 * 電力会社
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社", required = false, position = 27, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電源サイクル
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電源サイクル", required = false, position = 28, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 需要(供給)期間 開始日
	 */
	@ApiModelProperty(value = "需要(供給)期間　開始日", required = false, position = 29)
	@Temporal(TemporalType.DATE)
	private Date contractYmdStart;

	/**
	 * 需要(供給)期間 終了日
	 */
	@ApiModelProperty(value = "需要(供給)期間　終了日", required = false, position = 30)
	@Temporal(TemporalType.DATE)
	private Date contractYmdEnd;

	/**
	 * 供給開始月
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "供給開始月", required = false, position = 31, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 契約開始日
	 */
	@ApiModelProperty(value = "契約開始日", required = false, position = 32)
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;

	/**
	 * 電力区分
	 */
	@NotNull
	@ApiModelProperty(value = "電力区分", required = true, position = 33, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力メニュー", required = false, position = 34, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約数量
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "契約数量", required = false, position = 35, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "振込フラグチェック(業務区)", required = false, position = 36, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "原子力立地給付金フラグ", required = false, position = 37, allowableValues = "range[0,9]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@ApiModelProperty(value = "備考", required = false, position = 38, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 外部キー情報
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "外部キー情報", required = false, position = 39, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "NISHIKI契約番号", required = false, position = 40, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 需要家番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "需要家番号", required = false, position = 41, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * お申込み内容(高圧)
	 */
	@Valid
	@ApiModelProperty(value = "お申込み内容(高圧)", required = false, position = 42)
	private EntryContentHighPressureDto entryContentHighPressure;

	/**
	 * お申込み内容(低圧)
	 */
	@Valid
	@ApiModelProperty(value = "お申込み内容(低圧)", required = false, position = 43)
	private EntryContentLowPressureDto entryContentLowPressure;

	/**
	 * 解約情報
	 */
	@Valid
	@ApiModelProperty(value = "解約情報", required = false, position = 44)
	private CancellationInformationDto cancellationInformation;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "電力専任情報", required = true, position = 45)
	private ElectricExpertContractDto electricExpertContract;

	/**
	 * 販売店情報
	 */
	@Valid
	@ApiModelProperty(value = "販売店情報", required = false, position = 46)
	private ElectricDealerContractDto electricDealerContract;

	/**
	 * Mailアドレス情報
	 */
	@Valid
	@ApiModelProperty(value = "Mailアドレス情報", required = false, position = 47)
	private List<MailAddressInformationDto> mailAddressInformationList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@Valid
	@ApiModelProperty(value = "契約(電力)添付ファイル", required = false, position = 48)
	private List<ContractElectricAttachedFileDto> contractElectricAttachedFileList;

	/**
	 * 単価情報(高圧)
	 */
	@Valid
	@ApiModelProperty(value = "単価情報(高圧)", required = false, position = 49)
	private List<UnitPriceHighPressureDto> unitPriceHighPressureList;

	/**
	 * 単価情報(低圧)
	 */
	@Valid
	@ApiModelProperty(value = "単価情報(低圧)", required = false, position = 50)
	private List<UnitPriceLowPressureDto> unitPriceLowPressureList;

	/**
	 * 得意先情報
	 */
	@Valid
	@ApiModelProperty(value = "得意先情報", required = false, position = 51)
	private List<ClientInformationDto> clientInformationList;

	/**
	 * 商流区分
	 */
	@NotNull
	@ApiModelProperty(value = "商流区分", required = true, position = 52, allowableValues = "直売(\"1\"), 代売(\"2\"), 社内(\"3\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 現在の電力会社種別
	 */
	@ApiModelProperty(value = "現在の電力会社種別", required = false, position = 53, allowableValues = "種別1(\"1\")", example = "1")
	private CurrentElectricCompanyDiv currentElectricCompanyDiv;

	/**
	 * 品種コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "品種コード", required = false, position = 54, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 請求開始月
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求開始月", required = false, position = 55, allowableValues = "range[0,255]")
	private String billingStartMonth;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Column(name = "co2_emission_menu")
	@ApiModelProperty(value = "CO2排出メニュー", required = false, position = 56, allowableValues = "range[0,255]")
	private ElectricPlan co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 57, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 58, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 重要事項説明者
	 */
	@Valid
	@ApiModelProperty(value = "重要事項説明者", required = false, position = 59)
	private ImportantPointExplainerDto importantPointExplainer;

	/**
	 * SIM番号(主)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(主)", required = false, position = 60, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "SIM番号(従)", required = false, position = 61, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * CO2排出係数
	 */
	@Size(max = 255)
	@Column(name = "co2_emission_factor")
	@ApiModelProperty(value = "CO2排出係数", required = false, position = 62, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/**
	 * 契約期間
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "契約期間", required = false, position = 67, allowableValues = "range[0,255]")
	private String contractPeriod;

	/**
	 * 取次情報
	 */
	@Valid
	@ApiModelProperty(value = "取次情報", required = false, position = 63)
	private AgencyContractInformationDto agencyContractInformation;

	/**
	 * 初回供給開始日
	 */
	//TODO 契約更新修正時に初回供給開始日を追加
	//@ApiModelProperty(value = "初回供給開始日", required = false, position = 63)
	//private @Temporal(TemporalType.DATE) firstSupplyStartDate;

	/**
	 * 承認ルート名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "承認ルート名", required = false, position = 68, allowableValues = "range[0,255]")
	private String approvalRouteName;

	/**
	 * 契約番号フリー入力フラグ
	 */
	@ApiModelProperty(value = "契約番号フリー入力フラグ", required = false, position = 69, allowableValues = "range[0,9]")
	private Integer contractNumberFreeFlg;

	/**
	 * 締め日カレンダーチェックフラグ
	 */
	@ApiModelProperty(value = "締め日カレンダーチェックフラグ", required = false, position = 70, allowableValues = "range[0,9]")
	private Integer contractCalendarCheckFlg;

	/**
	 * 契約締結促進メールフラグ
	 */
	@ApiModelProperty(value = "契約締結促進メールフラグ", required = false, position = 71, allowableValues = "range[0,9]")
	private Integer contractReminderMailFlg;

	/**
	 * 契約書未返送アラート判定基準日
	 */
	@ApiModelProperty(value = "契約書未返送アラート判定基準日", required = false, position = 72)
	@Temporal(TemporalType.DATE)
	private Date contractReminderJudgeDate;

	/**
	 * 現在の契約番号入力フォーム識別子
	 */
	@ApiModelProperty(value = "現在の契約番号入力フォーム識別子", required = false, position = 73, allowableValues = "range[0,9]")
	private Integer currentContractNumberFormIdentifier;

	/**
	 * 契約満了前チェックフラグ
	 */
	@ApiModelProperty(value = "契約満了前チェックフラグ", required = false, position = 74, allowableValues = "range[0,9]")
	private Integer beforeContractExpiryCheckFlg;

	/**
	 * 必須表示区分
	 */
	@ApiModelProperty(value = "必須表示区分", required = false, position = 75, allowableValues = "帳票出力(\"1\"), 承認依頼(\"2\")", example = "1")
	private RequiredIndicationDiv requiredIndicationDiv;
}
