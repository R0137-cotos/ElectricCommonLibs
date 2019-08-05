package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.SendMail;

@Converter(autoApply = true)
public class SendMailConverter implements AttributeConverter<SendMail, String> {

	@Override
	public String convertToDatabaseColumn(SendMail voltageCategory) {
		if (voltageCategory == null)
			return null;
		return voltageCategory.toString();
	}

	@Override
	public SendMail convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return SendMail.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}