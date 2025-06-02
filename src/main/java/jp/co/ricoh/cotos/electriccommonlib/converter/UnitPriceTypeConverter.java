package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.UnitPriceType;

@Converter(autoApply = true)
public class UnitPriceTypeConverter implements AttributeConverter<UnitPriceType, String> {

	@Override
	public String convertToDatabaseColumn(UnitPriceType unitPriceType) {
		if (unitPriceType == null)
			return null;
		return unitPriceType.toString();
	}

	@Override
	public UnitPriceType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return UnitPriceType.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}