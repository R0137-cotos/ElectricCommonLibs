package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.AgencyEstimationInformation;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.AgencyEstimationInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = AgencyEstimationInformation.class, repository = AgencyEstimationInformationRepository.class)
public class AgencyEstimationInformationDto extends DtoBase {

	/**
	 * MOM顧客ID企業ID
	 */
	@ApiModelProperty(value = "MOM顧客ID企業ID", required = false, position = 3, allowableValues = "range[0,9223372036854775807]")
	private long momCustomerIdCompanyId;

	/**
	 * 取次会社
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "取次会社", required = false, position = 4, allowableValues = "range[0,255]")
	private String agencyName;

	/**
	 * 仕入先CD
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "仕入先CD", required = false, position = 5, allowableValues = "range[0,255]")
	private String supplierCode;

	/**
	 * 手数料率
	 */
	@DecimalMin("0.00")
	@Digits(integer = 5, fraction = 2)
	@ApiModelProperty(value = "手数料率", required = false, position = 6, allowableValues = "range[0.00,99999.99]")
	private BigDecimal feeRate;
}
