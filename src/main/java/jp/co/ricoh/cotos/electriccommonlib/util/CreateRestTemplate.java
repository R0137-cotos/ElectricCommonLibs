package jp.co.ricoh.cotos.electriccommonlib.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

import jp.co.ricoh.cotos.commonlib.security.CotosAuthenticationDetails;
import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;

@SpringBootApplication
public class CreateRestTemplate {

	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public RestTemplate getRestTemplate() {
		return loadRestTemplate();
	}

	private RestTemplate loadRestTemplate() {
		RestTemplate rest = restTemplateBuilder.build();
		rest.setInterceptors(Stream.concat(rest.getInterceptors().stream(), Arrays.asList(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
				CotosAuthenticationDetails userInfo = (CotosAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				request.getHeaders().add(headersProperties.getAuthorization(), "Bearer " + userInfo.getJwt());
				return execution.execute(request, body);
			}
		}).stream()).collect(Collectors.toList()));

		return rest;
	}
}