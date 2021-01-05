package jp.co.ricoh.cotos.electriccommonlib.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import jp.co.ricoh.cotos.commonlib.util.ClaimsProperties;
import jp.co.ricoh.cotos.commonlib.util.JwtProperties;
import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationHead;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.AgencyEstimationInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricDealerEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricExpertEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.CotosElcAuthenticationDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestEstimationElectricRepository extends RepositoryTestBase {

	@Autowired
	AgencyEstimationInformationRepository agencyEstimationInformationRepository;

	@Autowired
	ElectricDealerEstimationRepository electricDealerEstimationRepository;

	@Autowired
	ElectricExpertEstimationRepository electricExpertEstimationRepository;

	@Autowired
	EstimationElectricRepository estimationElectricRepository;

	@Autowired
	FeeSimulationHeadRepository feeSimulationHeadRepository;

	@Autowired
	TestTools testTools;

	@Autowired
	JwtProperties jwtProperties;

	@Autowired
	ClaimsProperties claimsProperties;

	@Autowired
	TestCheckComponent testCheckComponent;

	static ConfigurableApplicationContext context;

	private static boolean dataLoaded = false;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		if (!dataLoaded) {
			context.getBean(DBConfig.class).clearData();
			context.getBean(DBConfig.class).initTargetTestData("repository/estimation/EstimationElectric.sql");
			dataLoaded = true;
		}
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_電力用() {
		全てのカラムがNullではないことを確認_共通(estimationElectricRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_電力用を外部キーより取得() {

		// 外部キーにより契約(電力)を取得
		List<EstimationElectric> estimationElectricList = estimationElectricRepository.findByOppSysKeyBn("test");

		Assert.assertEquals("1件取得されること", 1, estimationElectricList.size());
		// null項目なく取得できていることを確認
		estimationElectricList.stream().forEach(estimationElectric -> {
			try {
				testTools.assertColumnsNotNull(estimationElectric);
			} catch (Exception e1) {
				Assert.fail("例外が発生した場合、エラー");
			}
		});
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_電力専任情報() {
		全てのカラムがNullではないことを確認_共通(electricExpertEstimationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_取次情報() {
		全てのカラムがNullではないことを確認_共通(agencyEstimationInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_販売店情報() {
		全てのカラムがNullではないことを確認_共通(electricDealerEstimationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_料金シュミレーション_営業用() {
		全てのカラムがNullではないことを確認_共通(feeSimulationHeadRepository, 1L);
	}

	@Test
	public void マイナス値登録_料金シミュレーション_本部用() {

		// JWT作成
		Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
		String jwt = JWT.create().withExpiresAt(new Date(25340226839900L)).withClaim(claimsProperties.getMomEmpId(), "00500784").withClaim(claimsProperties.getSingleUserId(), "u02901149").withClaim(claimsProperties.getOrigin(), "cotos.ricoh.co.jp").withClaim(claimsProperties.getApplicationId(), "cotos_electric_dev").sign(algorithm);

		CotosElcAuthenticationDetails principal = new CotosElcAuthenticationDetails("00500784", "u02901149", "https://dev-1.cotos.ricoh.co.jp", "cotos_dev_1", jwt, false, false, null);
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);

		final BigDecimal DECIMAL_MINUS_001 = BigDecimal.valueOf(0.01).negate();
		Assert.assertEquals("-0.01", DECIMAL_MINUS_001.toString());

		FeeSimulationHead feeSimulationHead = feeSimulationHeadRepository.findOne(1L);

		// 粗利額（営業）
		feeSimulationHead.setGrossMarginBusiness(DECIMAL_MINUS_001);
		// 粗利額（ＲＪ）
		feeSimulationHead.setGrossMarginRj(DECIMAL_MINUS_001);

		try {
			// 例外が発生せずにsaveが実行されることを確認
			testCheckComponent.update(feeSimulationHeadRepository, feeSimulationHead);
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 整数18桁登録_請求実績() {

		// JWT作成
		Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
		String jwt = JWT.create().withExpiresAt(new Date(25340226839900L)).withClaim(claimsProperties.getMomEmpId(), "00500784").withClaim(claimsProperties.getSingleUserId(), "u02901149").withClaim(claimsProperties.getOrigin(), "cotos.ricoh.co.jp").withClaim(claimsProperties.getApplicationId(), "cotos_electric_dev").sign(algorithm);

		CotosElcAuthenticationDetails principal = new CotosElcAuthenticationDetails("00500784", "u02901149", "https://dev-1.cotos.ricoh.co.jp", "cotos_dev_1", jwt, false, false, null);
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);

		FeeSimulationHead feeSimulationHead = feeSimulationHeadRepository.findOne(1L);
		final BigDecimal DECIMAL_OVER_MAX = BigDecimal.valueOf(123456789012345678.99);

		feeSimulationHead.setEstimationElectric(null);
		// 粗利額（営業）
		feeSimulationHead.setGrossMarginBusiness(DECIMAL_OVER_MAX);
		// 粗利額（ＲＪ）
		feeSimulationHead.setGrossMarginRj(DECIMAL_OVER_MAX);

		try {
			// 例外が発生することを確認
			testCheckComponent.update(feeSimulationHeadRepository, feeSimulationHead);
		} catch (TransactionSystemException expected) {
			Assert.assertTrue("整数桁あふれのバリデーションチェックによる例外が根本原因であること", expected.getRootCause() instanceof ConstraintViolationException);
			return;
		} catch (Exception unexpected) {
			unexpected.printStackTrace();
			Assert.fail("想定外の例外が発生した");
		}
		Assert.fail("例外が発生しなかった");
	}
}
