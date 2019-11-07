package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BillingHistoryUpdateDto {

	/**
	 * 請求基本情報ID
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "請求基本情報ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long billingBasicInformationId;

	/**
	 * 請求年月
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "請求年月", required = true, position = 2, allowableValues = "range[0,255]")
	private String billingYearMonth;

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
