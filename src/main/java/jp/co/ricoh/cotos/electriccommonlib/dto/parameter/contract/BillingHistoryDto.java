package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.BeforeDebitContact;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendMyRicoh;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
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
	@Schema(description = "No.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999]")
	private Long displaySequenceNumber;

	/**
	 * 請求NO
	 */
	@Size(max = 255)
	@Schema(description = "請求NO", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@Size(max = 255)
	@Schema(description = "売上年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesDate;

	/**
	 * 手数料計上日時
	 */
	@Schema(description = "手数料計上日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date feeAppropriationDay;

	/**
	 * 請求金額(税込)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "請求金額(税込)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimAmountInTax;

	/**
	 * 請求消費税額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "請求消費税額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimTax;

	/**
	 * 請求金額(税抜)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "請求金額(税抜)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal claimAmountOutTax;

	/**
	 * 引落予定日
	 */
	@Size(max = 255)
	@Schema(description = "引落予定日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String debitScheduleDay;

	/**
	 * 未収区分
	 */
	@Schema(description = "未収区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未受信(\"1\"), 未回収(\"2\"), 回収済(\"3\")", example = "1")
	private AccruedSection accruedSection;

	/**
	 * 未収事由
	 */
	@Size(max = 255)
	@Schema(description = "未収事由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String accruedReason;

	/**
	 * 未収判定日時
	 */
	@Schema(description = "未収判定日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date accuredJudgeDay;

	/**
	 * 未回収フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "未回収フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@Schema(description = "未回収分回収日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date accruedCollectionDate;

	/**
	 * 請求書発送区分
	 */
	@Schema(description = "請求書発送区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "メール+MyRICOH(\"1\"), メール(\"2\"), 紙請求(\"3\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求書出力フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "請求書出力フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer invoiceOutputFlg;

	/**
	 * 電力請求添付ファイル
	 */
	@Schema(description = "電力請求添付ファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ElectricBillingAttachedFileDto> electricBillingAttachedFileList;

	/**
	 * 引落前連絡
	 */
	@Schema(description = "引落前連絡", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private BeforeDebitContact beforeDebitContact;

	/**
	 * MyRicoh送信
	 */
	@Schema(description = "MyRicoh送信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMyRicoh sendMyRicoh;

	/**
	 * 供給期間(開始)
	 */
	@Schema(description = "供給期間(開始)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdStart;

	/**
	 * 供給期間(終了)
	 */
	@Schema(description = "供給期間(終了)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date electricSupplyYmdEnd;

	/**
	 * 請求書作成区分
	 */
	@Schema(description = "請求書作成区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未作成(\"0\"), 作成済(\"1\"), 社内利用(\"9\")", example = "0")
	private InvoiceCreateDiv invoiceCreateDiv;

	/**
	 * メール送信
	 */
	@Schema(description = "メール送信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMail sendMail;

	/**
	 * 請求書様式
	 */
	@Schema(description = "請求書様式", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "単一(\"1\"), 複数(\"2\")", example = "1")
	private InvoiceForm invoiceForm;

	/**
	 * 電力区分
	 */
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 請求書発行年月日
	 */
	@Schema(description = "請求書発行年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.DATE)
	private Date invoiceIssueDate;

	/**
	 * 請求メール送信日時
	 */
	@Schema(description = "請求メール送信日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.TIMESTAMP)
	private Date invoiceSendMailAt;

	/**
	 * 請求基本情報
	 */
	@Schema(description = "請求基本情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private BillingBasicInformationDto billingBasicInformation;

}
