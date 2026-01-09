package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約情報変更作成用DTO: 契約情報
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ContractInfoChangeExtDto {

	/**
	 * 契約ID
	 */
	@NotNull
	@Min(0)
	@Schema(description = "変更元契約ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 作成日
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "作成日", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String changePreferredDate;

	/**
	 * 契約情報（電力）
	 */
	@Valid
	@NotNull
	@Schema(description = "契約情報（電力）", requiredMode = Schema.RequiredMode.REQUIRED)
	private ContractElectricInfoChangeExtDto contractElectric;

}
