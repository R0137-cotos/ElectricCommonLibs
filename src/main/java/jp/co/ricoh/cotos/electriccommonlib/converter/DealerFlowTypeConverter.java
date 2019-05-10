package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricDealerMaster.DealerFlowType;

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