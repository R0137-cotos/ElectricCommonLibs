package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricDealerMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 販売店マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_dealer_master")
@CotosComplementTarget(entity = ElectricDealerMaster.class, repository = ElectricDealerMasterRepository.class)
public class ElectricDealerMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_dealer_master_seq")
	@SequenceGenerator(name = "electric_dealer_master_seq", sequenceName = "electric_dealer_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販売店コード
	 */
	@Column(nullable = false)
	@Schema(description = "販売店コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,10]")
	@JsonProperty("販売店コード")
	private String hnbitnCd;

	/**
	 * 販売店名(カナ)
	 */
	@Column(nullable = true)
	@Schema(description = "販売店名(カナ)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("販売店名(カナ)")
	private String hnbitnMiKn;

	/**
	 * 販売店名
	 */
	@Column(nullable = true)
	@Schema(description = "販売店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("販売店名")
	private String hnbitnMi;

	/**
	 * 販売店事業所名
	 */
	@Column(nullable = true)
	@Schema(description = "販売店事業所名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("販売店事業所名")
	private String hnbitnJgysyMi;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@Schema(description = "電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("電話番号")
	private String dnwBngu;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@Schema(description = "郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("郵便番号")
	private String ybnBngu;

	/**
	 * 住所1
	 */
	@Column(nullable = true)
	@Schema(description = "住所1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("住所１")
	private String zyusy1;

	/**
	 * 住所2
	 */
	@Column(nullable = true)
	@Schema(description = "住所2", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("住所２")
	private String zyusy2;

	/**
	 * 銀行番号
	 */
	@Column(nullable = true)
	@Schema(description = "銀行番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("銀行番号")
	private String gnnkuBngu;

	/**
	 * 銀行名
	 */
	@Column(nullable = true)
	@Schema(description = "銀行名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("銀行名")
	private String gnnkuMi;

	/**
	 * 支店コード
	 */
	@Column(nullable = true)
	@Schema(description = "支店コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,10]")
	@JsonProperty("支店コード")
	private String shtnCd;

	/**
	 * 支店名
	 */
	@Column(nullable = true)
	@Schema(description = "支店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("支店名")
	private String shtnMi;

	/**
	 * 口座種別
	 */
	@Column(nullable = true)
	@Schema(description = "口座種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("口座種別")
	private String kuzSybts;

	/**
	 * 口座番号
	 */
	@Column(nullable = true)
	@Schema(description = "口座番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("口座番号")
	private String kuzBngu;

	/**
	 * 口座名義人名カナ
	 */
	@Column(nullable = true)
	@Schema(description = "口座名義人名カナ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("口座名義人名カナ")
	private String kuzMignnMiKn;

	/**
	 * 担当者名
	 */
	@Column(nullable = true)
	@Schema(description = "担当者名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("担当者名")
	private String tntsyMi;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("メールアドレス１")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス2", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("メールアドレス２")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス3", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("メールアドレス３")
	private String mailAddress3;

	/**
	 * 契約期間(自)
	 */
	@Column(nullable = true)
	@Schema(description = "契約期間(自)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,10]")
	@JsonProperty("契約期間(自)")
	private String kiykKknFrom;

	/**
	 * 契約期間(至)
	 */
	@Column(nullable = true)
	@Schema(description = "契約期間(至)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,10]")
	@JsonProperty("契約期間(至)")
	private String kiykKknTo;

	/**
	 * 商流区分コード
	 */
	@Column(nullable = true)
	@Schema(description = "商流区分コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	@JsonProperty("商流区分コード")
	private String syuryuKbnCd;

	/**
	 * 商流区分名
	 */
	@Column(nullable = true)
	@Schema(description = "商流区分名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("商流区分名")
	private String syuryuKbnMi;

	/**
	 * 支払方法区分コード
	 */
	@Column(nullable = true)
	@Schema(description = "支払方法区分コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	@JsonProperty("支払方法区分コード")
	private String shhriHuhuKbnCd;

	/**
	 * 支払方法区分名
	 */
	@Column(nullable = true)
	@Schema(description = "支払方法区分名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("支払方法区分名")
	private String shhriHuhuKbnMi;

	/**
	 * 媒介手数料率
	 */
	@Column(nullable = true)
	@Schema(description = "媒介手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999999999.99]")
	@JsonProperty("媒介手数料率")
	private BigDecimal bikiTsuryuRt;

	/**
	 * 口座名義人名
	 */
	@Column(nullable = true)
	@Schema(description = "口座名義人名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("口座名義人名")
	private String kuzMignnMi;

	/**
	 * 支払先サイト(支払先コード)
	 */
	@Column(nullable = true)
	@Schema(description = "支払先サイト(支払先コード)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("支払先サイト（支払先コード）")
	private String shhriSite;

	/**
	 * 上流工程コード
	 */
	@Column(nullable = true)
	@Schema(description = "上流工程コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("上流工程コード")
	private String processCd;

	/**
	 * 登録ユーザID
	 */
	@Column(nullable = true)
	@Schema(description = "登録ユーザID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("登録ユーザID")
	private String registUserId;

	/**
	 * 登録日時
	 */
	@Column(nullable = true)
	@Schema(description = "登録日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("登録日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
	private Date registTime;

	/**
	 * 更新ユーザID
	 */
	@Column(nullable = true)
	@Schema(description = "更新ユーザID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	@JsonProperty("更新ユーザID")
	private String updateUserId;

	/**
	 * 更新日時
	 */
	@Column(nullable = true)
	@Schema(description = "更新日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("更新日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
	private Date updateTime;

	/**
	 * バージョン
	 */
	@Column(nullable = true)
	@Schema(description = "バージョン", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9999999999999999999]")
	@JsonProperty("バージョン")
	private BigDecimal rVersion;

	/**
	 * 支払間隔
	 */
	@Column(nullable = true)
	@Schema(description = "支払間隔", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,2]")
	@JsonProperty("支払間隔")
	private String paymentInterval;

	/**
	 * 支払期間
	 */
	@Column(nullable = true)
	@Schema(description = "支払期間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,2]")
	@JsonProperty("支払期間")
	private String paymentPeriod;

	/**
	 * 帳票区分
	 */
	@Column(nullable = true)
	@Schema(description = "帳票区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	@JsonProperty("帳票区分")
	private String reportsMethod;

}
