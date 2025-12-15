package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販売店コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "販売店コード", required = true, position = 2, allowableValues = "range[0,10]")
	@JsonProperty("販売店コード")
	private String hnbitnCd;

	/**
	 * 販売店名(カナ)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店名(カナ)", required = false, position = 3, allowableValues = "range[0,1000]")
	@JsonProperty("販売店名(カナ)")
	private String hnbitnMiKn;

	/**
	 * 販売店名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店名", required = false, position = 4, allowableValues = "range[0,1000]")
	@JsonProperty("販売店名")
	private String hnbitnMi;

	/**
	 * 販売店事業所名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店事業所名", required = false, position = 5, allowableValues = "range[0,1000]")
	@JsonProperty("販売店事業所名")
	private String hnbitnJgysyMi;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電話番号", required = false, position = 6, allowableValues = "range[0,1000]")
	@JsonProperty("電話番号")
	private String dnwBngu;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "郵便番号", required = false, position = 7, allowableValues = "range[0,1000]")
	@JsonProperty("郵便番号")
	private String ybnBngu;

	/**
	 * 住所1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所1", required = false, position = 8, allowableValues = "range[0,1000]")
	@JsonProperty("住所１")
	private String zyusy1;

	/**
	 * 住所2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所2", required = false, position = 9, allowableValues = "range[0,1000]")
	@JsonProperty("住所２")
	private String zyusy2;

	/**
	 * 銀行番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行番号", required = false, position = 10, allowableValues = "range[0,1000]")
	@JsonProperty("銀行番号")
	private String gnnkuBngu;

	/**
	 * 銀行名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行名", required = false, position = 11, allowableValues = "range[0,1000]")
	@JsonProperty("銀行名")
	private String gnnkuMi;

	/**
	 * 支店コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店コード", required = false, position = 12, allowableValues = "range[0,10]")
	@JsonProperty("支店コード")
	private String shtnCd;

	/**
	 * 支店名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店名", required = false, position = 13, allowableValues = "range[0,1000]")
	@JsonProperty("支店名")
	private String shtnMi;

	/**
	 * 口座種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座種別", required = false, position = 14, allowableValues = "range[0,1000]")
	@JsonProperty("口座種別")
	private String kuzSybts;

	/**
	 * 口座番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座番号", required = false, position = 15, allowableValues = "range[0,1000]")
	@JsonProperty("口座番号")
	private String kuzBngu;

	/**
	 * 口座名義人名カナ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座名義人名カナ", required = false, position = 16, allowableValues = "range[0,1000]")
	@JsonProperty("口座名義人名カナ")
	private String kuzMignnMiKn;

	/**
	 * 担当者名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "担当者名", required = false, position = 17, allowableValues = "range[0,1000]")
	@JsonProperty("担当者名")
	private String tntsyMi;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 18, allowableValues = "range[0,1000]")
	@JsonProperty("メールアドレス１")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス2", required = false, position = 19, allowableValues = "range[0,1000]")
	@JsonProperty("メールアドレス２")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 20, allowableValues = "range[0,1000]")
	@JsonProperty("メールアドレス３")
	private String mailAddress3;

	/**
	 * 契約期間(自)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(自)", required = false, position = 21, allowableValues = "range[0,10]")
	@JsonProperty("契約期間(自)")
	private String kiykKknFrom;

	/**
	 * 契約期間(至)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(至)", required = false, position = 22, allowableValues = "range[0,10]")
	@JsonProperty("契約期間(至)")
	private String kiykKknTo;

	/**
	 * 商流区分コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商流区分コード", required = false, allowableValues = "range[0,1]", position = 23)
	@JsonProperty("商流区分コード")
	private String syuryuKbnCd;

	/**
	 * 商流区分名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商流区分名", required = false, allowableValues = "range[0,1000]", position = 24)
	@JsonProperty("商流区分名")
	private String syuryuKbnMi;

	/**
	 * 支払方法区分コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払方法区分コード", required = false, position = 25, allowableValues = "range[0,1]")
	@JsonProperty("支払方法区分コード")
	private String shhriHuhuKbnCd;

	/**
	 * 支払方法区分名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払方法区分名", required = false, position = 26, allowableValues = "range[0,1000]")
	@JsonProperty("支払方法区分名")
	private String shhriHuhuKbnMi;

	/**
	 * 媒介手数料率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "媒介手数料率", required = false, position = 27, allowableValues = "range[0,99999999999.99]")
	@JsonProperty("媒介手数料率")
	private BigDecimal bikiTsuryuRt;

	/**
	 * 口座名義人名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座名義人名", required = false, position = 28, allowableValues = "range[0,1000]")
	@JsonProperty("口座名義人名")
	private String kuzMignnMi;

	/**
	 * 支払先サイト(支払先コード)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払先サイト(支払先コード)", required = false, position = 29, allowableValues = "range[0,1000]")
	@JsonProperty("支払先サイト（支払先コード）")
	private String shhriSite;

	/**
	 * 上流工程コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "上流工程コード", required = false, position = 30, allowableValues = "range[0,1000]")
	@JsonProperty("上流工程コード")
	private String processCd;

	/**
	 * 登録ユーザID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "登録ユーザID", required = false, position = 31, allowableValues = "range[0,1000]")
	@JsonProperty("登録ユーザID")
	private String registUserId;

	/**
	 * 登録日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "登録日時", required = false, position = 32)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("登録日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
	private Date registTime;

	/**
	 * 更新ユーザID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "更新ユーザID", required = false, position = 33, allowableValues = "range[0,1000]")
	@JsonProperty("更新ユーザID")
	private String updateUserId;

	/**
	 * 更新日時
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "更新日時", required = false, position = 34)
	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("更新日時")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
	private Date updateTime;

	/**
	 * バージョン
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "バージョン", required = false, position = 35, allowableValues = "range[0,9999999999999999999]")
	@JsonProperty("バージョン")
	private BigDecimal rVersion;

	/**
	 * 支払間隔
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払間隔", required = false, position = 36, allowableValues = "range[0,2]")
	@JsonProperty("支払間隔")
	private String paymentInterval;

	/**
	 * 支払期間
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払期間", required = false, position = 37, allowableValues = "range[0,2]")
	@JsonProperty("支払期間")
	private String paymentPeriod;

	/**
	 * 帳票区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "帳票区分", required = false, position = 38, allowableValues = "range[0,1]")
	@JsonProperty("帳票区分")
	private String reportsMethod;

}
