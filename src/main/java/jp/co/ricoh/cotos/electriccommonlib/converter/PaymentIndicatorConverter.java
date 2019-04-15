package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricDealerContract.PaymentIndicator;

@Converter(autoApply = true)
public class PaymentIndicatorConverter implements AttributeConverter<PaymentIndicator, String> {

	@Override
	public String convertToDatabaseColumn(PaymentIndicator paymentIndicator) {
		if (paymentIndicator == null)
			return null;
		return paymentIndicator.toString();
	}

	@Override
	public PaymentIndicator convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return PaymentIndicator.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}