package jp.co.ricoh.cotos.electriccommonlib.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricApprovalRouteMaster.RouteDiv;

@Converter(autoApply = true)
public class RouteDivConverter implements AttributeConverter<RouteDiv, String> {

	@Override
	public String convertToDatabaseColumn(RouteDiv routeDiv) {
		if (routeDiv == null)
			return null;
		return routeDiv.toString();
	}

	@Override
	public RouteDiv convertToEntityAttribute(String value) {
		if (value == null)
			return null;
		return RouteDiv.fromString(value); // IllegalArgumentExceptionはContractType.fromString側で投げている
	}

}