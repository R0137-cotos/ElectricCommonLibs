package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1)
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
	@ApiModelProperty(value = "企業ID", required = false, position = 2, allowableValues = "range[0,255]")
	private String companyId;

	/**
	 * 販売店企業名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販売店企業名", required = false, position = 3, allowableValues = "range[0,255]")
	private String companyBusinessName;

	/**
	 * 事業所電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "事業所電話番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 郵便番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "郵便番号", required = false, position = 5, allowableValues = "range[0,255]")
	private String postNumber;

	/**
	 * 住所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "住所", required = false, position = 6, allowableValues = "range[0,4000]")
	private String address;

	/**
	 * 支払区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "支払区分", required = true, position = 7, allowableValues = "定率(\"1\"), 定額(\"2\")", example = "1")
	private PaymentMethod paymentMethod;

	/**
	 * メールアドレス1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス1", required = false, position = 8, allowableValues = "range[0,]")
	private String mailAddress1;

	/**
	 * メールアドレス2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス2", required = false, position = 9, allowableValues = "range[0,]")
	private String mailAddress2;

	/**
	 * メールアドレス3
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス3", required = false, position = 10, allowableValues = "range[0,]")
	private String mailAddress3;
}
