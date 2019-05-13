package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricDealerMaster.PaymentMethod;

@Converter(autoApply = true)
public class PaymentMethodConverter implements AttributeConverter<PaymentMethod, String> {

	@Override
	public String convertToDatabaseColumn(PaymentMethod paymentMethod) {
		if (paymentMethod == null)
			return null;
		return paymentMethod.toString();
	}

	@Override
	public PaymentMethod convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return PaymentMethod.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}