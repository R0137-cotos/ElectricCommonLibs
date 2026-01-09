package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricExpertContract;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricExpertContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ElectricExpertContract.class, repository = ElectricExpertContractRepository.class)
public class ElectricExpertContractDto extends DtoBase {

	/**
	 * 氏名
	 */
	@Size(max = 255)
	@Schema(description = "氏名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Size(max = 255)
	@Schema(description = "メールアドレス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "電話番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 所属課所コード
	 */
	@Size(max = 255)
	@Schema(description = "所属課所コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 所属
	 */
	@Size(max = 255)
	@Schema(description = "所属", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * 修正時振替先コード
	 */
	@Size(max = 255)
	@Schema(description = "修正時振替先コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * 修正時振替課所名
	 */
	@Size(max = 255)
	@Schema(description = "修正時振替課所名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String fixTransferSectionName;

	/**
	 * MoM社員ID
	 */
	@Size(max = 255)
	@Schema(description = "MoM社員ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String momEmpId;
}
