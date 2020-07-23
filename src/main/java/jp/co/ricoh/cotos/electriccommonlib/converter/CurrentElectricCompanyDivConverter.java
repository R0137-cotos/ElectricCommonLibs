package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric.CurrentElectricCompanyDiv;

@Converter(autoApply = true)
public class CurrentElectricCompanyDivConverter implements AttributeConverter<CurrentElectricCompanyDiv, String> {

	@Override
	public String convertToDatabaseColumn(CurrentElectricCompanyDiv currentElectricCompanyDiv) {
		if (currentElectricCompanyDiv == null)
			return null;
		return currentElectricCompanyDiv.toString();
	}

	@Override
	public CurrentElectricCompanyDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return CurrentElectricCompanyDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}