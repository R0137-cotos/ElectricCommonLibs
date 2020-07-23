package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;

@Converter(autoApply = true)
public class ElectricPlanConverter implements AttributeConverter<ElectricPlan, String> {

	@Override
	public String convertToDatabaseColumn(ElectricPlan electricPlan) {
		if (electricPlan == null)
			return null;
		return electricPlan.toString();
	}

	@Override
	public ElectricPlan convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricPlan.fromString(value); // IllegalArgumentExceptionは.fromString側で投げている
	}

}
