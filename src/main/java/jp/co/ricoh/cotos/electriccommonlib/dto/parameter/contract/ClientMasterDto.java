package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.List;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ClientMaster.class, repository = ClientMasterRepository.class)
public class ClientMasterDto extends DtoBase {

	/**
	 * 得意先CD
	 */
	@Size(max = 255)
	@Schema(description = "得意先CD", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求先Mailアドレス情報
	 */
	@Schema(description = "請求先Mailアドレス情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<BillingMailAddressInformationDto> billingMailAddressInformationList;
}
