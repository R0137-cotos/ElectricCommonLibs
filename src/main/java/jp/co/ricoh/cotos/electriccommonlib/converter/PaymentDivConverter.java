package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.ElectricDealerEstimation.PaymentDiv;

@Converter(autoApply = true)
public class PaymentDivConverter implements AttributeConverter<PaymentDiv, String> {

	@Override
	public String convertToDatabaseColumn(PaymentDiv paymentDiv) {
		if (paymentDiv == null)
			return null;
		return paymentDiv.toString();
	}

	@Override
	public PaymentDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return PaymentDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}