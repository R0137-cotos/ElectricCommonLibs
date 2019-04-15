package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation.SendInvoiceDiv;

@Converter(autoApply = true)
public class SendInvoiceDivConverter implements AttributeConverter<SendInvoiceDiv, String> {

	@Override
	public String convertToDatabaseColumn(SendInvoiceDiv sendInvoiceDiv) {
		if (sendInvoiceDiv == null)
			return null;
		return sendInvoiceDiv.toString();
	}

	@Override
	public SendInvoiceDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return SendInvoiceDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}