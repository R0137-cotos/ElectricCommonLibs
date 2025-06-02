package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class BillingMailAddressInformationCreateExtDto {

	/**
	 * 氏名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "氏名", required = false, position = 1, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス", required = false, position = 2, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * MｙRicohユーザID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "MｙRicohユーザID", required = false, position = 3, allowableValues = "range[0,255]")
	private String myricohId;
}
