package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricDealerContract;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricDealerContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = ElectricDealerContract.class, repository = ElectricDealerContractRepository.class)
public class ElectricDealerContractDto extends DtoBase {

	/**
	 * 企業ID
	 */
	@Size(max = 255)
	@Schema(description = "企業ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Size(max = 255)
	@Schema(description = "販売店企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Size(max = 255)
	@Schema(description = "事業所電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Size(max = 255)
	@Schema(description = "郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Size(max = 255)
	@Schema(description = "住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Size(max = 255)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * 支払区分
	 */
	@Schema(description = "支払区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メールアドレス2
	 */
	@Size(max = 255)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Size(max = 255)
	@Schema(description = "メールアドレス3", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 1ショット支払済フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "1ショット支払済フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer oneShotPaidFlg;
}
