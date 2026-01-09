package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.PaymentMethod;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricDealerEstimationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 販売店情報
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_dealer_estimation")
@CotosComplementTarget(entity = ElectricDealerEstimation.class, repository = ElectricDealerEstimationRepository.class)
public class ElectricDealerEstimation extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_dealer_estimation_seq")
	@SequenceGenerator(name = "electric_dealer_estimation_seq", sequenceName = "electric_dealer_estimation_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 見積（電力）ID
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "estimationElectricId", referencedColumnName = "id")
	@JsonIgnore
	private EstimationElectric estimationElectric;

	/**
	 * 企業ID
	 */
	@Column(nullable = true)
	@Schema(description = "企業ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Column(nullable = true)
	@Schema(description = "販売店企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
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
	 * 支払区分
	 */
	@Column(nullable = false)
	@Schema(description = "支払区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "定額(\"1\"), 定率(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス1", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,]")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス2", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@Schema(description = "メールアドレス3", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,]")
	private String mailAddress3;

	/**
	 * 支払間隔
	 */
	@Column(nullable = true)
	@Schema(description = "支払間隔", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,2]")
	private String paymentInterval;

	/**
	 * 支払期間
	 */
	@Column(nullable = true)
	@Schema(description = "支払期間", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,2]")
	private String paymentPeriod;

	/**
	 * 帳票区分
	 */
	@Column(nullable = true)
	@Schema(description = "帳票区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1]")
	private String reportsMethod;
}
