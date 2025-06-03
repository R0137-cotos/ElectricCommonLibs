package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation.Honorific;

@Converter(autoApply = true)
public class HonorificConverter implements AttributeConverter<Honorific, String> {

	@Override
	public String convertToDatabaseColumn(Honorific honorific) {
		if (honorific == null)
			return null;
		return honorific.toString();
	}

	@Override
	public Honorific convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return Honorific.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}