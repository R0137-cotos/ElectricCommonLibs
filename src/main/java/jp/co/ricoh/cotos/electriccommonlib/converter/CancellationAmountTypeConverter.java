package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationAmountType;

@Converter(autoApply = true)
public class CancellationAmountTypeConverter implements AttributeConverter<CancellationAmountType, String> {

	@Override
	public String convertToDatabaseColumn(CancellationAmountType cancellationAmountType) {
		if (cancellationAmountType == null)
			return null;
		return cancellationAmountType.toString();
	}

	@Override
	public CancellationAmountType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return CancellationAmountType.fromString(value); // IllegalArgumentExceptionはCancellationAmountType.fromString側で投げている
	}

}