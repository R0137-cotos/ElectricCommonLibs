package jp.co.ricoh.cotos.electriccommonlib.dto.result.master;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電気事業者マスタのサジェスト入力候補を返すDTO
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricProviderMasterSuggestDto {

	@Id
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 登録番号
	 */
	@ApiModelProperty(value = "登録番号", required = false, position = 2, allowableValues = "range[0,255]")
	private String registrationNumber;

	/**
	 * 氏名又は名称
	 */
	@ApiModelProperty(value = "氏名又は名称", required = false, position = 3, allowableValues = "range[0,255]")
	private String providerName;

	/**
	 * 氏名又は名称（半角）
	 */
	@ApiModelProperty(value = "登録番号（半角）", required = false, position = 4, allowableValues = "range[0,255]")
	private String providerNameSingle;

	/**
	 * 氏名又は名称（全角）
	 */
	@ApiModelProperty(value = "氏名又は名称（全角）", required = false, position = 5, allowableValues = "range[0,255]")
	private String providerNameMulti;

}