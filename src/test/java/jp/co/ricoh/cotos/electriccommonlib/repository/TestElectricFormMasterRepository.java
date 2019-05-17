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
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormMasterRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class TestElectricFormMasterRepository extends RepositoryTestBase {

	@Autowired
	TestTools testTools;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		//context.getBean(DBConfig.class).clearData();
		//context.getBean(DBConfig.class).initTargetTestData("repository/estimation/EstimationElectric.sql");
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			//context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認() {
		System.out.println(VoltageCategory.高圧.toString());
		 //ElectricFormMaster result =
		 //context.getBean(ElectricFormMasterRepository.class).findByVoltageCategory(VoltageCategory.高圧);
		 //ElectricFormMaster result = context.getBean(ElectricFormMasterRepository.class).findByVoltageCategoryAndElectricCommercialFlowDivAndElectricPlanAndCancellationDivAndCancellationMoneyGeneratedFlgAndElectricFileTypeAndDomain(VoltageCategory.高圧, ElectricCommercialFlowDiv.直売,);
		//Assert.assertNotNull("", result);
		//result.getElectricFormIdentMasterList().stream().forEach(a -> {
			System.out.println("ID出ます");
			//System.out.println(a.getId());
	//	});
	}

}
