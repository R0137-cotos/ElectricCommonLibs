package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationReason;

@Converter(autoApply = true)
public class CancellationReasonConverter implements AttributeConverter<CancellationReason, String> {

	@Override
	public String convertToDatabaseColumn(CancellationReason cancellationReason) {
		if (cancellationReason == null)
			return null;
		return cancellationReason.toString();
	}

	@Override
	public CancellationReason convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return CancellationReason.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}