package jp.co.ricoh.cotos.electriccommonlib.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "cotos.api.standard")
public class StandardProperties {

	private String estimation;

	private String contract;

	private String master;
	
	private String reports;
}
