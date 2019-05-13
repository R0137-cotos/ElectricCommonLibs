package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;

@Converter(autoApply = true)
public class VoltageCategoryConverter implements AttributeConverter<VoltageCategory, String> {

	@Override
	public String convertToDatabaseColumn(VoltageCategory voltageCategory) {
		if (voltageCategory == null)
			return null;
		return voltageCategory.toString();
	}

	@Override
	public VoltageCategory convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return VoltageCategory.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
