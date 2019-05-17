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

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.Domain;
import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricDealerMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricFileType;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.HighContractCalendarMaster;
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
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricAreaMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricCompanyMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricDealerMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormIdentMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.HighContractCalendarMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class TestMasterElectricRepository extends RepositoryTestBase {

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
	ElectricCompanyMasterRepository electricCompanyMasterRepository;

	@Autowired
	ElectricAreaMasterRepository electricAreaMasterRepository;

	@Autowired
	ElectricDealerMasterRepository electricDealerMasterRepository;

	@Autowired
	ElectricFormMasterRepository electricFormMasterRepository;

	@Autowired
	ElectricFormIdentMasterRepository electricFormIdentMasterRepository;

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
	HighContractCalendarMasterRepository highContractCalendarMasterRepository;

	@Autowired
	TestTools testTools;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/master/Master.sql");
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_電力エリアマスタ() {
		全てのカラムがNullではないことを確認_マスタ(electricAreaMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_電力会社マスタ() {
		全てのカラムがNullではないことを確認_マスタ(electricCompanyMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_電力販売店マスタ() {
		全てのカラムがNullではないことを確認_マスタ(electricDealerMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_高圧契約締日カレンダーマスタ() {
		全てのカラムがNullではないことを確認_マスタ(highContractCalendarMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_電力帳票マスタ() {
		全てのカラムがNullではないことを確認_マスタ(electricFormMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_電力帳票識別マスタ() {
		全てのカラムがNullではないことを確認_マスタ(electricFormIdentMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_企業IDより取得() {
		String companyId = "test";

		// 企業IDにより販売店マスタを取得
		ElectricDealerMaster electricDealerMaster = electricDealerMasterRepository.findByCompanyId(companyId);

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(electricDealerMaster);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_必要な要素をすべて取得() {
		// String companyId = "test";

		// 企業IDにより販売店マスタを取得
		ElectricFormMaster electricFormMaster = electricFormMasterRepository.findByVoltageCategoryAndElectricCommercialFlowDivAndElectricPlanAndCancellationDivAndCancellationMoneyGeneratedFlgAndElectricFileTypeAndDomain(VoltageCategory.高圧, ElectricCommercialFlowDiv.直売, ElectricPlan.CO2フリー, CancellationDiv.消滅, 1, ElectricFileType.新規, Domain.contract);

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(electricFormMaster);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_電力会社名と供給開始月より高圧契約締日カレンダーマスタ取得() {
		String electricCompanyName = "北海道電力";
		String supplyStartYm = "2019/12";

		List<HighContractCalendarMaster> highContractCalendarMasterList = highContractCalendarMasterRepository.findByElectricCompanyNameAndSupplyStartYm(electricCompanyName, supplyStartYm);

		// null項目なく取得できていることを確認
		try {
			HighContractCalendarMaster highContractCalendarMaster = highContractCalendarMasterList.stream().findFirst().get();
			testTools.assertColumnsNotNull(highContractCalendarMaster);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}
}
