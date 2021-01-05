package jp.co.ricoh.cotos.electriccommonlib.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.ObjectUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import jp.co.ricoh.cotos.commonlib.util.ClaimsProperties;
import jp.co.ricoh.cotos.commonlib.util.JwtProperties;
import jp.co.ricoh.cotos.electriccommonlib.DBConfig;
import jp.co.ricoh.cotos.electriccommonlib.TestTools;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricAppropriation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricDealerContract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MonthlyElectricDealerContract;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.AgencyContractInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingBasicInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingHistoryRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.BillingMailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ClientMasterRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricAttachedFileRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricAppropriationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricBillingAttachedFileRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricDealerContractRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricExpertContractRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricPaymentAttachedFileRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentHighPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.EntryContentLowPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.FfmAccountRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ImportantPointExplainerRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MailAddressInformationRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MonthlyElectricDealerContractRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceHighPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.UnitPriceLowPressureRepository;
import jp.co.ricoh.cotos.electriccommonlib.security.CotosElcAuthenticationDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestContractElectricRepository extends RepositoryTestBase {

	@Autowired
	AgencyContractInformationRepository agencyContractInformationRepository;

	@Autowired
	BillingBasicInformationRepository billingBasicInformationRepository;

	@Autowired
	BillingHistoryRepository billingHistoryRepository;

	@Autowired
	BillingMailAddressInformationRepository billingMailAddressInformationRepository;

	@Autowired
	CancellationInformationRepository cancellationInformationRepository;

	@Autowired
	ClientInformationRepository clientInformationRepository;

	@Autowired
	ContractElectricRepository contractElectricRepository;

	@Autowired
	ClientMasterRepository clientMasterRepository;

	@Autowired
	ContractElectricAttachedFileRepository contractElectricAttachedFileRepository;

	@Autowired
	ElectricAppropriationRepository electricAppropriationRepository;

	@Autowired
	FfmAccountRepository ffmAccountRepository;

	@Autowired
	ElectricDealerContractRepository electricDealerContractRepository;

	@Autowired
	ElectricExpertContractRepository electricExpertContractRepository;

	@Autowired
	EntryContentHighPressureRepository entryContentHighPressureRepository;

	@Autowired
	EntryContentLowPressureRepository entryContentLowPressureRepository;

	@Autowired
	MailAddressInformationRepository mailAddressInformationRepository;

	@Autowired
	UnitPriceHighPressureRepository unitPriceHighPressureRepository;

	@Autowired
	UnitPriceLowPressureRepository unitPriceLowPressureRepository;

	@Autowired
	ImportantPointExplainerRepository importantPointExplainerRepository;

	@Autowired
	ElectricBillingAttachedFileRepository electricBillingAttachedFileRepository;

	@Autowired
	MonthlyElectricDealerContractRepository monthlyElectricDealerContractRepository;

	@Autowired
	ElectricPaymentAttachedFileRepository electricPaymentAttachedFileRepository;

	@Autowired
	TestTools testTools;

	@Autowired
	JwtProperties jwtProperties;

	@Autowired
	ClaimsProperties claimsProperties;

	@Autowired
	TestCheckComponent testCheckComponent;

	static ConfigurableApplicationContext context;

	private static boolean dataLoaded = false;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
		if (!dataLoaded) {
			テストデータ設定();
			dataLoaded = true;
		}
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.getBean(DBConfig.class).clearData();
			context.stop();
		}
	}

	public void テストデータ設定() {
		context.getBean(DBConfig.class).clearData();
		context.getBean(DBConfig.class).initTargetTestData("repository/contract/Electric.sql");
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用() {
		全てのカラムがNullではないことを確認_共通(contractElectricRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_Mailアドレス情報() {
		全てのカラムがNullではないことを確認_共通(mailAddressInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_お申込み内容_高圧() {
		全てのカラムがNullではないことを確認_共通(entryContentHighPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_お申込み内容_低圧() {
		全てのカラムがNullではないことを確認_共通(entryContentLowPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用_添付ファイル() {
		全てのカラムがNullではないことを確認_共通(contractElectricAttachedFileRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_単価情報_高圧() {
		全てのカラムがNullではないことを確認_共通(unitPriceHighPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_単価情報_低圧() {
		全てのカラムがNullではないことを確認_共通(unitPriceLowPressureRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_解約情報() {
		全てのカラムがNullではないことを確認_共通(cancellationInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_電力専任情報() {
		全てのカラムがNullではないことを確認_共通(electricExpertContractRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_販売店情報() {
		全てのカラムがNullではないことを確認_共通(electricDealerContractRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_得意先情報() {
		全てのカラムがNullではないことを確認_共通(clientInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_得意先情報マスタ() {
		全てのカラムがNullではないことを確認_共通(clientMasterRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_請求先Mailアドレス情報() {
		全てのカラムがNullではないことを確認_共通(billingMailAddressInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_取次情報() {
		全てのカラムがNullではないことを確認_共通(agencyContractInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_請求基本情報() {
		全てのカラムがNullではないことを確認_共通(billingBasicInformationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_請求実績() {
		全てのカラムがNullではないことを確認_共通(billingHistoryRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_計上実績() {
		全てのカラムがNullではないことを確認_共通(electricAppropriationRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_FFM計上() {
		全てのカラムがNullではないことを確認_共通(ffmAccountRepository);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_重要事項説明者() {
		全てのカラムがNullではないことを確認_共通(importantPointExplainerRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_電力請求添付ファイル() {
		全てのカラムがNullではないことを確認_共通(electricBillingAttachedFileRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_月次販売店情報() {
		全てのカラムがNullではないことを確認_共通(monthlyElectricDealerContractRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_電力支払添付ファイル() {
		全てのカラムがNullではないことを確認_共通(electricPaymentAttachedFileRepository, 1L);
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用を契約IDより取得() {

		// 契約IDにより契約(電力)を取得
		ContractElectric contractElectric = contractElectricRepository.findByContractId(2L);

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(contractElectric);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用を外部キーより取得() {

		// 外部キーにより契約(電力)を取得
		List<ContractElectric> contractElectricList = contractElectricRepository.findByOppSysKeyBn("test");

		Assert.assertEquals("1件取得されること", 1, contractElectricList.size());
		// null項目なく取得できていることを確認
		contractElectricList.stream().forEach(contractElectric -> {
			try {
				testTools.assertColumnsNotNull(contractElectric);
			} catch (Exception e1) {
				Assert.fail("例外が発生した場合、エラー");
			}
		});
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_電力用をSIM番号より取得() {

		// SIM番号により契約(電力)を取得
		List<ContractElectric> contractElectricList = contractElectricRepository.findBySimNumberMainAndSimNumberSub("00001", "01");

		Assert.assertEquals("1件取得されること", 1, contractElectricList.size());
		// null項目なく取得できていることを確認
		contractElectricList.stream().forEach(contractElectric -> {
			try {
				testTools.assertColumnsNotNull(contractElectric);
			} catch (Exception e1) {
				Assert.fail("例外が発生した場合、エラー");
			}
		});
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_得意先マスタを得意先CDから取得() {

		ClientMaster clientMaster = clientMasterRepository.findByClientCode("1234567");

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(clientMaster);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 全てのカラムがNullではないことを確認_契約_請求基本情報を得意先CDから取得() {

		BillingBasicInformation billingBasicInformation = billingBasicInformationRepository.findByClientCode("1234567");

		// null項目なく取得できていることを確認
		try {
			testTools.assertColumnsNotNull(billingBasicInformation);
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 請求先Mailアドレス情報を取得できないことを確認_得意先情報マスタIDにより削除() {

		billingMailAddressInformationRepository.deleteByClientMasterId(1L);
		ClientMaster clientMaster = clientMasterRepository.findOne(1L);

		// null項目なく取得できていることを確認
		try {
			Assert.assertEquals(0, clientMaster.getBillingMailAddressInformationList().size());
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
		テストデータ設定();
	}

	@Test
	public void Mailアドレス情報を取得できないことを確認_契約電力IDにより削除() {

		mailAddressInformationRepository.deleteByContractElectricId(1L);
		ContractElectric contractElectric = contractElectricRepository.findOne(1L);

		// null項目なく取得できていることを確認
		try {
			Assert.assertEquals(0, contractElectric.getMailAddressInformationList().size());
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
		テストデータ設定();
	}

	@Test
	public void 添付ファイルを取得できないことを確認_契約電力IDにより削除() {

		contractElectricAttachedFileRepository.deleteByContractElectricId(1L);
		ContractElectric contractElectric = contractElectricRepository.findOne(1L);

		// null項目なく取得できていることを確認
		try {
			Assert.assertEquals(0, contractElectric.getContractElectricAttachedFileList().size());
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
		テストデータ設定();
	}

	@Test
	public void 契約電力IDより取得_計上実績() {

		long contractElectricId = 1L;
		List<ElectricAppropriation> electricAppropriation = electricAppropriationRepository.findByContractElectricId(contractElectricId);

		// null項目なく取得できていることを確認
		try {
			Assert.assertEquals(1, electricAppropriation.size());
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 請求基本情報IDと請求年月より取得_請求実績() {
		long billingBasicInformationId = 1L;
		String billingYearMonth = "2017/11";
		BillingHistory billingHistoryEntity = null;
		try {
			billingHistoryEntity = billingHistoryRepository.findByBillingBasicInformationIdAndBillingYearMonth(billingBasicInformationId, billingYearMonth);
		} catch (Exception e) {
			Assert.fail("想定外のエラーが発生した。");
		}
		Assert.assertFalse("請求実績が1件取得", ObjectUtils.isEmpty(billingHistoryEntity));
	}

	@Test
	public void 電力販売店会社IDと請求年月より取得_計上実績() {

		String electricTradingCompanyId = "販売店1";
		String billingYearMonth = "2017/11";
		List<ElectricAppropriation> electricAppropriation = electricAppropriationRepository.findByElectricTradingCompanyIdAndBillingYearMonth(electricTradingCompanyId, billingYearMonth);

		// 電力販売店会社IDで取得できていることを確認
		try {
			electricAppropriation.stream().forEach(entity -> {
				Assert.assertEquals("販売店1", entity.getElectricTradingCompanyId());
			});
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 電力販売店会社IDと複数請求年月より取得_計上実績() {

		String electricTradingCompanyId = "販売店1";
		List<String> billingYearMonth = new ArrayList<>();
		billingYearMonth.add("2017/11");
		List<ElectricAppropriation> electricAppropriation = electricAppropriationRepository.findByElectricTradingCompanyIdAndBillingYearMonth(electricTradingCompanyId, billingYearMonth);

		// 電力販売店会社IDで取得できていることを確認
		try {
			Assert.assertEquals(1, electricAppropriation.size());
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void マイナス値登録_計上実績() {

		// JWT作成
		Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
		String jwt = JWT.create().withExpiresAt(new Date(25340226839900L)).withClaim(claimsProperties.getMomEmpId(), "00500784").withClaim(claimsProperties.getSingleUserId(), "u02901149").withClaim(claimsProperties.getOrigin(), "cotos.ricoh.co.jp").withClaim(claimsProperties.getApplicationId(), "cotos_electric_dev").sign(algorithm);

		CotosElcAuthenticationDetails principal = new CotosElcAuthenticationDetails("00500784", "u02901149", "https://dev-1.cotos.ricoh.co.jp", "cotos_dev_1", jwt, false, false, null);
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);

		final BigDecimal DECIMAL_MINUS_001 = BigDecimal.valueOf(0.01).negate();
		Assert.assertEquals("-0.01", DECIMAL_MINUS_001.toString());

		ElectricAppropriation electricAppropriation = electricAppropriationRepository.findOne(1L);

		// 売上金額(税込)
		electricAppropriation.setProceedsInTax(DECIMAL_MINUS_001);
		// 売上消費税額
		electricAppropriation.setProceedsTax(DECIMAL_MINUS_001);
		// 売上金額(税抜)
		electricAppropriation.setProceedsOutTax(DECIMAL_MINUS_001);

		// 仕入合計料金(税込)
		electricAppropriation.setPurchaserTotalChargeInTax(DECIMAL_MINUS_001);
		// 仕入消費税額
		electricAppropriation.setPurchaserTax(DECIMAL_MINUS_001);
		// 仕入合計料金(税抜)
		electricAppropriation.setPurchaserTotalChargeOutTax(DECIMAL_MINUS_001);

		// RJ粗利金額
		electricAppropriation.setRjGrossProfit(DECIMAL_MINUS_001);
		// 営業区粗利金額
		electricAppropriation.setSalesSectionGrossProfit(DECIMAL_MINUS_001);
		// 本部粗利金額
		electricAppropriation.setHeadofficeGrossProfit(DECIMAL_MINUS_001);

		// 取次割引単価
		electricAppropriation.setAgencyDiscountPrice(DECIMAL_MINUS_001);
		// 燃料費調整額単価
		electricAppropriation.setFuelAdjustmentPrice(DECIMAL_MINUS_001);
		// 再エネ賦課金単価
		electricAppropriation.setRenewableLevyPrice(DECIMAL_MINUS_001);
		// 燃料費調整額
		electricAppropriation.setFuelAdjustmentCost(DECIMAL_MINUS_001);
		// 再エネ賦課金
		electricAppropriation.setRenewableLevyCost(DECIMAL_MINUS_001);
		// 制限中止割引
		electricAppropriation.setRestrictionCancelDiscount(DECIMAL_MINUS_001);
		// その他
		electricAppropriation.setOtherCost(DECIMAL_MINUS_001);
		// 仕入契約超過金
		electricAppropriation.setPurchaserContractExcess(DECIMAL_MINUS_001);
		// 仕入前月調整
		electricAppropriation.setPurchaserAdjustment(DECIMAL_MINUS_001);
		// 仕入アンシラリー
		electricAppropriation.setPurchaserAncillary(DECIMAL_MINUS_001);
		// 仕入予備線
		electricAppropriation.setPurchaserSpareLine(DECIMAL_MINUS_001);
		// 仕入予備電源
		electricAppropriation.setPurchaserSparePower(DECIMAL_MINUS_001);
		// 仕切契約超過金
		electricAppropriation.setPartitionContractExcess(DECIMAL_MINUS_001);
		// 仕切前月調整
		electricAppropriation.setPartitionAdjustment(DECIMAL_MINUS_001);
		// 仕切アンシラリー
		electricAppropriation.setPartitionAncillary(DECIMAL_MINUS_001);
		// 仕切予備線
		electricAppropriation.setPartitionSpareLine(DECIMAL_MINUS_001);
		// 仕切予備電源
		electricAppropriation.setPartitionSparePower(DECIMAL_MINUS_001);

		try {
			// 例外が発生せずにsaveが実行されることを確認
			testCheckComponent.update(electricAppropriationRepository, electricAppropriation);
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail("例外が発生した場合、エラー");
		}
		テストデータ設定();
	}

	@Test
	public void 整数18桁登録_計上実績() {

		// JWT作成
		Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
		String jwt = JWT.create().withExpiresAt(new Date(25340226839900L)).withClaim(claimsProperties.getMomEmpId(), "00500784").withClaim(claimsProperties.getSingleUserId(), "u02901149").withClaim(claimsProperties.getOrigin(), "cotos.ricoh.co.jp").withClaim(claimsProperties.getApplicationId(), "cotos_electric_dev").sign(algorithm);

		CotosElcAuthenticationDetails principal = new CotosElcAuthenticationDetails("00500784", "u02901149", "https://dev-1.cotos.ricoh.co.jp", "cotos_dev_1", jwt, false, false, null);
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);

		ElectricAppropriation electricAppropriation = electricAppropriationRepository.findOne(1L);
		final BigDecimal DECIMAL_OVER_MAX = BigDecimal.valueOf(123456789012345678.99);

		// 売上金額(税込)
		electricAppropriation.setProceedsInTax(DECIMAL_OVER_MAX);
		// 売上消費税額
		electricAppropriation.setProceedsTax(DECIMAL_OVER_MAX);
		// 売上金額(税抜)
		electricAppropriation.setProceedsOutTax(DECIMAL_OVER_MAX);

		// 仕入合計料金(税込)
		electricAppropriation.setPurchaserTotalChargeInTax(DECIMAL_OVER_MAX);
		// 仕入消費税額
		electricAppropriation.setPurchaserTax(DECIMAL_OVER_MAX);
		// 仕入合計料金(税抜)
		electricAppropriation.setPurchaserTotalChargeOutTax(DECIMAL_OVER_MAX);

		// RJ粗利金額
		electricAppropriation.setRjGrossProfit(DECIMAL_OVER_MAX);
		// 営業区粗利金額
		electricAppropriation.setSalesSectionGrossProfit(DECIMAL_OVER_MAX);
		// 本部粗利金額
		electricAppropriation.setHeadofficeGrossProfit(DECIMAL_OVER_MAX);

		// 取次割引単価
		electricAppropriation.setAgencyDiscountPrice(DECIMAL_OVER_MAX);
		// 燃料費調整額単価
		electricAppropriation.setFuelAdjustmentPrice(DECIMAL_OVER_MAX);
		// 再エネ賦課金単価
		electricAppropriation.setRenewableLevyPrice(DECIMAL_OVER_MAX);
		// 燃料費調整額
		electricAppropriation.setFuelAdjustmentCost(DECIMAL_OVER_MAX);
		// 再エネ賦課金
		electricAppropriation.setRenewableLevyCost(DECIMAL_OVER_MAX);
		// 制限中止割引
		electricAppropriation.setRestrictionCancelDiscount(DECIMAL_OVER_MAX);
		// その他
		electricAppropriation.setOtherCost(DECIMAL_OVER_MAX);
		// 仕入契約超過金
		electricAppropriation.setPurchaserContractExcess(DECIMAL_OVER_MAX);
		// 仕入前月調整
		electricAppropriation.setPurchaserAdjustment(DECIMAL_OVER_MAX);
		// 仕入アンシラリー
		electricAppropriation.setPurchaserAncillary(DECIMAL_OVER_MAX);
		// 仕入予備線
		electricAppropriation.setPurchaserSpareLine(DECIMAL_OVER_MAX);
		// 仕入予備電源
		electricAppropriation.setPurchaserSparePower(DECIMAL_OVER_MAX);
		// 仕切契約超過金
		electricAppropriation.setPartitionContractExcess(DECIMAL_OVER_MAX);
		// 仕切前月調整
		electricAppropriation.setPartitionAdjustment(DECIMAL_OVER_MAX);
		// 仕切アンシラリー
		electricAppropriation.setPartitionAncillary(DECIMAL_OVER_MAX);
		// 仕切予備線
		electricAppropriation.setPartitionSpareLine(DECIMAL_OVER_MAX);
		// 仕切予備電源
		electricAppropriation.setPartitionSparePower(DECIMAL_OVER_MAX);

		try {
			// 例外が発生することを確認
			testCheckComponent.update(electricAppropriationRepository, electricAppropriation);
		} catch (TransactionSystemException expected) {
			Assert.assertTrue("整数桁あふれのバリデーションチェックによる例外が根本原因であること", expected.getRootCause() instanceof ConstraintViolationException);
			Assert.assertEquals("整数桁あふれが発生する項目数が２６であること", 26, ((ConstraintViolationException) expected.getRootCause()).getConstraintViolations().size());
			return;
		} catch (Exception unexpected) {
			unexpected.printStackTrace();
			Assert.fail("想定外の例外が発生した");
		}
		Assert.fail("例外が発生しなかった");
	}

	@Test
	public void マイナス値登録_請求実績() {

		// JWT作成
		Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
		String jwt = JWT.create().withExpiresAt(new Date(25340226839900L)).withClaim(claimsProperties.getMomEmpId(), "00500784").withClaim(claimsProperties.getSingleUserId(), "u02901149").withClaim(claimsProperties.getOrigin(), "cotos.ricoh.co.jp").withClaim(claimsProperties.getApplicationId(), "cotos_electric_dev").sign(algorithm);

		CotosElcAuthenticationDetails principal = new CotosElcAuthenticationDetails("00500784", "u02901149", "https://dev-1.cotos.ricoh.co.jp", "cotos_dev_1", jwt, false, false, null);
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);

		final BigDecimal DECIMAL_MINUS_001 = BigDecimal.valueOf(0.01).negate();
		Assert.assertEquals("-0.01", DECIMAL_MINUS_001.toString());

		BillingHistory billingHistory = billingHistoryRepository.findOne(1L);

		// 請求金額(税込)
		billingHistory.setClaimAmountInTax(DECIMAL_MINUS_001);
		// 売上消費税額
		billingHistory.setClaimTax(DECIMAL_MINUS_001);
		// 売上金額(税抜)
		billingHistory.setClaimAmountOutTax(DECIMAL_MINUS_001);

		try {
			// 例外が発生せずにsaveが実行されることを確認
			testCheckComponent.update(billingHistoryRepository, billingHistory);
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail("例外が発生した場合、エラー");
		}
		テストデータ設定();
	}

	@Test
	public void 整数18桁登録_請求実績() {

		// JWT作成
		Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
		String jwt = JWT.create().withExpiresAt(new Date(25340226839900L)).withClaim(claimsProperties.getMomEmpId(), "00500784").withClaim(claimsProperties.getSingleUserId(), "u02901149").withClaim(claimsProperties.getOrigin(), "cotos.ricoh.co.jp").withClaim(claimsProperties.getApplicationId(), "cotos_electric_dev").sign(algorithm);

		CotosElcAuthenticationDetails principal = new CotosElcAuthenticationDetails("00500784", "u02901149", "https://dev-1.cotos.ricoh.co.jp", "cotos_dev_1", jwt, false, false, null);
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, null, null);
		SecurityContextHolder.getContext().setAuthentication(auth);

		BillingHistory billingHistory = billingHistoryRepository.findOne(1L);
		final BigDecimal DECIMAL_OVER_MAX = BigDecimal.valueOf(123456789012345678.99);

		// 請求金額(税込)
		billingHistory.setClaimAmountInTax(DECIMAL_OVER_MAX);
		// 売上消費税額
		billingHistory.setClaimTax(DECIMAL_OVER_MAX);
		// 売上金額(税抜)
		billingHistory.setClaimAmountOutTax(DECIMAL_OVER_MAX);

		try {
			// 例外が発生することを確認
			testCheckComponent.update(billingHistoryRepository, billingHistory);
		} catch (TransactionSystemException expected) {
			Assert.assertTrue("整数桁あふれのバリデーションチェックによる例外が根本原因であること", expected.getRootCause() instanceof ConstraintViolationException);
			return;
		} catch (Exception unexpected) {
			unexpected.printStackTrace();
			Assert.fail("想定外の例外が発生した");
		}
		Assert.fail("例外が発生しなかった");
	}

	@Test
	public void 企業IDと請求年月より取得_月次販売店情報() {

		String companyId = "販売店1";
		String billingYearMonth = "2017/11";
		MonthlyElectricDealerContract monthlyElectricDealerContract = monthlyElectricDealerContractRepository.findByCompanyIdAndBillingYearMonth(companyId, billingYearMonth);

		// 企業IDで取得できていることを確認
		try {
			Assert.assertEquals("販売店1", monthlyElectricDealerContract.getCompanyId());
		} catch (Exception e1) {
			Assert.fail("例外が発生した場合、エラー");
		}
	}

	@Test
	public void 販売店情報が取得できること() {
		final long expect = 1L;

		ElectricDealerContract findResult = null;
		try {
			findResult = electricDealerContractRepository.findByContractElectricId(expect);
		} catch (Exception e) {
			Assert.fail("想定外のエラーが発生した。");
		}
		Assert.assertFalse("販売店情報エンティティが取得できること", ObjectUtils.isEmpty(findResult));
		Assert.assertEquals("契約（電力用）IDが期待値通りであること", expect, findResult.getContractElectric().getId());
	}
}
