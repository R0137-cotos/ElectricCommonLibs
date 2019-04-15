package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.EntryContentLowPressure.ContractCapacityUnit;

@Converter(autoApply = true)
public class ContractCapacityUnitConverter implements AttributeConverter<ContractCapacityUnit, String> {

	@Override
	public String convertToDatabaseColumn(ContractCapacityUnit contractCapacityUnit) {
		if (contractCapacityUnit == null)
			return null;
		return contractCapacityUnit.toString();
	}

	@Override
	public ContractCapacityUnit convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ContractCapacityUnit.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
