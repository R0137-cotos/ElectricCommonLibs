package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation.CollectMethod;

@Converter(autoApply = true)
public class CollectMethodConverter implements AttributeConverter<CollectMethod, String> {

	@Override
	public String convertToDatabaseColumn(CollectMethod collectMethod) {
		if (collectMethod == null)
			return null;
		return collectMethod.toString();
	}

	@Override
	public CollectMethod convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return CollectMethod.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}