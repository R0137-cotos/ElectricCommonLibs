package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "販社コード", required = false, position = 2, allowableValues = "range[0,255]")
	private String tradingCompanyCode;

	/**
	 * 得意先CD
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "得意先CD", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求書発送区分
	 */
	@ApiModelProperty(value = "請求書発送区分", required = false, position = 4, allowableValues = "郵送のみ(\"1\")", example = "1")
	private SendInvoiceDiv sendInvoiceDiv;

	/**
	 * 請求先名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求先名", required = false, position = 5, allowableValues = "range[0,4000]")
	private String billingName;

	/**
	 * 敬称
	 */
	@ApiModelProperty(value = "敬称", required = false, position = 6, allowableValues = "御中(\"1\")", example = "1")
	private Honorific honorific;

	/**
	 * 請求先郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求先郵便番号", required = false, position = 7, allowableValues = "range[0,255]")
	private String billingZipCode;

	/**
	 * 請求先住所
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求先住所", required = false, position = 8, allowableValues = "range[0,255]")
	private String billingAddress;

	/**
	 * サイト番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "サイト番号", required = false, position = 9, allowableValues = "range[0,255]")
	private String siteNumber;

	/**
	 * 回収方法
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "回収方法", required = false, position = 10, allowableValues = "自振(RL)(\"1\")", example = "1")
	private String collectMethod;

	/**
	 * 回収条件
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "回収条件", required = false, position = 11, allowableValues = "range[0,255]")
	private String collectCondition;

	/**
	 * お客様口座番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "お客様口座番号", required = false, position = 12, allowableValues = "range[0,255]")
	private String customerAccountNumber;

	/**
	 * 銀行番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "銀行番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String bankNumber;

	/**
	 * 銀行名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "銀行名", required = false, position = 14, allowableValues = "range[0,255]")
	private String bankName;

	/**
	 * 支店番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "支店番号", required = false, position = 15, allowableValues = "range[0,255]")
	private String branchNumber;

	/**
	 * 支店名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "支店名", required = false, position = 16, allowableValues = "range[0,255]")
	private String branchName;

	/**
	 * 口座名義人名カナ
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "口座名義人名カナ", required = false, position = 17, allowableValues = "range[0,255]")
	private String accountHolderKana;

	/**
	 * 部門/バーチャル口座番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "部門/バーチャル口座番号", required = false, position = 18, allowableValues = "range[0,255]")
	private String vertualAccountNumber;

	/**
	 * 銀行コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "銀行コード", required = false, position = 19, allowableValues = "range[0,255]")
	private String bankCode;

	/**
	 * 本支店コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "本支店コード", required = false, position = 20, allowableValues = "range[0,255]")
	private String branchCode;

	/**
	 * 口座種別
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "口座種別", required = false, position = 21, allowableValues = "range[0,255]")
	private String accountType;

	/**
	 * 売上課所コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "売上課所コード", required = false, position = 22, allowableValues = "range[0,255]")
	private String salesDivisionCode;

	/**
	 * 請求先分類
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "請求先分類", required = false, position = 23, allowableValues = "range[0,255]")
	private String billingDiv;

}
