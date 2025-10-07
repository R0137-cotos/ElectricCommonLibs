package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.VKjbMaster.DepartmentDiv;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.CustomerInformationForWashingRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * （洗替用）企業情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "customer_information_for_washing")
@CotosComplementTarget(entity = CustomerInformationForWashing.class, repository = CustomerInformationForWashingRepository.class)
public class CustomerInformationForWashing extends EntityBaseMaster {

	@Id
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 変更前MoM顧客企事部ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "変更前MoM顧客企事部ID", required = true, position = 2, allowableValues = "range[0,255]")
	private String originMclMomKjbId;

	/**
	 * MoM顧客企事部ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "MoM顧客企事部ID", required = true, position = 3, allowableValues = "range[0,255]")
	private String mclMomKjbId;

	/**
	 * MoM企業ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "MoM企業ID", required = false, position = 4, allowableValues = "range[0,255]")
	private String prflMomKgyId;

	/**
	 * MoM事業所ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "MoM事業所ID", required = false, position = 5, allowableValues = "range[0,255]")
	private String prflMomJgsId;

	/**
	 * 企事部設定区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企事部設定区分", required = false, position = 6, allowableValues = "range[0,255]")
	private DepartmentDiv prflKjbSetKbn;

	/**
	 * 企業名_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企業名_漢字", required = false, position = 7, allowableValues = "range[0,255]")
	private String kgyKgyNmKnji;

	/**
	 * 企業法人格区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企業法人格区分", required = false, position = 8, allowableValues = "range[0,255]")
	private String kgyHjnKakuCd;

	/**
	 * 企業法人格前後区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企業法人格前後区分", required = false, position = 9, allowableValues = "range[0,255]")
	private String kgyHjnKakuZengoCd;

	/**
	 * 企業名_カナ
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "企業名_カナ", required = false, position = 10, allowableValues = "range[0,255]")
	private String kgyKgyNmKana;

	/**
	 * 事業所名_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所名_漢字", required = false, position = 11, allowableValues = "range[0,255]")
	private String jgsJgsNmKnji;

	/**
	 * 部門名_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "部門名_漢字", required = false, position = 12, allowableValues = "range[0,255]")
	private String bmnBmnNmKnji;

	/**
	 * 事業所郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所郵便番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String jgsJgsPostNum;

	/**
	 * 事業所代表TEL
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所代表TEL", required = false, position = 14, allowableValues = "range[0,255]")
	private String jgsJgsTelNum;

	/**
	 * 事業所代表FAX
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所代表FAX", required = false, position = 15, allowableValues = "range[0,255]")
	private String jgsJgsFaxNum;

	/**
	 * 住所都道府県名_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所都道府県名_漢字", required = false, position = 16, allowableValues = "range[0,255]")
	private String adsJtdhknNmKnji;

	/**
	 * 住所市区郡町村名_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所市区郡町村名_漢字", required = false, position = 17, allowableValues = "range[0,255]")
	private String adsJskugnchosnKnji;

	/**
	 * 住所大字・通称名_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所大字・通称名_漢字", required = false, position = 18, allowableValues = "range[0,255]")
	private String adsJowaTusyoKnji;

	/**
	 * 住所字名・丁目_漢字
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所字名・丁目_漢字", required = false, position = 19, allowableValues = "range[0,255]")
	private String adsJkowChomeKnji;

	/**
	 * 事業所住所字通称名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所住所字通称名", required = false, position = 20, allowableValues = "range[0,255]")
	private String jgsJgsAdsAzatusyoNm;

	/**
	 * 事業所住所番地名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所住所番地名", required = false, position = 21, allowableValues = "range[0,255]")
	private String jgsJgsAdsBantiNm;

	/**
	 * 事業所住所号名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所住所号名", required = false, position = 22, allowableValues = "range[0,255]")
	private String jgsJgsAdsGoNm;

	/**
	 * 事業所住所ビル名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所住所ビル名", required = false, position = 23, allowableValues = "range[0,255]")
	private String jgsJgsAdsBldgNm;

	/**
	 * 事業所住所フロア名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所住所フロア名", required = false, position = 24, allowableValues = "range[0,255]")
	private String jgsJgsAdsFlorNm;

}
