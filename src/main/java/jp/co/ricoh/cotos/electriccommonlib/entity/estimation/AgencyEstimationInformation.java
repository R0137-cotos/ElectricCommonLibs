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
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 取次情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "agency_estimation_information")
public class AgencyEstimationInformation extends EntityBase {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_estimation_information_seq")
	@SequenceGenerator(name = "agency_estimation_information_seq", sequenceName = "agency_estimation_information_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1)
	private long id;

	/**
	 * 見積（電力）ID
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "estimationElectricId", referencedColumnName = "id")
	@ApiModelProperty(value = "見積（電力）ID", required = true, position = 2)
	@JsonIgnore
	private EstimationElectric estimationElectric;

	/**
	 * MOM顧客ID企業ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "MOM顧客ID企業ID", required = false, position = 3, allowableValues = "range[0,9223372036854775807]")
	private long momCustomerIdCompanyId;
	
	/**
	 * 取次会社
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "取次会社", required = false, position = 4, allowableValues = "range[0,255]")
	private String agencyName;
	
	/**
	 * 仕入先CD
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "仕入先CD", required = false, position = 5, allowableValues = "range[0,255]")
	private String supplierCode;
	
	/**
	 * 手数料率
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "手数料率", required = false, position = 6, allowableValues = "range[0.00,99999.99]")
	private String feeRate;
}