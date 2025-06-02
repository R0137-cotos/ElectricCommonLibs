package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.DealerFlowType;

@Converter(autoApply = true)
public class DealerFlowTypeConverter implements AttributeConverter<DealerFlowType, String> {

	@Override
	public String convertToDatabaseColumn(DealerFlowType dealerFlowType) {
		if (dealerFlowType == null)
			return null;
		return dealerFlowType.toString();
	}

	@Override
	public DealerFlowType convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return DealerFlowType.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}