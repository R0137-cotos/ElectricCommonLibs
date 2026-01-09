package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricArea;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.RequiredIndicationDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 契約(電力用)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true, exclude = {"entryContentHighPressure", "entryContentLowPressure", "cancellationInformation", "electricExpertContract", "electricDealerContract", "mailAddressInformationList", "contractElectricAttachedFileList", "unitPriceHighPressureList", "unitPriceLowPressureList", "clientInformationList", "importantPointExplainer", "agencyContractInformation"})
@ToString(callSuper = true, exclude = {"entryContentHighPressure", "entryContentLowPressure", "cancellationInformation", "electricExpertContract", "electricDealerContract", "mailAddressInformationList", "contractElectricAttachedFileList", "unitPriceHighPressureList", "unitPriceLowPressureList", "clientInformationList", "importantPointExplainer", "agencyContractInformation"})
@Data
@Table(name = "contract_electric")
@EntityListeners(ContractElectricListener.class)
@CotosComplementTarget(entity = ContractElectric.class, repository = ContractElectricRepository.class)
public class ContractElectric extends EntityBase {

	public enum CurrentElectricCompanyDiv {

		管轄地域電力会社("1"), 新電力会社("2"), リコージャパン("3");

		private final String text;

		private CurrentElectricCompanyDiv(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static CurrentElectricCompanyDiv fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_electric_seq")
	@SequenceGenerator(name = "contract_electric_seq", sequenceName = "contract_electric_seq", allocationSize = 1)
	@Schema(description = "契約(電力用)ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約
	 */
	@Column(nullable = false)
	@Schema(description = "契約ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

	/**
	 * 申込番号
	 */
	@Column(nullable = true)
	@Schema(description = "申込番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * お客様識別番号
	 */
	@Column(nullable = true)
	@Schema(description = "お客様識別番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@Schema(description = "供給地点特定番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 仕入元拠点ID
	 */
	@Column(nullable = true)
	@Schema(description = "仕入元拠点ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplierCustId;

	/**
	 * ご契約者名(法人名)
	 */
	@Column(nullable = true)
	@Schema(description = "ご契約者名(法人名)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名(カナ)
	 */
	@Column(nullable = true)
	@Schema(description = "ご契約者名(カナ)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 簡略名称
	 */
	@Column(nullable = true)
	@Schema(description = "簡略名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * メール配信
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "メール配信", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@Schema(description = "郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 都道府県
	 */
	@Column(nullable = true)
	@Schema(description = "都道府県", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 市区町村
	 */
	@Column(nullable = true)
	@Schema(description = "市区町村", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 番地
	 */
	@Column(nullable = true)
	@Schema(description = "番地", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 建物名
	 */
	@Column(nullable = true)
	@Schema(description = "建物名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@Schema(description = "電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@Column(nullable = true)
	@Schema(description = "旧契約名義", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@Column(nullable = true)
	@Schema(description = "旧需要場所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 電気主任技術者
	 */
	@Column(nullable = true)
	@Schema(description = "電気主任技術者", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 電話番号
	 */
	@Column(nullable = true)
	@Schema(description = "電気主任技術者 電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 所属名
	 */
	@Column(nullable = true)
	@Schema(description = "電気主任技術者 所属名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 現在の電力会社
	 */
	@Column(nullable = true)
	@Schema(description = "現在の電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 現在の契約番号
	 */
	@Column(nullable = true)
	@Schema(description = "現在の契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String currentContractNumber;

	/**
	 * 現在の契約番号 その他
	 */

	/**
	 * 申込日
	 */
	@Column(nullable = true)
	@Schema(description = "申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date entryDate;

	/**
	 * 変更希望日
	 */
	@Column(nullable = true)
	@Schema(description = "変更希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date changeHopeDate;

	/**
	 * 電力エリア
	 */
	@Column(nullable = true)
	@Schema(description = "電力エリア", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private ElectricArea electricArea;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電源サイクル
	 */
	@Column(nullable = true)
	@Schema(description = "電源サイクル", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 需要(供給)期間 開始日
	 */
	@Column(nullable = true)
	@Schema(description = "需要(供給)期間　開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractYmdStart;

	/**
	 * 需要(供給)期間 終了日
	 */
	@Column(nullable = true)
	@Schema(description = "需要(供給)期間　終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractYmdEnd;

	/**
	 * 供給開始月
	 */
	@Column(nullable = true)
	@Schema(description = "供給開始月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 契約開始日
	 */
	@Column(nullable = true)
	@Schema(description = "契約開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Column(nullable = true)
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約数量
	 */
	@Column(nullable = true)
	@Schema(description = "契約数量", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "振込フラグチェック(業務区)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "原子力立地給付金フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@Schema(description = "備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 外部キー情報
	 */
	@Column(nullable = true)
	@Schema(description = "外部キー情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Column(nullable = true)
	@Schema(description = "NISHIKI契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 需要家番号
	 */
	@Column(nullable = true)
	@Schema(description = "需要家番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * お申込み内容(高圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "お申込み内容(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EntryContentHighPressure entryContentHighPressure;

	/**
	 * お申込み内容(低圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "お申込み内容(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private EntryContentLowPressure entryContentLowPressure;

	/**
	 * 解約情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "解約情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationInformation cancellationInformation;

	/**
	 * 電力専任情報
	 */
	@OneToOne(mappedBy = "contractElectric", optional = false)
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricExpertContract electricExpertContract;

	/**
	 * 販売店情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricDealerContract electricDealerContract;

	/**
	 * Mailアドレス情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "Mailアドレス情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<MailAddressInformation> mailAddressInformationList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "契約(電力)添付ファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ContractElectricAttachedFile> contractElectricAttachedFileList;

	/**
	 * 単価情報(高圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "単価情報(高圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<UnitPriceHighPressure> unitPriceHighPressureList;

	/**
	 * 単価情報(低圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "単価情報(低圧)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<UnitPriceLowPressure> unitPriceLowPressureList;

	/**
	 * 得意先情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@Schema(description = "得意先情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ClientInformation> clientInformationList;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "直売(\"1\"), 媒介(\"2\"), 社内(\"3\"), 取次(\"4\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 現在の電力会社種別
	 */
	@Column(nullable = true)
	@Schema(description = "現在の電力会社種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "種別1(\"1\")", example = "1")
	private CurrentElectricCompanyDiv currentElectricCompanyDiv;

	/**
	 * 品種コード
	 */
	@Column(nullable = true)
	@Schema(description = "品種コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 請求開始月
	 */
	@Column(nullable = true)
	@Schema(description = "請求開始月", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingStartMonth;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Column(nullable = true, name = "co2_emission_menu")
	@Schema(description = "CO2排出メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "CO2フリー(\"1\"), それ以外(\"2\")", example = "1")
	private ElectricPlan co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 契約書最終作成日
	 */
	@Column(nullable = true)
	@Schema(description = "契約書最終作成日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractLastCreationDate;

	/**
	 * 重要事項説明者
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "重要事項説明者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ImportantPointExplainer importantPointExplainer;

	/**
	 * SIM番号(主)
	 */
	@Column(nullable = true)
	@Schema(description = "SIM番号(主)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Column(nullable = true)
	@Schema(description = "SIM番号(従)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * CO2排出係数
	 */
	@Column(nullable = true, name = "co2_emission_factor")
	@Schema(description = "CO2排出係数", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/**
	 * 初回供給開始日
	 */
	@Column(nullable = true)
	@Schema(description = "初回供給開始日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date firstSupplyStartDate;

	/**
	 * 契約終了日
	 */
	@Column(nullable = true)
	@Schema(description = "契約終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractEndDate;

	/**
	 * 契約期間
	 */
	@Column(nullable = true)
	@Schema(description = "契約期間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contractPeriod;

	/**
	 * 取次情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@Schema(description = "取次情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private AgencyContractInformation agencyContractInformation;

	/**
	 * 承認ルート名
	 */
	@Column(nullable = true)
	@Schema(description = "承認ルート名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String approvalRouteName;

	/**
	 * 契約番号フリー入力フラグ
	 */
	@Column(nullable = true)
	@Schema(description = "契約番号フリー入力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer contractNumberFreeFlg;

	/**
	 * 締め日カレンダーチェックフラグ
	 */
	@Column(nullable = true)
	@Schema(description = "締め日カレンダーチェックフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer contractCalendarCheckFlg;

	/**
	 * 契約締結促進メールフラグ
	 */
	@Column(nullable = true)
	@Schema(description = "契約締結促進メールフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer contractReminderMailFlg;

	/**
	 * 契約書未返送アラート判定基準日
	 */
	@Column(nullable = true)
	@Schema(description = "契約書未返送アラート判定基準日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date contractReminderJudgeDate;

	/**
	 * 現在の契約番号入力フォーム識別子
	 */
	@Column(nullable = true)
	@Schema(description = "現在の契約番号入力フォーム識別子", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer currentContractNumberFormIdentifier;

	/**
	 * 契約満了前チェックフラグ
	 */
	@Column(nullable = true)
	@Schema(description = "契約満了前チェックフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer beforeContractExpiryCheckFlg;

	/**
	 * 必須表示区分
	 */
	@Column(nullable = true)
	@Schema(description = "必須表示区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "帳票出力(\"1\"), 承認依頼(\"2\")", example = "1")
	private RequiredIndicationDiv requiredIndicationDiv;
}
