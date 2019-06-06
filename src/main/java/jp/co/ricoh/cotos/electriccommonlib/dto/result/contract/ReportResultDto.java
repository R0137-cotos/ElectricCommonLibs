package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportResultDto {

	/**
	 * 帳票バイナリデータ
	 */
	@ApiModelProperty(value = "帳票バイナリデータ", required = true, position = 1)
	private byte[] reportData;

	/**
	 * 帳票名
	 */
	@ApiModelProperty(value = "帳票名", required = true, position = 2)
	private String fileName;

}
