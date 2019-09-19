package jp.co.ricoh.cotos.electriccommonlib.repository;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.commonlib.entity.common.MailSendHistory.MailSendType;
import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.entity.common.ElectricMailSendHistory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricMailControlMaster;
import jp.co.ricoh.cotos.electriccommonlib.repository.common.ElectricMailSendHistoryRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricMailControlMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class TestCommonElectricRepository extends RepositoryTestBase {

	@Autowired
	ElectricMailSendHistoryRepository electricMailSendHistoryRepository;

	@Autowired
	ElectricMailControlMasterRepository electricMailControlMasterRepository;

	@Autowired
	TestTools testTools;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/common/Common.sql");
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	// Todo
	// 電力メール送信履歴について、今後他ドメインに拡張される可能性があるので、Commonへの配置としている

	@Test
	public void 全てのカラムがNullではないことを確認_共通_電力メール送信履歴() {
		全てのカラムがNullではないことを確認_共通(electricMailSendHistoryRepository, 1L);
	}

	@Test
	public void 電力メール送信履歴_対象データIDと電力通知メール変換値マスタとメール送信区分より取得_共通() {
		long targetDataId = 1L;
		ElectricMailControlMaster master = electricMailControlMasterRepository.findOne(1L);

		// 対象データIDと電力通知メール変換値マスタとメール送信区分により電力メール送信履歴を取得
		ElectricMailSendHistory electricMailSendHistory = electricMailSendHistoryRepository.findByTargetDataIdAndElectricMailControlMasterAndMailSendType(targetDataId, master, MailSendType.完了);
		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(electricMailSendHistory);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}

	}

	@Test
	public void 電力通知メール変換値マスタとメール送信区分より取得_共通_電力メール送信履歴() {
		ElectricMailControlMaster master = electricMailControlMasterRepository.findOne(1L);

		// 力通知メール変換値マスタとメール送信区分により電力メール送信履歴を取得
		List<ElectricMailSendHistory> electricMailSendHistoryList = electricMailSendHistoryRepository.findByElectricMailControlMasterAndMailSendType(master, MailSendType.完了);
		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(electricMailSendHistoryList.get(0));
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}

	}

}
