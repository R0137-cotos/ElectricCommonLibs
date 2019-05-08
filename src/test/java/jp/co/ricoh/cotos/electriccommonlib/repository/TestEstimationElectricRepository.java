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
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceHighPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceLowPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricDealerEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricExpertEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationSalesRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricApprovalRouteMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricApprovalRouteNodeMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricAreaMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricCompanyMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestEstimationElectricRepository extends RepositoryTestBase {

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
	ElectricApprovalRouteNodeMasterRepository electricApprovalRouteNodeMasterRepository;
	
	@Autowired
	ElectricApprovalRouteMasterRepository electricApprovalRouteMasterRepository;
	
	@Autowired
	ElectricCompanyMasterRepository electricCompanyMasterRepository;
	
	@Autowired
	ElectricAreaMasterRepository electricAreaMasterRepository;

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

	@Test
	public void 全てのカラムがNullではないことを確認_見積_料金シュミレーション_本部用() {
		全てのカラムがNullではないことを確認_共通(feeSimulationSalesRepository, 1L);
	}

}
