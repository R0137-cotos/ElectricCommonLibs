package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;

@Converter(autoApply = true)
public class ElectricCommercialFlowDivConverter implements AttributeConverter<ElectricCommercialFlowDiv, String> {

	@Override
	public String convertToDatabaseColumn(ElectricCommercialFlowDiv electricCommercialFlowDiv) {
		if (electricCommercialFlowDiv == null)
			return null;
		return electricCommercialFlowDiv.toString();
	}

	@Override
	public ElectricCommercialFlowDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return ElectricCommercialFlowDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}