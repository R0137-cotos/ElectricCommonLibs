package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.NonBillingReason;

@Converter(autoApply = true)
public class NonBillingReasonConverter implements AttributeConverter<NonBillingReason, String> {

	@Override
	public String convertToDatabaseColumn(NonBillingReason nonBillingReason) {
		if (nonBillingReason == null)
			return null;
		return nonBillingReason.toString();
	}

	@Override
	public NonBillingReason convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return NonBillingReason.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
