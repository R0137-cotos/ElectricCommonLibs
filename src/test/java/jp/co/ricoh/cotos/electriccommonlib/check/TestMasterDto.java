package jp.co.ricoh.cotos.electriccommonlib.check;

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
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external.CustomerInformationExtWashingDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external.CustomerInformationForWashingExtDto;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.CustomerInformationForWashing;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.CustomerInformationForWashingRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.bean.ParamterCheckResult;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestMasterDto {

	private static final String STR_256 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345";

	static ConfigurableApplicationContext context;

	private static boolean dataLoaded = false;

	@Autowired
	HeadersProperties headersProperties;

	@Autowired
	CustomerInformationForWashingRepository customerInformationForWashingRepository;

	@Autowired
	TestTools testTool;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		if (!dataLoaded) {
			context.getBean(DBConfig.class).clearData();
			context.getBean(DBConfig.class).initTargetTestData("repository/master/Master.sql");
			dataLoaded = true;
		}
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
	public void CustomerInformationForWashingExtDtoのテスト() throws Exception {

		CustomerInformationForWashing entity = customerInformationForWashingRepository.findOne(1L);
		CustomerInformationForWashingExtDto testTarget = new CustomerInformationForWashingExtDto();
		BeanUtils.copyProperties(entity, testTarget);

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		testTarget.setOriginMclMomKjbId(null);
		testTarget.setMclMomKjbId(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(2, result.getErrorInfoList().size());

		// 異常系(@Size(max))
		testTarget = new CustomerInformationForWashingExtDto();
		BeanUtils.copyProperties(entity, testTarget);
		testTarget.setOriginMclMomKjbId(STR_256);
		testTarget.setMclMomKjbId(STR_256);
		testTarget.setPrflMomKgyId(STR_256);
		testTarget.setPrflMomJgsId(STR_256);
		testTarget.setPrflKjbSetKbn(STR_256);
		testTarget.setKgyKgyNmKnji(STR_256);
		testTarget.setKgyHjnKakuCd(STR_256);
		testTarget.setKgyHjnKakuZengoCd(STR_256);
		testTarget.setKgyKgyNmKana(STR_256);
		testTarget.setJgsJgsNmKnji(STR_256);
		testTarget.setBmnBmnNmKnji(STR_256);
		testTarget.setJgsJgsPostNum(STR_256);
		testTarget.setJgsJgsTelNum(STR_256);
		testTarget.setJgsJgsFaxNum(STR_256);
		testTarget.setAdsJtdhknNmKnji(STR_256);
		testTarget.setAdsJskugnchosnKnji(STR_256);
		testTarget.setAdsJowaTusyoKnji(STR_256);
		testTarget.setAdsJkowChomeKnji(STR_256);
		testTarget.setJgsJgsAdsAzatusyoNm(STR_256);
		testTarget.setJgsJgsAdsBantiNm(STR_256);
		testTarget.setJgsJgsAdsGoNm(STR_256);
		testTarget.setJgsJgsAdsBldgNm(STR_256);
		testTarget.setJgsJgsAdsFlorNm(STR_256);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(23, result.getErrorInfoList().size());

	}

	@Test
	public void CustomerInformationExtWashingDtoのテスト() throws Exception {

		CustomerInformationExtWashingDto testTarget = new CustomerInformationExtWashingDto();
		CustomerInformationForWashingExtDto entity = new CustomerInformationForWashingExtDto();
		entity.setOriginMclMomKjbId("変更前MoM顧客企事部ID");
		entity.setMclMomKjbId("MoM顧客企事部ID");
		testTarget.setCustomerInformationList(Arrays.asList(entity));

		// 正常系
		ParamterCheckResult result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		testTool.assertValidationOk(result);

		// 異常系(@NotNull)
		testTarget.setCustomerInformationList(null);
		result = testCheckController.callParameterCheck(testTarget, headersProperties, localServerPort);
		Assert.assertEquals(1, result.getErrorInfoList().size());

	}

}
