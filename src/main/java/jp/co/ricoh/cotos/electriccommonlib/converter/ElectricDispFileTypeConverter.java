package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile.ElectricDispFileType;

@Converter(autoApply = true)
public class ElectricDispFileTypeConverter implements AttributeConverter<ElectricDispFileType, String> {

	@Override
	public String convertToDatabaseColumn(ElectricDispFileType electricDispFileType) {
		if (electricDispFileType == null)
			return null;
		return electricDispFileType.toString();
	}

	@Override
	public ElectricDispFileType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricDispFileType.fromString(value); // IllegalArgumentExceptionは.fromString側で投げている
	}

}