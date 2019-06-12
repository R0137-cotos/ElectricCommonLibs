package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricExpertEstimationDto extends DtoBase {

	/**
	 * 氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "氏名", required = false, position = 2, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス", required = false, position = 3, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電話番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 所属課所コード
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属課所コード", required = false, position = 5, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 所属
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "所属", required = false, position = 6, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * MoM社員ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "MoM社員ID", required = false, position = 7, allowableValues = "range[0,255]")
	private String momEmpId;

}
