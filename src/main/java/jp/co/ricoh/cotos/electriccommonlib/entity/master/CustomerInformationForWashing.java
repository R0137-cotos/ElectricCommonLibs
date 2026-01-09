package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 変更前MoM顧客企事部ID
	 */
	@Column(nullable = false)
	@Schema(description = "変更前MoM顧客企事部ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String originMclMomKjbId;

	/**
	 * MoM顧客企事部ID
	 */
	@Column(nullable = false)
	@Schema(description = "MoM顧客企事部ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String mclMomKjbId;

	/**
	 * MoM企業ID
	 */
	@Column(nullable = true)
	@Schema(description = "MoM企業ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String prflMomKgyId;

	/**
	 * MoM事業所ID
	 */
	@Column(nullable = true)
	@Schema(description = "MoM事業所ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String prflMomJgsId;

	/**
	 * 企事部設定区分
	 */
	@Column(nullable = true)
	@Schema(description = "企事部設定区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private DepartmentDiv prflKjbSetKbn;

	/**
	 * 企業名_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "企業名_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String kgyKgyNmKnji;

	/**
	 * 企業法人格区分
	 */
	@Column(nullable = true)
	@Schema(description = "企業法人格区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String kgyHjnKakuCd;

	/**
	 * 企業法人格前後区分
	 */
	@Column(nullable = true)
	@Schema(description = "企業法人格前後区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String kgyHjnKakuZengoCd;

	/**
	 * 企業名_カナ
	 */
	@Column(nullable = true)
	@Schema(description = "企業名_カナ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String kgyKgyNmKana;

	/**
	 * 事業所名_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "事業所名_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsNmKnji;

	/**
	 * 部門名_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "部門名_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bmnBmnNmKnji;

	/**
	 * 事業所郵便番号
	 */
	@Column(nullable = true)
	@Schema(description = "事業所郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsPostNum;

	/**
	 * 事業所代表TEL
	 */
	@Column(nullable = true)
	@Schema(description = "事業所代表TEL", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsTelNum;

	/**
	 * 事業所代表FAX
	 */
	@Column(nullable = true)
	@Schema(description = "事業所代表FAX", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsFaxNum;

	/**
	 * 住所都道府県名_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "住所都道府県名_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String adsJtdhknNmKnji;

	/**
	 * 住所市区郡町村名_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "住所市区郡町村名_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String adsJskugnchosnKnji;

	/**
	 * 住所大字・通称名_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "住所大字・通称名_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String adsJowaTusyoKnji;

	/**
	 * 住所字名・丁目_漢字
	 */
	@Column(nullable = true)
	@Schema(description = "住所字名・丁目_漢字", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String adsJkowChomeKnji;

	/**
	 * 事業所住所字通称名
	 */
	@Column(nullable = true)
	@Schema(description = "事業所住所字通称名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsAdsAzatusyoNm;

	/**
	 * 事業所住所番地名
	 */
	@Column(nullable = true)
	@Schema(description = "事業所住所番地名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsAdsBantiNm;

	/**
	 * 事業所住所号名
	 */
	@Column(nullable = true)
	@Schema(description = "事業所住所号名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsAdsGoNm;

	/**
	 * 事業所住所ビル名
	 */
	@Column(nullable = true)
	@Schema(description = "事業所住所ビル名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsAdsBldgNm;

	/**
	 * 事業所住所フロア名
	 */
	@Column(nullable = true)
	@Schema(description = "事業所住所フロア名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String jgsJgsAdsFlorNm;

}
