package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ClientInformationDto.class, repository = ClientInformationRepository.class)
public class ClientInformationDto extends DtoBase {

	/**
	 * 得意先CD
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "得意先CD", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 得意先情報M_ID
	 */
	@ApiModelProperty(value = "得意先情報M_ID", required = false, position = 4, allowableValues = "range[0,9223372036854775807]")
	private long clientMasterId;

	/**
	 * アクティブflg
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アクティブflg", required = false, position = 5, allowableValues = "range[0,9]")
	private Integer activeFlg;

}
