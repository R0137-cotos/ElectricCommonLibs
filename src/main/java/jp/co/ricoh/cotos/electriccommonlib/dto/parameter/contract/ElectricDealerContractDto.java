package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricDealerContract;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricDealerContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ElectricDealerContract.class, repository = ElectricDealerContractRepository.class)
public class ElectricDealerContractDto extends DtoBase {

	/**
	 * 企業ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業ID", required = false, position = 3, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "販売店企業名", required = false, position = 4, allowableValues = "range[0,1000]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所電話番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "郵便番号", required = false, position = 6, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "住所", required = false, position = 7, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 8, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * 支払区分
	 */
	@ApiModelProperty(value = "支払区分", required = false, position = 9, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メールアドレス2
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 10, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 11, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 1ショット支払済フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "1ショット支払済フラグ", required = false, position = 12, allowableValues = "range[0,9]")
	private Integer oneShotPaidFlg;
}
