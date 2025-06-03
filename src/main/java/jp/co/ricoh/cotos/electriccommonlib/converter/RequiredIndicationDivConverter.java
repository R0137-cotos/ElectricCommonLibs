package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.RequiredIndicationDiv;

@Converter(autoApply = true)
public class RequiredIndicationDivConverter implements AttributeConverter<RequiredIndicationDiv, String> {

	@Override
	public String convertToDatabaseColumn(RequiredIndicationDiv requiredIndicationDiv) {
		if (requiredIndicationDiv == null)
			return null;
		return requiredIndicationDiv.toString();
	}

	@Override
	public RequiredIndicationDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return RequiredIndicationDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
