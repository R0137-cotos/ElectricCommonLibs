package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricBillingAttachedFile.FileKind;

@Converter(autoApply = true)
public class FileKindConverter implements AttributeConverter<FileKind, String> {

	@Override
	public String convertToDatabaseColumn(FileKind fileKind) {
		if (fileKind == null)
			return null;
		return fileKind.toString();
	}

	@Override
	public FileKind convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return FileKind.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}
