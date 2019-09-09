package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricArea;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約(電力用)を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
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
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst()
					.orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_electric_seq")
	@SequenceGenerator(name = "contract_electric_seq", sequenceName = "contract_electric_seq", allocationSize = 1)
	@ApiModelProperty(value = "契約(電力用)ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "契約ID", required = true, position = 2, allowableValues = "range[0,9223372036854775807]")
	private long contractId;

	/**
	 * 申込番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "申込番号", required = false, position = 3, allowableValues = "range[0,255]")
	private String entryNumber;

	/**
	 * お客様識別番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "お客様識別番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 供給地点特定番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給地点特定番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String feedPointNumber;

	/**
	 * 仕入元拠点ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入元拠点ID", required = false, position = 6, allowableValues = "range[0,255]")
	private String supplierCustId;

	/**
	 * ご契約者名(法人名)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ご契約者名(法人名)", required = false, position = 7, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名(カナ)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ご契約者名(カナ)", required = false, position = 8, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 簡略名称
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "簡略名称", required = false, position = 9, allowableValues = "range[0,255]")
	private String demandNameKr;

	/**
	 * メール配信
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "メール配信", required = true, position = 10, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "郵便番号", required = false, position = 11, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 都道府県
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "都道府県", required = false, position = 12, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 市区町村
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "市区町村", required = false, position = 13, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 番地
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "番地", required = false, position = 14, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 建物名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "建物名", required = false, position = 15, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電話番号", required = false, position = 16, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 旧契約名義
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "旧契約名義", required = false, position = 17, allowableValues = "range[0,255]")
	private String contractHolderOld;

	/**
	 * 旧需要場所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "旧需要場所", required = false, position = 18, allowableValues = "range[0,255]")
	private String demandPlaceOld;

	/**
	 * 電気主任技術者
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電気主任技術者", required = false, position = 19, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電気主任技術者 電話番号", required = false, position = 20, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 所属名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電気主任技術者 所属名", required = false, position = 21, allowableValues = "range[0,255]")
	private String licensedEngineerDep;

	/**
	 * 現在の電力会社
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "現在の電力会社", required = false, position = 22, allowableValues = "range[0,255]")
	private String currentElectricCompany;

	/**
	 * 現在の契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "現在の契約番号", required = false, position = 23, allowableValues = "range[0,255]")
	private String currentContractNumber;

	/**
	 * 現在の契約番号 その他
	 */

	/**
	 * 申込日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "申込日", required = false, position = 24)
	@Temporal(TemporalType.DATE)
	private Date entryDate;

	/**
	 * 変更希望日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "変更希望日", required = false, position = 25)
	@Temporal(TemporalType.DATE)
	private Date changeHopeDate;

	/**
	 * 電力エリア
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力エリア", required = false, position = 26, allowableValues = "range[0,255]")
	private ElectricArea electricArea;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社", required = false, position = 27, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 電源サイクル
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電源サイクル", required = false, position = 28, allowableValues = "range[0,255]")
	private String chargeCycle;

	/**
	 * 需要(供給)期間 開始日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需要(供給)期間　開始日", required = false, position = 29)
	@Temporal(TemporalType.DATE)
	private Date contractYmdStart;

	/**
	 * 需要(供給)期間 終了日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需要(供給)期間　終了日", required = false, position = 30)
	@Temporal(TemporalType.DATE)
	private Date contractYmdEnd;

	/**
	 * 供給開始月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給開始月", required = false, position = 31, allowableValues = "range[0,255]")
	private String supplyStartDate;

	/**
	 * 契約開始日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約開始日", required = false, position = 32)
	@Temporal(TemporalType.DATE)
	private Date contractStartDate;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力区分", required = true, position = 33, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 電力メニュー
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力メニュー", required = false, position = 34, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 契約数量
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約数量", required = false, position = 35, allowableValues = "range[0,255]")
	private String contractAmount;

	/**
	 * 振込フラグチェック(業務区)
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "振込フラグチェック(業務区)", required = false, position = 36, allowableValues = "range[0,9]")
	private Integer transferCheckFlg;

	/**
	 * 原子力立地給付金フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "原子力立地給付金フラグ", required = false, position = 37, allowableValues = "range[0,9]")
	private Integer atomicPaymentFlg;

	/**
	 * 備考
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "備考", required = false, position = 38, allowableValues = "range[0,255]")
	private String notes;

	/**
	 * 外部キー情報
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "外部キー情報", required = false, position = 39, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "NISHIKI契約番号", required = false, position = 40, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * 需要家番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需要家番号", required = false, position = 41, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * お申込み内容(高圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "お申込み内容(高圧)", required = false, position = 42)
	private EntryContentHighPressure entryContentHighPressure;

	/**
	 * お申込み内容(低圧)
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "お申込み内容(低圧)", required = false, position = 43)
	private EntryContentLowPressure entryContentLowPressure;

	/**
	 * 解約情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "解約情報", required = false, position = 44)
	private CancellationInformation cancellationInformation;

	/**
	 * 電力専任情報
	 */
	@OneToOne(mappedBy = "contractElectric", optional = false)
	@ApiModelProperty(value = "電力専任情報", required = true, position = 45)
	private ElectricExpertContract electricExpertContract;

	/**
	 * 販売店情報
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "販売店情報", required = false, position = 46)
	private ElectricDealerContract electricDealerContract;

	/**
	 * Mailアドレス情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "Mailアドレス情報", required = false, position = 47)
	private List<MailAddressInformation> mailAddressInformationList;

	/**
	 * 契約(電力)添付ファイル
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "契約(電力)添付ファイル", required = false, position = 48)
	private List<ContractElectricAttachedFile> contractElectricAttachedFileList;

	/**
	 * 単価情報(高圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "単価情報(高圧)", required = false, position = 49)
	private List<UnitPriceHighPressure> unitPriceHighPressureList;

	/**
	 * 単価情報(低圧)
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "単価情報(低圧)", required = false, position = 50)
	private List<UnitPriceLowPressure> unitPriceLowPressureList;

	/**
	 * 得意先情報
	 */
	@OneToMany(mappedBy = "contractElectric")
	@ApiModelProperty(value = "得意先情報", required = false, position = 51)
	private List<ClientInformation> clientInformationList;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "商流区分", required = true, position = 52, allowableValues = "直売(\"1\"), 媒介(\"2\"), 社内(\"3\"), 取次(\"4\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 現在の電力会社種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "現在の電力会社種別", required = false, position = 53, allowableValues = "種別1(\"1\")", example = "1")
	private CurrentElectricCompanyDiv currentElectricCompanyDiv;

	/**
	 * 品種コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "品種コード", required = false, position = 54, allowableValues = "range[0,255]")
	private String itemCode;

	/**
	 * 請求開始月
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "請求開始月", required = false, position = 55, allowableValues = "range[0,255]")
	private String billingStartMonth;

	/**
	 * CO2排出メニュー CO2EMISSION_MENUとして読み取られるためname指定
	 */
	@Column(nullable = true, name = "co2_emission_menu")
	@ApiModelProperty(value = "CO2排出メニュー", required = false, position = 56, allowableValues = "CO2フリー(\"1\"), それ以外(\"2\")", example = "1")
	private ElectricPlan co2EmissionMenu;

	/**
	 * 電力会社コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 57, allowableValues = "range[0,255]")
	private String electricCompanyCode;

	/**
	 * 電力メニューコード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社コード", required = false, position = 58, allowableValues = "range[0,255]")
	private String electricMenuCode;

	/**
	 * 契約書初回作成日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約書初回作成日", required = false, position = 59)
	@Temporal(TemporalType.DATE)
	private Date contractFirstCreationDate;

	/**
	 * 重要事項説明者
	 */
	@OneToOne(mappedBy = "contractElectric")
	@ApiModelProperty(value = "重要事項説明者", required = false, position = 61)
	private ImportantPointExplainer importantPointExplainer;

	/**
	 * SIM番号(主)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "SIM番号(主)", required = false, position = 62, allowableValues = "range[0,255]")
	private String simNumberMain;

	/**
	 * SIM番号(従)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "SIM番号(従)", required = false, position = 63, allowableValues = "range[0,255]")
	private String simNumberSub;

	/**
	 * CO2排出係数
	 */
	@Column(nullable = true, name = "co2_emission_factor")
	@ApiModelProperty(value = "CO2排出係数", required = false, position = 64, allowableValues = "range[0,255]")
	private String co2EmissionFactor;

	/**
	 * 初回供給開始日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "初回供給開始日", required = false, position = 65)
	@Temporal(TemporalType.DATE)
	private Date firstSupplyStartDate;

	/**
	 * 契約終了日
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約終了日", required = false, position = 66)
	@Temporal(TemporalType.DATE)
	private Date contractEndDate;
	
	/**
	 * 契約期間
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間", required = false, position = 67, allowableValues = "range[0,255]")
	private String contractPeriod;
}
