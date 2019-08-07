package jp.co.ricoh.cotos.electriccommonlib.check.external;

import java.math.BigDecimal;
import java.util.Arrays;

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
import jp.co.ricoh.cotos.electriccommonlib.check.TestCheckController;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.CustomerEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.ElectricDealerEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.ElectricExpertEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationAddedEditorEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationElectricExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationExtCreateDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationExtPlanChangeDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationPicSaEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.FeeSimulationHeadExtDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationHead;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.bean.ParamterCheckResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestEstimationExtDto {

	private static final String STR_256 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345";
	private static final String STR_1001 = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
	private static final String STR_4001 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"//
			+ "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"//
			+ "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"//
			+ "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
	private static final int INT_MINUS_1 = -1;
	private static final int INT_10 = 10;
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
	TestCheckController testCheckController;

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
	public void EstimationExtPlanChangeDtoのテスト() {

		EstimationExtPlanChangeDto target = new EstimationExtPlanChangeDto();

		// 正常系
		target.setCaseTitle("test");
		target.setCaseNumber("test");
		target.setOriginContractId(1);
		EstimationElectric entityEstimation = estimationElectricRepository.findOne(1L);
		EstimationElectricExtDto targetEstimation = new EstimationElectricExtDto();
		BeanUtils.copyProperties(entityEstimation, targetEstimation);
		targetEstimation.setElectricArea(entityEstimation.getElectricArea().toString());
		targetEstimation.setPowerCompany(entityEstimation.getElectricCompany());
		targetEstimation.setElectricCommercialFlowDivCode("1");
		targetEstimation.setElectricCommercialFlowDiv(entityEstimation.getElectricCommercialFlowDiv().toString());
		targetEstimation.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		targetEstimation.setCo2EmissionFactor("1");
		targetEstimation.setVoltageCategory(entityEstimation.getVoltageCategory().toString());
		targetEstimation.setSupplyStartScheduledDate("2019/05");
		target.setEstimationElectric(targetEstimation);

		CustomerEstimationExtDto targetCustomer = 顧客正常データ作成();
		target.setCustomerEstimation(targetCustomer);

		EstimationPicSaEmpExtDto targetEmp = new EstimationPicSaEmpExtDto();
		targetEmp.setMomEmployeeId("test");
		target.setEstimationPicSaEmp(targetEmp);

		ElectricExpertEstimationExtDto targetExpert = new ElectricExpertEstimationExtDto();
		targetExpert.setMomEmployeeId("test");
		target.setElectricExpertEstimation(targetExpert);

		FeeSimulationHead entitySimulation = estimationElectricRepository.findOne(1L).getFeeSimulationHead();
		FeeSimulationHeadExtDto targetSimulation = new FeeSimulationHeadExtDto();
		BeanUtils.copyProperties(entitySimulation, targetSimulation);
		target.setFeeSimulationHead(targetSimulation);
		target.getFeeSimulationHead().setCreatedDate("2019/05/31");
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系
		target.setCaseTitle(null);
		target.setCaseNumber(null);
		target.setEstimationElectric(null);
		target.setCustomerEstimation(null);
		target.setEstimationPicSaEmp(null);
		target.setElectricExpertEstimation(null);
		target.setFeeSimulationHead(null);

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 7);

		target.setEstimationElectric(new EstimationElectricExtDto());
		target.setCustomerEstimation(new CustomerEstimationExtDto());
		target.setEstimationPicSaEmp(new EstimationPicSaEmpExtDto());
		target.setElectricExpertEstimation(new ElectricExpertEstimationExtDto());
		target.setFeeSimulationHead(new FeeSimulationHeadExtDto());
		target.setElectricDealerEstimation(new ElectricDealerEstimationExtDto());
		target.setEstimationAddedEditorEmpList(Arrays.asList(new EstimationAddedEditorEmpExtDto()));

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 88);

	}

	@Test
	public void EstimationExtCreateDtoのテスト() {

		EstimationExtCreateDto target = new EstimationExtCreateDto();

		// 正常系
		target.setCaseTitle("test");
		target.setCaseNumber("test");
		EstimationElectric entityEstimation = estimationElectricRepository.findOne(1L);
		EstimationElectricExtDto targetEstimation = new EstimationElectricExtDto();
		BeanUtils.copyProperties(entityEstimation, targetEstimation);
		targetEstimation.setElectricArea(entityEstimation.getElectricArea().toString());
		targetEstimation.setPowerCompany(entityEstimation.getElectricCompany());
		targetEstimation.setElectricCommercialFlowDivCode("1");
		targetEstimation.setElectricCommercialFlowDiv(entityEstimation.getElectricCommercialFlowDiv().toString());
		targetEstimation.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		targetEstimation.setCo2EmissionFactor("1");
		targetEstimation.setVoltageCategory(entityEstimation.getVoltageCategory().toString());
		targetEstimation.setSupplyStartScheduledDate("2019/05");
		target.setEstimationElectric(targetEstimation);

		CustomerEstimationExtDto targetCustomer = 顧客正常データ作成();
		target.setCustomerEstimation(targetCustomer);

		EstimationPicSaEmpExtDto targetEmp = new EstimationPicSaEmpExtDto();
		targetEmp.setMomEmployeeId("test");
		target.setEstimationPicSaEmp(targetEmp);

		ElectricExpertEstimationExtDto targetExpert = new ElectricExpertEstimationExtDto();
		targetExpert.setMomEmployeeId("test");
		target.setElectricExpertEstimation(targetExpert);

		FeeSimulationHead entitySimulation = estimationElectricRepository.findOne(1L).getFeeSimulationHead();
		FeeSimulationHeadExtDto targetSimulation = new FeeSimulationHeadExtDto();
		BeanUtils.copyProperties(entitySimulation, targetSimulation);
		target.setFeeSimulationHead(targetSimulation);
		target.getFeeSimulationHead().setCreatedDate("2019/05/31");
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系
		target.setCaseTitle(null);
		target.setCaseNumber(null);
		target.setEstimationElectric(null);
		target.setCustomerEstimation(null);
		target.setEstimationPicSaEmp(null);
		target.setElectricExpertEstimation(null);
		target.setFeeSimulationHead(null);

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 7);

		target.setEstimationElectric(new EstimationElectricExtDto());
		target.setCustomerEstimation(new CustomerEstimationExtDto());
		target.setEstimationPicSaEmp(new EstimationPicSaEmpExtDto());
		target.setElectricExpertEstimation(new ElectricExpertEstimationExtDto());
		target.setFeeSimulationHead(new FeeSimulationHeadExtDto());
		target.setElectricDealerEstimation(new ElectricDealerEstimationExtDto());
		target.setEstimationAddedEditorEmpList(Arrays.asList(new EstimationAddedEditorEmpExtDto()));

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 88);

	}

	@Test
	public void EstimationElectricExtDtoのテスト() {

		// 正常系
		EstimationElectric entity = estimationElectricRepository.findOne(1L);
		EstimationElectricExtDto target = new EstimationElectricExtDto();
		BeanUtils.copyProperties(entity, target);
		target.setElectricArea(entity.getElectricArea().toString());
		target.setPowerCompany(entity.getElectricCompany());
		target.setElectricCommercialFlowDivCode("1");
		target.setSupplyStartScheduledDate("2019/05");
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		target.setCo2EmissionFactor("1");
		target.setVoltageCategory(entity.getVoltageCategory().toString());
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		target.setOppSysKeyBn(null);
		target.setElectricCommercialFlowDiv(null);
		target.setElectricCommercialFlowDivCode(null);
		target.setElectricArea(null);
		target.setPowerCompany(null);
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
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 26);

		// 異常系（@Size(max))
		BeanUtils.copyProperties(entity, target);
		target.setOppSysKeyBn(STR_256);
		target.setElectricCommercialFlowDiv(STR_256);
		target.setElectricCommercialFlowDivCode(STR_256);
		target.setElectricArea(STR_256);
		target.setPowerCompany(STR_256);
		target.setElectricCompanyCode(STR_256);
		target.setElectricMenu(STR_256);
		target.setSupplyStartScheduledDate(STR_256);
		target.setElectricMenuCode(STR_256);
		target.setCo2EmissionFactor(STR_256);
		target.setItemCode(STR_256);
		target.setPowerSupplyCycle(STR_256);
		target.setContractQuantity(STR_256);
		target.setTypeOfContract(STR_256);
		target.setVoltageCategory(STR_256);
		target.setSupplyStartScheduledDate(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 14);

		// 異常系(@Min)
		BeanUtils.copyProperties(entity, target);
		target.setElectricArea(entity.getElectricArea().toString());
		target.setPowerCompany(entity.getElectricCompany());
		target.setSupplyStartScheduledDate("2019/05");
		target.setElectricCommercialFlowDivCode("1");
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		target.setCo2EmissionFactor("1");
		target.setVoltageCategory(entity.getVoltageCategory().toString());
		target.setPartialSupplyFlg(INT_MINUS_1);
		target.setSpareWireFlg(INT_MINUS_1);
		target.setSparePowerFlg(INT_MINUS_1);
		target.setAncillaryFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);

		// 異常系(@Max)
		BeanUtils.copyProperties(entity, target);
		target.setSupplyStartScheduledDate("2019/05");
		target.setElectricCommercialFlowDivCode("1");
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		target.setCo2EmissionFactor("1");
		target.setVoltageCategory(entity.getVoltageCategory().toString());
		target.setPartialSupplyFlg(INT_10);
		target.setSpareWireFlg(INT_10);
		target.setSparePowerFlg(INT_10);
		target.setAncillaryFlg(INT_10);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity, target);
		target.setSupplyStartScheduledDate("2019/05");
		target.setElectricCommercialFlowDivCode("1");
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		target.setCo2EmissionFactor("1");
		target.setVoltageCategory(entity.getVoltageCategory().toString());
		target.setContractPower(DECIMAL_MINUS_001);
		target.setPowerRate(DECIMAL_MINUS_001);
		target.setLoadFactor(DECIMAL_MINUS_001);
		target.setBasePart(DECIMAL_MINUS_001);
		target.setFluctuatingPart(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 5);

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity, target);
		target.setSupplyStartScheduledDate("2019/05");
		target.setElectricCommercialFlowDivCode("1");
		target.setElectricCommercialFlowDiv(entity.getElectricCommercialFlowDiv().toString());
		target.setCo2EmissionMenu(ElectricPlan.CO2フリー);
		target.setCo2EmissionFactor("1");
		target.setVoltageCategory(entity.getVoltageCategory().toString());
		target.setContractPower(DECIMAL_0001);
		target.setPowerRate(DECIMAL_0001);
		target.setLoadFactor(DECIMAL_0001);
		target.setBasePart(DECIMAL_0001);
		target.setFluctuatingPart(DECIMAL_0001);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 5);
	}

	@Test
	public void CustomerEstimationExtDtoのテスト() {
		CustomerEstimationExtDto target = 顧客正常データ作成();
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		target.setMomCustId(null);
		target.setCompanyId(null);
		target.setOfficeId(null);
		target.setCustomerName(null);
		target.setCompanyName(null);
		target.setCompanyNameKana(null);
		target.setOfficeName(null);
		target.setDepartmentName(null);
		target.setPostNumber(null);
		target.setAddress(null);
		target.setPhoneNumber(null);
		target.setFaxNumber(null);
		target.setCompanyRepresentativeName(null);
		target.setPicName(null);
		target.setPicNameKana(null);
		target.setPicDeptName(null);
		target.setPicPhoneNumber(null);
		target.setPicFaxNumber(null);
		target.setPicMailAddress(null);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 19);

		// 異常系（@Size(max))
		target = 顧客正常データ作成();
		target.setMomCustId(STR_256);
		target.setCompanyId(STR_256);
		target.setOfficeId(STR_256);
		target.setCustomerName(STR_256);
		target.setCompanyName(STR_256);
		target.setCompanyNameKana(STR_256);
		target.setOfficeName(STR_256);
		target.setDepartmentName(STR_256);
		target.setPostNumber(STR_256);
		target.setAddress(STR_1001);
		target.setPhoneNumber(STR_256);
		target.setFaxNumber(STR_256);
		target.setCompanyRepresentativeName(STR_256);
		target.setPicName(STR_256);
		target.setPicNameKana(STR_256);
		target.setPicDeptName(STR_256);
		target.setPicPhoneNumber(STR_256);
		target.setPicFaxNumber(STR_256);
		target.setPicMailAddress(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 19);

	}

	@Test
	public void EstimationPicSaEmpExtDtoのテスト() {
		EstimationPicSaEmpExtDto target = new EstimationPicSaEmpExtDto();
		target.setMomEmployeeId("test");
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		target.setMomEmployeeId(null);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 1);

		// 異常系（@Size(max))
		target.setMomEmployeeId(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 1);

	}

	@Test
	public void ElectricExpertEstimationExtDtoのテスト() {
		ElectricExpertEstimationExtDto target = new ElectricExpertEstimationExtDto();
		target.setMomEmployeeId("test");
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		target.setMomEmployeeId(null);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 1);

		// 異常系（@Size(max))
		target.setMomEmployeeId(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 1);

	}

	@Test
	public void EstimationAddedEditorEmpExtDtoのテスト() {
		EstimationAddedEditorEmpExtDto target = new EstimationAddedEditorEmpExtDto();
		target.setMomEmployeeId("test");
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		target.setMomEmployeeId(null);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 1);

		// 異常系（@Size(max))
		target.setMomEmployeeId(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 1);

	}

	@Test
	public void ElectricDealerEstimationExtDtoのテスト() {
		ElectricDealerEstimationExtDto target = new ElectricDealerEstimationExtDto();
		target.setCompanyId("test");
		target.setCompanyBusinessName("test");
		target.setPhoneNumber("test");
		target.setPostNumber("test");
		target.setAddress("test");
		target.setMailAddress1("test");
		target.setMailAddress2("test");
		target.setMailAddress3("test");
		target.setPaymentMethod(PaymentMethod.定率);
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@Size(max))
		target.setCompanyId(STR_256);
		target.setCompanyBusinessName(STR_1001);
		target.setPhoneNumber(STR_256);
		target.setPostNumber(STR_256);
		target.setAddress(STR_4001);
		target.setMailAddress1(STR_256);
		target.setMailAddress2(STR_256);
		target.setMailAddress3(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 8);

	}

	@Test
	public void FeeSimulationHeadExtDtoのテスト() {

		// 正常系
		FeeSimulationHead entity = estimationElectricRepository.findOne(1L).getFeeSimulationHead();
		FeeSimulationHeadExtDto target = new FeeSimulationHeadExtDto();
		BeanUtils.copyProperties(entity, target);
		target.setCreatedDate("2019/05/31");
		ParamterCheckResult result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		target.setSimNumberMain(null);
		target.setSimNumberSub(null);
		target.setCreatedDate(null);
		target.setAnnualElectricityRateCurrent(null);
		target.setAnnualElectricityRateAfter(null);
		target.setReductionAmount(null);
		target.setReductionRate(null);
		target.setOverallPrice1(null);
		target.setOverallPrice2(null);
		target.setOverallPrice3(null);
		target.setLoadFactor(null);
		target.setBasicRateListPrice(null);
		target.setBasicRateSellingPrice(null);
		target.setBasicRateBankPriceBusiness(null);
		target.setBasicRateBankPriceRj(null);
		target.setUsageFeeSummerSellingPrice(null);
		target.setUsageFeeSummerBankPriceBusiness(null);
		target.setUsageFeeSummerBankPriceRj(null);
		target.setUsageFeeOtherSeasonSellingPrice(null);
		target.setUsageFeeOtherSeasonBankPriceBusiness(null);
		target.setUsageFeeOtherSeasonBankPriceRj(null);
		target.setSpareLineSellingPrice(null);
		target.setSpareLineBankPriceBusiness(null);
		target.setSpareLineBankPriceRj(null);
		target.setSparePowerSellingPrice(null);
		target.setSparePowerBankPriceBusiness(null);
		target.setSparePowerBankPriceRj(null);
		target.setAncillarySellingPrice(null);
		target.setAncillaryBankPriceBusiness(null);
		target.setAncillaryBankPriceRj(null);
		target.setFeeFixedAmountInTax(null);
		target.setFeeFixedRate(null);
		target.setElectricityChargeBusiness(null);
		target.setGrossMarginBusiness(null);
		target.setGrossProfitMarginBusiness(null);
		target.setElectricityChargeRj(null);
		target.setGrossMarginRj(null);
		target.setGrossProfitMarginRj(null);

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 38);

		// 異常系（@Size(max))
		BeanUtils.copyProperties(entity, target);
		target.setSimNumberMain(STR_256);
		target.setSimNumberSub(STR_256);
		target.setCreatedDate(STR_256);
		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 3);

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity, target);
		target.setAnnualElectricityRateCurrent(DECIMAL_MINUS_001);
		target.setAnnualElectricityRateAfter(DECIMAL_MINUS_001);
		target.setReductionAmount(DECIMAL_MINUS_001);
		target.setReductionRate(DECIMAL_MINUS_001);
		target.setOverallPrice1(DECIMAL_MINUS_001);
		target.setOverallPrice2(DECIMAL_MINUS_001);
		target.setOverallPrice3(DECIMAL_MINUS_001);
		target.setLoadFactor(DECIMAL_MINUS_001);
		target.setBasicRateListPrice(DECIMAL_MINUS_001);
		target.setBasicRateSellingPrice(DECIMAL_MINUS_001);
		target.setBasicRateBankPriceBusiness(DECIMAL_MINUS_001);
		target.setBasicRateBankPriceRj(DECIMAL_MINUS_001);
		target.setUsageFeeSummerSellingPrice(DECIMAL_MINUS_001);
		target.setUsageFeeSummerBankPriceBusiness(DECIMAL_MINUS_001);
		target.setUsageFeeSummerBankPriceRj(DECIMAL_MINUS_001);
		target.setUsageFeeOtherSeasonSellingPrice(DECIMAL_MINUS_001);
		target.setUsageFeeOtherSeasonBankPriceBusiness(DECIMAL_MINUS_001);
		target.setUsageFeeOtherSeasonBankPriceRj(DECIMAL_MINUS_001);
		target.setSpareLineSellingPrice(DECIMAL_MINUS_001);
		target.setSpareLineBankPriceBusiness(DECIMAL_MINUS_001);
		target.setSpareLineBankPriceRj(DECIMAL_MINUS_001);
		target.setSparePowerSellingPrice(DECIMAL_MINUS_001);
		target.setSparePowerBankPriceBusiness(DECIMAL_MINUS_001);
		target.setSparePowerBankPriceRj(DECIMAL_MINUS_001);
		target.setAncillarySellingPrice(DECIMAL_MINUS_001);
		target.setAncillaryBankPriceBusiness(DECIMAL_MINUS_001);
		target.setAncillaryBankPriceRj(DECIMAL_MINUS_001);
		target.setFeeFixedAmountInTax(DECIMAL_MINUS_001);
		target.setFeeFixedRate(DECIMAL_MINUS_001);
		target.setElectricityChargeBusiness(DECIMAL_MINUS_001);
		target.setGrossMarginBusiness(DECIMAL_MINUS_001);
		target.setGrossProfitMarginBusiness(DECIMAL_MINUS_001);
		target.setElectricityChargeRj(DECIMAL_MINUS_001);
		target.setGrossMarginRj(DECIMAL_MINUS_001);
		target.setGrossProfitMarginRj(DECIMAL_MINUS_001);
		target.setCreatedDate("2019/05/31");

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 35);

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity, target);
		target.setAnnualElectricityRateCurrent(DECIMAL_0001);
		target.setAnnualElectricityRateAfter(DECIMAL_0001);
		target.setReductionAmount(DECIMAL_0001);
		target.setReductionRate(DECIMAL_0001);
		target.setOverallPrice1(DECIMAL_0001);
		target.setOverallPrice2(DECIMAL_0001);
		target.setOverallPrice3(DECIMAL_0001);
		target.setLoadFactor(DECIMAL_0001);
		target.setBasicRateListPrice(DECIMAL_0001);
		target.setBasicRateSellingPrice(DECIMAL_0001);
		target.setBasicRateBankPriceBusiness(DECIMAL_0001);
		target.setBasicRateBankPriceRj(DECIMAL_0001);
		target.setUsageFeeSummerSellingPrice(DECIMAL_0001);
		target.setUsageFeeSummerBankPriceBusiness(DECIMAL_0001);
		target.setUsageFeeSummerBankPriceRj(DECIMAL_0001);
		target.setUsageFeeOtherSeasonSellingPrice(DECIMAL_0001);
		target.setUsageFeeOtherSeasonBankPriceBusiness(DECIMAL_0001);
		target.setUsageFeeOtherSeasonBankPriceRj(DECIMAL_0001);
		target.setSpareLineSellingPrice(DECIMAL_0001);
		target.setSpareLineBankPriceBusiness(DECIMAL_0001);
		target.setSpareLineBankPriceRj(DECIMAL_0001);
		target.setSparePowerSellingPrice(DECIMAL_0001);
		target.setSparePowerBankPriceBusiness(DECIMAL_0001);
		target.setSparePowerBankPriceRj(DECIMAL_0001);
		target.setAncillarySellingPrice(DECIMAL_0001);
		target.setAncillaryBankPriceBusiness(DECIMAL_0001);
		target.setAncillaryBankPriceRj(DECIMAL_0001);
		target.setFeeFixedAmountInTax(DECIMAL_0001);
		target.setFeeFixedRate(DECIMAL_0001);
		target.setElectricityChargeBusiness(DECIMAL_0001);
		target.setGrossMarginBusiness(DECIMAL_0001);
		target.setGrossProfitMarginBusiness(DECIMAL_0001);
		target.setElectricityChargeRj(DECIMAL_0001);
		target.setGrossMarginRj(DECIMAL_0001);
		target.setGrossProfitMarginRj(DECIMAL_0001);
		target.setCreatedDate("2019/05/31");

		result = testCheckController.callParameterCheck(target, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 35);
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
