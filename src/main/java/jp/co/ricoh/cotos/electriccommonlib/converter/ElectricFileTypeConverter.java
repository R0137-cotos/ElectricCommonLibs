package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricFileType;

@Converter(autoApply = true)
public class ElectricFileTypeConverter implements AttributeConverter<ElectricFileType, String> {

	@Override
	public String convertToDatabaseColumn(ElectricFileType electricFileType) {
		if (electricFileType == null)
			return null;
		return electricFileType.toString();
	}

	@Override
	public ElectricFileType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricFileType.fromString(value); // IllegalArgumentExceptionは.fromString側で投げている
	}

}