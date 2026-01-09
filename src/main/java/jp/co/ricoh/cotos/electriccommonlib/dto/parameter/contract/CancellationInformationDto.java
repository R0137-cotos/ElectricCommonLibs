package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationAmountType;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationReason;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = CancellationInformationDto.class, repository = CancellationInformationRepository.class)
public class CancellationInformationDto extends DtoBase {

	/**
	 * 解約希望日
	 */
	@Temporal(TemporalType.DATE)
	@Schema(description = "解約希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationHopeDate;

	/**
	 * 送電停止施行指定フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "送電停止施行指定フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer transmissionStopFlg;

	/**
	 * 指定時刻
	 */
	@Size(max = 255)
	@Schema(description = "指定時刻", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String specifiedTime;

	/**
	 * 解約日
	 */
	@Temporal(TemporalType.DATE)
	@Schema(description = "解約日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationDate;

	/**
	 * 解約理由
	 * ※解約理由情報エンティティに移行するため以後、未使用
	 */
	@Schema(description = "解約理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "その他(\"1\")", example = "1")
	private CancellationReason cancellationReason;

	/**
	 * その他備考
	 */
	@Size(max = 4000)
	@Schema(description = "その他備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notesOther;

	/**
	 * 解約金額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "解約金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal cancellationAmount;

	/**
	 * 調整後金額
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "調整後金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal adjustmentAmount;

	/**
	 * 清算金
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "清算金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal liquidationAmount;

	/**
	 * 調整後(清算金)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "調整後(清算金)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal adjustmentLiquidationAmount;

	/**
	 * 違約金
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "違約金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal penaltyAmount;

	/**
	 * 調整後(違約金)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 19, fraction = 2)
	@Schema(description = "調整後(違約金)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal adjustmentPenaltyAmount;

	/**
	 * 解約金請求フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "解約金請求フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer cancellationBillingFlg;

	/**
	 * 非請求理由
	 */
	@Size(max = 4000)
	@Schema(description = "非請求理由", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,4000]")
	private String nonBillingReason;

	/**
	 * 上長確認フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "上長確認フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer superiorConfirmFlg;

	/**
	 * 解約種別
	 */
	@Schema(description = "解約種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "消滅(\"1\"), 他社への切り替え_お客様申込(\"2\"), 他社への切り替え_広域申込(\"3\")", example = "1")
	private CancellationDiv cancellationDiv;

	/**
	 * 手配結果登録確定日
	 */
	@Temporal(TemporalType.DATE)
	@Schema(description = "手配結果登録確定日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date registerArrangedDate;

	/**
	 * （解約手続時点）需給（供給）期間 終了日
	 */
	@Temporal(TemporalType.DATE)
	@Schema(description = "（解約手続時点）需給（供給）期間 終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractYmdEndAtCancellation;

	/**
	 * 解約金額分類
	 */
	@Schema(description = "解約金額分類", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "満額請求(\"1\"), 減額請求(\"2\"), 免除(\"3\")")
	private CancellationAmountType cancellationAmountType;

	/**
	 * 解約詳細情報
	 */
	@Valid
	@Schema(description = "解約詳細情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationDetailInformationDto cancellationDetailInformation;

	/**
	 * 解約理由情報
	 */
	@Valid
	@Schema(description = "解約理由情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationReasonInformationDto cancellationReasonInformation;
}
