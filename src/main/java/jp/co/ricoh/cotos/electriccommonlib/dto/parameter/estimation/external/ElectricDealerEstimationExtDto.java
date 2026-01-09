package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ElectricDealerEstimationExtDto  {

	/**
	 * 企業ID
	 */
	@Size(max = 255)
	@Schema(description = "企業ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 企業_事業所名
	 */
	@Size(max = 1000)
	@Schema(description = "企業_事業所名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
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
	@Size(max = 4000)
	@Schema(description = "住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Size(max = 255)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress1;

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
	 * 支払区分
	 */
	@Schema(description = "支払区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * 支払間隔
	 */
	@Schema(description = "支払間隔", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,2]")
	private String paymentInterval;

	/**
	 * 支払期間
	 */
	@Schema(description = "支払期間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,2]")
	private String paymentPeriod;

	/**
	 * 支払期間
	 */
	@Schema(description = "帳票区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	private String reportsMethod;
}
