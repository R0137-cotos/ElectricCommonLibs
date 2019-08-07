package jp.co.ricoh.cotos.electriccommonlib.fileupdownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.repository.common.AttachedFileRepository;
import jp.co.ricoh.cotos.commonlib.util.AppProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestElcFileUpDownload {

	@Autowired
	AttachedFileRepository attachedFileRepository;

	@Autowired
	ElcFileUpDownload elcFileUpDownload;

	@Autowired
	AppProperties appProperties;

	static ConfigurableApplicationContext context;

	@Autowired
	public void injectContext(ConfigurableApplicationContext injectContext) {
		context = injectContext;
	}

	@AfterClass
	public static void stopAPServer() throws InterruptedException {
		if (null != context) {
			context.stop();
		}
	}

	@Test
	public void 正常系_ファイルダウンロード() throws Exception {

		String fileName = "sample.xlsx";

		String dirPath = new File(".").getAbsoluteFile().getParent();
		File filePath = new File(dirPath + "/src/test/resources/fileUpDownload/" + fileName);

		InputStream expect = new FileInputStream(filePath);
		InputStream actual = elcFileUpDownload.downloadFile(filePath.getAbsolutePath());
		Assert.assertTrue("ファイル内容が一致していること", IOUtils.contentEquals(expect, actual));
	}

	@Test
	public void 異常系_ファイルダウンロードエラー() throws Exception {

		try {
			elcFileUpDownload.downloadFile("notexists.txt");
			Assert.fail("正常終了してしまった");
		} catch (ErrorCheckException e) {
			Assert.assertEquals("エラーIDが正しく設定されること", "ROT00100", e.getErrorInfoList().get(0).getErrorId());
			Assert.assertEquals("エラーメッセージが正しく設定されること", "指定されたファイルが存在しません。", e.getErrorInfoList().get(0).getErrorMessage());
		}
	}
}
