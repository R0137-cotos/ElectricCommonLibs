package jp.co.ricoh.cotos.electriccommonlib.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.StringUtils;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.entity.nishiki.MaximumDemandPowerHighVolt;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.ExcsChargeInfoHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.FeeCalcInterfaceRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.FeeClcUssInterfaceRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.InstrumentInfoHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.LimDscInfoHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.MaximumDemandPowerHighVoltRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.nishiki.SettleUssDifferrenceInfoHighVoltRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
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

	private static boolean dataLoaded = false;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		if (!dataLoaded) {
			context.getBean(DBConfig.class).clearData();
			context.getBean(DBConfig.class).initTargetTestData("repository/nishiki/NishikiEntity.sql");
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

	@Test
	public void 最大需要電力情報レコードがリストで取得できること() {
		final Long[] expect = { 201907L, 201906L, 201905L, 201904L };
		final String ctctBn = "1";
		final String feeClcYm = "201907";
		List<MaximumDemandPowerHighVolt> findresult = null;
		try {
			findresult = maximumDemandPowerHighVoltRepository.findByCtctBnAndFeeClcYmOrderByMaxDmdElcRsYmDesc(ctctBn, feeClcYm);
		} catch (Exception e) {
			Assert.fail("想定外のエラーが発生した。");
		}
		Assert.assertThat("ソート順が正しいことを確認", findresult.stream().map(elem -> elem.getMaxDmdElcRsYm()).collect(Collectors.toList()), Matchers.contains(expect));
		Assert.assertTrue("契約番号,料金計算対象年月が同一のレコードのみが取得できていることを確認", findresult.stream().allMatch(elem -> StringUtils.equals(elem.getCtctBn(), ctctBn) && StringUtils.equals(elem.getFeeClcYm(), feeClcYm)));
	}

	@Test
	public void 最大需要電力情報レコードの対象月全件がリストで取得できること() {
		final Long[] expect = { 201903L, 201902L, 201907L, 201906L, 201905L, 201904L };
		final String feeClcYm = "201907";
		List<MaximumDemandPowerHighVolt> findresult = null;
		try {
			findresult = maximumDemandPowerHighVoltRepository.findByFeeClcYmOrderByCtctBnDescMaxDmdElcRsYmDesc(feeClcYm);
		} catch (Exception e) {
			Assert.fail("想定外のエラーが発生した。");
		}
		Assert.assertThat("ソート順が正しいことを確認", findresult.stream().map(elem -> elem.getMaxDmdElcRsYm()).collect(Collectors.toList()), Matchers.contains(expect));
		Assert.assertTrue("料金計算対象年月が同一のレコードのみが取得できていることを確認", findresult.stream().allMatch(elem -> StringUtils.equals(elem.getFeeClcYm(), feeClcYm)));
	}
}
