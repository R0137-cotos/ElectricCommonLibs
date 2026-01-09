package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BillingHistoryUpdateDto {

	/**
	 * 請求実績ID
	 */
	@NotNull
	@Min(0)
	@Schema(description = "請求実績ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long billingHistoryId;

	/**
	 * 未回収フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "未回収フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 請求書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "請求書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

}
