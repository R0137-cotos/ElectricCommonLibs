package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 得意先情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "client_information")
public class ClientInformation extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_electric_seq")
	@SequenceGenerator(name = "contract_electric_seq", sequenceName = "contract_electric_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private List<ContractElectric> contractElectricList;

	/**
	 * 得意先CD
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "得意先CD", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;

	/**
	 * 得意先情報M_ID
	 */
	@ManyToOne
	@JoinColumn(name = "client_master_id", referencedColumnName = "id")
	@ApiModelProperty(value = "得意先情報M_ID", required = true, position = 4)
	@JsonIgnore
	private ClientMaster clientMaster;

	/**
	 * アクティブflg
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アクティブflgグ", required = false, position = 5, allowableValues = "range[0,9]")
	private Integer activeFlg;
}
