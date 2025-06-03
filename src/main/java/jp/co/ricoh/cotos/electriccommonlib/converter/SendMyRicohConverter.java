package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendMyRicoh;

@Converter(autoApply = true)
public class SendMyRicohConverter implements AttributeConverter<SendMyRicoh, String> {

	@Override
	public String convertToDatabaseColumn(SendMyRicoh sendMyRicoh) {
		if (sendMyRicoh == null)
			return null;
		return sendMyRicoh.toString();
	}

	@Override
	public SendMyRicoh convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return SendMyRicoh.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
