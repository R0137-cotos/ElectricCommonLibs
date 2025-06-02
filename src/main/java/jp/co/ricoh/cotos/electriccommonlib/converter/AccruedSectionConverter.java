package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.AccruedSection;

@Converter(autoApply = true)
public class AccruedSectionConverter implements AttributeConverter<AccruedSection, String> {

	@Override
	public String convertToDatabaseColumn(AccruedSection accruedSection) {
		if (accruedSection == null)
			return null;
		return accruedSection.toString();
	}

	@Override
	public AccruedSection convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return AccruedSection.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}