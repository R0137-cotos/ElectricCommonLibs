package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "Mail識別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "契約担当者(\"1\"), ピークアラート担当者(\"2\")", example = "1")
	private MailIdentification mailIdentification;

	/**
	 * 氏名
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "氏名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * ピークアラートしきい値
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "ピークアラートしきい値", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal peakAlertThreshold;

}
