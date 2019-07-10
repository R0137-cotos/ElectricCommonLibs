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
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricDealerMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricFileType;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.HighContractCalendarMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ProfitTransferDepartmentMaster;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.CommissionMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricAreaMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricCompanyMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricDealerMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormIdentMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.HighContractCalendarMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ProfitTransferDepartmentMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class TestMasterElectricRepository extends RepositoryTestBase {

	@Autowired
	ClientMasterRepository clientMasterRepository;

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
	HighContractCalendarMasterRepository highContractCalendarMasterRepository;

	@Autowired
	CommissionMasterRepository commissionMasterRepository;

	@Autowired
	ProfitTransferDepartmentMasterRepository profitTransferDepartmentMasterRepository;

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
	public void 全てのカラムがNullではないことを確認_マスタ_媒介手数料マスタ() {
		全てのカラムがNullではないことを確認_マスタ(commissionMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_粗利振替先部門マスタ() {
		全てのカラムがNullではないことを確認_マスタ(profitTransferDepartmentMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_企業IDより取得() {
		String hnbitnCd = "test";

		// 企業IDにより販売店マスタを取得
		ElectricDealerMaster electricDealerMaster = electricDealerMasterRepository.findByHnbitnCd(hnbitnCd);

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(electricDealerMaster);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_必要な要素をすべて取得() {

		// 必須情報によりマスタを取得
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
	
	@Test
	public void 全てのカラムがNullではないことを確認_マスタ_粗利振替先部門マスタ_販社課所コードより取得() {
		全てのカラムがNullではないことを確認_マスタ(profitTransferDepartmentMasterRepository, 1L);
		
		String affiliationCode = "2020367";
		
		// 販社課所コードにより粗利振替先部門マスタを取得
		List<ProfitTransferDepartmentMaster> profitTransferDepartmentMasterList = profitTransferDepartmentMasterRepository.findByAffiliationCode(affiliationCode);
		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(profitTransferDepartmentMasterList.get(0));
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
		
	}
}
