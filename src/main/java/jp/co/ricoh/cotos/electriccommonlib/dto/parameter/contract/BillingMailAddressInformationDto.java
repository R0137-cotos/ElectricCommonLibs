package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class BillingMailAddressInformationDto extends DtoBase {

	/**
	 * 氏名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "氏名", required = true, position = 3, allowableValues = "range[0,255]")
	private String name;
	
	/**
	 * メールアドレス
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス", required = true, position = 3, allowableValues = "range[0,255]")
	private String mailAddress;
	
	/**
	 * MｙRicohユーザID
	 */
	@Min(0)
	@ApiModelProperty(value = "MｙRicohユーザID", required = true, position = 4, allowableValues = "range[0,9223372036854775807]")
	private long myricohId;
}
