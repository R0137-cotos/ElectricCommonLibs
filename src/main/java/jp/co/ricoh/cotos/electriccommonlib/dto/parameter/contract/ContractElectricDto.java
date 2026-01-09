package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "契約ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

	/**
	 * 申込番号
	 */
	@Size(max = 255)
	@Schema(description = "申込番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * お客様識別番号
	 */
	@Size(max = 255)
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Size(max = 255)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 仕入元拠点ID
	 */
	@Size(max = 255)
	@Schema(description = "仕入元拠点ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplierCustId;

	/**
	 * ご契約者名(法人名)
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者名(法人名)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名(カナ)
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者名(カナ)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 簡略名称
	 */
	@Size(max = 255)
	@Schema(description = "簡略名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * メール配信
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "メール配信", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@Schema(description = "郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 都道府県
	 */
	@Size(max = 255)
	@Schema(description = "都道府県", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 市区町村
	 */
	@Size(max = 255)
	@Schema(description = "市区町村", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 番地
	 */
	@Size(max = 255)
	@Schema(description = "番地", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 建物名
	 */
	@Size(max = 255)
	@Schema(description = "建物名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
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
	 * 電気主任技術者
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 所属名
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 所属名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

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
	 * 現在の契約番号 その他
	 */

	/**
	 * 申込日
	 */
	@Schema(description = "申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date entryDate;

	/**
	 * 変更希望日
	 */
	@Schema(description = "変更希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date changeHopeDate;

	/**
	 * 電力エリア
	 */
	@Schema(description = "電力エリア", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "北日本(\"1\"), 首都圏(\"2\"), 中部(\"3\"), 関西(\"4\"), 西日本(\"5\")", example = "1")
	private ElectricArea electricArea;

	/**
	 * 電力会社
	 */
	@Size(max = 255)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電源サイクル
	 */
	@Size(max = 255)
	@Schema(description = "電源サイクル", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 需要(供給)期間 開始日
	 */
	@Schema(description = "需要(供給)期間　開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractYmdStart;

	/**
	 * 需要(供給)期間 終了日
	 */
	@Schema(description = "需要(供給)期間　終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractYmdEnd;

	/**
	 * 供給開始月
	 */
	@Size(max = 255)
	@Schema(description = "供給開始月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 契約開始日
	 */
	@Schema(description = "契約開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;

	/**
	 * 電力区分
	 */
	@NotNull
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Size(max = 255)
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約数量
	 */
	@Size(max = 255)
	@Schema(description = "契約数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "振込フラグチェック(業務区)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "原子力立地給付金フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 外部キー情報
	 */
	@Size(max = 255)
	@Schema(description = "外部キー情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Size(max = 255)
	@Schema(description = "NISHIKI契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 需要家番号
	 */
	@Size(max = 255)
	@Schema(description = "需要家番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * お申込み内容(高圧)
	 */
	@Valid
	@Schema(description = "お申込み内容(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EntryContentHighPressureDto entryContentHighPressure;

	/**
	 * お申込み内容(低圧)
	 */
	@Valid
	@Schema(description = "お申込み内容(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EntryContentLowPressureDto entryContentLowPressure;

	/**
	 * 解約情報
	 */
	@Valid
	@Schema(description = "解約情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationInformationDto cancellationInformation;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricExpertContractDto electricExpertContract;

	/**
	 * 販売店情報
	 */
	@Valid
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricDealerContractDto electricDealerContract;

	/**
	 * Mailアドレス情報
	 */
	@Valid
	@Schema(description = "Mailアドレス情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<MailAddressInformationDto> mailAddressInformationList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@Valid
	@Schema(description = "契約(電力)添付ファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ContractElectricAttachedFileDto> contractElectricAttachedFileList;

	/**
	 * 単価情報(高圧)
	 */
	@Valid
	@Schema(description = "単価情報(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<UnitPriceHighPressureDto> unitPriceHighPressureList;

	/**
	 * 単価情報(低圧)
	 */
	@Valid
	@Schema(description = "単価情報(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<UnitPriceLowPressureDto> unitPriceLowPressureList;

	/**
	 * 得意先情報
	 */
	@Valid
	@Schema(description = "得意先情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ClientInformationDto> clientInformationList;

	/**
	 * 商流区分
	 */
	@NotNull
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "直売(\"1\"), 代売(\"2\"), 社内(\"3\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 現在の電力会社種別
	 */
	@Schema(description = "現在の電力会社種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "種別1(\"1\")", example = "1")
	private CurrentElectricCompanyDiv currentElectricCompanyDiv;

	/**
	 * 品種コード
	 */
	@Size(max = 255)
	@Schema(description = "品種コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 請求開始月
	 */
	@Size(max = 255)
	@Schema(description = "請求開始月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingStartMonth;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Column(name = "co2_emission_menu")
	@Schema(description = "CO2排出メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private ElectricPlan co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Size(max = 255)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Size(max = 255)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 重要事項説明者
	 */
	@Valid
	@Schema(description = "重要事項説明者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ImportantPointExplainerDto importantPointExplainer;

	/**
	 * SIM番号(主)
	 */
	@Size(max = 255)
	@Schema(description = "SIM番号(主)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Size(max = 255)
	@Schema(description = "SIM番号(従)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * CO2排出係数
	 */
	@Size(max = 255)
	@Column(name = "co2_emission_factor")
	@Schema(description = "CO2排出係数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/**
	 * 契約期間
	 */
	@Size(max = 255)
	@Schema(description = "契約期間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractPeriod;

	/**
	 * 取次情報
	 */
	@Valid
	@Schema(description = "取次情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
	@Schema(description = "承認ルート名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String approvalRouteName;

	/**
	 * 契約番号フリー入力フラグ
	 */
	@Schema(description = "契約番号フリー入力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer contractNumberFreeFlg;

	/**
	 * 締め日カレンダーチェックフラグ
	 */
	@Schema(description = "締め日カレンダーチェックフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer contractCalendarCheckFlg;

	/**
	 * 契約締結促進メールフラグ
	 */
	@Schema(description = "契約締結促進メールフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer contractReminderMailFlg;

	/**
	 * 契約書未返送アラート判定基準日
	 */
	@Schema(description = "契約書未返送アラート判定基準日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractReminderJudgeDate;

	/**
	 * 現在の契約番号入力フォーム識別子
	 */
	@Schema(description = "現在の契約番号入力フォーム識別子", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer currentContractNumberFormIdentifier;

	/**
	 * 契約満了前チェックフラグ
	 */
	@Schema(description = "契約満了前チェックフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer beforeContractExpiryCheckFlg;

	/**
	 * 必須表示区分
	 */
	@Schema(description = "必須表示区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "帳票出力(\"1\"), 承認依頼(\"2\")", example = "1")
	private RequiredIndicationDiv requiredIndicationDiv;
}
