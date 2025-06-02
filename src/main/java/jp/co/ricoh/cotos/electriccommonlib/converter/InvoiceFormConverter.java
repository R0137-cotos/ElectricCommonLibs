package jp.co.ricoh.cotos.electriccommonlib.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.InvoiceForm;

@Converter(autoApply = true)
public class InvoiceFormConverter implements AttributeConverter<InvoiceForm, String> {

	@Override
	public String convertToDatabaseColumn(InvoiceForm invoiceForm) {
		if (invoiceForm == null)
			return null;
		return invoiceForm.toString();
	}

	@Override
	public InvoiceForm convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return InvoiceForm.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
