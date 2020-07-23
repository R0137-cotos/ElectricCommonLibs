package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MailAddressInformation.MailIdentification;

@Converter(autoApply = true)
public class MailIdentificationConverter implements AttributeConverter<MailIdentification, String> {

	@Override
	public String convertToDatabaseColumn(MailIdentification mailIdentification) {
		if (mailIdentification == null)
			return null;
		return mailIdentification.toString();
	}

	@Override
	public MailIdentification convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return MailIdentification.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
