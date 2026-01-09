package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "得意先CD", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 得意先情報M_ID
	 */
	@Schema(description = "得意先情報M_ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long clientMasterId;

	/**
	 * アクティブflg
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "アクティブflg", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer activeFlg;

}
