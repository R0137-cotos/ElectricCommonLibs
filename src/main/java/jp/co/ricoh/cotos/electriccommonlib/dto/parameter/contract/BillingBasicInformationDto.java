package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation.Honorific;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingBasicInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = BillingBasicInformation.class, repository = BillingBasicInformationRepository.class)
public class BillingBasicInformationDto extends DtoBase {

	/**
	 * 販社コード
	 */
	@Size(max = 255)
	@Schema(description = "販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 得意先CD
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "得意先CD", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求書発送区分
	 */
	@Schema(description = "請求書発送区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "郵送のみ(\"1\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求先名
	 */
	@Size(max = 255)
	@Schema(description = "請求先名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String billingName;

	/**
	 * 敬称
	 */
	@Schema(description = "敬称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "御中(\"1\")", example = "1")
	private Honorific honorific;

	/**
	 * 請求先郵便番号
	 */
	@Size(max = 255)
	@Schema(description = "請求先郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingZipCode;

	/**
	 * 請求先住所
	 */
	@Size(max = 255)
	@Schema(description = "請求先住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingAddress;

	/**
	 * サイト番号
	 */
	@Size(max = 255)
	@Schema(description = "サイト番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String siteNumber;

	/**
	 * 回収方法
	 */
	@Size(max = 255)
	@Schema(description = "回収方法", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "自振(RL)(\"1\")", example = "1")
	private String collectMethod;

	/**
	 * 回収条件
	 */
	@Size(max = 255)
	@Schema(description = "回収条件", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String collectCondition;

	/**
	 * お客様口座番号
	 */
	@Size(max = 255)
	@Schema(description = "お客様口座番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerAccountNumber;

	/**
	 * 銀行番号
	 */
	@Size(max = 255)
	@Schema(description = "銀行番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bankNumber;

	/**
	 * 銀行名
	 */
	@Size(max = 255)
	@Schema(description = "銀行名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bankName;

	/**
	 * 支店番号
	 */
	@Size(max = 255)
	@Schema(description = "支店番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String branchNumber;

	/**
	 * 支店名
	 */
	@Size(max = 255)
	@Schema(description = "支店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String branchName;

	/**
	 * 口座名義人名カナ
	 */
	@Size(max = 255)
	@Schema(description = "口座名義人名カナ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String accountHolderKana;

	/**
	 * 部門/バーチャル口座番号
	 */
	@Size(max = 255)
	@Schema(description = "部門/バーチャル口座番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String vertualAccountNumber;

	/**
	 * 銀行コード
	 */
	@Size(max = 255)
	@Schema(description = "銀行コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bankCode;

	/**
	 * 本支店コード
	 */
	@Size(max = 255)
	@Schema(description = "本支店コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String branchCode;

	/**
	 * 口座種別
	 */
	@Size(max = 255)
	@Schema(description = "口座種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String accountType;

	/**
	 * 売上課所コード
	 */
	@Size(max = 255)
	@Schema(description = "売上課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String salesDivisionCode;

	/**
	 * 請求先分類
	 */
	@Size(max = 255)
	@Schema(description = "請求先分類", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String billingDiv;

	/**
	 * 口座引落前連絡メール配信
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "口座引落前連絡メール配信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer sendMailFlg;

	/**
	 * RJ部門名
	 */
	@Size(max = 255)
	@Schema(description = "RJ部門名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String rjDepartmentName;

	/**
	 * 振込先銀行名
	 */
	@Size(max = 255)
	@Schema(description = "振込先銀行名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String transferBankName;

	/**
	 * 振込先銀行支店名
	 */
	@Size(max = 255)
	@Schema(description = "振込先銀行支店名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String transferBranchName;

}
