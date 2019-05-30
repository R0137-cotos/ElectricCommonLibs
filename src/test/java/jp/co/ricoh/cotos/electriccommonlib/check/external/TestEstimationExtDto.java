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
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.CustomerEstimationExtDto;
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
		target.setElectricCommercialFlowDivCode("1");//TODO カラム追加
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu("test");
		target.setCo2EmissionFactor("1");//TODO カラム追加
		ParamterCheckResult result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		//異常系（@NotNull）
		target.setOppSysKeyBn(null);
		target.setElectricCommercialFlowDiv(null);
		target.setElectricCommercialFlowDivCode(null);
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

		// 異常系（@Size(max))
		BeanUtils.copyProperties(entity, target);
		target.setOppSysKeyBn(STR_256);
		target.setElectricCommercialFlowDiv(STR_256);
		target.setElectricCommercialFlowDivCode(STR_256);
		target.setElectricArea(STR_256);
		target.setElectricCompany(STR_256);
		target.setElectricCompanyCode(STR_256);
		target.setElectricMenu(STR_256);
		target.setElectricMenuCode(STR_256);
		target.setCo2EmissionMenu(STR_256);
		target.setCo2EmissionFactor(STR_256);
		target.setItemCode(STR_256);
		target.setScale(STR_256);
		target.setPowerSupplyCycle(STR_256);
		target.setContractQuantity(STR_256);
		target.setTypeOfContract(STR_256);
		result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 15);

		// 異常系(@Min)
		BeanUtils.copyProperties(entity, target);
		target.setElectricCommercialFlowDivCode("1");//TODO カラム追加
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu("test");
		target.setCo2EmissionFactor("1");//TODO カラム追加
		target.setPartialSupplyFlg(INT_MINUS_1);
		target.setSpareWireFlg(INT_MINUS_1);
		target.setSparePowerFlg(INT_MINUS_1);
		target.setAncillaryFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);

		// 異常系(@Max)
		BeanUtils.copyProperties(entity, target);
		target.setElectricCommercialFlowDivCode("1");//TODO カラム追加
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu("test");
		target.setCo2EmissionFactor("1");//TODO カラム追加
		target.setPartialSupplyFlg(INT_10);
		target.setSpareWireFlg(INT_10);
		target.setSparePowerFlg(INT_10);
		target.setAncillaryFlg(INT_10);
		result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity, target);
		target.setElectricCommercialFlowDivCode("1");//TODO カラム追加
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu("test");
		target.setCo2EmissionFactor("1");//TODO カラム追加
		target.setContractPower(DECIMAL_MINUS_001);
		target.setPowerRate(DECIMAL_MINUS_001);
		target.setLoadFactor(DECIMAL_MINUS_001);
		target.setBasePart(DECIMAL_MINUS_001);
		target.setFluctuatingPart(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 5);

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity, target);
		target.setElectricCommercialFlowDivCode("1");//TODO カラム追加
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu("test");
		target.setCo2EmissionFactor("1");//TODO カラム追加
		target.setContractPower(DECIMAL_0001);
		target.setPowerRate(DECIMAL_0001);
		target.setLoadFactor(DECIMAL_0001);
		target.setBasePart(DECIMAL_0001);
		target.setFluctuatingPart(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 5);
	}

	@Test
	public void CustomerEstimationExtDtoのテスト() {
		CustomerEstimationExtDto target = 顧客正常データ作成();
		ParamterCheckResult result = testSecurityController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
	}

	private CustomerEstimationExtDto 顧客正常データ作成() {
		CustomerEstimationExtDto target = new CustomerEstimationExtDto();
		target.setMomCustId("test");
		target.setCompanyId("test");
		target.setOfficeId("test");
		target.setCustomerName("test");
		target.setCompanyName("test");
		target.setCompanyNameKana("test");
		target.setOfficeName("test");
		target.setDepartmentName("test");
		target.setPostNumber("test");
		target.setAddress("test");
		target.setPhoneNumber("test");
		target.setFaxNumber("test");
		target.setCompanyRepresentativeName("test");
		target.setPicName("test");
		target.setPicNameKana("test");
		target.setPicDeptName("test");
		target.setPicPhoneNumber("test");
		target.setPicFaxNumber("test");
		target.setPicMailAddress("test");

		return target;
	}

}
