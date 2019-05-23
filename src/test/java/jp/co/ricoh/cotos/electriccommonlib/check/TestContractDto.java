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
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingBasicInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingMailAddressInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.CancellationInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ClientInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ClientMasterDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricAttachedFileDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricDealerContractDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricExpertContractDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.EntryContentHighPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.EntryContentLowPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ImportantPointExplainerDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.MailAddressInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.UnitPriceHighPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.UnitPriceLowPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingMailAddressInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingBasicInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingMailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
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
	private static final int INT_100000 = 100000;
	private static final BigDecimal DECIMAL_MINUS_001 = new BigDecimal("-0.01");
	private static final BigDecimal DECIMAL_0001 = new BigDecimal("0.001");

	static ConfigurableApplicationContext context;

	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	BillingBasicInformationRepository billingBasicInformationRepository;

	@Autowired
	BillingMailAddressInformationRepository billingMailAddressInformationRepository;

	@Autowired
	ContractElectricRepository contractElectricRepository;

	@Autowired
	ClientMasterRepository clientMasterRepository;

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
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setElectricExpertContractDto(electricExpertContractDto);
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
		Assert.assertEquals(33, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setElectricExpertContractDto(electricExpertContractDto);
		testTarget.setContractId(LONG_MINUS_1);
		testTarget.setSendMailFlg(INT_MINUS_1);
		testTarget.setTransferCheckFlg(INT_MINUS_1);
		testTarget.setAtomicPaymentFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);

		// 異常系(@Max)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setElectricExpertContractDto(electricExpertContractDto);
		testTarget.setSendMailFlg(INT_10);
		testTarget.setTransferCheckFlg(INT_10);
		testTarget.setAtomicPaymentFlg(INT_10);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 3);
	}

	@Test
	public void MailAddressInformationDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		MailAddressInformationDto testTarget = new MailAddressInformationDto();
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setMailIdentification(null);
		testTarget.setName(null);
		testTarget.setMailAddress(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setName(STR_256);
		testTarget.setMailAddress(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setPeakAlertThreshold(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setPeakAlertThreshold(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
	}

	@Test
	public void EntryContentHighPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		EntryContentHighPressureDto testTarget = new EntryContentHighPressureDto();
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(Max))
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setScale(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setMeasureDateHigh(INT_100000);
		testTarget.setSpareWireFlg(INT_10);
		testTarget.setSparePowerFlg(INT_10);
		testTarget.setAncillaryFlg(INT_10);
		testTarget.setThermalStorageMeterFlg(INT_10);
		testTarget.setRenewableEnergyExemptionFlg(INT_10);
		testTarget.setDemandPlaceResales(INT_10);
		testTarget.setPartialSupplyFlg(INT_10);
		testTarget.setOtherFlg(INT_10);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(9, result.getErrorInfoList().size());

		// 異常系(＠Min)
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setMeasureDateHigh(INT_MINUS_1);
		testTarget.setSpareWireFlg(INT_MINUS_1);
		testTarget.setSparePowerFlg(INT_MINUS_1);
		testTarget.setAncillaryFlg(INT_MINUS_1);
		testTarget.setThermalStorageMeterFlg(INT_MINUS_1);
		testTarget.setRenewableEnergyExemptionFlg(INT_MINUS_1);
		testTarget.setDemandPlaceResales(INT_MINUS_1);
		testTarget.setPartialSupplyFlg(INT_MINUS_1);
		testTarget.setOtherFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(9, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setContractPowerHigh(DECIMAL_MINUS_001);
		testTarget.setPowerRate(DECIMAL_MINUS_001);
		testTarget.setLoadFactor(DECIMAL_MINUS_001);
		testTarget.setPartialSupplySettingValue(DECIMAL_MINUS_001);
		testTarget.setBase(DECIMAL_MINUS_001);
		testTarget.setVariable(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setContractPowerHigh(DECIMAL_0001);
		testTarget.setPowerRate(DECIMAL_0001);
		testTarget.setLoadFactor(DECIMAL_0001);
		testTarget.setPartialSupplySettingValue(DECIMAL_0001);
		testTarget.setBase(DECIMAL_0001);
		testTarget.setVariable(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());

	}

	@Test
	public void EntryContentLowPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		EntryContentLowPressureDto testTarget = new EntryContentLowPressureDto();
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setContractCapacityUnit(null);
		testTarget.setContractElectricCurrentUnit(null);
		testTarget.setBasicMeterReadingDate(null);
		testTarget.setLowPressureType(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(4, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setContractElectricCurrent(DECIMAL_MINUS_001);
		testTarget.setContractElectricPower(DECIMAL_MINUS_001);
		testTarget.setLoadFactor(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setContractElectricCurrent(DECIMAL_0001);
		testTarget.setContractElectricPower(DECIMAL_0001);
		testTarget.setLoadFactor(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

	}

	@Test
	public void ContractElectricAttachedFileDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ContractElectricAttachedFileDto testTarget = new ContractElectricAttachedFileDto();
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);
		testTarget.setFileName(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);
		testTarget.setFileName(STR_256);
		testTarget.setFileKind(STR_256);
		testTarget.setAttachedComment(STR_1001);
		testTarget.setAttachedEmpId(STR_256);
		testTarget.setAttachedEmpName(STR_256);
		testTarget.setAttachedOrgName(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());

	}

	@Test
	public void UnitPriceHighPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		UnitPriceHighPressureDto testTarget = new UnitPriceHighPressureDto();
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setUnitPriceType(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setCreatedUserName(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_100000);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setBasicListPrice(DECIMAL_MINUS_001);
		testTarget.setBasicSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonPrice(DECIMAL_MINUS_001);
		testTarget.setSpareLinePrice(DECIMAL_MINUS_001);
		testTarget.setSparePowerPrice(DECIMAL_MINUS_001);
		testTarget.setAncillaryPrice(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(7, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setBasicListPrice(DECIMAL_0001);
		testTarget.setBasicSellingPrice(DECIMAL_0001);
		testTarget.setUsageFeeSummerPrice(DECIMAL_0001);
		testTarget.setUsageFeeOtherSeasonPrice(DECIMAL_0001);
		testTarget.setSpareLinePrice(DECIMAL_0001);
		testTarget.setSparePowerPrice(DECIMAL_0001);
		testTarget.setAncillaryPrice(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(7, result.getErrorInfoList().size());

	}

	@Test
	public void UnitPriceLowPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		UnitPriceLowPressureDto testTarget = new UnitPriceLowPressureDto();
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setUnitPriceType(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setCreatedUserName(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_100000);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setBasicCharge(DECIMAL_MINUS_001);
		testTarget.setPerUseLightListPrice(DECIMAL_MINUS_001);
		testTarget.setPerUseLightSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerListPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonListPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonSellingPrice(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(7, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setBasicCharge(DECIMAL_0001);
		testTarget.setPerUseLightListPrice(DECIMAL_0001);
		testTarget.setPerUseLightSellingPrice(DECIMAL_0001);
		testTarget.setUsageFeeSummerListPrice(DECIMAL_0001);
		testTarget.setUsageFeeSummerSellingPrice(DECIMAL_0001);
		testTarget.setUsageFeeOtherSeasonListPrice(DECIMAL_0001);
		testTarget.setUsageFeeOtherSeasonSellingPrice(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(7, result.getErrorInfoList().size());
	}

	@Test
	public void CancellationInformationDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		CancellationInformationDto testTarget = new CancellationInformationDto();
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setSpecifiedTime(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setTransmissionStopFlg(INT_10);
		testTarget.setCancellationBillingFlg(INT_10);
		testTarget.setSuperiorConfirmFlg(INT_10);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setTransmissionStopFlg(INT_MINUS_1);
		testTarget.setCancellationBillingFlg(INT_MINUS_1);
		testTarget.setSuperiorConfirmFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setCancellationAmount(DECIMAL_MINUS_001);
		testTarget.setAdjustmentAmount(DECIMAL_MINUS_001);
		testTarget.setLiquidationAmount(DECIMAL_MINUS_001);
		testTarget.setAdjustmentLiquidationAmount(DECIMAL_MINUS_001);
		testTarget.setPenaltyAmount(DECIMAL_MINUS_001);
		testTarget.setAdjustmentPenaltyAmount(DECIMAL_MINUS_001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setCancellationAmount(DECIMAL_0001);
		testTarget.setAdjustmentAmount(DECIMAL_0001);
		testTarget.setLiquidationAmount(DECIMAL_0001);
		testTarget.setAdjustmentLiquidationAmount(DECIMAL_0001);
		testTarget.setPenaltyAmount(DECIMAL_0001);
		testTarget.setAdjustmentPenaltyAmount(DECIMAL_0001);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());
	}

	@Test
	public void ElectricExpertContractDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ElectricExpertContractDto testTarget = new ElectricExpertContractDto();
		BeanUtils.copyProperties(entity.getElectricExpertContract(), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@String(max))
		BeanUtils.copyProperties(entity.getElectricExpertContract(), testTarget);
		testTarget.setName(STR_256);
		testTarget.setMailAddress(STR_256);
		testTarget.setPhoneNumber(STR_256);
		testTarget.setAffiliationCode(STR_256);
		testTarget.setBelongs(STR_256);
		testTarget.setFixTransferDestinationCode(STR_256);
		testTarget.setFixTransferSectionName(STR_256);
		testTarget.setMomEmpId(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(8, result.getErrorInfoList().size());

	}

	@Test
	public void ElectricDealerContractDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ElectricDealerContractDto testTarget = new ElectricDealerContractDto();
		BeanUtils.copyProperties(entity.getElectricDealerContract(), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getElectricDealerContract(), testTarget);
		testTarget.setCompanyId(STR_256);
		testTarget.setCompanyBusinessName(STR_256);
		testTarget.setPhoneNumber(STR_256);
		testTarget.setMailAddress1(STR_256);
		testTarget.setMailAddress2(STR_256);
		testTarget.setMailAddress3(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());
	}

	@Test
	public void ClientInformationDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ClientInformationDto testTarget = new ClientInformationDto();
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setClientCode(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setClientCode(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setActiveFlg(INT_10);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setActiveFlg(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
	}

	@Test
	public void ClientMasterDtoのテスト() throws Exception {

		ClientMaster entity = clientMasterRepository.findOne(1L);
		ClientMasterDto testTarget = new ClientMasterDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setClientCode(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

	}

	@Test
	public void BillingMailAddressInformationDtoのテスト() throws Exception {

		BillingMailAddressInformation entity = billingMailAddressInformationRepository.findOne(1L);
		BillingMailAddressInformationDto testTarget = new BillingMailAddressInformationDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
		
		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setName(null);
		testTarget.setMailAddress(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		
		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setName(STR_256);
		testTarget.setMailAddress(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		
		// 異常系(@Min)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setMyricohId(INT_MINUS_1);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
	}

	@Test
	public void ImportantPointExplainerDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ImportantPointExplainerDto testTarget = new ImportantPointExplainerDto();
		BeanUtils.copyProperties(entity.getImportantPointExplainer(), testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getImportantPointExplainer(), testTarget);
		testTarget.setDescriptionName(STR_256);
		testTarget.setOrganizationName1(STR_256);
		testTarget.setOrganizationName2(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());
	}

	@Test
	public void BillingBasicInformationDtoのテスト() {
		BillingBasicInformation entity = billingBasicInformationRepository.findOne(1L);
		BillingBasicInformationDto testTarget = new BillingBasicInformationDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setClientCode(null);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setTradingCompanyCode(STR_256);
		testTarget.setClientCode(STR_256);
		testTarget.setBillingName(STR_256);
		testTarget.setBillingAddress(STR_256);
		testTarget.setSiteNumber(STR_256);
		testTarget.setCollectCondition(STR_256);
		testTarget.setCustomerAccountNumber(STR_256);
		testTarget.setBankNumber(STR_256);
		testTarget.setBankName(STR_256);
		testTarget.setBranchNumber(STR_256);
		testTarget.setBranchName(STR_256);
		testTarget.setAccountHolderKana(STR_256);
		testTarget.setVertualAccountNumber(STR_256);
		testTarget.setBankCode(STR_256);
		testTarget.setAccountType(STR_256);
		testTarget.setSalesDivisionCode(STR_256);
		result = testSecurityController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(16, result.getErrorInfoList().size());
	}

}
