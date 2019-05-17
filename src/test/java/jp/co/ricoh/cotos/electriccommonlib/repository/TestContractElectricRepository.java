package jp.co.ricoh.cotos.electriccommonlib.repository;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.repository.common.ElectricAttachedFileRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingBasicInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingHistoryRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingMailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricAttachedFileRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricAppropriationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricDealerContractRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricExpertContractRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentHighPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentLowPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ImportantPointExplainerRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceHighPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceLowPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricDealerEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricExpertEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationSalesRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricAreaMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricCompanyMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestContractElectricRepository extends RepositoryTestBase {

	@Autowired
	BillingBasicInformationRepository billingBasicInformationRepository;

	@Autowired
	BillingHistoryRepository billingHistoryRepository;

	@Autowired
	BillingMailAddressInformationRepository billingMailAddressInformationRepository;

	@Autowired
	CancellationInformationRepository cancellationInformationRepository;

	@Autowired
	ClientInformationRepository clientInformationRepository;

	@Autowired
	ContractElectricRepository contractElectricRepository;

	@Autowired
	ClientMasterRepository clientMasterRepository;

	@Autowired
	ContractElectricAttachedFileRepository contractElectricAttachedFileRepository;

	@Autowired
	ElectricAttachedFileRepository electricAttachedFileRepository;

	@Autowired
	ElectricAppropriationRepository electricAppropriationRepository;

	@Autowired
	ElectricDealerContractRepository electricDealerContractRepository;

	@Autowired
	ElectricDealerEstimationRepository electricDealerEstimationRepository;

	@Autowired
	ElectricExpertContractRepository electricExpertContractRepository;

	@Autowired
	ElectricExpertEstimationRepository electricExpertEstimationRepository;

	@Autowired
	EntryContentHighPressureRepository entryContentHighPressureRepository;

	@Autowired
	EntryContentLowPressureRepository entryContentLowPressureRepository;

	@Autowired
	EstimationElectricRepository estimationElectricRepository;

	@Autowired
	FeeSimulationHeadRepository feeSimulationHeadRepository;

	@Autowired
	FeeSimulationSalesRepository feeSimulationSalesRepository;

	@Autowired
	MailAddressInformationRepository mailAddressInformationRepository;

	@Autowired
	UnitPriceHighPressureRepository unitPriceHighPressureRepository;

	@Autowired
	UnitPriceLowPressureRepository unitPriceLowPressureRepository;

	@Autowired
	ElectricCompanyMasterRepository electricCompanyMasterRepository;

	@Autowired
	ElectricAreaMasterRepository electricAreaMasterRepository;
	
	@Autowired
	ImportantPointExplainerRepository importantPointExplainerRepository;

	@Autowired
	TestTools testTools;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/contract/Electric.sql");
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用() {
		全てのカラムがNullではないことを確認_共通(contractElectricRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_Mailアドレス情報() {
		全てのカラムがNullではないことを確認_共通(mailAddressInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_お申込み内容_高圧() {
		全てのカラムがNullではないことを確認_共通(entryContentHighPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_お申込み内容_低圧() {
		全てのカラムがNullではないことを確認_共通(entryContentLowPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用_添付ファイル() {
		全てのカラムがNullではないことを確認_共通(contractElectricAttachedFileRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_単価情報_高圧() {
		全てのカラムがNullではないことを確認_共通(unitPriceHighPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_単価情報_低圧() {
		全てのカラムがNullではないことを確認_共通(unitPriceLowPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_解約情報() {
		全てのカラムがNullではないことを確認_共通(cancellationInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_電力専任情報() {
		全てのカラムがNullではないことを確認_共通(electricExpertContractRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_販売店情報() {
		全てのカラムがNullではないことを確認_共通(electricDealerContractRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_得意先情報() {
		全てのカラムがNullではないことを確認_共通(clientInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_得意先情報マスタ() {
		全てのカラムがNullではないことを確認_共通(clientMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_請求先Mailアドレス情報() {
		全てのカラムがNullではないことを確認_共通(billingMailAddressInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_請求基本情報() {
		全てのカラムがNullではないことを確認_共通(billingBasicInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_請求実績() {
		全てのカラムがNullではないことを確認_共通(billingHistoryRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_計上実績() {
		全てのカラムがNullではないことを確認_共通(electricAppropriationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_添付ファイル() {
		全てのカラムがNullではないことを確認_共通(electricAttachedFileRepository, 1L);
	}
	
	@Test 
	public void 全てのカラムがNullではないことを確認_重要事項説明者() {
		全てのカラムがNullではないことを確認_共通(importantPointExplainerRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用を契約IDより取得() {

		// 契約IDにより契約(電力)を取得
		ContractElectric contractElectric = contractElectricRepository.findByContractId(2L);

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(contractElectric);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}
	
	@Test
	public void 全てのカラムがNullではないことを確認_契約_得意先マスタを得意先CDから取得() {

		// 契約IDにより契約(電力)を取得
		ClientMaster clientMaster = clientMasterRepository.findByClientCode("1234567");

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(clientMaster);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

}
