package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.Scale;

@Converter(autoApply = true)
public class ScaleConverter implements AttributeConverter<Scale, String> {

	@Override
	public String convertToDatabaseColumn(Scale scale) {
		if (scale == null)
			return null;
		return scale.toString();
	}

	@Override
	public Scale convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return Scale.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}