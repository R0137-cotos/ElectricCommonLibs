package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約情報変更作成用DTO: 契約情報（電力）
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricInfoChangeExtDto {

	/**
	 * 作成日
	 */
	@Size(max = 255)
	@Schema(description = "申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String entryDate;
}
