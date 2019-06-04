package jp.co.ricoh.cotos.electriccommonlib.repository;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricDealerEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricExpertEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestEstimationElectricRepository extends RepositoryTestBase {

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

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/estimation/EstimationElectric.sql");
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
	public void 全てのカラムがNullではないことを確認_見積_電力専任情報() {
		全てのカラムがNullではないことを確認_共通(electricExpertEstimationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_販売店情報() {
		全てのカラムがNullではないことを確認_共通(electricDealerEstimationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_見積_料金シュミレーション_営業用() {
		全てのカラムがNullではないことを確認_共通(feeSimulationHeadRepository, 1L);
	}

}
