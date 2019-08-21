package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.List;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "得意先CD", required = true, position = 2, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 請求先Mailアドレス情報
	 */
	@ApiModelProperty(value = "請求先Mailアドレス情報", required = false, position = 3)
	private List<BillingMailAddressInformationDto> BillingMailAddressInformationList;
}
