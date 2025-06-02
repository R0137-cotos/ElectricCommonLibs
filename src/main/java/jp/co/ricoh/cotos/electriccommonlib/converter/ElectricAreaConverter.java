package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricArea;

public class ElectricAreaConverter implements AttributeConverter<ElectricArea, String> {

	@Override
	public String convertToDatabaseColumn(ElectricArea electricArea) {
		if (electricArea == null)
			return null;
		return electricArea.toString();
	}

	@Override
	public ElectricArea convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricArea.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}


}
