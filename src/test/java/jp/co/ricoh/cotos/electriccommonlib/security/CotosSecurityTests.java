package jp.co.ricoh.cotos.electriccommonlib.security;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.ActionDiv;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AuthDiv;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService.AuthLevel;
import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;
import jp.co.ricoh.cotos.electriccommonlib.util.RestTemplateCreator;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;
import lombok.val;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CotosSecurityTests {

	private static final String WITHIN_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoyNTM0MDIyNjgzOTksImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.qJBFsMJFZcLdF7jWwEafZSOQfmL1EqPVDcRuz6WvsCI";

	private static final String WITHIN_PERIOD_JWT_SUPER_USER = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoiTU9NX0VNUExPWUVFX0lEIiwiZXhwIjoyNTM0MDIyNjgzOTksImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.8INJ9gALA3thQ6iwvveYRmGIbZdZAvl2uZBXR8dqblk";

	private static final String WITHOUT_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoxNTM5NTY5MDQsImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.NO_r4hID2vt3_fJWa4Mwmk1tKvZe5ndCwHF17wkv1Bo";

	private static final String FALSIFICATION_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoyNTM0MDIyNjgzOTksImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQA.qJBFsMJFZcLdF7jWwEafZSOQfmL1EqPVDcRuz6WvsCI";

	@LocalServerPort
	private int port;

	private String loadTopURL() {
		return "http://localhost:" + port + "/";
	}

	@SpyBean
	MomAuthorityService momAuthorityService;

	@SpyBean
	RestTemplateCreator restTemplateCreator;

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	StandardProperties standardProperties;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
	}

	private MockRestServiceServer mockServer;

	/**
	 * 毎テストメソッドごとに実施
	 */
	@Before
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.stop();
		}
	}

	@Test
	public void 認証_トークンなしGET() {
		RestTemplate rest = initRest(null);
		try {
			rest.getForEntity(loadTopURL() + "test/api/test/1", String.class);
			Assert.fail("正常終了しない");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	public void 認証_トークンなしPOST() {
		RestTemplate rest = initRest(null);
		try {
			rest.postForEntity(loadTopURL() + "test/api/test", null, String.class);
			Assert.fail("正常終了しない");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_通常ユーザー() {

		try {
			// MoM権限マップをMockにより差し替え
			Mockito.doReturn(new HashMap<ActionDiv, Map<AuthDiv, AuthLevel>>()).when(momAuthorityService).searchAllMomAuthorities(Mockito.anyString());
			// モックサーバー用にrestテンプレートを差し替え
			Mockito.doReturn(restTemplate).when(restTemplateCreator).getRestTemplate(Mockito.anyString());
			mockServer.expect(ExpectedCount.manyTimes(), MockRestRequestMatchers.requestTo(new URI(standardProperties.getMaster() + "/findSuperUserMaster/mid"))).andExpect(MockRestRequestMatchers.method(HttpMethod.GET)).andRespond(MockRestResponseCreators.withSuccess("", MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "sid,mid,cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_JWT + ",false,true", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_スーパーユーザー() throws Exception {

		try {
			// モックサーバー用にrestテンプレートを差し替え
			Mockito.doReturn(restTemplate).when(restTemplateCreator).getRestTemplate(Mockito.anyString());
			mockServer.expect(ExpectedCount.manyTimes(), MockRestRequestMatchers.requestTo(new URI(standardProperties.getMaster() + "/findSuperUserMaster/MOM_EMPLOYEE_ID"))).andExpect(MockRestRequestMatchers.method(HttpMethod.GET)).andRespond(MockRestResponseCreators.withSuccess("{}", MediaType.APPLICATION_JSON));
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT_SUPER_USER);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "sid,MOM_EMPLOYEE_ID,cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_JWT_SUPER_USER + ",true,false", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_異常_有効期限切れ() throws Exception {
		RestTemplate rest = initRest(WITHOUT_PERIOD_JWT);
		try {
			rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
			Assert.fail("正常終了");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	@Transactional
	public void 認証_トークンあり_異常_改竄() throws Exception {
		RestTemplate rest = initRest(FALSIFICATION_JWT);
		try {
			rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
			Assert.fail("正常終了");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	@Transactional
	public void 認証_トークンあり_異常_MoM権限無し() throws Exception {
		RestTemplate rest = initRest(WITHIN_PERIOD_JWT);
		try {
			rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
			Assert.fail("正常終了");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	public void 指定されたURLには未認証でアクセス可能なこと() {
		RestTemplate rest = initRest(null);
		val response = rest.getForEntity(loadTopURL() + "test/api/swagger-ui.html", String.class);
		Assert.assertEquals("アクセス可能であること", 200, response.getStatusCodeValue());
		Assert.assertEquals("コンテンツが取得できていること", context.getBean(TestSecurityController.class).getSwaggerBody(), response.getBody());
	}

	private RestTemplate initRest(final String header) {
		RestTemplate rest = new RestTemplate();
		if (null != header) {
			rest.setInterceptors(Stream.concat(rest.getInterceptors().stream(), Arrays.asList(new ClientHttpRequestInterceptor() {
				@Override
				public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
					System.out.println("initRest Start");
					System.out.println(request.getURI());
					System.out.println(request.getMethod());
					request.getHeaders().add(headersProperties.getAuthorization(), "Bearer " + header);
					System.out.println(request.getHeaders());
					System.out.println("initRest End");
					return execution.execute(request, body);
				}
			}).stream()).collect(Collectors.toList()));
		}
		return rest;
	}
}
