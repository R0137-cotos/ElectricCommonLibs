package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationReason;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.NonBillingReason;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CancellationInformationDto extends DtoBase {

	/**
	 * 解約希望日
	 */
	@ApiModelProperty(value = "解約希望日", required = false, position = 3)
	private Date cancellationHopeDate;

	/**
	 * 送電停止施行指定フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "送電停止施行指定フラグ", required = false, position = 4, allowableValues = "range[0,9]")
	private Integer transmissionStopFlg;

	/**
	 * 指定時刻
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "指定時刻", required = false, position = 5, allowableValues = "range[0,255]")
	private String specifiedTime;

	/**
	 * 解約望日
	 */
	@ApiModelProperty(value = "解約日", required = false, position = 6)
	private Date cancellationDate;

	/**
	 * 解約理由
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "解約理由", required = true, position = 7, allowableValues = "その他(\"1\")", example = "1")
	private CancellationReason cancellationReason;

	/**
	 * その他備考
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "その他備考", required = false, position = 8, allowableValues = "range[0,4000]")
	private String notesOther;

	/**
	 * 解約金額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "解約金額", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal cancellationAmount;

	/**
	 * 調整後金額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "調整後金額", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal adjustmentAmount;

	/**
	 * 清算金
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "清算金", required = false, position = 11, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal liquidationAmount;

	/**
	 * 調整後(清算金)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "調整後(清算金)", required = false, position = 12, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal adjustmentLiquidationAmount;

	/**
	 * 違約金
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "違約金", required = false, position = 13, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal penaltyAmount;

	/**
	 * 調整後(違約金)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@ApiModelProperty(value = "調整後(違約金)", required = false, position = 14, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal adjustmentPenaltyAmount;

	/**
	 * 解約金請求フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "解約金請求フラグ", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer cancellationBillingFlg;

	/**
	 * 非請求理由
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "非請求理由", required = true, position = 16, allowableValues = "その他(\"1\")", example = "1")
	private NonBillingReason nonBillingReason;

	/**
	 * 上長確認フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "上長確認フラグ", required = false, position = 17, allowableValues = "range[0,9]")
	private Integer superiorConfirmFlg;

	/**
	 * 解約種別
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "解約種別", required = true, position = 18, allowableValues = "消滅(\"1\"), 他社への切り替え(\"1\")", example = "1")
	private CancellationDiv cancellationDiv;
}
