package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ClientInformationDto extends DtoBase {

	/**
	 * 得意先CD
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "得意先CD", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求先Mailアドレス情報
	 */
	@OneToMany(mappedBy = "clientInformationDto")
	@ApiModelProperty(value = "請求先Mailアドレス情報", required = true, position = 4)
	private BillingMailAddressInformationDto billingMailAddressInformationDto;

	/**
	 * アクティブflg
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アクティブflg", required = false, position = 5, allowableValues = "range[0,9]")
	private Integer activeFlg;
	
	/**
	 * 販社CD
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "販社CD", required = true, position = 6, allowableValues = "range[0,255]")
	private String salesCompanyCode;
	
	/**
	 * 請求先名 敬称
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "請求先名 敬称", required = true, position = 7, allowableValues = "range[0,255]")
	private String billingNameHonorific;
}
