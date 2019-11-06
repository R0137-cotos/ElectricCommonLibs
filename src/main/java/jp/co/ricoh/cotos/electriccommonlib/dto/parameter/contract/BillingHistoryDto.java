package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.BeforeDebitContact;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendMyRicoh;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.AccruedSection;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.InvoiceCreateDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.InvoiceForm;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.SendMail;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingHistoryRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = BillingHistory.class, repository = BillingHistoryRepository.class)
public class BillingHistoryDto extends DtoBase {

	/**
	 * No.
	 */
	@Max(99999)
	@ApiModelProperty(value = "No.", required = false, position = 3, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 請求NO
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求NO", required = false, position = 4, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "請求年月", required = true, position = 5, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "売上年月日", required = false, position = 6, allowableValues = "range[0,255]")
	private String salesDate;

	/**
	 * 手数料計上日時
	 */
	@ApiModelProperty(value = "手数料計上日時", required = false, position = 7)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 請求金額(税込)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "請求金額(税込)", required = false, position = 8, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimAmountInTax;

	/**
	 * 請求消費税額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "請求消費税額", required = false, position = 9, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimTax;

	/**
	 * 請求金額(税抜)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "請求金額(税抜)", required = false, position = 10, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimAmountOutTax;

	/**
	 * 引落予定日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "引落予定日", required = false, position = 11, allowableValues = "range[0,255]")
	private String debitScheduleDay;

	/**
	 * 未収区分
	 */
	@ApiModelProperty(value = "未収区分", required = false, position = 12, allowableValues = "未受信(\"1\"), 未回収(\"2\"), 回収済(\"3\")", example = "1")
	private AccruedSection accruedSection;

	/**
	 * 未収事由
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "未収事由", required = false, position = 13, allowableValues = "range[0,255]")
	private String accruedReason;

	/**
	 * 未収判定日時
	 */
	@ApiModelProperty(value = "未収判定日時", required = false, position = 14)
	@Temporal(TemporalType.DATE)
	private Date accuredJudgeDay;

	/**
	 * 未回収フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@ApiModelProperty(value = "未回収分回収日", required = false, position = 16)
	@Temporal(TemporalType.DATE)
	private Date accruedCollectionDate;

	/**
	 * 請求書発送区分
	 */
	@ApiModelProperty(value = "請求書発送区分", required = false, position = 17, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "請求書出力フラグ", required = false, position = 18, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

	/**
	 * 電力請求添付ファイル
	 */
	@ApiModelProperty(value = "電力請求添付ファイル", required = false, position = 19)
	private List<ElectricBillingAttachedFileDto> electricBillingAttachedFileList;

	/**
	 * 引落前連絡
	 */
	@ApiModelProperty(value = "引落前連絡", required = false, position = 20, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private BeforeDebitContact beforeDebitContact;

	/**
	 * MyRicoh送信
	 */
	@ApiModelProperty(value = "MyRicoh送信", required = false, position = 21, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMyRicoh sendMyRicoh;

	/**
	 * 供給期間(開始)
	 */
	@ApiModelProperty(value = "供給期間(開始)", required = false, position = 22)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdStart;

	/**
	 * 供給期間(終了)
	 */
	@ApiModelProperty(value = "供給期間(終了)", required = false, position = 23)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdEnd;

	/**
	 * 請求書作成区分
	 */
	@ApiModelProperty(value = "請求書作成区分", required = false, position = 24, allowableValues = "未作成(\"0\"), 作成済(\"1\"), 社内利用(\"9\")", example = "0")
	private InvoiceCreateDiv invoiceCreateDiv;

	/**
	 * メール送信
	 */
	@ApiModelProperty(value = "メール送信", required = false, position = 25, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMail sendMail;

	/**
	 * 請求書様式
	 */
	@ApiModelProperty(value = "請求書様式", required = false, position = 26, allowableValues = "単一(\"1\"), 複数(\"2\")", example = "1")
	private InvoiceForm invoiceForm;

	/**
	 * 請求基本情報
	 */
	@ApiModelProperty(value = "請求基本情報ID", required = true, position = 27)
	private BillingBasicInformationDto billingBasicInformation;

}
