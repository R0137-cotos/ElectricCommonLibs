package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractFindOneResultDto {

	/**
	 * 契約(標準)
	 */
	@ApiModelProperty(value = "契約(標準)", required = true, position = 1)
	private Contract contract;

	/**
	 * 契約(電力)
	 */
	@ApiModelProperty(value = "契約(電力)", required = true, position = 2)
	private ContractElectric contractElectric;

}
