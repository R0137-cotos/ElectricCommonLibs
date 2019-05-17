package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

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
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ImportantPointExplainerRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 得意先情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "important_point_explainer")
@CotosComplementTarget(entity = ImportantPointExplainer.class, repository = ImportantPointExplainerRepository.class)
public class ImportantPointExplainer extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "important_point_explainer_seq")
	@SequenceGenerator(name = "important_point_explainer_seq", sequenceName = "important_point_explainer_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;
	
	/**
	 * 説明者名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "説明者名", required = false, position = 3, allowableValues = "range[0,255]")
	private String descriptionName;
	
	/**
	 * 所属組織名1
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "所属組織名1", required = false, position = 4, allowableValues = "range[0,255]")
	private String organizatioName1;
	
	/**
	 * 所属組織名2
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "所属組織名2", required = false, position = 5, allowableValues = "range[0,255]")
	private String organizatioName2;
}
