package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
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
	@JsonProperty("HNBITN_CD")
	private String hnbitnCd;

	/**
	 * 販売店名(カナ)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店名(カナ)", required = false, position = 3, allowableValues = "range[0,1000]")
	@JsonProperty("HNBITN_MI_KN")
	private String hnbitnMiKn;

	/**
	 * 販売店名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店名", required = false, position = 4, allowableValues = "range[0,1000]")
	@JsonProperty("HNBITN_MI")
	private String hnbitnMi;

	/**
	 * 販売店事業所名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店事業所名", required = false, position = 5, allowableValues = "range[0,1000]")
	@JsonProperty("HNBITN_JGYSY_MI")
	private String hnbitnJgysyMi;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電話番号", required = false, position = 6, allowableValues = "range[0,1000]")
	@JsonProperty("DNW_BNGU")
	private String dnwBngu;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "郵便番号", required = false, position = 7, allowableValues = "range[0,1000]")
	@JsonProperty("YBN_BNGU")
	private String ybnBngu;

	/**
	 * 住所1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所1", required = false, position = 8, allowableValues = "range[0,1000]")
	@JsonProperty("ZYUSY1")
	private String zyusy1;

	/**
	 * 住所2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所2", required = false, position = 9, allowableValues = "range[0,1000]")
	@JsonProperty("ZYUSY2")
	private String zyusy2;

	/**
	 * 銀行番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行番号", required = false, position = 10, allowableValues = "range[0,1000]")
	@JsonProperty("GNNKU_BNGU")
	private String gnnkuBngu;

	/**
	 * 銀行名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "銀行名", required = false, position = 11, allowableValues = "range[0,1000]")
	@JsonProperty("GNNKU_MI")
	private String gnnkuMi;

	/**
	 * 支店コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店コード", required = false, position = 12, allowableValues = "range[0,10]")
	@JsonProperty("SHTN_CD")
	private String shtnCd;

	/**
	 * 支店名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支店名", required = false, position = 13, allowableValues = "range[0,1000]")
	@JsonProperty("SHTN_MI")
	private String shtnMi;

	/**
	 * 口座種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座種別", required = false, position = 14, allowableValues = "range[0,1000]")
	@JsonProperty("KUZ_SYBTS")
	private String kuzSybts;

	/**
	 * 口座番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座番号", required = false, position = 15, allowableValues = "range[0,1000]")
	@JsonProperty("KUZ_BNGU")
	private String kuzBngu;

	/**
	 * 口座名義人名カナ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "口座名義人名カナ", required = false, position = 16, allowableValues = "range[0,1000]")
	@JsonProperty("KUZ_MIGNN_MI_KN")
	private String kuzMignnMiKn;

	/**
	 * 担当者名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "担当者名", required = false, position = 17, allowableValues = "range[0,1000]")
	@JsonProperty("TNTSY_MI")
	private String tntsyMi;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 18, allowableValues = "range[0,1000]")
	@JsonProperty("MAIL_ADDRESS1")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス2", required = false, position = 19, allowableValues = "range[0,1000]")
	@JsonProperty("MAIL_ADDRESS2")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 20, allowableValues = "range[0,1000]")
	@JsonProperty("MAIL_ADDRESS3")
	private String mailAddress3;

	/**
	 * 契約期間(自)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(自)", required = false, position = 21, allowableValues = "range[0,10]")
	@JsonProperty("KIYK_KKN_FROM")
	private String kiykKknFrom;

	/**
	 * 契約期間(至)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "契約期間(至)", required = false, position = 22, allowableValues = "range[0,10]")
	@JsonProperty("KIYK_KKN_TO")
	private String kiykKknTo;

	/**
	 * 商流区分コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商流区分コード", required = false, allowableValues = "range[0,1]", position = 23)
	@JsonProperty("SYURYU_KBN_CD")
	private String syuryuKbnCd;

	/**
	 * 商流区分名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "商流区分名", required = false, allowableValues = "range[0,1000]", position = 24)
	@JsonProperty("SYURYU_KBN_MI")
	private String syuryuKbnMi;

	/**
	 * 支払方法区分コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払方法区分コード", required = false, position = 25, allowableValues = "range[0,1]")
	@JsonProperty("SHHRI_HUHU_KBN_CD")
	private String shhriHuhuKbnCd;

	/**
	 * 支払方法区分名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "支払方法区分名", required = false, position = 26, allowableValues = "range[0,1000]")
	@JsonProperty("SHHRI_HUHU_KBN_MI")
	private String shhriHuhuKbnMi;

	/**
	 * 媒介手数料率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "媒介手数料率", required = false, position = 27, allowableValues = "range[0,99999999999.99]")
	@JsonProperty("BIKI_TSURYU_RT")
	private BigDecimal bikiTsuryuRt;
}
