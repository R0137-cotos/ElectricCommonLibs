package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricPaymentAttachedFile.PaymentFileKind;

@Converter(autoApply = true)
public class PaymentFileKindConverter implements AttributeConverter<PaymentFileKind, String> {

	@Override
	public String convertToDatabaseColumn(PaymentFileKind paymentFileKind) {
		if (paymentFileKind == null)
			return null;
		return paymentFileKind.toString();
	}

	@Override
	public PaymentFileKind convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return PaymentFileKind.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}

