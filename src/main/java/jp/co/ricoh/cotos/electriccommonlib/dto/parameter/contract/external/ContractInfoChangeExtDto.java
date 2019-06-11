package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約情報変更作成用DTO: 契約情報
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ContractInfoChangeExtDto {

	/**
	 * 契約ID
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "変更元契約ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 作成日
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "作成日", required = true, position = 2, allowableValues = "range[0,255]")
	private String changePreferredDate;

	/**
	 * 契約情報（電力）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "契約情報（電力）", required = true, position = 3)
	private ContractElectricInfoChangeExtDto contractElectric;

}
