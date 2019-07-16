package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.contract.Contract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractResultDto {

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

	/**
	 * 請求基本情報
	 */
	@ApiModelProperty(value = "請求基本情報", required = false, position = 3)
	private BillingBasicInformation billingBasicInformation;

}
