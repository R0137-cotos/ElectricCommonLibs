package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricDealerContractChangePlanExtDto {

	/**
	 * 企業ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業ID", required = false, position = 1, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "販売店企業名", required = false, position = 2, allowableValues = "range[0,1000]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "事業所電話番号", required = false, position = 3, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "郵便番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "住所", required = false, position = 5, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 6, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * 支払区分
	 */
	@ApiModelProperty(value = "支払区分", required = false, position = 7, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メールアドレス2
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス2", required = false, position = 8, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 9, allowableValues = "range[0,255]")
	private String mailAddress3;
}
