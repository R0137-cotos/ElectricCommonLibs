package jp.co.ricoh.cotos.electriccommonlib.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.commonlib.util.ClaimsProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestProperties {

	@Autowired
	StandardProperties standardProperties;
	
	@Autowired
	ClaimsProperties claimsPropertires;

	@Autowired
	ElectricProperties electricProperties;

	@Autowired
	ExternalDatabaseProperties externalDatabaseProperties;

	@Autowired
	ElectricHeadersProperties electricHeadersProperties;

	@Test
	public void 標準側のAPIのURLを取得できること() {
		Assert.assertEquals("契約のURLが取得できること", "https://dev-api.cotos.ricoh.co.jp/contract/api", standardProperties.getContract());
		Assert.assertEquals("見積のURLが取得できること", "https://dev-api.cotos.ricoh.co.jp/estimaiton/api", standardProperties.getEstimation());
		Assert.assertEquals("マスターのURLが取得できること", "https://dev-api.cotos.ricoh.co.jp/master/api", standardProperties.getMaster());
		Assert.assertEquals("帳票のURLが取得できること", "https://dev-api.cotos.ricoh.co.jp/reports/api", standardProperties.getReports());
	}

	@Test
	public void 電力側のAPIのURLを取得できること() {
		Assert.assertEquals("契約のURLが取得できること", "https://dev-api.cotos.ricoh.co.jp/contract/electric/api", electricProperties.getContract());
		Assert.assertEquals("見積のURLが取得できること", "https://dev-api.cotos.ricoh.co.jp/estimaiton/electric/api", electricProperties.getEstimation());
	}

	@Test
	public void 外部スキーマ情報を取得できること() {
		Assert.assertEquals("外部スキーマ情報を取得できること", "test_schema", externalDatabaseProperties.getSchema());
	}

	@Test
	public void MoM権限ヘッダー情報を取得できること() {
		Assert.assertEquals("MoM権限ヘッダー情報を取得できること", "X-Cotos-Mom-Authorization", electricHeadersProperties.getMomAuthorization());
		Assert.assertEquals("MoM権限要否ヘッダー情報を取得できること", "X-Cotos-Require-Mom-Authorize", electricHeadersProperties.getRequireMomAuthorize());
		Assert.assertEquals("親クラスのヘッダー情報を取得できること", "X-Cotos-Disp-Authorization", electricHeadersProperties.getDispAuthorization());
	}
	
	@Test
	public void JWT情報を取得できること() {
		Assert.assertEquals("MoM社員IDを取得できること", "momEmpId", claimsPropertires.getMomEmpId());
		Assert.assertEquals("シングルユーザIDを取得できること", "singleUserId", claimsPropertires.getSingleUserId());
		Assert.assertEquals("オリジンを取得できること", "origin", claimsPropertires.getOrigin());
		Assert.assertEquals("アプリケーションIDを取得できること", "applicationId", claimsPropertires.getApplicationId());
		Assert.assertEquals("MoM権限情報を取得できること", "momAuth", claimsPropertires.getMomAuth());
	}
}
