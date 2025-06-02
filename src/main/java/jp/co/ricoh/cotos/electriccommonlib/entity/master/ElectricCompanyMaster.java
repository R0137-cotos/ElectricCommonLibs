package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricCompanyMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力会社スタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_company_master")
@CotosComplementTarget(entity = ElectricCompanyMaster.class, repository = ElectricCompanyMasterRepository.class)
public class ElectricCompanyMaster extends EntityBaseMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_company_master_seq")
	@SequenceGenerator(name = "electric_company_master_seq", sequenceName = "electric_company_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力会社名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力会社名", required = true, position = 2, allowableValues = "range[0,255]")
	private String electricCompanyName;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "説明", required = false, position = 3, allowableValues = "range[0,255]")
	private String description;

	/**
	 * 電力エリアマスタ
	 */
	@ManyToOne(optional = true)
	@JoinColumn(name = "electric_area_master_id", referencedColumnName = "id")
	@ApiModelProperty(value = "電力エリアマスタ", required = false, position = 4)
	@JsonIgnore
	private ElectricAreaMaster electricAreaMaster;
}
