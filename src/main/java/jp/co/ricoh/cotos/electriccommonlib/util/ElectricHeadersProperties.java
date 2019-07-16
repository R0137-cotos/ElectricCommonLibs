package jp.co.ricoh.cotos.electriccommonlib.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "cotos.auth.headers")
public class ElectricHeadersProperties extends HeadersProperties {

	private String momAuthorization;
}
