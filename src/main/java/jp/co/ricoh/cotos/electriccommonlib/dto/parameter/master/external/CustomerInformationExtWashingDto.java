package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomerInformationExtWashingDto {

	/**
	 * (洗替用)企業情報
	 */
	@Valid
	@NotNull
	@Schema(description = "(洗替用)企業情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<CustomerInformationForWashingExtDto> customerInformationList;

}
