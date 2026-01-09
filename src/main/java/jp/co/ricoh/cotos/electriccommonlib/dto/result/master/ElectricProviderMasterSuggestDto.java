package jp.co.ricoh.cotos.electriccommonlib.dto.result.master;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 登録番号
	 */
	@Schema(description = "登録番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String registrationNumber;

	/**
	 * 氏名又は名称
	 */
	@Schema(description = "氏名又は名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String providerName;

	/**
	 * 氏名又は名称（半角）
	 */
	@Schema(description = "登録番号（半角）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String providerNameSingle;

	/**
	 * 氏名又は名称（全角）
	 */
	@Schema(description = "氏名又は名称（全角）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String providerNameMulti;

}