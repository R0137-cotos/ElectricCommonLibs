package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReportResultDto {

	/**
	 * 帳票バイナリデータ
	 */
	@Schema(description = "帳票バイナリデータ", requiredMode = Schema.RequiredMode.REQUIRED)
	private byte[] reportData;

	/**
	 * 帳票名
	 */
	@Schema(description = "帳票名", requiredMode = Schema.RequiredMode.REQUIRED)
	private String fileName;

}
