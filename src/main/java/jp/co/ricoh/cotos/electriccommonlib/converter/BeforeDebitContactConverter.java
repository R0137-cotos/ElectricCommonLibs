package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.BeforeDebitContact;

@Converter(autoApply = true)
public class BeforeDebitContactConverter implements AttributeConverter<BeforeDebitContact, String> {

	@Override
	public String convertToDatabaseColumn(BeforeDebitContact beforeDebitContact) {
		if (beforeDebitContact == null)
			return null;
		return beforeDebitContact.toString();
	}

	@Override
	public BeforeDebitContact convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return BeforeDebitContact.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}