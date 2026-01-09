package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.AgencyContractInformation;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.AgencyContractInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = AgencyContractInformation.class, repository = AgencyContractInformationRepository.class)
public class AgencyContractInformationDto extends DtoBase {

	/**
	 * MOM顧客ID企業ID
	 */

	@Schema(description = "MOM顧客ID企業ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long momCustomerIdCompanyId;

	/**
	 * 取次会社
	 */
	@Size(max = 255)
	@Schema(description = "取次会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String agencyName;

	/**
	 * 仕入先CD
	 */
	@Size(max = 255)
	@Schema(description = "仕入先CD", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String supplierCode;

	/**
	 * 手数料率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@Schema(description = "手数料率", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999.99]")
	private BigDecimal feeRate;

}
