package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class MailAddressInformationCreateExtDto {

	/**
	 * 氏名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "氏名", required = true, position = 1, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス", required = true, position = 2, allowableValues = "range[0,255]")
	private String mailAddress;
}
