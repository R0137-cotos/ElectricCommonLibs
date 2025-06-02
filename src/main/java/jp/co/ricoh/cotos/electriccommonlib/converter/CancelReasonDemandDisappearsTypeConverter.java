package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationReasonInformation.DemandDisappearsType;

@Converter(autoApply = true)
public class CancelReasonDemandDisappearsTypeConverter implements AttributeConverter<DemandDisappearsType, String> {

	@Override
	public String convertToDatabaseColumn(DemandDisappearsType demandDisappearsType) {
		if (demandDisappearsType == null)
			return null;
		return demandDisappearsType.toString();
	}

	@Override
	public DemandDisappearsType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return DemandDisappearsType.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}