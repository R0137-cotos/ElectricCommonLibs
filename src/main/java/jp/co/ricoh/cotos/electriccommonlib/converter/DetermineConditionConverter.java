package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.HighContractCalendarMaster.DetermineCondition;

@Converter(autoApply = true)
public class DetermineConditionConverter implements AttributeConverter<DetermineCondition, String> {

	@Override
	public String convertToDatabaseColumn(DetermineCondition determineCondition) {
		if (determineCondition == null)
			return null;
		return determineCondition.toString();
	}

	@Override
	public DetermineCondition convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return DetermineCondition.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}