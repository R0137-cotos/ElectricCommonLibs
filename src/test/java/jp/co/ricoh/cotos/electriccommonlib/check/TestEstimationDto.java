package jp.co.ricoh.cotos.electriccommonlib.check;

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
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.ElectricDealerEstimationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.ElectricExpertEstimationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.EstimationElectricDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.EstimationUpdateParameter;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.FeeSimulationHeadDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.ElectricDealerEstimation;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.ElectricExpertEstimation;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationHead;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricDealerEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricExpertEstimationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.EstimationElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.FeeSimulationHeadRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.TestSecurityController;
import jp.co.ricoh.cotos.electriccommonlib.security.bean.ParamterCheckResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestEstimationDto {

	private static final String STR_256 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345";
	private static final int INT_MINUS_1 = -1;
	private static final int INT_10 = 10;
	private static final BigDecimal DECIMAL_MINUS_001 = new BigDecimal("-0.01");

	static ConfigurableApplicationContext context;
	
	@Autowired
	HeadersProperties headersProperties;
	
	@Autowired
	ElectricDealerEstimationRepository electricDealerEstimationRepository;

	@Autowired
	EstimationElectricRepository estimationElectricRepository;
	
	@Autowired
	ElectricExpertEstimationRepository electricExpertEstimationRepository;
	
	@Autowired
	FeeSimulationHeadRepository feeSimulationHeadRepository;

	@Autowired
	TestTools testTool;

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

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	@Test
	public void EstimationElectricDtoのテスト() throws Exception {

		EstimationElectric entity = estimationElectricRepository.findOne(1L);
		EstimationElectricDto testTarget = new EstimationElectricDto();
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setFeeSimulationHead(new FeeSimulationHeadDto());
		testTarget.setElectricExpertEstimation(new ElectricExpertEstimationDto());

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
		
		// 異常系(@NotNull)
		testTarget.setFeeSimulationHead(null);
		testTarget.setElectricExpertEstimation(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		
		// 異常系(@Size(max))
		testTarget = new EstimationElectricDto();
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setFeeSimulationHead(new FeeSimulationHeadDto());
		testTarget.setElectricExpertEstimation(new ElectricExpertEstimationDto());
		testTarget.setElectricArea(STR_256);
		testTarget.setElectricCompany(STR_256);
		testTarget.setElectricMenu(STR_256);
		testTarget.setNotes(STR_256);
		testTarget.setPowerSupplyCycle(STR_256);
		testTarget.setContractQuantity(STR_256);
		testTarget.setTypeOfContract(STR_256);
		testTarget.setItemCode(STR_256);
		testTarget.setOppSysKeyBn(STR_256);
		testTarget.setCustomerNumber(STR_256);
		testTarget.setElectricCompanyCode(STR_256);
		testTarget.setElectricMenuCode(STR_256);
		testTarget.setCo2EmissionFactor(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(13, result.getErrorInfoList().size());
		
		// 異常系(@Max)
		testTarget = new EstimationElectricDto();
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setFeeSimulationHead(new FeeSimulationHeadDto());
		testTarget.setElectricExpertEstimation(new ElectricExpertEstimationDto());
		testTarget.setPartialSupplyFlg(INT_10);
		testTarget.setSpareWireFlg(INT_10);
		testTarget.setSparePowerFlg(INT_10);
		testTarget.setAncillaryFlg(INT_10);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(4, result.getErrorInfoList().size());
		
		// 異常系(@Min、DecimailMin)
		testTarget = new EstimationElectricDto();
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setFeeSimulationHead(new FeeSimulationHeadDto());
		testTarget.setElectricExpertEstimation(new ElectricExpertEstimationDto());
		testTarget.setContractPower(DECIMAL_MINUS_001);
		testTarget.setPowerRate(DECIMAL_MINUS_001);
		testTarget.setLoadFactor(DECIMAL_MINUS_001);
		testTarget.setBasePart(DECIMAL_MINUS_001);
		testTarget.setFluctuatingPart(DECIMAL_MINUS_001);
		testTarget.setPartialSupplyFlg(INT_MINUS_1);
		testTarget.setSpareWireFlg(INT_MINUS_1);
		testTarget.setSparePowerFlg(INT_MINUS_1);
		testTarget.setAncillaryFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(9, result.getErrorInfoList().size());

	}
	
	@Test
	public void ElectricExpertEstimationDtoのテスト() throws Exception {

		ElectricExpertEstimation entity = electricExpertEstimationRepository.findOne(1L);
		ElectricExpertEstimationDto testTarget = new ElectricExpertEstimationDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
	
		// 異常系(@Size(max))
		testTarget.setName(STR_256);
		testTarget.setMailAddress(STR_256);
		testTarget.setPhoneNumber(STR_256);
		testTarget.setAffiliationCode(STR_256);
		testTarget.setBelongs(STR_256);
		testTarget.setMomEmpId(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());
		
	}
	
	@Test
	public void ElectricDealerEstimationDtoのテスト() throws Exception {

		ElectricDealerEstimation entity = electricDealerEstimationRepository.findOne(1L);
		ElectricDealerEstimationDto testTarget = new ElectricDealerEstimationDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
	
		// 異常系(@Size(max))
		testTarget.setCompanyId(STR_256);
		testTarget.setCompanyBusinessName(STR_256);
		testTarget.setPhoneNumber(STR_256);
		testTarget.setPostNumber(STR_256);
		testTarget.setAddress(STR_256);
		testTarget.setMailAddress1(STR_256);
		testTarget.setMailAddress2(STR_256);
		testTarget.setMailAddress3(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(8, result.getErrorInfoList().size());
		
	}
	
	@Test
	public void FeeSimulationHeadDtoのテスト() throws Exception {

		FeeSimulationHead entity = feeSimulationHeadRepository.findOne(1L);
		FeeSimulationHeadDto testTarget = new FeeSimulationHeadDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
	
		// 異常系(@Size(max))
		testTarget.setSimNumberMain(STR_256);
		testTarget.setSimNumberSub(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		
		// 異常系(@DecimaiMin)
		testTarget = new FeeSimulationHeadDto();
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setAnnualElectricityRateCurrent(DECIMAL_MINUS_001);
		testTarget.setAnnualElectricityRateAfter(DECIMAL_MINUS_001);
		testTarget.setReductionAmount(DECIMAL_MINUS_001);
		testTarget.setReductionRate(DECIMAL_MINUS_001);
		testTarget.setOverallPrice1(DECIMAL_MINUS_001);
		testTarget.setOverallPrice2(DECIMAL_MINUS_001);
		testTarget.setOverallPrice3(DECIMAL_MINUS_001);
		testTarget.setLoadFactor(DECIMAL_MINUS_001);
		testTarget.setBasicRateSellingPrice(DECIMAL_MINUS_001);
		testTarget.setBasicRateBankPriceBusiness(DECIMAL_MINUS_001);
		testTarget.setBasicRateBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerBankPriceBusiness(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonBankPriceBusiness(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setSpareLineSellingPrice(DECIMAL_MINUS_001);
		testTarget.setSpareLineBankPriceBusiness(DECIMAL_MINUS_001);
		testTarget.setSpareLineBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setSparePowerSellingPrice(DECIMAL_MINUS_001);
		testTarget.setSparePowerBankPriceBusiness(DECIMAL_MINUS_001);
		testTarget.setSparePowerBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setAncillarySellingPrice(DECIMAL_MINUS_001);
		testTarget.setAncillaryBankPriceBusiness(DECIMAL_MINUS_001);
		testTarget.setAncillaryBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setFeeFixedAmountInTax(DECIMAL_MINUS_001);
		testTarget.setFeeFixedRate(DECIMAL_MINUS_001);
		testTarget.setElectricityChargeBusiness(DECIMAL_MINUS_001);
		testTarget.setGrossMarginBusiness(DECIMAL_MINUS_001);
		testTarget.setGrossProfitMarginBusiness(DECIMAL_MINUS_001);
		testTarget.setElectricityChargeRj(DECIMAL_MINUS_001);
		testTarget.setGrossMarginRj(DECIMAL_MINUS_001);
		testTarget.setGrossProfitMarginRj(DECIMAL_MINUS_001);
		testTarget.setBasicRateListPrice(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(35, result.getErrorInfoList().size());
		
	}
	
	@Test
	public void EstimationUpdateParameterのテスト() throws Exception {
		
		// 異常系(@NotNull)
		EstimationUpdateParameter testTarget = new EstimationUpdateParameter();
		testTarget.setEstimationDto(null);
		testTarget.setEstimationElectricDto(null);
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		
		//@Validが有効であること
		ElectricExpertEstimationDto electricExpertEstimationDto = new ElectricExpertEstimationDto();
		electricExpertEstimationDto.setName(STR_256);
		
		ElectricDealerEstimationDto electricDealerEstimationDto = new ElectricDealerEstimationDto();
		electricDealerEstimationDto.setCompanyId(STR_256);
		electricDealerEstimationDto.setPaymentMethod(PaymentMethod.定率);
		
		FeeSimulationHeadDto feeSimulationHeadDto = new FeeSimulationHeadDto();
		feeSimulationHeadDto.setAncillaryBankPriceBusiness(DECIMAL_MINUS_001);
		
		EstimationElectricDto estimationElectricDto = new EstimationElectricDto();
		estimationElectricDto.setElectricExpertEstimation(electricExpertEstimationDto);
		estimationElectricDto.setFeeSimulationHead(feeSimulationHeadDto);
		estimationElectricDto.setElectricDealerEstimation(electricDealerEstimationDto);
		estimationElectricDto.setVoltageCategory(VoltageCategory.高圧);
		estimationElectricDto.setElectricCommercialFlowDiv(ElectricCommercialFlowDiv.直売);
		
		testTarget = new EstimationUpdateParameter();	
		testTarget.setEstimationElectricDto(estimationElectricDto);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(4, result.getErrorInfoList().size());
		
	}
}
