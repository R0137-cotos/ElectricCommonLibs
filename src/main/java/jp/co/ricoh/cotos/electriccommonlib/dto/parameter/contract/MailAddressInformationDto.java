package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MailAddressInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MailAddressInformation.MailIdentification;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MailAddressInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = MailAddressInformation.class, repository = MailAddressInformationRepository.class)
public class MailAddressInformationDto extends DtoBase {

	/**
	 * Mail識別
	 */
	@NotNull
	@ApiModelProperty(value = "Mail識別", required = true, position = 3, allowableValues = "契約担当者(\"1\"), ピークアラート担当者(\"2\")", example = "1")
	private MailIdentification mailIdentification;

	/**
	 * 氏名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "氏名", required = true, position = 4, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "メールアドレス", required = true, position = 5, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * ピークアラートしきい値
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "ピークアラートしきい値", required = false, position = 6, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal peakAlertThreshold;

}
