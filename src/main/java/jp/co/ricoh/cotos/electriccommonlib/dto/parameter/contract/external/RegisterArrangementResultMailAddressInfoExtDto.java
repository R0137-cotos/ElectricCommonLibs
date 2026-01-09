package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class RegisterArrangementResultMailAddressInfoExtDto {

	/**
	 * 氏名
	 */
	@Size(max = 255)
	@Schema(description = "氏名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Size(max = 255)
	@Schema(description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress;
}
