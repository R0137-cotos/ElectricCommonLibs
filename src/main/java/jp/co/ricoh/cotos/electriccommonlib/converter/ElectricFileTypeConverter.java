package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricFileType;

@Converter(autoApply = true)
public class ElectricFileTypeConverter implements AttributeConverter<ElectricFileType, String> {

	@Override
	public String convertToDatabaseColumn(ElectricFileType electricPlan) {
		if (electricPlan == null)
			return null;
		return electricPlan.toString();
	}

	@Override
	public ElectricFileType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricFileType.fromString(value); // IllegalArgumentExceptionは.fromString側で投げている
	}

}
