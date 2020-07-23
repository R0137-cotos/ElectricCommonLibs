package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class RegisterArrangementResultElectricDealerContractExtDto {

	/**
	 * 企業ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業ID", required = false, position = 1, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 企業_事業所名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業_事業所名", required = false, position = 2, allowableValues = "range[0,1000]")
	private String companyBusinessName;
}
