package jp.co.ricoh.cotos.electriccommonlib.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import jp.co.ricoh.cotos.commonlib.dto.parameter.common.AuthorityJudgeParameter;
import jp.co.ricoh.cotos.commonlib.entity.master.MvEmployeeMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AccessType;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.ActionDiv;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AuthDiv;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService.AuthLevel;
import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;
import jp.co.ricoh.cotos.electriccommonlib.security.mom.ElcMomAuthorityService;
import jp.co.ricoh.cotos.electriccommonlib.util.RestTemplateCreator;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;
import lombok.val;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CotosSecurityTests {

	private static final String WITHIN_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoyNTM0MDIyNjgzOTksImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.qJBFsMJFZcLdF7jWwEafZSOQfmL1EqPVDcRuz6WvsCI";

	private static final String WITHIN_PERIOD_JWT_SUPER_USER = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoiMDA1MDA3ODQiLCJleHAiOjI1MzQwMjI2ODM5OSwiYXBwbGljYXRpb25JZCI6ImNvdG9zLnJpY29oLmNvLmpwIn0.P72uE-VnrC_BPlIGC3LSKbgA7tCtOrBRk-xUO077o88";

	private static final String WITHIN_PERIOD_JWT_DUMMY_USER = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoiQ09UT1NfQkFUQ0hfVVNFUiIsImV4cCI6MjUzNDAyMjY4Mzk5LCJhcHBsaWNhdGlvbklkIjoiY290b3Mucmljb2guY28uanAifQ.Blbmd9ZfCMrUTU0IynWsgxRcC9jycjP0CHOuyRtg7Og";

	private static final String WITHOUT_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoxNTM5NTY5MDQsImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.NO_r4hID2vt3_fJWa4Mwmk1tKvZe5ndCwHF17wkv1Bo";

	private static final String FALSIFICATION_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoyNTM0MDIyNjgzOTksImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQA.qJBFsMJFZcLdF7jWwEafZSOQfmL1EqPVDcRuz6WvsCI";

	@LocalServerPort
	private int port;

	private String loadTopURL() {
		return "http://localhost:" + port + "/";
	}

	@SpyBean
	ElcMomAuthorityService elcMomAuthorityService;

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
			Mockito.doReturn(new HashMap<ActionDiv, Map<AuthDiv, AuthLevel>>()).when(elcMomAuthorityService).searchAllMomAuthorities(Mockito.anyString());
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "sid,mid,cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_JWT + ",false,false,true", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_スーパーユーザー() throws Exception {

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT_SUPER_USER);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "sid,00500784,cotos.ricoh.co.jp,cotos.ricoh.co.jp," + WITHIN_PERIOD_JWT_SUPER_USER + ",true,false,false", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_ダミーユーザー() throws Exception {

		try {
			// MoM権限マップをMockにより差し替え
			Mockito.doReturn(new HashMap<ActionDiv, Map<AuthDiv, AuthLevel>>()).when(elcMomAuthorityService).searchAllMomAuthorities(Mockito.anyString());
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT_DUMMY_USER);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "sid,COTOS_BATCH_USER,cotos.ricoh.co.jp,cotos.ricoh.co.jp," + WITHIN_PERIOD_JWT_DUMMY_USER + ",true,true,true", response.getBody());
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

	@Test
	public void MoM権限_正常_自顧客_権限あり_参照() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomEmployeeId("LOGIN_USER");
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = new MvEmployeeMaster();
		sa.setMomEmployeeId("LOGIN_USER");

		// 追加編集者
		MvEmployeeMaster subEditor = new MvEmployeeMaster();
		subEditor.setMomEmployeeId("SUB_EDITOR");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		Mockito.doReturn(AuthLevel.自顧客).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// context.getBean(ElcMomAuthorityService.class).

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.参照);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	public void MoM権限_正常_自顧客_権限あり_編集() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomEmployeeId("LOGIN_USER");
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = new MvEmployeeMaster();
		sa.setMomEmployeeId("LOGIN_USER");

		// 追加編集者
		MvEmployeeMaster subEditor = new MvEmployeeMaster();
		subEditor.setMomEmployeeId("SUB_EDITOR");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		Mockito.doReturn(AuthLevel.自顧客).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// context.getBean(ElcMomAuthorityService.class).

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	public void MoM権限_正常_自顧客_権限なし() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomEmployeeId("LOGIN_USER");
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = new MvEmployeeMaster();
		sa.setMomEmployeeId("NOT_ACTOR");

		// 追加編集者
		MvEmployeeMaster subEditor = new MvEmployeeMaster();
		subEditor.setMomEmployeeId("SUB_EDITOR");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		Mockito.doReturn(AuthLevel.自顧客).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertFalse("権限なしと判定されること", result);
	}

	@Test
	public void MoM権限_正常_配下_権限あり_参照() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomOrgId("0880788");
		actor.setOrgHierarchyLevel(3);
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = new MvEmployeeMaster();
		sa.setOrgHierarchyLevel(4);
		sa.setMomOrgId("0880792");

		// 追加編集者
		MvEmployeeMaster subEditor = new MvEmployeeMaster();
		subEditor.setOrgHierarchyLevel(4);
		subEditor.setMomEmployeeId("0880792");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		Mockito.doReturn(AuthLevel.配下).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.参照);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	public void MoM権限_正常_配下_権限あり_編集() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomOrgId("0880788");
		actor.setOrgHierarchyLevel(3);
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = new MvEmployeeMaster();
		sa.setOrgHierarchyLevel(4);
		sa.setMomOrgId("0880792");

		// 追加編集者
		MvEmployeeMaster subEditor = new MvEmployeeMaster();
		subEditor.setOrgHierarchyLevel(4);
		subEditor.setMomEmployeeId("0880792");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		Mockito.doReturn(AuthLevel.配下).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	public void MoM権限_正常_配下_権限なし() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomOrgId("0880788");
		actor.setOrgHierarchyLevel(3);
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = new MvEmployeeMaster();
		sa.setOrgHierarchyLevel(4);
		sa.setMomOrgId("NOT_EXISTS");

		// 追加編集者
		MvEmployeeMaster subEditor = new MvEmployeeMaster();
		subEditor.setOrgHierarchyLevel(4);
		subEditor.setMomOrgId("NOT_EXISTS");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		Mockito.doReturn(AuthLevel.配下).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertFalse("権限なしと判定されること", result);
	}

	@Test
	public void MoM権限_正常_権限あり_直接指定_承認() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();
		parameter.setManualApprover(true);

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomOrgId("DUMMY");
		parameter.setActorMvEmployeeMaster(actor);

		Mockito.doReturn(AuthLevel.不可).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.更新, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	public void MoM権限_正常_権限あり_直接指定以外_承認() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();
		parameter.setManualApprover(false);

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setSingleUserId("u0200757");
		parameter.setActorMvEmployeeMaster(actor);

		// 承認依頼者
		MvEmployeeMaster requester = new MvEmployeeMaster();
		requester.setSingleUserId("u0201125");
		parameter.setRequesterMvEmployeeMaster(requester);

		Mockito.doReturn(AuthLevel.配下).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	public void MoM権限_正常_権限なし_承認() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();
		parameter.setManualApprover(false);

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setSingleUserId("u0200757");
		parameter.setActorMvEmployeeMaster(actor);

		// 承認依頼者
		MvEmployeeMaster requester = new MvEmployeeMaster();
		requester.setSingleUserId("u0201125");
		parameter.setRequesterMvEmployeeMaster(requester);

		Mockito.doReturn(AuthLevel.不可).when((MomAuthorityService) elcMomAuthorityService).searchMomAuthority(Mockito.any(), Mockito.any(), Mockito.any());

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertFalse("権限なしと判定されること", result);
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
