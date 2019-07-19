package jp.co.ricoh.cotos.electriccommonlib.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import jp.co.ricoh.cotos.commonlib.security.CotosAuthenticationDetails;
import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;

@Component
public class RestTemplateCreator {

	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public RestTemplate getRestTemplate() {
		return loadRestTemplate(null, false, false);
	}

	/**
	 * 画面表示用ユーザー権限を利用時に使用する
	 */
	public RestTemplate getRestTemplate(boolean requireDispAuthorize) {
		return loadRestTemplate(null, requireDispAuthorize, false);
	}

	/**
	 * SecurityContextが存在しない場合に使用する
	 */
	public RestTemplate getRestTemplate(String jwt) {
		return loadRestTemplate(jwt, false, false);
	}

	/**
	 * バッチからAPIをコールする場合に使用する
	 */
	public RestTemplate getRestTemplateForBatch(boolean hasBearer) {
		return loadRestTemplate(null, false, hasBearer);
	}

	private RestTemplate loadRestTemplate(String jwt, boolean requireDispAuthorize, boolean hasBearer) {
		RestTemplate rest = restTemplateBuilder.build();
		rest.setInterceptors(Stream.concat(rest.getInterceptors().stream(), Arrays.asList(new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

				// JWT
				if (jwt == null) {
					CotosAuthenticationDetails userInfo = (CotosAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					request.getHeaders().add(headersProperties.getAuthorization(), (hasBearer ? "" : "Bearer ") + userInfo.getJwt());
				} else {
					request.getHeaders().add(headersProperties.getAuthorization(), (hasBearer ? "" : "Bearer ") + jwt);
				}

				// 画面表示用ユーザー権限
				request.getHeaders().add(headersProperties.getRequireDispAuthorize(), Boolean.toString(requireDispAuthorize));

				return execution.execute(request, body);
			}
		}).stream()).collect(Collectors.toList()));

		return rest;
	}
}