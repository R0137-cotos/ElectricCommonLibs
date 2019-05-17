package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricExpertContractDto extends DtoBase {

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
	@ApiModelProperty(value = "メールアドレス", required = true, position = 4, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * 電話番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "電話番号", required = true, position = 5, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 所属課所コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "所属課所コード", required = true, position = 6, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 所属
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "所属", required = true, position = 7, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * 修正時振替先コード
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "修正時振替先コード", required = true, position = 8, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * 修正時振替課所名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "修正時振替課所名", required = true, position = 9, allowableValues = "range[0,255]")
	private String fixTransferSectionName;
	
	/**
	 * MoM社員ID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "MoM社員ID", required = false, position = 10, allowableValues = "range[0,255]")
	private String momEmpId;
}
