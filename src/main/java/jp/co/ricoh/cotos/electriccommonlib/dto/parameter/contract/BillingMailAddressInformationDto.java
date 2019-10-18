package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingMailAddressInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = BillingMailAddressInformationDto.class, repository = BillingMailAddressInformationRepository.class)
public class BillingMailAddressInformationDto extends DtoBase {

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

	/**
	 * MｙRicohユーザID
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "MｙRicohユーザID", required = false, position = 3, allowableValues = "range[0,255]")
	private String myricohId;
}
