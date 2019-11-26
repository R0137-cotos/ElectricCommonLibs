package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.AccruedSection;
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
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 2, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 請求書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 3, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

	/**
	 * 未収区分
	 */
	@ApiModelProperty(value = "未収区分", required = false, position = 4, allowableValues = "未受信(\"1\"), 未回収(\"2\"), 回収済(\"3\")", example = "1")
	private AccruedSection accruedSection;

	/**
	 * 未回収分回収日
	 */
	@ApiModelProperty(value = "未回収分回収日", required = false, position = 5)
	@Temporal(TemporalType.DATE)
	private Date accruedCollectionDate;

}
