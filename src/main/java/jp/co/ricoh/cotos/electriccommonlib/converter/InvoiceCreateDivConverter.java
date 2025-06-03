package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.InvoiceCreateDiv;

@Converter(autoApply = true)
public class InvoiceCreateDivConverter implements AttributeConverter<InvoiceCreateDiv, String> {

	@Override
	public String convertToDatabaseColumn(InvoiceCreateDiv invoiceCreateDiv) {
		if (invoiceCreateDiv == null)
			return null;
		return invoiceCreateDiv.toString();
	}

	@Override
	public InvoiceCreateDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return InvoiceCreateDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}