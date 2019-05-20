package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.CancellationDiv;

@Converter(autoApply = true)
public class CancellationDivConverter implements AttributeConverter<CancellationDiv, String> {

	@Override
	public String convertToDatabaseColumn(CancellationDiv cancellationDiv) {
		if (cancellationDiv == null)
			return null;
		return cancellationDiv.toString();
	}

	@Override
	public CancellationDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return CancellationDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}