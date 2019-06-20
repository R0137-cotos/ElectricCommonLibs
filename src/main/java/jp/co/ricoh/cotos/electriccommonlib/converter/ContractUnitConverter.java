package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.ContractUnit;

@Converter(autoApply = true)
public class ContractUnitConverter implements AttributeConverter<ContractUnit, String> {

	@Override
	public String convertToDatabaseColumn(ContractUnit contractUnit) {
		if (contractUnit == null)
			return null;
		return contractUnit.toString();
	}

	@Override
	public ContractUnit convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ContractUnit.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
