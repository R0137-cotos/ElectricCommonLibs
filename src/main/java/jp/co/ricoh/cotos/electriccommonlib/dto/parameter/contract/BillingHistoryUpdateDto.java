package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BillingHistoryUpdateDto {

	/**
	 * 請求実績ID
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "請求実績ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long billingHistoryId;

	/**
	 * 未回収フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 3, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 請求書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 4, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

}
