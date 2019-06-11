package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約情報変更作成用DTO: 契約情報（電力）
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricInfoChangeExtDto {

	/**
	 * 作成日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "申込日", required = false, position = 1, allowableValues = "range[0,255]")
	private String entryDate;
}
