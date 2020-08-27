package jp.co.ricoh.cotos.electriccommonlib.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import jp.co.ricoh.cotos.commonlib.repository.master.MvEmployeeMasterRepository;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService.AuthLevel;
import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;
import jp.co.ricoh.cotos.electriccommonlib.WithMockCustomUser;
import jp.co.ricoh.cotos.electriccommonlib.security.mom.ElcMomAuthorityService;
import jp.co.ricoh.cotos.electriccommonlib.util.RestTemplateCreator;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;
import lombok.val;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CotosSecurityTests {

	private static final String WITHIN_PERIOD_HAS_MOM_AUTH_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtb21BdXRoIjoie1wiMDNcIjp7XCIyMjEwXCI6XCIwMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI1MFwifSxcIjA1XCI6e1wiMjIxMFwiOlwiMDBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNTBcIn0sXCIwN1wiOntcIjIyMTBcIjpcIjAwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIzMFwiOlwiMTBcIixcIjIyMDBcIjpcIjUwXCJ9LFwiMDFcIjp7XCIyMjEwXCI6XCIwMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI1MFwifSxcIjA0XCI6e1wiMjIxMFwiOlwiMDBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNTBcIn0sXCIwNlwiOntcIjIyMTBcIjpcIjAwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIzMFwiOlwiMTBcIixcIjIyMDBcIjpcIjUwXCJ9LFwiMDJcIjp7XCIyMjEwXCI6XCIwMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI1MFwifX0iLCJvcmlnaW4iOiJodHRwczovL2Rldi5jb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InUwMjAxMTI1IiwibW9tRW1wSWQiOiIwMDIyOTc0NiIsImV4cCI6MjUzNDAyMjY4Mzk5LCJhcHBsaWNhdGlvbklkIjoiY290b3NfZGV2In0.DVREQfy-8H2hOAX44ktBfi8IVKB45I43dinEN_a8I5E";

	private static final String WITHIN_PERIOD_MOM_AUTH_IS_NO_AUTHORITIES_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtb21BdXRoIjoiTk9fQVVUSE9SSVRJRVMiLCJvcmlnaW4iOiJodHRwczovL2Rldi5jb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InUwMjkwMTE0OSIsIm1vbUVtcElkIjoiMDA1MDA3ODQiLCJleHAiOjI1ODI3MDc1NzMsImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.s9ab8korhw_7lUNQFhplALBKsuALiuL0FPcZ8voVOkM";

	private static final String WITHIN_PERIOD_MOM_AUTH_IS_NULL_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJodHRwczovL2Rldi5jb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InUwMjAxMTI1IiwibW9tRW1wSWQiOiIwMDIyOTc0NiIsImV4cCI6MjUzNDAyMjY4Mzk5LCJhcHBsaWNhdGlvbklkIjoiY290b3NfZGV2In0.OT-pRq6L-LfZOU_yaec7GhhTasROqt4qN1PWzIrntNk";

	private static final String WITHIN_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJvcmlnaW4iOiJjb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InNpZCIsIm1vbUVtcElkIjoibWlkIiwiZXhwIjoyNTM0MDIyNjgzOTksImFwcGxpY2F0aW9uSWQiOiJjb3Rvc19kZXYifQ.qJBFsMJFZcLdF7jWwEafZSOQfmL1EqPVDcRuz6WvsCI";

	private static final String WITHIN_PERIOD_JWT_SUPER_USER = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtb21BdXRoIjoie1wiMDZcIjp7XCIyMjMwXCI6XCIxMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMTBcIjpcIjAwXCIsXCIyMjAwXCI6XCI3MFwifSxcIjA1XCI6e1wiMjIzMFwiOlwiMTBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjEwXCI6XCIwMFwiLFwiMjIwMFwiOlwiNzBcIn0sXCIwMlwiOntcIjIyMzBcIjpcIjEwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIxMFwiOlwiMDBcIixcIjIyMDBcIjpcIjcwXCJ9LFwiMDFcIjp7XCIyMjMwXCI6XCIxMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMTBcIjpcIjAwXCIsXCIyMjAwXCI6XCI3MFwifSxcIjAzXCI6e1wiMjIzMFwiOlwiMTBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjEwXCI6XCIwMFwiLFwiMjIwMFwiOlwiNzBcIn0sXCIwNFwiOntcIjIyMzBcIjpcIjEwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIxMFwiOlwiMDBcIixcIjIyMDBcIjpcIjcwXCJ9LFwiMDdcIjp7XCIyMjMwXCI6XCIxMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMTBcIjpcIjAwXCIsXCIyMjAwXCI6XCI3MFwifX0iLCJvcmlnaW4iOiJodHRwczovL2Rldi5jb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InUwMjkwMTE0OSIsIm1vbUVtcElkIjoiMDA1MDA3ODQiLCJleHAiOjI1MzQwMjI2ODM5OSwiYXBwbGljYXRpb25JZCI6ImNvdG9zX2RldiJ9.laSviNxIvxCQnOk2lLLtVtwmvlmYR6K8Nvgq34ZHsyY";

	private static final String WITHOUT_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtb21BdXRoIjoie1wiMDNcIjp7XCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNzBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjEwXCI6XCIwMFwifSxcIjAyXCI6e1wiMjIzMFwiOlwiMTBcIixcIjIyMDBcIjpcIjcwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIxMFwiOlwiMDBcIn0sXCIwNVwiOntcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI3MFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMTBcIjpcIjAwXCJ9LFwiMDdcIjp7XCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNzBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjEwXCI6XCIwMFwifSxcIjAxXCI6e1wiMjIzMFwiOlwiMTBcIixcIjIyMDBcIjpcIjcwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIxMFwiOlwiMDBcIn0sXCIwNlwiOntcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI3MFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMTBcIjpcIjAwXCJ9LFwiMDRcIjp7XCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNzBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjEwXCI6XCIwMFwifX0iLCJvcmlnaW4iOiJodHRwczovL2Rldi5jb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InUwMjkwMTE0OSIsIm1vbUVtcElkIjoiMDA1MDA3ODQiLCJleHAiOjI1MzQwMjI2OCwiYXBwbGljYXRpb25JZCI6ImNvdG9zX2RldiJ9.u2tE3LF_iaSJv5mIu870k7VKmq7hkIPMYY8oa72njOc";

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

	@Autowired
	MvEmployeeMasterRepository mvEmployeeMasterRepository;

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
			rest.getForEntity(loadTopURL() + "securitytest/api/test/1", String.class);
			Assert.fail("正常終了しない");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	public void 認証_トークンなしPOST() {
		RestTemplate rest = initRest(null);
		try {
			rest.postForEntity(loadTopURL() + "securitytest/api/test", null, String.class);
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

		RestTemplate rest = initRest(WITHIN_PERIOD_HAS_MOM_AUTH_JWT);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "u0201125,00229746,https://dev.cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_HAS_MOM_AUTH_JWT + ",false,false,true", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_通常ユーザー_独自投票クラスで認可() {

		try {
			// MoM権限マップをMockにより差し替え
			Mockito.doReturn(new HashMap<ActionDiv, Map<AuthDiv, AuthLevel>>()).when(elcMomAuthorityService).searchAllMomAuthorities(Mockito.anyString());
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=true", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "sid,mid,cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_JWT + ",false,false,true", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_異常_通常ユーザー_認可失敗() {

		try {
			// MoM権限マップをMockにより差し替え
			Mockito.doReturn(new HashMap<ActionDiv, Map<AuthDiv, AuthLevel>>()).when(elcMomAuthorityService).searchAllMomAuthorities(Mockito.anyString());
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT);
		try {
			rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=false&hasBody=false", String.class);
			Assert.fail("正常終了しない");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 403, e.getStatusCode().value());
		}
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_スーパーユーザー() throws Exception {

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT_SUPER_USER);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "u02901149,00500784,https://dev.cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_JWT_SUPER_USER + ",true,false,true", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_正常_NO_AUTHORITIES_スーパーユーザ() throws Exception {

		RestTemplate rest = initRest(WITHIN_PERIOD_MOM_AUTH_IS_NO_AUTHORITIES_JWT);
		ResponseEntity<String> response = rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=false", String.class);
		Assert.assertEquals("正常終了", 200, response.getStatusCodeValue());
		Assert.assertEquals("正常終了", "u02901149,00500784,https://dev.cotos.ricoh.co.jp,cotos_dev," + WITHIN_PERIOD_MOM_AUTH_IS_NO_AUTHORITIES_JWT + ",true,false,false", response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_異常_MoM権限がnull() throws Exception {
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
	public void 認証_トークンあり_異常_MoM権限null() throws Exception {
		RestTemplate rest = initRest(WITHIN_PERIOD_MOM_AUTH_IS_NULL_JWT);
		Mockito.doReturn(null).when(elcMomAuthorityService).searchAllMomAuthorities(Mockito.any());
		try {
			rest.getForEntity(loadTopURL() + "test/api/test/1?isSuccess=true&hasBody=false", String.class);
			Assert.fail("正常終了");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	@Transactional
	public void 認証_トークンあり_異常_有効期限切れ() throws Exception {
		RestTemplate rest = initRest(WITHOUT_PERIOD_JWT);
		try {
			rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=false", String.class);
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
			rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=false", String.class);
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
			rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=false", String.class);
			Assert.fail("正常終了");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 401, e.getStatusCode().value());
		}
	}

	@Test
	public void 指定されたURLには未認証でアクセス可能なこと() {
		RestTemplate rest = initRest(null);
		val response = rest.getForEntity(loadTopURL() + "securitytest/api/swagger-ui.html", String.class);
		Assert.assertEquals("アクセス可能であること", 200, response.getStatusCodeValue());
		Assert.assertEquals("コンテンツが取得できていること", context.getBean(TestSecurityController.class).getSwaggerBody(), response.getBody());
	}

	@Test
	@Transactional
	public void 認証_トークンあり_オリジンなし_異常_通常ユーザー_独自投票クラスで認可棄権() {

		try {
			// MoM権限マップをMockにより差し替え
			Mockito.doReturn(new HashMap<ActionDiv, Map<AuthDiv, AuthLevel>>()).when(elcMomAuthorityService).searchAllMomAuthorities(Mockito.anyString());
		} catch (Exception e) {
			Assert.fail("モック差し替えに失敗");
		}

		RestTemplate rest = initRest(WITHIN_PERIOD_JWT);

		try {
			rest.getForEntity(loadTopURL() + "securitytest/api/test/1?isSuccess=true&hasBody=false&isAbstain=true&isAbstainOriginal=true", String.class);
			Assert.fail("正常終了");
		} catch (HttpClientErrorException e) {
			Assert.assertEquals("アクセス不可であること", 403, e.getStatusCode().value());
		}
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.自顧客)
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

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.参照);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.自顧客)
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

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.自顧客)
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

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertFalse("権限なしと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.配下)
	public void MoM権限_正常_配下_権限あり_参照() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = mvEmployeeMasterRepository.findOne("00229692");
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = mvEmployeeMasterRepository.findOne("00229692");

		// 追加編集者
		MvEmployeeMaster subEditor = mvEmployeeMasterRepository.findOne("00220552");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.参照);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.配下)
	public void MoM権限_正常_配下_権限あり_編集() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = mvEmployeeMasterRepository.findOne("00229692");
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = mvEmployeeMasterRepository.findOne("00229692");

		// 追加編集者
		MvEmployeeMaster subEditor = mvEmployeeMasterRepository.findOne("00220552");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.配下)
	public void MoM権限_正常_配下_権限あり_編集_退職者混在() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();

		// アクター
		MvEmployeeMaster actor = mvEmployeeMasterRepository.findOne("00229692");
		parameter.setActorMvEmployeeMaster(actor);

		// 担当SA
		MvEmployeeMaster sa = mvEmployeeMasterRepository.findOne("00229692");

		// 追加編集者
		MvEmployeeMaster subEditor = mvEmployeeMasterRepository.findOne("99999999");

		parameter.setMvEmployeeMasterList(Arrays.asList(sa, subEditor));

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.配下)
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

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);

		// 結果判定
		Assert.assertFalse("権限なしと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.更新, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void MoM権限_正常_権限あり_直接指定_承認() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();
		parameter.setManualApprover(true);

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomOrgId("DUMMY");
		parameter.setActorMvEmployeeMaster(actor);

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.更新, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@Transactional
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void 正常_MoM権限_参照_次回承認者() throws Exception {

		AuthorityJudgeParameter authParam = new AuthorityJudgeParameter();
		authParam.setActorMvEmployeeMaster(mvEmployeeMasterRepository.findOne("00220552"));
		authParam.setManualApprover(true);

		List<MvEmployeeMaster> approverList = new ArrayList<MvEmployeeMaster>();
		MvEmployeeMaster approver = new MvEmployeeMaster();
		approver.setMomEmployeeId("00220552");
		approverList.add(approver);
		authParam.setApproverMvEmployeeMasterList(approverList);
		;

		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(authParam, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.参照);
		Assert.assertTrue("対象の権限があること", result);
	}

	@Test
	@Transactional
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void 正常_MoM権限_参照_次回代理承認者() throws Exception {

		AuthorityJudgeParameter authParam = new AuthorityJudgeParameter();
		authParam.setActorMvEmployeeMaster(mvEmployeeMasterRepository.findOne("00220552"));
		authParam.setManualApprover(true);

		List<MvEmployeeMaster> approverList = new ArrayList<MvEmployeeMaster>();
		MvEmployeeMaster approver = new MvEmployeeMaster();
		approver.setMomEmployeeId("00229746");
		approverList.add(approver);

		MvEmployeeMaster subApprover = new MvEmployeeMaster();
		subApprover.setMomEmployeeId("00220552");
		approverList.add(subApprover);

		authParam.setApproverMvEmployeeMasterList(approverList);

		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(authParam, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.参照);
		Assert.assertTrue("対象の権限があること", result);
	}

	@Test
	@Transactional
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void 正常_MoM権限_編集_次回承認者() throws Exception {

		AuthorityJudgeParameter authParam = new AuthorityJudgeParameter();
		authParam.setActorMvEmployeeMaster(mvEmployeeMasterRepository.findOne("00220552"));
		authParam.setManualApprover(true);

		MvEmployeeMaster nextApprover = new MvEmployeeMaster();
		nextApprover.setMomEmployeeId("00220552");
		authParam.setNextApproverMvEmployeeMaster(nextApprover);

		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(authParam, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);
		Assert.assertTrue("対象の権限があること", result);
	}

	@Test
	@Transactional
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void 正常_MoM権限_編集_次回代理承認者() throws Exception {

		AuthorityJudgeParameter authParam = new AuthorityJudgeParameter();
		authParam.setActorMvEmployeeMaster(mvEmployeeMasterRepository.findOne("00220552"));
		authParam.setManualApprover(true);

		MvEmployeeMaster nextApprover = new MvEmployeeMaster();
		nextApprover.setMomEmployeeId("00229746");
		authParam.setNextApproverMvEmployeeMaster(nextApprover);

		MvEmployeeMaster nextSubApprover = new MvEmployeeMaster();
		nextSubApprover.setMomEmployeeId("00220552");
		authParam.setNextApproverMvEmployeeMaster(nextSubApprover);

		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(authParam, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);
		Assert.assertTrue("対象の権限があること", result);
	}

	@Test
	@Transactional
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void 正常_MoM権限_編集_前回承認者() throws Exception {

		AuthorityJudgeParameter authParam = new AuthorityJudgeParameter();
		authParam.setActorMvEmployeeMaster(mvEmployeeMasterRepository.findOne("00220552"));
		authParam.setManualApprover(true);

		MvEmployeeMaster nextApprover = new MvEmployeeMaster();
		nextApprover.setMomEmployeeId("00220552");
		authParam.setPrevApproverMvEmployeeMaster(nextApprover);

		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(authParam, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);
		Assert.assertTrue("対象の権限があること", result);
	}

	@Test
	@Transactional
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void 正常_MoM権限_編集_前回代理承認者() throws Exception {

		AuthorityJudgeParameter authParam = new AuthorityJudgeParameter();
		authParam.setActorMvEmployeeMaster(mvEmployeeMasterRepository.findOne("00220552"));
		authParam.setManualApprover(true);

		MvEmployeeMaster nextApprover = new MvEmployeeMaster();
		nextApprover.setMomEmployeeId("00229746");
		authParam.setPrevApproverMvEmployeeMaster(nextApprover);

		MvEmployeeMaster nextSubApprover = new MvEmployeeMaster();
		nextSubApprover.setMomEmployeeId("00220552");
		authParam.setPrevApproverMvEmployeeMaster(nextSubApprover);

		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(authParam, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.編集);
		Assert.assertTrue("対象の権限があること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.配下)
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

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void MoM権限_正常_権限あり_直接指定以外_代理承認() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();
		parameter.setManualApprover(false);

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setMomEmployeeId("01901092");
		parameter.setActorMvEmployeeMaster(actor);

		// 承認依頼者
		MvEmployeeMaster requester = new MvEmployeeMaster();
		requester.setMomEmployeeId("00229746");
		parameter.setRequesterMvEmployeeMaster(requester);

		// 承認者
		MvEmployeeMaster approver = new MvEmployeeMaster();
		approver.setMomEmployeeId("00229692");
		parameter.setNextApproverMvEmployeeMaster(approver);

		// 代理承認者
		MvEmployeeMaster subApprover = new MvEmployeeMaster();
		subApprover.setMomEmployeeId("01901092");
		parameter.setNextSubApproverMvEmployeeMaster(subApprover);

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertTrue("権限ありと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
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

		// 電力用MoM権限共通処理を実行
		boolean result = context.getBean(ElcMomAuthorityService.class).hasAuthority(parameter, ActionDiv.照会, AuthDiv.見積_契約_手配, AccessType.承認);

		// 結果判定
		Assert.assertFalse("権限なしと判定されること", result);
	}

	@Test
	@WithMockCustomUser(actionDiv = ActionDiv.照会, authDiv = AuthDiv.見積_契約_手配, authLevel = AuthLevel.不可)
	public void MoM権限_正常_権限なし_承認_退職者() throws Exception {

		AuthorityJudgeParameter parameter = new AuthorityJudgeParameter();
		parameter.setManualApprover(false);

		// アクター
		MvEmployeeMaster actor = new MvEmployeeMaster();
		actor.setSingleUserId("u0200757");
		parameter.setActorMvEmployeeMaster(actor);

		// 承認依頼者
		parameter.setRequesterMvEmployeeMaster(null);

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
