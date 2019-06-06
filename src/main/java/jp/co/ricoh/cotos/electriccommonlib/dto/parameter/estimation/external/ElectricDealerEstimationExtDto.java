package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricDealerEstimationExtDto extends DtoBase {

	/**
	 * 企業ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "企業ID", required = false, position = 3, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 企業_事業所名
	 */
	@Size(max = 1000)
	@ApiModelProperty(value = "企業_事業所名", required = false, position = 4, allowableValues = "range[0,1000]")
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
	@Size(max = 4000)
	@ApiModelProperty(value = "住所", required = false, position = 7, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 8, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 9, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 10, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 支払区分
	 */
	@ApiModelProperty(value = "支払区分", required = false, position = 11, allowableValues = "定率(\"1\"), 定額(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

}
