package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory.SendMail;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MonthlyElectricDealerContractRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 月次販売店情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "monthly_electric_dealer_contract")
@CotosComplementTarget(entity = MonthlyElectricDealerContract.class, repository = MonthlyElectricDealerContractRepository.class)
public class MonthlyElectricDealerContract extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monthly_electric_dealer_contract_seq")
	@SequenceGenerator(name = "monthly_electric_dealer_contract_seq", sequenceName = "monthly_electric_dealer_contract_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 企業ID
	 */
	@Column(nullable = false)
	@Schema(description = "企業ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Column(nullable = true)
	@Schema(description = "販売店企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Column(nullable = true)
	@Schema(description = "事業所電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@Schema(description = "郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Column(nullable = true)
	@Schema(description = "住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス3", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailAddress3;

	/**
	 * 支払区分
	 */
	@Column(nullable = true)
	@Schema(description = "支払区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メール送信
	 */
	@Column(nullable = true)
	@Schema(description = "メール送信", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "未送信(\"0\"), 送信済(\"1\"), 送信対象外(\"9\")", example = "0")
	private SendMail sendMail;

	/**
	 * 請求年月
	 */
	@Column(nullable = false)
	@Schema(description = "請求年月", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String billingYearMonth;

	/**
	 * 電力支払添付ファイル
	 */
	@OneToMany(mappedBy = "monthlyElectricDealerContract")
	@Schema(description = "電力支払添付ファイル", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ElectricPaymentAttachedFile> electricPaymentAttachedFileList;

}
