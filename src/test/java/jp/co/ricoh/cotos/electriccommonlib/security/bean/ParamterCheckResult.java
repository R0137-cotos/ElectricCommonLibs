package jp.co.ricoh.cotos.electriccommonlib.security.bean;

import java.util.List;

import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import lombok.Data;

@Data
public class ParamterCheckResult {
	private List<ErrorInfo> errorInfoList;
}
