package jp.co.ricoh.cotos.electriccommonlib.check.external;

import java.math.BigDecimal;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;
import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationElectricExtDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.TestSecurityController;
import jp.co.ricoh.cotos.electriccommonlib.security.bean.ParamterCheckResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestEstimationExtDto {

	private static final String STR_256 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345";
	private static final String STR_1001 = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
	private static final int INT_MINUS_1 = -1;
	private static final Long LONG_MINUS_1 = -1L;
	private static final int INT_10 = 10;
	private static final int INT_100000 = 100000;
	private static final BigDecimal DECIMAL_MINUS_001 = new BigDecimal("-0.01");
	private static final BigDecimal DECIMAL_0001 = new BigDecimal("0.001");

	static ConfigurableApplicationContext context;

	@Autowired
	TestTools testTool;

	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/estimation/EstimationElectric.sql");
	}

	@Autowired
	TestSecurityController testSecurityController;

	@LocalServerPort
	private int localServerPort;

	@Autowired
	EstimationElectricRepository estimationElectricRepository;

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void EstimationElectricExtDtoのテスト() {

		//正常系
		EstimationElectric entity = estimationElectricRepository.findOne(1L);
		EstimationElectricExtDto target = new EstimationElectricExtDto();
		BeanUtils.copyProperties(entity, target);
		target.setElectricCommercialFlowDivCd("test");//TODO カラム追加
		target.setCo2EmissionMenu("test");
		target.setCo2EmissionFactor(1);//TODO カラム追加
		ParamterCheckResult result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		//異常系（@NotNull）
		target.setOppSysKeyBn(null);
		target.setElectricCommercialFlowDiv(null);
		target.setElectricCommercialFlowDivCd(null);
		target.setElectricArea(null);
		target.setElectricCompany(null);
		target.setElectricCompanyCode(null);
		target.setVoltageCategory(null);
		target.setElectricMenu(null);
		target.setElectricMenuCode(null);
		target.setCo2EmissionMenu(null);
		target.setCo2EmissionFactor(null);
		target.setItemCode(null);
		target.setContractPower(null);
		target.setScale(null);
		target.setPowerRate(null);
		target.setLoadFactor(null);
		target.setSupplyStartScheduledDate(null);
		target.setPowerSupplyCycle(null);
		target.setContractQuantity(null);
		target.setTypeOfContract(null);
		target.setPartialSupplyFlg(null);
		target.setBasePart(null);
		target.setFluctuatingPart(null);
		target.setSpareWireFlg(null);
		target.setSparePowerFlg(null);
		target.setAncillaryFlg(null);
		result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 26);

	}

}
