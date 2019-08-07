package jp.co.ricoh.cotos.electriccommonlib.fileupdownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;

@Component
public class ElcFileUpDownload {

	@Autowired
	CheckUtil checkUtil;

	public InputStream downloadFile(String targetFilePath) throws IOException {

		File file = new File(targetFilePath);
		if (!file.exists()) {
			throw new ErrorCheckException(checkUtil.addErrorInfo(new ArrayList<ErrorInfo>(), "FileNotFoundError"));
		}

		return new FileInputStream(file);
	}
}
