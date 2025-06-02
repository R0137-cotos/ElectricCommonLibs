package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerInformationForWashingExtDto {

	/** 変更前MoM顧客企事部ID */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "変更前MoM顧客企事部ID", required = true, position = 1, allowableValues = "range[0,255]")
	private String originMclMomKjbId;

	/** MoM顧客企事部ID */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "MoM顧客企事部ID", required = true, position = 2, allowableValues = "range[0,255]")
	private String mclMomKjbId;

	/** MoM企業ID */
	@Size(max = 255)
	@ApiModelProperty(value = "MoM企業ID", required = false, position = 3, allowableValues = "range[0,255]")
	private String prflMomKgyId;

	/** MoM事業所ID */
	@Size(max = 255)
	@ApiModelProperty(value = "MoM事業所ID", required = false, position = 4, allowableValues = "range[0,255]")
	private String prflMomJgsId;

	/** 企事部設定区分 */
	@Size(max = 255)
	@ApiModelProperty(value = "企事部設定区分", required = false, position = 5, allowableValues = "range[0,255]")
	private String prflKjbSetKbn;

	/** 企業名_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業名_漢字", required = false, position = 6, allowableValues = "range[0,255]")
	private String kgyKgyNmKnji;

	/** 企業法人格区分 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業法人格区分", required = false, position = 7, allowableValues = "range[0,255]")
	private String kgyHjnKakuCd;

	/** 企業法人格前後区分 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業法人格前後区分", required = false, position = 8, allowableValues = "range[0,255]")
	private String kgyHjnKakuZengoCd;

	/** 企業名_カナ */
	@Size(max = 255)
	@ApiModelProperty(value = "企業名_カナ", required = false, position = 9, allowableValues = "range[0,255]")
	private String kgyKgyNmKana;

	/** 事業所名_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所名_漢字", required = false, position = 10, allowableValues = "range[0,255]")
	private String jgsJgsNmKnji;

	/** 部門名_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "部門名_漢字", required = false, position = 11, allowableValues = "range[0,255]")
	private String bmnBmnNmKnji;

	/** 事業所郵便番号 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所郵便番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String jgsJgsPostNum;

	/** 事業所代表TEL */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所代表TEL", required = false, position = 13, allowableValues = "range[0,255]")
	private String jgsJgsTelNum;

	/** 事業所代表FAX */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所代表FAX", required = false, position = 14, allowableValues = "range[0,255]")
	private String jgsJgsFaxNum;

	/** 住所都道府県名_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "住所都道府県名_漢字", required = false, position = 15, allowableValues = "range[0,255]")
	private String adsJtdhknNmKnji;

	/** 住所市区郡町村名_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "住所市区郡町村名_漢字", required = false, position = 16, allowableValues = "range[0,255]")
	private String adsJskugnchosnKnji;

	/** 住所大字・通称名_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "住所大字・通称名_漢字", required = false, position = 17, allowableValues = "range[0,255]")
	private String adsJowaTusyoKnji;

	/** 住所字名・丁目_漢字 */
	@Size(max = 255)
	@ApiModelProperty(value = "住所字名・丁目_漢字", required = false, position = 18, allowableValues = "range[0,255]")
	private String adsJkowChomeKnji;

	/** 事業所住所字通称名 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所住所字通称名", required = false, position = 19, allowableValues = "range[0,255]")
	private String jgsJgsAdsAzatusyoNm;

	/** 事業所住所番地名 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所住所番地名", required = false, position = 20, allowableValues = "range[0,255]")
	private String jgsJgsAdsBantiNm;

	/** 事業所住所号名 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所住所号名", required = false, position = 21, allowableValues = "range[0,255]")
	private String jgsJgsAdsGoNm;

	/** 事業所住所ビル名 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所住所ビル名", required = false, position = 22, allowableValues = "range[0,255]")
	private String jgsJgsAdsBldgNm;

	/** 事業所住所フロア名 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所住所フロア名", required = false, position = 23, allowableValues = "range[0,255]")
	private String jgsJgsAdsFlorNm;

}
