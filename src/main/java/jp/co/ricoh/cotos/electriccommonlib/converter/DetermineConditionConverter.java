package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.HighContractCalendarMaster.DetermineCondition;

@Converter(autoApply = true)
public class DetermineConditionConverter implements AttributeConverter<DetermineCondition, String> {

	@Override
	public String convertToDatabaseColumn(DetermineCondition dealerFlowType) {
		if (dealerFlowType == null)
			return null;
		return dealerFlowType.toString();
	}

	@Override
	public DetermineCondition convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return DetermineCondition.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}