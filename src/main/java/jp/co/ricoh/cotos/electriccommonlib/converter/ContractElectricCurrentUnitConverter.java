package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.ContractElectricCurrentUnit;

@Converter(autoApply = true)
public class ContractElectricCurrentUnitConverter implements AttributeConverter<ContractElectricCurrentUnit, String> {

	@Override
	public String convertToDatabaseColumn(ContractElectricCurrentUnit contractElectricCurrentUnit) {
		if (contractElectricCurrentUnit == null)
			return null;
		return contractElectricCurrentUnit.toString();
	}

	@Override
	public ContractElectricCurrentUnit convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ContractElectricCurrentUnit.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
