package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricMailControlMaster.ElectricNotificationTimingType;

@Converter(autoApply = true)
public class ElectricNotificationTimingTypeConverter implements AttributeConverter<ElectricNotificationTimingType, String> {

	@Override
	public String convertToDatabaseColumn(ElectricNotificationTimingType electricNotificationTimingType) {
		if (electricNotificationTimingType == null)
			return null;
		return electricNotificationTimingType.toString();
	}

	@Override
	public ElectricNotificationTimingType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricNotificationTimingType.fromString(value); // IllegalArgumentExceptionは.fromString側で投げている
	}

}
