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
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.ExcsChargeInfoHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.FeeCalcInterfaceRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.FeeClcUssInterfaceRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.InstrumentInfoHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.LimDscInfoHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.MaximumDemandPowerHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.SettleUssDifferrenceInfoHighVoltRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestNishikiRepository extends RepositoryTestBase {

	@Autowired
	FeeCalcInterfaceRepository feeCalcInterfaceRepository;

	@Autowired
	FeeClcUssInterfaceRepository feeClcUssInterfaceRepository;

	@Autowired
	MaximumDemandPowerHighVoltRepository maximumDemandPowerHighVoltRepository;

	@Autowired
	SettleUssDifferrenceInfoHighVoltRepository settleUssDifferrenceInfoHighVoltRepository;

	@Autowired
	InstrumentInfoHighVoltRepository instrumentInfoHighVoltRepository;

	@Autowired
	ExcsChargeInfoHighVoltRepository excsChargeInfoHighVoltRepository;

	@Autowired
	LimDscInfoHighVoltRepository limDscInfoHighVoltRepository;

	@Autowired
	TestTools testTools;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/nishiki/NishikiEntity.sql");
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_料金計算結果() {
		全てのカラムがNullではないことを確認_共通(feeCalcInterfaceRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_料金計算結果電力量() {
		全てのカラムがNullではないことを確認_共通(feeClcUssInterfaceRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_最大需要電力量() {
		全てのカラムがNullではないことを確認_共通(maximumDemandPowerHighVoltRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_精算分電力量差異() {
		全てのカラムがNullではないことを確認_共通(settleUssDifferrenceInfoHighVoltRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_計器情報() {
		全てのカラムがNullではないことを確認_共通(instrumentInfoHighVoltRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約超過金() {
		全てのカラムがNullではないことを確認_共通(excsChargeInfoHighVoltRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_制限中止割引() {
		全てのカラムがNullではないことを確認_共通(limDscInfoHighVoltRepository, 1L);
	}

}
