package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "(洗替用)企業情報", required = true, position = 1)
	private List<CustomerInformationForWashingExtDto> customerInformationList;

}
