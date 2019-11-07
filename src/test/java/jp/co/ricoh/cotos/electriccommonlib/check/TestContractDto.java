package jp.co.ricoh.cotos.electriccommonlib.check;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.AgencyContractInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingBasicInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingHistoryDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingHistoryUpdateDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingMailAddressInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.CancellationInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ClientInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ClientMasterDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricAttachedFileDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricBillingAttachedFileDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricDealerContractDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricExpertContractDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.EntryContentHighPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.EntryContentLowPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ImportantPointExplainerDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.MailAddressInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.UnitPriceHighPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.UnitPriceLowPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.BillingMailAddressInformationChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.BillingMailAddressInformationCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractAddedEditorEmpChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractAddedEditorEmpCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricChangePlanExtInputDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricCreateExtInputDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricInfoChangeExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractInfoChangeExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractPicSaEmpChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractPicSaEmpCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.CustomerContractChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.CustomerContractCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ElectricDealerContractChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ElectricDealerContractCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ElectricExpertContractChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ElectricExpertContractCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.FeeSimulationHeadChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.FeeSimulationHeadCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ImportantPointExplainerChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ImportantPointExplainerCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.MailAddressInformationChangePlanExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.MailAddressInformationCreateExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultBillingMailAddressInfoExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultContractAddedEditorEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultContractElectricExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultContractPicSaEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultCustomerContractExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultElectricDealerContractExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultElectricExpertContractExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultMailAddressInfoExtDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.BeforeDebitContact;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendInvoiceDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.SendMyRicoh;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.AccruedSection;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.InvoiceCreateDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.InvoiceForm;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.SendMail;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingMailAddressInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricBillingAttachedFile.FileKind;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingBasicInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingMailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
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
	TestCheckController testCheckController;

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
		testTarget.setElectricExpertContract(electricExpertContractDto);
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系（@NotNull）
		testTarget.setVoltageCategory(null);
		testTarget.setElectricExpertContract(null);
		testTarget.setElectricCommercialFlowDiv(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 3);

		// 異常系（@Size(max))
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setElectricExpertContract(electricExpertContractDto);
		testTarget.setSimNumberMain(STR_256);
		testTarget.setSimNumberSub(STR_256);
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
		testTarget.setCo2EmissionFactor(STR_256);
		testTarget.setContractPeriod(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(35, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setElectricExpertContract(electricExpertContractDto);
		testTarget.setContractId(LONG_MINUS_1);
		testTarget.setSendMailFlg(INT_MINUS_1);
		testTarget.setTransferCheckFlg(INT_MINUS_1);
		testTarget.setAtomicPaymentFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 4);

		// 異常系(@Max)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setElectricExpertContract(electricExpertContractDto);
		testTarget.setSendMailFlg(INT_10);
		testTarget.setTransferCheckFlg(INT_10);
		testTarget.setAtomicPaymentFlg(INT_10);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertTrue(result.getErrorInfoList().size() == 3);
	}

	@Test
	public void MailAddressInformationDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		MailAddressInformationDto testTarget = new MailAddressInformationDto();
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setMailIdentification(null);
		testTarget.setName(null);
		testTarget.setMailAddress(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setName(STR_256);
		testTarget.setMailAddress(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setPeakAlertThreshold(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		BeanUtils.copyProperties(entity.getMailAddressInformationList().get(0), testTarget);
		testTarget.setPeakAlertThreshold(DECIMAL_0001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
	}

	@Test
	public void EntryContentHighPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		EntryContentHighPressureDto testTarget = new EntryContentHighPressureDto();
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

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
		testTarget.setNotApplicableFlg(INT_10);
		testTarget.setTohokuAgencyNewFlg(INT_10);
		testTarget.setTohokuAgencySwitchFlg(INT_10);
		testTarget.setIncreaseElectricPowerFlg(INT_10);
		testTarget.setNotes(STR_1001 + STR_1001 + STR_1001 + STR_1001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(14, result.getErrorInfoList().size());

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
		testTarget.setNotApplicableFlg(INT_MINUS_1);
		testTarget.setTohokuAgencyNewFlg(INT_MINUS_1);
		testTarget.setTohokuAgencySwitchFlg(INT_MINUS_1);
		testTarget.setIncreaseElectricPowerFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(13, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setContractPowerHigh(DECIMAL_MINUS_001);
		testTarget.setPowerRate(DECIMAL_MINUS_001);
		testTarget.setLoadFactor(DECIMAL_MINUS_001);
		testTarget.setPartialSupplySettingValue(DECIMAL_MINUS_001);
		testTarget.setBase(DECIMAL_MINUS_001);
		testTarget.setVariable(DECIMAL_MINUS_001);
		testTarget.setAncillaryCapacityHighPressure(DECIMAL_MINUS_001);
		testTarget.setAgencyFeeAmount(DECIMAL_MINUS_001);
		testTarget.setAgencyFeeRate(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(9, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getEntryContentHighPressure(), testTarget);
		testTarget.setContractPowerHigh(DECIMAL_0001);
		testTarget.setPowerRate(DECIMAL_0001);
		testTarget.setLoadFactor(DECIMAL_0001);
		testTarget.setPartialSupplySettingValue(DECIMAL_0001);
		testTarget.setBase(DECIMAL_0001);
		testTarget.setVariable(DECIMAL_0001);
		testTarget.setAncillaryCapacityHighPressure(DECIMAL_0001);
		testTarget.setAgencyFeeAmount(DECIMAL_0001);
		testTarget.setAgencyFeeRate(DECIMAL_0001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(9, result.getErrorInfoList().size());

	}

	@Test
	public void EntryContentLowPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		EntryContentLowPressureDto testTarget = new EntryContentLowPressureDto();
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setBasicMeterReadingDate(null);
		testTarget.setLowPressureType(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setContractElectricCurrent(DECIMAL_MINUS_001);
		testTarget.setContractElectricPower(DECIMAL_MINUS_001);
		testTarget.setLoadFactor(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setContractElectricCurrent(DECIMAL_0001);
		testTarget.setContractElectricPower(DECIMAL_0001);
		testTarget.setLoadFactor(DECIMAL_0001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Max(max))
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), testTarget);
		testTarget.setBasicMeterReadingDate(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

	}

	@Test
	public void ContractElectricAttachedFileDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ContractElectricAttachedFileDto testTarget = new ContractElectricAttachedFileDto();
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);
		testTarget.setElectricFileType(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);
		testTarget.setFileName(STR_256);
		testTarget.setFileKind(STR_256);
		testTarget.setAttachedComment(STR_1001);
		testTarget.setAttachedEmpId(STR_256);
		testTarget.setAttachedEmpName(STR_256);
		testTarget.setAttachedOrgName(STR_256);
		testTarget.setDocumentName(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(7, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);
		testTarget.setTargetRequiredFlg(INT_10);
		testTarget.setActiveFlg(INT_10);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getContractElectricAttachedFileList().get(0), testTarget);
		testTarget.setTargetRequiredFlg(INT_MINUS_1);
		testTarget.setActiveFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

	}

	@Test
	public void UnitPriceHighPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		UnitPriceHighPressureDto testTarget = new UnitPriceHighPressureDto();
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setUnitPriceType(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setCreatedUserName(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_100000);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getUnitPriceHighPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
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
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
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
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(7, result.getErrorInfoList().size());

	}

	@Test
	public void UnitPriceLowPressureDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		UnitPriceLowPressureDto testTarget = new UnitPriceLowPressureDto();
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setUnitPriceType(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setCreatedUserName(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_100000);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setNumberOfChanges(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setBasicListPrice(DECIMAL_MINUS_001);
		testTarget.setBasicSellingPrice(DECIMAL_MINUS_001);
		testTarget.setPerUseLightListPrice(DECIMAL_MINUS_001);
		testTarget.setPerUseLightSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerListPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeSummerSellingPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonListPrice(DECIMAL_MINUS_001);
		testTarget.setUsageFeeOtherSeasonSellingPrice(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(8, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getUnitPriceLowPressureList().get(0), testTarget);
		testTarget.setBasicListPrice(DECIMAL_MINUS_001);
		testTarget.setBasicSellingPrice(DECIMAL_MINUS_001);
		testTarget.setPerUseLightListPrice(DECIMAL_0001);
		testTarget.setPerUseLightSellingPrice(DECIMAL_0001);
		testTarget.setUsageFeeSummerListPrice(DECIMAL_0001);
		testTarget.setUsageFeeSummerSellingPrice(DECIMAL_0001);
		testTarget.setUsageFeeOtherSeasonListPrice(DECIMAL_0001);
		testTarget.setUsageFeeOtherSeasonSellingPrice(DECIMAL_0001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(8, result.getErrorInfoList().size());
	}

	@Test
	public void CancellationInformationDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		CancellationInformationDto testTarget = new CancellationInformationDto();
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setSpecifiedTime(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setTransmissionStopFlg(INT_10);
		testTarget.setCancellationBillingFlg(INT_10);
		testTarget.setSuperiorConfirmFlg(INT_10);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@Min)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setTransmissionStopFlg(INT_MINUS_1);
		testTarget.setCancellationBillingFlg(INT_MINUS_1);
		testTarget.setSuperiorConfirmFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setCancellationAmount(DECIMAL_MINUS_001);
		testTarget.setAdjustmentAmount(DECIMAL_MINUS_001);
		testTarget.setLiquidationAmount(DECIMAL_MINUS_001);
		testTarget.setAdjustmentLiquidationAmount(DECIMAL_MINUS_001);
		testTarget.setPenaltyAmount(DECIMAL_MINUS_001);
		testTarget.setAdjustmentPenaltyAmount(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());

		// 異常系(@Decimal)
		BeanUtils.copyProperties(entity.getCancellationInformation(), testTarget);
		testTarget.setCancellationAmount(DECIMAL_0001);
		testTarget.setAdjustmentAmount(DECIMAL_0001);
		testTarget.setLiquidationAmount(DECIMAL_0001);
		testTarget.setAdjustmentLiquidationAmount(DECIMAL_0001);
		testTarget.setPenaltyAmount(DECIMAL_0001);
		testTarget.setAdjustmentPenaltyAmount(DECIMAL_0001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());
	}

	@Test
	public void ElectricExpertContractDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ElectricExpertContractDto testTarget = new ElectricExpertContractDto();
		BeanUtils.copyProperties(entity.getElectricExpertContract(), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
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
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(8, result.getErrorInfoList().size());

	}

	@Test
	public void ElectricDealerContractDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ElectricDealerContractDto testTarget = new ElectricDealerContractDto();
		BeanUtils.copyProperties(entity.getElectricDealerContract(), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getElectricDealerContract(), testTarget);
		testTarget.setCompanyId(STR_256);
		testTarget.setCompanyBusinessName(STR_256);
		testTarget.setPhoneNumber(STR_256);
		testTarget.setMailAddress1(STR_256);
		testTarget.setMailAddress2(STR_256);
		testTarget.setMailAddress3(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());
	}

	@Test
	public void ClientInformationDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ClientInformationDto testTarget = new ClientInformationDto();
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setClientCode(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setClientCode(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setActiveFlg(INT_10);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

		// 異常系(@Max)
		BeanUtils.copyProperties(entity.getClientInformationList().get(0), testTarget);
		testTarget.setActiveFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
	}

	@Test
	public void ClientMasterDtoのテスト() throws Exception {

		ClientMaster entity = clientMasterRepository.findOne(1L);
		ClientMasterDto testTarget = new ClientMasterDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setClientCode(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

	}

	@Test
	public void BillingMailAddressInformationDtoのテスト() throws Exception {

		BillingMailAddressInformation entity = billingMailAddressInformationRepository.findOne(1L);
		BillingMailAddressInformationDto testTarget = new BillingMailAddressInformationDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setName(null);
		testTarget.setMailAddress(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setName(STR_256);
		testTarget.setMailAddress(STR_256);
		testTarget.setMyricohId(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());
	}

	@Test
	public void ImportantPointExplainerDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);
		ImportantPointExplainerDto testTarget = new ImportantPointExplainerDto();
		BeanUtils.copyProperties(entity.getImportantPointExplainer(), testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Size(max))
		BeanUtils.copyProperties(entity.getImportantPointExplainer(), testTarget);
		testTarget.setDescriptionName(STR_256);
		testTarget.setOrganizationName1(STR_256);
		testTarget.setOrganizationName2(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());
	}

	@Test
	public void BillingBasicInformationDtoのテスト() {
		BillingBasicInformation entity = billingBasicInformationRepository.findOne(1L);
		BillingBasicInformationDto testTarget = new BillingBasicInformationDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setClientCode(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
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
		testTarget.setCollectMethod(STR_256);
		testTarget.setBillingDiv(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(18, result.getErrorInfoList().size());
	}

	@Test
	public void ContractElectricCreateExtInputDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);

		// テストデータ作成
		ContractElectricCreateExtInputDto testTarget = new ContractElectricCreateExtInputDto();
		testTarget.setCaseNumber("案件番号");
		testTarget.setCaseTitle("案件名");
		testTarget.setClientCode("得意先コード");
		testTarget.setChangePreferredDate("2019/05/31");
		// 契約(電力)
		ContractElectricCreateExtDto contractElectricExtDto = new ContractElectricCreateExtDto();
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), contractElectricExtDto);
		BeanUtils.copyProperties(entity, contractElectricExtDto);
		contractElectricExtDto.setBasicMeterReadingDate("dd");
		contractElectricExtDto.setElectricCommercialFlowDiv("直売");
		contractElectricExtDto.setElectricCommercialFlowDivCode("1");
		contractElectricExtDto.setFixTransferDestinationCode("修正時振替先コード");
		contractElectricExtDto.setVoltageCategory("1");
		contractElectricExtDto.setEntryDate("2019/05/31");
		contractElectricExtDto.setCurrentElectricCompanyDiv("1");
		contractElectricExtDto.setContractUnit("A");
		contractElectricExtDto.setSupplyStartScheduledDate("2019/05/31");
		contractElectricExtDto.setPowerArea(entity.getElectricArea().toString());
		testTarget.setContractElectric(contractElectricExtDto);
		// 顧客
		CustomerContractCreateExtDto customerContractExtDto = new CustomerContractCreateExtDto();
		customerContractExtDto.setMomCustId("MoMkjbID");
		customerContractExtDto.setCompanyId("MoM企業ID");
		customerContractExtDto.setOfficeId("MoM事業所ID");
		customerContractExtDto.setPicName("担当者氏名");
		customerContractExtDto.setPicNameKana("担当者氏名(カナ)");
		customerContractExtDto.setPicDeptName("担当者部署");
		customerContractExtDto.setPicPhoneNumber("担当者電話番号");
		customerContractExtDto.setPicFaxNumber("担当者FAX番号");
		customerContractExtDto.setPicMailAddress("担当者メールアドレス");
		testTarget.setCustomerContract(customerContractExtDto);
		// メールアドレス情報
		List<MailAddressInformationCreateExtDto> mailAddressInformationExtDtoList = new ArrayList<>();
		MailAddressInformationCreateExtDto mailAddressInformationExtDto = new MailAddressInformationCreateExtDto();
		mailAddressInformationExtDto.setName("氏名");
		mailAddressInformationExtDto.setMailAddress("メールアドレス");
		mailAddressInformationExtDtoList.add(mailAddressInformationExtDto);
		testTarget.setContractPersonMailAddressList(mailAddressInformationExtDtoList);
		// 請求先メールアドレス
		List<BillingMailAddressInformationCreateExtDto> billingMailAddressInformationExtDtoList = new ArrayList<>();
		BillingMailAddressInformationCreateExtDto billingMailAddressInformationExtDto = new BillingMailAddressInformationCreateExtDto();
		billingMailAddressInformationExtDto.setName("氏名");
		billingMailAddressInformationExtDto.setMailAddress("メールアドレス");
		billingMailAddressInformationExtDto.setMyricohId("MyRicohID");
		billingMailAddressInformationExtDtoList.add(billingMailAddressInformationExtDto);
		testTarget.setBillingMailAddressList(billingMailAddressInformationExtDtoList);
		// 契約担当SA社員
		ContractPicSaEmpCreateExtDto contractPicSaEmpExtDto = new ContractPicSaEmpCreateExtDto();
		contractPicSaEmpExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setContractPicSaEmp(contractPicSaEmpExtDto);
		// 電力専任情報
		ElectricExpertContractCreateExtDto electricExpertContractExtDto = new ElectricExpertContractCreateExtDto();
		electricExpertContractExtDto.setMomEmpId("MoM社員ID");
		testTarget.setElectricExpertContract(electricExpertContractExtDto);
		// 追加編集者
		List<ContractAddedEditorEmpCreateExtDto> contractAddedEditorEmpExtDtoList = new ArrayList<>();
		ContractAddedEditorEmpCreateExtDto contractAddedEditorEmpExtDto = new ContractAddedEditorEmpCreateExtDto();
		contractAddedEditorEmpExtDto.setMomEmployeeId("MoM社員ID");
		contractAddedEditorEmpExtDtoList.add(contractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(contractAddedEditorEmpExtDtoList);
		// 重要項目説明者
		ImportantPointExplainerCreateExtDto importantPointExplainerExtDto = new ImportantPointExplainerCreateExtDto();
		importantPointExplainerExtDto.setDescriptionName("説明者");
		importantPointExplainerExtDto.setOrganizationName1("所属組織名1");
		importantPointExplainerExtDto.setOrganizationName2("所属組織名2");
		testTarget.setImportantPointExplainer(importantPointExplainerExtDto);
		// 料金シュミレーション
		FeeSimulationHeadCreateExtDto feeSimulationHeadExtDto = new FeeSimulationHeadCreateExtDto();
		feeSimulationHeadExtDto.setCreatedDate("2019/05/31");
		feeSimulationHeadExtDto.setBasicListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPeruseLightListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceRj(BigDecimal.valueOf(100));
		testTarget.setFeeSimulationHead(feeSimulationHeadExtDto);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		testTarget = new ContractElectricCreateExtInputDto();
		testTarget.setContractElectric(new ContractElectricCreateExtDto());
		testTarget.setCustomerContract(new CustomerContractCreateExtDto());
		testTarget.setContractPersonMailAddressList(new ArrayList<MailAddressInformationCreateExtDto>());
		testTarget.setBillingMailAddressList(new ArrayList<BillingMailAddressInformationCreateExtDto>());
		testTarget.setContractPicSaEmp(new ContractPicSaEmpCreateExtDto());
		testTarget.setElectricExpertContract(new ElectricExpertContractCreateExtDto());
		testTarget.setContractAddedEditorEmpList(new ArrayList<ContractAddedEditorEmpCreateExtDto>());
		testTarget.setImportantPointExplainer(new ImportantPointExplainerCreateExtDto());
		testTarget.setElectricDealerContract(new ElectricDealerContractCreateExtDto());
		testTarget.setFeeSimulationHead(new FeeSimulationHeadCreateExtDto());
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(39, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		entity = contractElectricRepository.findOne(1L);
		// テストデータ作成
		testTarget = new ContractElectricCreateExtInputDto();
		testTarget.setCaseNumber(STR_256);
		testTarget.setCaseTitle(STR_256);
		testTarget.setClientCode(STR_256);
		testTarget.setChangePreferredDate(STR_256);

		// 契約(電力)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), contractElectricExtDto);
		BeanUtils.copyProperties(entity, contractElectricExtDto);
		contractElectricExtDto.setBasicMeterReadingDate("dd");
		contractElectricExtDto.setElectricCommercialFlowDiv("直売");
		contractElectricExtDto.setElectricCommercialFlowDivCode("1");
		contractElectricExtDto.setFixTransferDestinationCode("修正時振替先コード");
		contractElectricExtDto.setOppSysKeyBn(STR_256);
		contractElectricExtDto.setSimNumberMain(STR_256);
		contractElectricExtDto.setSimNumberSub(STR_256);
		contractElectricExtDto.setCustomerName(STR_256);
		contractElectricExtDto.setCustomerNameKana(STR_256);
		contractElectricExtDto.setItemCode(STR_256);
		contractElectricExtDto.setBildInfo(STR_256);
		contractElectricExtDto.setCity(STR_256);
		contractElectricExtDto.setAddress(STR_256);
		contractElectricExtDto.setBuildingName(STR_256);
		contractElectricExtDto.setPhoneNumber(STR_256);
		contractElectricExtDto.setContractHolderOld(STR_256);
		contractElectricExtDto.setDemandPlaceOld(STR_256);
		contractElectricExtDto.setCurrentElectricCompany(STR_256);
		contractElectricExtDto.setElectricCommercialFlowDiv(STR_256);
		contractElectricExtDto.setElectricCommercialFlowDivCode(STR_256);
		contractElectricExtDto.setPowerArea(STR_256);
		contractElectricExtDto.setPowerCompany(STR_256);
		contractElectricExtDto.setElectricCompanyCode(STR_256);
		contractElectricExtDto.setVoltageCategory(STR_256);
		contractElectricExtDto.setElectricMenu(STR_256);
		contractElectricExtDto.setElectricMenuCode(STR_256);
		contractElectricExtDto.setItemCode(STR_256);
		contractElectricExtDto.setChargeCycle(STR_256);
		contractElectricExtDto.setContractAmount(STR_256);
		contractElectricExtDto.setBasicMeterReadingDate(STR_256);
		contractElectricExtDto.setFixTransferDestinationCode(STR_256);
		contractElectricExtDto.setFeedPointNumber(STR_256);
		contractElectricExtDto.setDemandNameKr(STR_256);
		contractElectricExtDto.setLicensedEngineerName(STR_256);
		contractElectricExtDto.setLicensedEngineerTel(STR_256);
		contractElectricExtDto.setLicensedEngineerDep(STR_256);
		contractElectricExtDto.setEntryNumber(STR_256);
		contractElectricExtDto.setZipCode(STR_256);
		contractElectricExtDto.setCurrentContractNumber(STR_256);
		contractElectricExtDto.setEntryDate(STR_256);
		contractElectricExtDto.setCurrentElectricCompanyDiv(STR_256);
		contractElectricExtDto.setContractUnit(STR_256);
		contractElectricExtDto.setSupplyStartScheduledDate(STR_256);
		contractElectricExtDto.setContractPeriod(STR_256);
		testTarget.setContractElectric(contractElectricExtDto);
		// 顧客
		customerContractExtDto = new CustomerContractCreateExtDto();
		customerContractExtDto.setMomCustId(STR_256);
		customerContractExtDto.setCompanyId(STR_256);
		customerContractExtDto.setOfficeId(STR_256);
		customerContractExtDto.setPicName(STR_256);
		customerContractExtDto.setPicNameKana(STR_256);
		customerContractExtDto.setPicDeptName(STR_256);
		customerContractExtDto.setPicPhoneNumber(STR_256);
		customerContractExtDto.setPicFaxNumber(STR_256);
		customerContractExtDto.setPicMailAddress(STR_256);
		testTarget.setCustomerContract(customerContractExtDto);
		// メールアドレス情報
		mailAddressInformationExtDtoList = new ArrayList<MailAddressInformationCreateExtDto>();
		mailAddressInformationExtDto = new MailAddressInformationCreateExtDto();
		mailAddressInformationExtDto.setName(STR_256);
		mailAddressInformationExtDto.setMailAddress(STR_256);
		mailAddressInformationExtDtoList.add(mailAddressInformationExtDto);
		testTarget.setContractPersonMailAddressList(mailAddressInformationExtDtoList);
		// 請求先メールアドレス
		billingMailAddressInformationExtDtoList = new ArrayList<BillingMailAddressInformationCreateExtDto>();
		billingMailAddressInformationExtDto = new BillingMailAddressInformationCreateExtDto();
		billingMailAddressInformationExtDto.setName(STR_256);
		billingMailAddressInformationExtDto.setMailAddress(STR_256);
		billingMailAddressInformationExtDto.setMyricohId(STR_256);
		billingMailAddressInformationExtDtoList.add(billingMailAddressInformationExtDto);
		testTarget.setBillingMailAddressList(billingMailAddressInformationExtDtoList);
		// 契約担当SA社員
		contractPicSaEmpExtDto = new ContractPicSaEmpCreateExtDto();
		contractPicSaEmpExtDto.setMomEmployeeId(STR_256);
		testTarget.setContractPicSaEmp(contractPicSaEmpExtDto);
		// 電力専任情報
		electricExpertContractExtDto = new ElectricExpertContractCreateExtDto();
		electricExpertContractExtDto.setMomEmpId(STR_256);
		testTarget.setElectricExpertContract(electricExpertContractExtDto);
		// 追加編集者
		contractAddedEditorEmpExtDtoList = new ArrayList<ContractAddedEditorEmpCreateExtDto>();
		contractAddedEditorEmpExtDto = new ContractAddedEditorEmpCreateExtDto();
		contractAddedEditorEmpExtDto.setMomEmployeeId(STR_256);
		contractAddedEditorEmpExtDtoList.add(contractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(contractAddedEditorEmpExtDtoList);
		// 重要項目説明者
		importantPointExplainerExtDto = new ImportantPointExplainerCreateExtDto();
		importantPointExplainerExtDto.setDescriptionName(STR_256);
		importantPointExplainerExtDto.setOrganizationName1(STR_256);
		importantPointExplainerExtDto.setOrganizationName2(STR_256);
		testTarget.setImportantPointExplainer(importantPointExplainerExtDto);
		// 料金シュミレーション
		feeSimulationHeadExtDto.setCreatedDate(STR_256);
		feeSimulationHeadExtDto.setBasicListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPeruseLightListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceRj(BigDecimal.valueOf(100));
		testTarget.setFeeSimulationHead(feeSimulationHeadExtDto);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(64, result.getErrorInfoList().size());

		// 異常系(@Min, @Decimal)
		// テストデータ作成
		testTarget = new ContractElectricCreateExtInputDto();
		testTarget.setCaseNumber("案件番号");
		testTarget.setCaseTitle("案件名");
		testTarget.setClientCode("得意先コード");
		// 契約(電力)
		contractElectricExtDto = new ContractElectricCreateExtDto();
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), contractElectricExtDto);
		BeanUtils.copyProperties(entity, contractElectricExtDto);
		contractElectricExtDto.setBasicMeterReadingDate("dd");
		contractElectricExtDto.setElectricCommercialFlowDiv("直売");
		contractElectricExtDto.setElectricCommercialFlowDivCode("1");
		contractElectricExtDto.setFixTransferDestinationCode("修正時振替先コード");
		contractElectricExtDto.setVoltageCategory("1");
		contractElectricExtDto.setPowerArea(entity.getElectricArea().toString());
		contractElectricExtDto.setContractCapacityUsage(DECIMAL_MINUS_001);
		contractElectricExtDto.setContractElectricCurrent(DECIMAL_MINUS_001);
		contractElectricExtDto.setContractElectricPower(DECIMAL_MINUS_001);
		contractElectricExtDto.setLoadFactor(DECIMAL_MINUS_001);
		contractElectricExtDto.setTransferCheckFlg(INT_MINUS_1);
		contractElectricExtDto.setEntryDate("2019/05/31");
		contractElectricExtDto.setCurrentElectricCompanyDiv("1");
		contractElectricExtDto.setContractUnit("A");
		contractElectricExtDto.setSupplyStartScheduledDate("2019/05/31");
		testTarget.setContractElectric(contractElectricExtDto);
		// 顧客
		customerContractExtDto = new CustomerContractCreateExtDto();
		customerContractExtDto.setMomCustId("MoMkjbID");
		customerContractExtDto.setCompanyId("MoM企業ID");
		customerContractExtDto.setOfficeId("MoM事業所ID");
		customerContractExtDto.setPicName("担当者氏名");
		customerContractExtDto.setPicNameKana("担当者氏名(カナ)");
		customerContractExtDto.setPicDeptName("担当者部署");
		customerContractExtDto.setPicPhoneNumber("担当者電話番号");
		customerContractExtDto.setPicFaxNumber("担当者FAX番号");
		customerContractExtDto.setPicMailAddress("担当者メールアドレス");
		testTarget.setCustomerContract(customerContractExtDto);
		// メールアドレス情報
		mailAddressInformationExtDtoList = new ArrayList<MailAddressInformationCreateExtDto>();
		mailAddressInformationExtDto = new MailAddressInformationCreateExtDto();
		mailAddressInformationExtDto.setName("氏名");
		mailAddressInformationExtDto.setMailAddress("メールアドレス");
		mailAddressInformationExtDtoList.add(mailAddressInformationExtDto);
		testTarget.setContractPersonMailAddressList(mailAddressInformationExtDtoList);
		// 請求先メールアドレス
		billingMailAddressInformationExtDtoList = new ArrayList<BillingMailAddressInformationCreateExtDto>();
		billingMailAddressInformationExtDto = new BillingMailAddressInformationCreateExtDto();
		billingMailAddressInformationExtDto.setName("氏名");
		billingMailAddressInformationExtDto.setMailAddress("メールアドレス");
		billingMailAddressInformationExtDto.setMyricohId("MyRicohID");
		billingMailAddressInformationExtDtoList.add(billingMailAddressInformationExtDto);
		testTarget.setBillingMailAddressList(billingMailAddressInformationExtDtoList);
		// 契約担当SA社員
		contractPicSaEmpExtDto = new ContractPicSaEmpCreateExtDto();
		contractPicSaEmpExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setContractPicSaEmp(contractPicSaEmpExtDto);
		// 電力専任情報
		electricExpertContractExtDto = new ElectricExpertContractCreateExtDto();
		electricExpertContractExtDto.setMomEmpId("MoM社員ID");
		testTarget.setElectricExpertContract(electricExpertContractExtDto);
		// 追加編集者
		contractAddedEditorEmpExtDtoList = new ArrayList<ContractAddedEditorEmpCreateExtDto>();
		contractAddedEditorEmpExtDto = new ContractAddedEditorEmpCreateExtDto();
		contractAddedEditorEmpExtDto.setMomEmployeeId("MoM社員ID");
		contractAddedEditorEmpExtDtoList.add(contractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(contractAddedEditorEmpExtDtoList);
		// 重要項目説明者
		importantPointExplainerExtDto = new ImportantPointExplainerCreateExtDto();
		importantPointExplainerExtDto.setDescriptionName("説明者");
		importantPointExplainerExtDto.setOrganizationName1("所属組織名1");
		importantPointExplainerExtDto.setOrganizationName2("所属組織名2");
		testTarget.setImportantPointExplainer(importantPointExplainerExtDto);
		// 料金シュミレーション
		feeSimulationHeadExtDto.setCreatedDate("2019/05/31");
		feeSimulationHeadExtDto.setBasicListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setBasicSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setBasicBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setBasicBankPriceRj(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPeruseLightListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPerUseLightSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPerUseLightBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPerUseLightBankPriceRj(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceRj(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setFeeSimulationHead(feeSimulationHeadExtDto);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(21, result.getErrorInfoList().size());

		// 異常系(@Max)
		contractElectricExtDto.setTransferCheckFlg(INT_10);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(21, result.getErrorInfoList().size());

	}

	@Test
	public void ContractElectricChangePlanExtInputDtoのテスト() throws Exception {

		ContractElectric entity = contractElectricRepository.findOne(1L);

		// テストデータ作成
		ContractElectricChangePlanExtInputDto testTarget = new ContractElectricChangePlanExtInputDto();
		testTarget.setCaseNumber("案件番号");
		testTarget.setCaseTitle("案件名");
		testTarget.setClientCode("得意先コード");
		testTarget.setChangePreferredDate("2019/05/31");
		testTarget.setId(1L);
		// 契約(電力)
		ContractElectricChangePlanExtDto contractElectricExtDto = new ContractElectricChangePlanExtDto();
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), contractElectricExtDto);
		BeanUtils.copyProperties(entity, contractElectricExtDto);
		contractElectricExtDto.setBasicMeterReadingDate("dd");
		contractElectricExtDto.setElectricCommercialFlowDiv("直売");
		contractElectricExtDto.setElectricCommercialFlowDivCode("1");
		contractElectricExtDto.setFixTransferDestinationCode("修正時振替先コード");
		contractElectricExtDto.setVoltageCategory("1");
		contractElectricExtDto.setEntryDate("2019/05/31");
		contractElectricExtDto.setContractUnit("1");
		contractElectricExtDto.setSupplyStartScheduledDate("2019/05/31");
		contractElectricExtDto.setPowerArea(entity.getElectricArea().toString());
		testTarget.setContractElectric(contractElectricExtDto);
		// 顧客
		CustomerContractChangePlanExtDto customerContractExtDto = new CustomerContractChangePlanExtDto();
		customerContractExtDto.setMomCustId("MoMkjbID");
		customerContractExtDto.setCompanyId("MoM企業ID");
		customerContractExtDto.setOfficeId("MoM事業所ID");
		customerContractExtDto.setPicName("担当者氏名");
		customerContractExtDto.setPicNameKana("担当者氏名(カナ)");
		customerContractExtDto.setPicDeptName("担当者部署");
		customerContractExtDto.setPicPhoneNumber("担当者電話番号");
		customerContractExtDto.setPicFaxNumber("担当者FAX番号");
		customerContractExtDto.setPicMailAddress("担当者メールアドレス");
		testTarget.setCustomerContract(customerContractExtDto);
		// メールアドレス情報
		List<MailAddressInformationChangePlanExtDto> mailAddressInformationExtDtoList = new ArrayList<>();
		MailAddressInformationChangePlanExtDto mailAddressInformationExtDto = new MailAddressInformationChangePlanExtDto();
		mailAddressInformationExtDto.setName("氏名");
		mailAddressInformationExtDto.setMailAddress("メールアドレス");
		mailAddressInformationExtDtoList.add(mailAddressInformationExtDto);
		testTarget.setContractPersonMailAddressList(mailAddressInformationExtDtoList);
		// 請求先メールアドレス
		List<BillingMailAddressInformationChangePlanExtDto> billingMailAddressInformationExtDtoList = new ArrayList<>();
		BillingMailAddressInformationChangePlanExtDto billingMailAddressInformationExtDto = new BillingMailAddressInformationChangePlanExtDto();
		billingMailAddressInformationExtDto.setName("氏名");
		billingMailAddressInformationExtDto.setMailAddress("メールアドレス");
		billingMailAddressInformationExtDto.setMyricohId("MyRicohID");
		billingMailAddressInformationExtDtoList.add(billingMailAddressInformationExtDto);
		testTarget.setBillingMailAddressList(billingMailAddressInformationExtDtoList);
		// 契約担当SA社員
		ContractPicSaEmpChangePlanExtDto contractPicSaEmpExtDto = new ContractPicSaEmpChangePlanExtDto();
		contractPicSaEmpExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setContractPicSaEmp(contractPicSaEmpExtDto);
		// 電力専任情報
		ElectricExpertContractChangePlanExtDto electricExpertContractExtDto = new ElectricExpertContractChangePlanExtDto();
		electricExpertContractExtDto.setMomEmpId("MoM社員ID");
		testTarget.setElectricExpertContract(electricExpertContractExtDto);
		// 追加編集者
		List<ContractAddedEditorEmpChangePlanExtDto> contractAddedEditorEmpExtDtoList = new ArrayList<>();
		ContractAddedEditorEmpChangePlanExtDto contractAddedEditorEmpExtDto = new ContractAddedEditorEmpChangePlanExtDto();
		contractAddedEditorEmpExtDto.setMomEmployeeId("MoM社員ID");
		contractAddedEditorEmpExtDtoList.add(contractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(contractAddedEditorEmpExtDtoList);
		// 重要項目説明者
		ImportantPointExplainerChangePlanExtDto importantPointExplainerExtDto = new ImportantPointExplainerChangePlanExtDto();
		importantPointExplainerExtDto.setDescriptionName("説明者");
		importantPointExplainerExtDto.setOrganizationName1("所属組織名1");
		importantPointExplainerExtDto.setOrganizationName2("所属組織名2");
		testTarget.setImportantPointExplainer(importantPointExplainerExtDto);
		// 料金シュミレーション
		FeeSimulationHeadChangePlanExtDto feeSimulationHeadExtDto = new FeeSimulationHeadChangePlanExtDto();
		feeSimulationHeadExtDto.setCreatedDate("2019/05/31");
		feeSimulationHeadExtDto.setBasicListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPeruseLightListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceRj(BigDecimal.valueOf(100));
		testTarget.setFeeSimulationHead(feeSimulationHeadExtDto);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		testTarget = new ContractElectricChangePlanExtInputDto();
		testTarget.setContractElectric(new ContractElectricChangePlanExtDto());
		testTarget.setCustomerContract(new CustomerContractChangePlanExtDto());
		testTarget.setContractPersonMailAddressList(new ArrayList<MailAddressInformationChangePlanExtDto>());
		testTarget.setBillingMailAddressList(new ArrayList<BillingMailAddressInformationChangePlanExtDto>());
		testTarget.setContractPicSaEmp(new ContractPicSaEmpChangePlanExtDto());
		testTarget.setElectricExpertContract(new ElectricExpertContractChangePlanExtDto());
		testTarget.setContractAddedEditorEmpList(new ArrayList<ContractAddedEditorEmpChangePlanExtDto>());
		testTarget.setImportantPointExplainer(new ImportantPointExplainerChangePlanExtDto());
		testTarget.setElectricDealerContract(new ElectricDealerContractChangePlanExtDto());
		testTarget.setFeeSimulationHead(new FeeSimulationHeadChangePlanExtDto());
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(39, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		entity = contractElectricRepository.findOne(1L);
		// テストデータ作成
		testTarget = new ContractElectricChangePlanExtInputDto();
		testTarget.setCaseNumber(STR_256);
		testTarget.setCaseTitle(STR_256);
		testTarget.setClientCode(STR_256);
		testTarget.setChangePreferredDate(STR_256);
		testTarget.setId(1L);
		// 契約(電力)
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), contractElectricExtDto);
		BeanUtils.copyProperties(entity, contractElectricExtDto);
		contractElectricExtDto.setBasicMeterReadingDate("dd");
		contractElectricExtDto.setElectricCommercialFlowDiv("直売");
		contractElectricExtDto.setElectricCommercialFlowDivCode("1");
		contractElectricExtDto.setFixTransferDestinationCode("修正時振替先コード");
		contractElectricExtDto.setOppSysKeyBn(STR_256);
		contractElectricExtDto.setSimNumberMain(STR_256);
		contractElectricExtDto.setSimNumberSub(STR_256);
		contractElectricExtDto.setCustomerName(STR_256);
		contractElectricExtDto.setCustomerNameKana(STR_256);
		contractElectricExtDto.setItemCode(STR_256);
		contractElectricExtDto.setBildInfo(STR_256);
		contractElectricExtDto.setCity(STR_256);
		contractElectricExtDto.setAddress(STR_256);
		contractElectricExtDto.setBuildingName(STR_256);
		contractElectricExtDto.setPhoneNumber(STR_256);
		contractElectricExtDto.setContractHolderOld(STR_256);
		contractElectricExtDto.setDemandPlaceOld(STR_256);
		contractElectricExtDto.setCurrentElectricCompany(STR_256);
		contractElectricExtDto.setElectricCommercialFlowDiv(STR_256);
		contractElectricExtDto.setElectricCommercialFlowDivCode(STR_256);
		contractElectricExtDto.setPowerArea(STR_256);
		contractElectricExtDto.setPowerCompany(STR_256);
		contractElectricExtDto.setElectricCompanyCode(STR_256);
		contractElectricExtDto.setVoltageCategory(STR_256);
		contractElectricExtDto.setElectricMenu(STR_256);
		contractElectricExtDto.setElectricMenuCode(STR_256);
		contractElectricExtDto.setItemCode(STR_256);
		contractElectricExtDto.setChargeCycle(STR_256);
		contractElectricExtDto.setContractAmount(STR_256);
		contractElectricExtDto.setBasicMeterReadingDate(STR_256);
		contractElectricExtDto.setFixTransferDestinationCode(STR_256);
		contractElectricExtDto.setFeedPointNumber(STR_256);
		contractElectricExtDto.setDemandNameKr(STR_256);
		contractElectricExtDto.setLicensedEngineerName(STR_256);
		contractElectricExtDto.setLicensedEngineerTel(STR_256);
		contractElectricExtDto.setLicensedEngineerDep(STR_256);
		contractElectricExtDto.setEntryNumber(STR_256);
		contractElectricExtDto.setZipCode(STR_256);
		contractElectricExtDto.setCurrentContractNumber(STR_256);
		contractElectricExtDto.setEntryDate(STR_256);
		contractElectricExtDto.setSupplyStartScheduledDate(STR_256);
		testTarget.setContractElectric(contractElectricExtDto);
		// 顧客
		customerContractExtDto = new CustomerContractChangePlanExtDto();
		customerContractExtDto.setMomCustId(STR_256);
		customerContractExtDto.setCompanyId(STR_256);
		customerContractExtDto.setOfficeId(STR_256);
		customerContractExtDto.setPicName(STR_256);
		customerContractExtDto.setPicNameKana(STR_256);
		customerContractExtDto.setPicDeptName(STR_256);
		customerContractExtDto.setPicPhoneNumber(STR_256);
		customerContractExtDto.setPicFaxNumber(STR_256);
		customerContractExtDto.setPicMailAddress(STR_256);
		testTarget.setCustomerContract(customerContractExtDto);
		// メールアドレス情報
		mailAddressInformationExtDtoList = new ArrayList<MailAddressInformationChangePlanExtDto>();
		mailAddressInformationExtDto = new MailAddressInformationChangePlanExtDto();
		mailAddressInformationExtDto.setName(STR_256);
		mailAddressInformationExtDto.setMailAddress(STR_256);
		mailAddressInformationExtDtoList.add(mailAddressInformationExtDto);
		testTarget.setContractPersonMailAddressList(mailAddressInformationExtDtoList);
		// 請求先メールアドレス
		billingMailAddressInformationExtDtoList = new ArrayList<BillingMailAddressInformationChangePlanExtDto>();
		billingMailAddressInformationExtDto = new BillingMailAddressInformationChangePlanExtDto();
		billingMailAddressInformationExtDto.setName(STR_256);
		billingMailAddressInformationExtDto.setMailAddress(STR_256);
		billingMailAddressInformationExtDto.setMyricohId(STR_256);
		billingMailAddressInformationExtDtoList.add(billingMailAddressInformationExtDto);
		testTarget.setBillingMailAddressList(billingMailAddressInformationExtDtoList);
		// 契約担当SA社員
		contractPicSaEmpExtDto = new ContractPicSaEmpChangePlanExtDto();
		contractPicSaEmpExtDto.setMomEmployeeId(STR_256);
		testTarget.setContractPicSaEmp(contractPicSaEmpExtDto);
		// 電力専任情報
		electricExpertContractExtDto = new ElectricExpertContractChangePlanExtDto();
		electricExpertContractExtDto.setMomEmpId(STR_256);
		testTarget.setElectricExpertContract(electricExpertContractExtDto);
		// 追加編集者
		contractAddedEditorEmpExtDtoList = new ArrayList<ContractAddedEditorEmpChangePlanExtDto>();
		contractAddedEditorEmpExtDto = new ContractAddedEditorEmpChangePlanExtDto();
		contractAddedEditorEmpExtDto.setMomEmployeeId(STR_256);
		contractAddedEditorEmpExtDtoList.add(contractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(contractAddedEditorEmpExtDtoList);
		// 重要項目説明者
		importantPointExplainerExtDto = new ImportantPointExplainerChangePlanExtDto();
		importantPointExplainerExtDto.setDescriptionName(STR_256);
		importantPointExplainerExtDto.setOrganizationName1(STR_256);
		importantPointExplainerExtDto.setOrganizationName2(STR_256);
		testTarget.setImportantPointExplainer(importantPointExplainerExtDto);
		// 料金シュミレーション
		feeSimulationHeadExtDto.setCreatedDate(STR_256);
		feeSimulationHeadExtDto.setBasicListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setBasicBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPeruseLightListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setPerUseLightBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceRj(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonListPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonSellingPrice(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceBusiness(BigDecimal.valueOf(100));
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceRj(BigDecimal.valueOf(100));
		testTarget.setFeeSimulationHead(feeSimulationHeadExtDto);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(61, result.getErrorInfoList().size());

		// 異常系(@Min, @Decimal)
		// テストデータ作成
		testTarget = new ContractElectricChangePlanExtInputDto();
		testTarget.setCaseNumber("案件番号");
		testTarget.setCaseTitle("案件名");
		testTarget.setClientCode("得意先コード");
		testTarget.setId(1L);
		// 契約(電力)
		contractElectricExtDto = new ContractElectricChangePlanExtDto();
		BeanUtils.copyProperties(entity.getEntryContentLowPressure(), contractElectricExtDto);
		BeanUtils.copyProperties(entity, contractElectricExtDto);
		contractElectricExtDto.setBasicMeterReadingDate("dd");
		contractElectricExtDto.setElectricCommercialFlowDiv("直売");
		contractElectricExtDto.setElectricCommercialFlowDivCode("1");
		contractElectricExtDto.setFixTransferDestinationCode("修正時振替先コード");
		contractElectricExtDto.setVoltageCategory("1");
		contractElectricExtDto.setPowerArea(entity.getElectricArea().toString());
		contractElectricExtDto.setContractCapacityUsage(DECIMAL_MINUS_001);
		contractElectricExtDto.setContractElectricCurrent(DECIMAL_MINUS_001);
		contractElectricExtDto.setContractElectricPower(DECIMAL_MINUS_001);
		contractElectricExtDto.setLoadFactor(DECIMAL_MINUS_001);
		contractElectricExtDto.setTransferCheckFlg(INT_MINUS_1);
		contractElectricExtDto.setEntryDate("2019/05/31");
		contractElectricExtDto.setContractUnit("1");
		contractElectricExtDto.setSupplyStartScheduledDate("2019/05/31");
		testTarget.setContractElectric(contractElectricExtDto);
		// 顧客
		customerContractExtDto = new CustomerContractChangePlanExtDto();
		customerContractExtDto.setMomCustId("MoMkjbID");
		customerContractExtDto.setCompanyId("MoM企業ID");
		customerContractExtDto.setOfficeId("MoM事業所ID");
		customerContractExtDto.setPicName("担当者氏名");
		customerContractExtDto.setPicNameKana("担当者氏名(カナ)");
		customerContractExtDto.setPicDeptName("担当者部署");
		customerContractExtDto.setPicPhoneNumber("担当者電話番号");
		customerContractExtDto.setPicFaxNumber("担当者FAX番号");
		customerContractExtDto.setPicMailAddress("担当者メールアドレス");
		testTarget.setCustomerContract(customerContractExtDto);
		// メールアドレス情報
		mailAddressInformationExtDtoList = new ArrayList<MailAddressInformationChangePlanExtDto>();
		mailAddressInformationExtDto = new MailAddressInformationChangePlanExtDto();
		mailAddressInformationExtDto.setName("氏名");
		mailAddressInformationExtDto.setMailAddress("メールアドレス");
		mailAddressInformationExtDtoList.add(mailAddressInformationExtDto);
		testTarget.setContractPersonMailAddressList(mailAddressInformationExtDtoList);
		// 請求先メールアドレス
		billingMailAddressInformationExtDtoList = new ArrayList<BillingMailAddressInformationChangePlanExtDto>();
		billingMailAddressInformationExtDto = new BillingMailAddressInformationChangePlanExtDto();
		billingMailAddressInformationExtDto.setName("氏名");
		billingMailAddressInformationExtDto.setMailAddress("メールアドレス");
		billingMailAddressInformationExtDto.setMyricohId("MyRicohID");
		billingMailAddressInformationExtDtoList.add(billingMailAddressInformationExtDto);
		testTarget.setBillingMailAddressList(billingMailAddressInformationExtDtoList);
		// 契約担当SA社員
		contractPicSaEmpExtDto = new ContractPicSaEmpChangePlanExtDto();
		contractPicSaEmpExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setContractPicSaEmp(contractPicSaEmpExtDto);
		// 電力専任情報
		electricExpertContractExtDto = new ElectricExpertContractChangePlanExtDto();
		electricExpertContractExtDto.setMomEmpId("MoM社員ID");
		testTarget.setElectricExpertContract(electricExpertContractExtDto);
		// 追加編集者
		contractAddedEditorEmpExtDtoList = new ArrayList<ContractAddedEditorEmpChangePlanExtDto>();
		contractAddedEditorEmpExtDto = new ContractAddedEditorEmpChangePlanExtDto();
		contractAddedEditorEmpExtDto.setMomEmployeeId("MoM社員ID");
		contractAddedEditorEmpExtDtoList.add(contractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(contractAddedEditorEmpExtDtoList);
		// 重要項目説明者
		importantPointExplainerExtDto = new ImportantPointExplainerChangePlanExtDto();
		importantPointExplainerExtDto.setDescriptionName("説明者");
		importantPointExplainerExtDto.setOrganizationName1("所属組織名1");
		importantPointExplainerExtDto.setOrganizationName2("所属組織名2");
		testTarget.setImportantPointExplainer(importantPointExplainerExtDto);
		// 料金シュミレーション
		feeSimulationHeadExtDto.setCreatedDate("2019/05/31");
		feeSimulationHeadExtDto.setBasicListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setBasicSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setBasicBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setBasicBankPriceRj(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPeruseLightListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPerUseLightSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPerUseLightBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setPerUseLightBankPriceRj(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeSummerBankPriceRj(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonListPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonSellingPrice(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceBusiness(DECIMAL_MINUS_001);
		feeSimulationHeadExtDto.setUsageFeeOtherSeasonBankPriceRj(DECIMAL_MINUS_001);
		testTarget.setFeeSimulationHead(feeSimulationHeadExtDto);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(21, result.getErrorInfoList().size());

		// 異常系(@Max)
		contractElectricExtDto.setTransferCheckFlg(INT_10);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(21, result.getErrorInfoList().size());
	}

	@Test
	public void ContractInfoChangeExtDtoのテスト_正常系() throws Exception {

		ContractInfoChangeExtDto contractInfoChangeExtDto = new ContractInfoChangeExtDto();
		contractInfoChangeExtDto.setId(1L);
		contractInfoChangeExtDto.setChangePreferredDate("2011/04/01");

		ContractElectricInfoChangeExtDto contractElectricInfoChangeExtDto = new ContractElectricInfoChangeExtDto();
		contractElectricInfoChangeExtDto.setEntryDate("2011/04/01");

		contractInfoChangeExtDto.setContractElectric(contractElectricInfoChangeExtDto);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(contractInfoChangeExtDto, headersProperties, localServerPort);
		testTool.assertValidationOk(result);
	}

	@Test
	public void ContractInfoChangeExtDtoのテスト_異常系_NOTNULL() throws Exception {

		ContractInfoChangeExtDto contractInfoChangeExtDto = new ContractInfoChangeExtDto();
		contractInfoChangeExtDto.setId(1L);
		contractInfoChangeExtDto.setChangePreferredDate(null);
		contractInfoChangeExtDto.setContractElectric(null);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(contractInfoChangeExtDto, headersProperties, localServerPort);
		testTool.assertValidationNg(result);
	}

	@Test
	public void ContractInfoChangeExtDtoのテスト_異常系_SIZE_MIN() throws Exception {

		ContractInfoChangeExtDto contractInfoChangeExtDto = new ContractInfoChangeExtDto();
		contractInfoChangeExtDto.setId(1L);
		contractInfoChangeExtDto.setChangePreferredDate(STR_256);

		ContractElectricInfoChangeExtDto contractElectricInfoChangeExtDto = new ContractElectricInfoChangeExtDto();
		contractElectricInfoChangeExtDto.setEntryDate(STR_256);

		contractInfoChangeExtDto.setContractElectric(contractElectricInfoChangeExtDto);

		ParamterCheckResult result = testCheckController.callParameterCheck(contractInfoChangeExtDto, headersProperties, localServerPort);
		testTool.assertValidationNg(result);
	}

	@Test
	public void RegisterArrangementResultExtDtoのテスト() throws Exception {

		// テストデータ作成
		ContractElectric contractElectric = contractElectricRepository.findOne(1L);
		RegisterArrangementResultExtDto testTarget = new RegisterArrangementResultExtDto();
		testTarget.setContractId(1L);
		testTarget.setCaseNumber("案件番号");
		testTarget.setCaseTitle("案件名");
		testTarget.setChangePreferredDate("2019/05/31");

		RegisterArrangementResultContractElectricExtDto registerArrangementResultContractElectricExtDto = new RegisterArrangementResultContractElectricExtDto();
		BeanUtils.copyProperties(contractElectric, registerArrangementResultContractElectricExtDto);
		BeanUtils.copyProperties(contractElectric.getEntryContentLowPressure(), registerArrangementResultContractElectricExtDto);
		registerArrangementResultContractElectricExtDto.setSupplyStartScheduledDate("2019/05/31");
		testTarget.setContractElectric(registerArrangementResultContractElectricExtDto);

		RegisterArrangementResultCustomerContractExtDto registerArrangementResultCustomerContractExtDto = new RegisterArrangementResultCustomerContractExtDto();
		registerArrangementResultCustomerContractExtDto.setMomCustId("MoM企事部ID");
		registerArrangementResultCustomerContractExtDto.setCompanyId("MoM企業ID");
		registerArrangementResultCustomerContractExtDto.setOfficeId("MoM事業所ID");
		registerArrangementResultCustomerContractExtDto.setPicName("MoM非連携_担当者氏名");
		registerArrangementResultCustomerContractExtDto.setPicNameKana("MoM非連携_担当者氏名（カナ）");
		registerArrangementResultCustomerContractExtDto.setPicDeptName("MoM非連携_担当者部署");
		registerArrangementResultCustomerContractExtDto.setPicPhoneNumber("MoM非連携_担当者電話番号");
		registerArrangementResultCustomerContractExtDto.setPicMailAddress("MoM非連携_担当者メールアドレス");
		testTarget.setCustomerContract(registerArrangementResultCustomerContractExtDto);

		List<RegisterArrangementResultMailAddressInfoExtDto> registerArrangementResultMailAddressInfoExtDtoList = new ArrayList<RegisterArrangementResultMailAddressInfoExtDto>();
		RegisterArrangementResultMailAddressInfoExtDto registerArrangementResultMailAddressInfoExtDto = new RegisterArrangementResultMailAddressInfoExtDto();
		registerArrangementResultMailAddressInfoExtDto.setName("氏名");
		registerArrangementResultMailAddressInfoExtDto.setMailAddress("メールアドレス");
		registerArrangementResultMailAddressInfoExtDtoList.add(registerArrangementResultMailAddressInfoExtDto);
		testTarget.setContractPersonMailAddressList(registerArrangementResultMailAddressInfoExtDtoList);

		List<RegisterArrangementResultBillingMailAddressInfoExtDto> registerArrangementResultBillingMailAddressInfoExtDtoList = new ArrayList<RegisterArrangementResultBillingMailAddressInfoExtDto>();
		RegisterArrangementResultBillingMailAddressInfoExtDto registerArrangementResultBillingMailAddressInfoExtDto = new RegisterArrangementResultBillingMailAddressInfoExtDto();
		registerArrangementResultBillingMailAddressInfoExtDto.setName("氏名");
		registerArrangementResultBillingMailAddressInfoExtDto.setMailAddress("メールアドレス");
		registerArrangementResultBillingMailAddressInfoExtDto.setMyricohId("MｙRicohユーザID");
		registerArrangementResultBillingMailAddressInfoExtDtoList.add(registerArrangementResultBillingMailAddressInfoExtDto);
		testTarget.setBillingMailAddressList(registerArrangementResultBillingMailAddressInfoExtDtoList);

		RegisterArrangementResultContractPicSaEmpExtDto registerArrangementResultContractPicSaEmpExtDto = new RegisterArrangementResultContractPicSaEmpExtDto();
		registerArrangementResultContractPicSaEmpExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setContractPicSaEmp(registerArrangementResultContractPicSaEmpExtDto);

		RegisterArrangementResultElectricExpertContractExtDto registerArrangementResultElectricExpertContractExtDto = new RegisterArrangementResultElectricExpertContractExtDto();
		registerArrangementResultElectricExpertContractExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setElectricExpertContract(registerArrangementResultElectricExpertContractExtDto);

		List<RegisterArrangementResultContractAddedEditorEmpExtDto> registerArrangementResultContractAddedEditorEmpExtDtoList = new ArrayList<RegisterArrangementResultContractAddedEditorEmpExtDto>();
		RegisterArrangementResultContractAddedEditorEmpExtDto registerArrangementResultContractAddedEditorEmpExtDto = new RegisterArrangementResultContractAddedEditorEmpExtDto();
		registerArrangementResultContractAddedEditorEmpExtDto.setMomEmployeeId("MoM社員ID");
		registerArrangementResultContractAddedEditorEmpExtDtoList.add(registerArrangementResultContractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(registerArrangementResultContractAddedEditorEmpExtDtoList);

		RegisterArrangementResultElectricDealerContractExtDto registerArrangementResultElectricDealerContractExtDto = new RegisterArrangementResultElectricDealerContractExtDto();
		registerArrangementResultElectricDealerContractExtDto.setCompanyId("企業ID");
		registerArrangementResultElectricDealerContractExtDto.setCompanyBusinessName("企業_事業所名");
		testTarget.setElectricDealerContract(registerArrangementResultElectricDealerContractExtDto);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		contractElectric = contractElectricRepository.findOne(1L);
		BeanUtils.copyProperties(contractElectric, registerArrangementResultContractElectricExtDto);
		BeanUtils.copyProperties(contractElectric.getEntryContentLowPressure(), registerArrangementResultContractElectricExtDto);
		testTarget.setCaseNumber(null);
		testTarget.setCaseTitle(null);
		testTarget.setContractElectric(null);
		testTarget.setCustomerContract(null);
		testTarget.setContractPicSaEmp(null);
		testTarget.setElectricExpertContract(null);

		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(6, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		contractElectric = contractElectricRepository.findOne(1L);
		BeanUtils.copyProperties(contractElectric, registerArrangementResultContractElectricExtDto);
		BeanUtils.copyProperties(contractElectric.getEntryContentLowPressure(), registerArrangementResultContractElectricExtDto);
		testTarget.setCaseNumber(STR_256);
		testTarget.setCaseTitle(STR_256);
		testTarget.setChangePreferredDate(STR_256);

		registerArrangementResultContractElectricExtDto.setOppSysKeyBn(STR_256);
		registerArrangementResultContractElectricExtDto.setNishikiContractNumber(STR_256);
		registerArrangementResultContractElectricExtDto.setCstmrBn(STR_256);
		registerArrangementResultContractElectricExtDto.setCustomerName(STR_256);
		registerArrangementResultContractElectricExtDto.setCustomerNameKana(STR_256);
		registerArrangementResultContractElectricExtDto.setZipCode(STR_256);
		registerArrangementResultContractElectricExtDto.setBildInfo(STR_256);
		registerArrangementResultContractElectricExtDto.setCity(STR_256);
		registerArrangementResultContractElectricExtDto.setAddress(STR_256);
		registerArrangementResultContractElectricExtDto.setBuildingName(STR_256);
		registerArrangementResultContractElectricExtDto.setPhoneNumber(STR_256);
		registerArrangementResultContractElectricExtDto.setEntryDate(STR_256);
		registerArrangementResultContractElectricExtDto.setSupplyStartScheduledDate(STR_256);
		registerArrangementResultContractElectricExtDto.setLicensedEngineerName(STR_256);
		registerArrangementResultContractElectricExtDto.setLicensedEngineerTel(STR_256);
		registerArrangementResultContractElectricExtDto.setLicensedEngineerDep(STR_256);
		testTarget.setContractElectric(registerArrangementResultContractElectricExtDto);

		registerArrangementResultCustomerContractExtDto.setMomCustId(STR_256);
		registerArrangementResultCustomerContractExtDto.setCompanyId(STR_256);
		registerArrangementResultCustomerContractExtDto.setOfficeId(STR_256);
		registerArrangementResultCustomerContractExtDto.setPicName(STR_256);
		registerArrangementResultCustomerContractExtDto.setPicNameKana(STR_256);
		registerArrangementResultCustomerContractExtDto.setPicDeptName(STR_256);
		registerArrangementResultCustomerContractExtDto.setPicPhoneNumber(STR_256);
		registerArrangementResultCustomerContractExtDto.setPicMailAddress(STR_256);
		testTarget.setCustomerContract(registerArrangementResultCustomerContractExtDto);

		registerArrangementResultMailAddressInfoExtDto.setName(STR_256);
		registerArrangementResultMailAddressInfoExtDto.setMailAddress(STR_256);
		registerArrangementResultMailAddressInfoExtDtoList.add(registerArrangementResultMailAddressInfoExtDto);
		testTarget.setContractPersonMailAddressList(registerArrangementResultMailAddressInfoExtDtoList);

		registerArrangementResultBillingMailAddressInfoExtDto.setName(STR_256);
		registerArrangementResultBillingMailAddressInfoExtDto.setMailAddress(STR_256);
		registerArrangementResultBillingMailAddressInfoExtDto.setMyricohId(STR_256);
		registerArrangementResultBillingMailAddressInfoExtDtoList.add(registerArrangementResultBillingMailAddressInfoExtDto);
		testTarget.setBillingMailAddressList(registerArrangementResultBillingMailAddressInfoExtDtoList);

		registerArrangementResultContractPicSaEmpExtDto.setMomEmployeeId(STR_256);
		testTarget.setContractPicSaEmp(registerArrangementResultContractPicSaEmpExtDto);

		registerArrangementResultElectricExpertContractExtDto.setMomEmployeeId(STR_256);
		testTarget.setElectricExpertContract(registerArrangementResultElectricExpertContractExtDto);

		registerArrangementResultContractAddedEditorEmpExtDto.setMomEmployeeId(STR_256);
		registerArrangementResultContractAddedEditorEmpExtDtoList.add(registerArrangementResultContractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(registerArrangementResultContractAddedEditorEmpExtDtoList);

		registerArrangementResultElectricDealerContractExtDto.setCompanyId(STR_256);
		registerArrangementResultElectricDealerContractExtDto.setCompanyBusinessName(STR_256);
		testTarget.setElectricDealerContract(registerArrangementResultElectricDealerContractExtDto);

		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(43, result.getErrorInfoList().size());

		// 異常系(@Min, @Decimal)
		contractElectric = contractElectricRepository.findOne(1L);
		BeanUtils.copyProperties(contractElectric, registerArrangementResultContractElectricExtDto);
		BeanUtils.copyProperties(contractElectric.getEntryContentLowPressure(), registerArrangementResultContractElectricExtDto);

		testTarget.setContractId(LONG_MINUS_1);
		testTarget.setCaseNumber("案件番号");
		testTarget.setCaseTitle("案件名");
		testTarget.setChangePreferredDate("2019/05/31");
		registerArrangementResultContractElectricExtDto.setContractCapacityUsage(DECIMAL_MINUS_001);
		registerArrangementResultContractElectricExtDto.setContractElectricCurrent(DECIMAL_MINUS_001);
		registerArrangementResultContractElectricExtDto.setContractElectricPower(DECIMAL_MINUS_001);
		registerArrangementResultContractElectricExtDto.setEntryDate("2019/05/31");
		registerArrangementResultContractElectricExtDto.setSupplyStartScheduledDate("2019/05/31");
		testTarget.setContractElectric(registerArrangementResultContractElectricExtDto);

		registerArrangementResultCustomerContractExtDto.setMomCustId("MoM企事部ID");
		registerArrangementResultCustomerContractExtDto.setCompanyId("MoM企業ID");
		registerArrangementResultCustomerContractExtDto.setOfficeId("MoM事業所ID");
		registerArrangementResultCustomerContractExtDto.setPicName("MoM非連携_担当者氏名");
		registerArrangementResultCustomerContractExtDto.setPicNameKana("MoM非連携_担当者氏名（カナ）");
		registerArrangementResultCustomerContractExtDto.setPicDeptName("MoM非連携_担当者部署");
		registerArrangementResultCustomerContractExtDto.setPicPhoneNumber("MoM非連携_担当者電話番号");
		registerArrangementResultCustomerContractExtDto.setPicMailAddress("MoM非連携_担当者メールアドレス");
		testTarget.setCustomerContract(registerArrangementResultCustomerContractExtDto);

		registerArrangementResultMailAddressInfoExtDto.setName("氏名");
		registerArrangementResultMailAddressInfoExtDto.setMailAddress("メールアドレス");
		registerArrangementResultMailAddressInfoExtDtoList.add(registerArrangementResultMailAddressInfoExtDto);
		testTarget.setContractPersonMailAddressList(registerArrangementResultMailAddressInfoExtDtoList);

		registerArrangementResultBillingMailAddressInfoExtDto.setName("氏名");
		registerArrangementResultBillingMailAddressInfoExtDto.setMailAddress("メールアドレス");
		registerArrangementResultBillingMailAddressInfoExtDto.setMyricohId("MｙRicohユーザID");
		registerArrangementResultBillingMailAddressInfoExtDtoList.add(registerArrangementResultBillingMailAddressInfoExtDto);
		testTarget.setBillingMailAddressList(registerArrangementResultBillingMailAddressInfoExtDtoList);

		registerArrangementResultContractPicSaEmpExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setContractPicSaEmp(registerArrangementResultContractPicSaEmpExtDto);

		registerArrangementResultElectricExpertContractExtDto.setMomEmployeeId("MoM社員ID");
		testTarget.setElectricExpertContract(registerArrangementResultElectricExpertContractExtDto);

		registerArrangementResultContractAddedEditorEmpExtDto.setMomEmployeeId("MoM社員ID");
		registerArrangementResultContractAddedEditorEmpExtDtoList.add(registerArrangementResultContractAddedEditorEmpExtDto);
		testTarget.setContractAddedEditorEmpList(registerArrangementResultContractAddedEditorEmpExtDtoList);

		registerArrangementResultElectricDealerContractExtDto.setCompanyId("企業ID");
		registerArrangementResultElectricDealerContractExtDto.setCompanyBusinessName("企業_事業所名");
		testTarget.setElectricDealerContract(registerArrangementResultElectricDealerContractExtDto);

		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(4, result.getErrorInfoList().size());

	}

	@Test
	public void AgencyContractInformationのテスト() throws Exception {

		// 異常系(@Size(max))
		AgencyContractInformationDto testTarget = new AgencyContractInformationDto();
		testTarget.setAgencyName(STR_256);
		testTarget.setSupplierCode(STR_256);
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@DecimalMin)
		testTarget = new AgencyContractInformationDto();
		testTarget.setFeeRate(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
	}

	@Test
	public void BillingHistoryのテスト() throws Exception {

		//データ作成
		BillingHistoryDto testTarget = new BillingHistoryDto();
		testTarget.setDisplaySequenceNumber(1L);
		testTarget.setClaimNumber("claimNo");
		testTarget.setBillingYearMonth("201911");
		testTarget.setSalesDate("20191106");
		testTarget.setFeeAppropriationDay(new Date());
		testTarget.setClaimAmountInTax(new BigDecimal(0));
		testTarget.setClaimTax(new BigDecimal(0));
		testTarget.setClaimAmountOutTax(new BigDecimal(0));
		testTarget.setDebitScheduleDay("20191106");
		testTarget.setAccruedSection(AccruedSection.未回収);
		testTarget.setAccruedReason("事由");
		testTarget.setAccuredJudgeDay(new Date());
		testTarget.setAccruedFlg(1);
		testTarget.setAccruedCollectionDate(new Date());
		testTarget.setSendInvoiceDiv(SendInvoiceDiv.メール);
		testTarget.setInvoiceOutputFlg(1);
		testTarget.setBeforeDebitContact(BeforeDebitContact.未送信);
		testTarget.setSendMyRicoh(SendMyRicoh.未送信);
		testTarget.setElectricSupplyYmdStart(new Date());
		testTarget.setElectricSupplyYmdEnd(new Date());
		testTarget.setInvoiceCreateDiv(InvoiceCreateDiv.作成済);
		testTarget.setSendMail(SendMail.未送信);
		testTarget.setInvoiceForm(InvoiceForm.単一);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		testTarget.setBillingYearMonth(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());
		testTarget.setBillingYearMonth("201911");

		// 異常系(@Max)
		testTarget.setDisplaySequenceNumber(100000L);
		testTarget.setAccruedFlg(99);
		testTarget.setInvoiceOutputFlg(99);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());
		testTarget.setDisplaySequenceNumber(1L);
		testTarget.setAccruedFlg(1);
		testTarget.setInvoiceOutputFlg(1);

		// 異常系(@Min)
		testTarget.setAccruedFlg(INT_MINUS_1);
		testTarget.setInvoiceOutputFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		testTarget.setAccruedFlg(1);
		testTarget.setInvoiceOutputFlg(1);

		// 異常系(@Size)
		testTarget.setClaimNumber(STR_256);
		testTarget.setBillingYearMonth(STR_256);
		testTarget.setSalesDate(STR_256);
		testTarget.setDebitScheduleDay(STR_256);
		testTarget.setAccruedReason(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(5, result.getErrorInfoList().size());
		testTarget.setClaimNumber("test");
		testTarget.setBillingYearMonth("test");
		testTarget.setSalesDate("test");
		testTarget.setDebitScheduleDay("test");
		testTarget.setAccruedReason("test");

		// 異常系(@DecimalMin)
		testTarget.setClaimAmountInTax(DECIMAL_MINUS_001);
		testTarget.setClaimTax(DECIMAL_MINUS_001);
		testTarget.setClaimAmountOutTax(DECIMAL_MINUS_001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());
		testTarget.setClaimAmountInTax(new BigDecimal(0));
		testTarget.setClaimTax(new BigDecimal(0));
		testTarget.setClaimAmountOutTax(new BigDecimal(0));

		// 異常系(@Digits)
		testTarget.setClaimAmountInTax(DECIMAL_0001);
		testTarget.setClaimTax(DECIMAL_0001);
		testTarget.setClaimAmountOutTax(DECIMAL_0001);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(3, result.getErrorInfoList().size());

	}

	@Test
	public void ElectricBillingAttachedFileのテスト() throws Exception {

		//データ作成
		ElectricBillingAttachedFileDto testTarget = new ElectricBillingAttachedFileDto();
		testTarget.setFileName("test");
		testTarget.setFileKind(FileKind.日別電力量明細表Excel);
		testTarget.setFilePhysicsName("test");
		testTarget.setFileSize(1);
		testTarget.setContentType("test");
		testTarget.setSavedPath("test");

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		testTarget.setFileName(null);
		testTarget.setFilePhysicsName(null);
		testTarget.setContentType(null);
		testTarget.setSavedPath(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(4, result.getErrorInfoList().size());
		testTarget.setFileName("test");
		testTarget.setFilePhysicsName("test");
		testTarget.setContentType("test");
		testTarget.setSavedPath("test");

		// 異常系(@Size)
		testTarget.setFileName(STR_256);
		testTarget.setFilePhysicsName(STR_256);
		testTarget.setContentType(STR_256);
		testTarget.setSavedPath(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(4, result.getErrorInfoList().size());

	}

	@Test
	public void BillingHistoryUpdateのテスト() throws Exception {

		//データ作成
		BillingHistoryUpdateDto testTarget = new BillingHistoryUpdateDto();
		testTarget.setBillingHistoryId(1L);
		testTarget.setAccruedFlg(1);
		testTarget.setInvoiceOutputFlg(1);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@Max)
		testTarget.setAccruedFlg(99);
		testTarget.setInvoiceOutputFlg(99);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		testTarget.setAccruedFlg(1);
		testTarget.setInvoiceOutputFlg(1);

		// 異常系(@Min)
		testTarget.setAccruedFlg(INT_MINUS_1);
		testTarget.setInvoiceOutputFlg(INT_MINUS_1);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());
		testTarget.setAccruedFlg(1);
		testTarget.setInvoiceOutputFlg(1);
	}
}
