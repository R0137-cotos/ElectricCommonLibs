package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.LowPressureType;

@Converter(autoApply = true)
public class LowPressureTypeConverter implements AttributeConverter<LowPressureType, String> {

	@Override
	public String convertToDatabaseColumn(LowPressureType lowPressureType) {
		if (lowPressureType == null)
			return null;
		return lowPressureType.toString();
	}

	@Override
	public LowPressureType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return LowPressureType.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}