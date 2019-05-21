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
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricExpertContractDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.TestSecurityController;
import jp.co.ricoh.cotos.electriccommonlib.security.bean.ParamterCheckResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestContractDto {

	private static final String STR_256 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345";
	private static final String STR_1001 = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
	private static final int INT_MINUS_1 = -1;
	private static final Long LONG_MINUS_1 = -1L;
	private static final int INT_10 = 10;
	private static final int INT_100 = 100;
	private static final int INT_1000 = 1000;
	private static final int INT_100000 = 100000;
	private static final BigDecimal DECIMAL_MINUS_001 = new BigDecimal("-0.01");
	private static final BigDecimal DECIMAL_0001 = new BigDecimal("0.001");

	static ConfigurableApplicationContext context;
	
	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	ContractElectricRepository contractElectricRepository;

	@Autowired
	TestTools testTool;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/contract/Electric.sql");
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
	public void ContractElectricDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ContractElectricDto testTarget = new ContractElectricDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ElectricExpertContractDto electricExpertContractDto = new ElectricExpertContractDto();
		BeanUtils.copyProperties(entity.getElectricExpertContract(), electricExpertContractDto);
		testTarget.setElectricExpertContractDto(electricExpertContractDto);
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
		
		// 異常系（@NotNull）
		testTarget.setVoltageCategory(null);
		testTarget.setElectricExpertContractDto(null);
		testTarget.setElectricCommercialFlowDiv(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 3);
		
		// 異常系（@Size(max))
		testTarget.setSimNumber(STR_256);
		testTarget.setEntryNumber(STR_256);
		testTarget.setCustomerNumber(STR_256);
		testTarget.setFeedPointNumber(STR_256);
		testTarget.setSupplierCustId(STR_256);
		testTarget.setCustomerName(STR_256);
		testTarget.setCustomerNameKana(STR_256);
		testTarget.setDemandNameKr(STR_256);
		testTarget.setZipCode(STR_256);
		testTarget.setBildInfo(STR_256);
		testTarget.setCity(STR_256);
		testTarget.setAddress(STR_256);
		testTarget.setBuildingName(STR_256);
		testTarget.setPhoneNumber(STR_256);
		testTarget.setContractHolderOld(STR_256);
		testTarget.setDemandPlaceOld(STR_256);
		testTarget.setLicensedEngineerName(STR_256);
		testTarget.setLicensedEngineerTel(STR_256);
		testTarget.setLicensedEngineerDep(STR_256);
		testTarget.setCurrentElectricCompany(STR_256);
		testTarget.setCurrentContractNumber(STR_256);
		testTarget.setPowerArea(STR_256);
		testTarget.setChargeCycle(STR_256);
		testTarget.setSupplyStartDate(STR_256);
		testTarget.setElectricMenu(STR_256);
		testTarget.setContractAmount(STR_256);
		testTarget.setOppSysKeyBn(STR_256);
		testTarget.setNishikiContractNumber(STR_256);
		testTarget.setCstmrBn(STR_256);
		testTarget.setItemCode(STR_256);
		testTarget.setBillingStartMonth(STR_256);
		testTarget.setElectricCompanyCode(STR_256);
		testTarget.setElectricMenuCode(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 33);
		
		// 異常系(@Min)
		testTarget.setContractId(LONG_MINUS_1);
		testTarget.setSendMailFlg(INT_MINUS_1);
		testTarget.setTransferCheckFlg(INT_MINUS_1);
		testTarget.setAtomicPaymentFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);
		
		// 異常系(@Max)
		testTarget.setSendMailFlg(INT_10);
		testTarget.setTransferCheckFlg(INT_10);
		testTarget.setAtomicPaymentFlg(INT_10);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 3);
	}

	@Test
	public void MailAddressInformationDtoのテスト() throws Exception {

	}

	@Test
	public void EntryContentHighPressureDtoのテスト() throws Exception {

	}

	@Test
	public void EntryContentLowPressureDtoのテスト() throws Exception {

	}

	@Test
	public void ContractElectricAttachedFileDtoのテスト() throws Exception {

	}

	@Test
	public void UnitPriceHighPressureDtoのテスト() throws Exception {

	}

	@Test
	public void UnitPriceLowPressureDtoのテスト() throws Exception {

	}

	@Test
	public void CancellationInformationDtoのテスト() throws Exception {

	}

	@Test
	public void ElectricExpertContractDtoのテスト() throws Exception {

	}

	@Test
	public void ElectricDealerContractDtoのテスト() throws Exception {

	}

	@Test
	public void ClientInformationDtoのテスト() throws Exception {

	}

	@Test
	public void BillingMailAddressInformationDtoのテスト() throws Exception {

	}

}
