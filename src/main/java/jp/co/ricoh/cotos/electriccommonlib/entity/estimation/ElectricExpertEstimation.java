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

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.estimation.ElectricExpertEstimationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力専任情報
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_expert_estimation")
@CotosComplementTarget(entity = ElectricExpertEstimation.class, repository = ElectricExpertEstimationRepository.class)
public class ElectricExpertEstimation extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_expert_estimation_seq")
	@SequenceGenerator(name = "electric_expert_estimation_seq", sequenceName = "electric_expert_estimation_seq", allocationSize = 1)
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
	 * 氏名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "氏名", required = false, position = 2, allowableValues = "range[0,255]")
	private String name;

	/**
	 * メールアドレス
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "メールアドレス", required = false, position = 3, allowableValues = "range[0,255]")
	private String mailAddress;

	/**
	 * 電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電話番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 所属課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "所属課所コード", required = false, position = 5, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 所属
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "所属", required = false, position = 6, allowableValues = "range[0,255]")
	private String belongs;

	/**
	 * MoM社員ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "MoM社員ID", required = false, position = 7, allowableValues = "range[0,255]")
	private String momEmpId;

	/**
	 * 修正時振替先コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "修正時振替先コード", required = false, position = 8, allowableValues = "range[0,255]")
	private String fixTransferDestinationCode;

	/**
	 * 修正時振替先課所名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "修正時振替先課所名", required = false, position = 9, allowableValues = "range[0,255]")
	private String fixTransferSectionName;

}
