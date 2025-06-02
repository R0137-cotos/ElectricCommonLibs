package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricAreaMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力エリアマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_area_master")
@CotosComplementTarget(entity = ElectricAreaMaster.class, repository = ElectricAreaMasterRepository.class)
public class ElectricAreaMaster extends EntityBaseMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_area_master_seq")
	@SequenceGenerator(name = "electric_area_master_seq", sequenceName = "electric_area_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力エリア名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力エリア名", required = true, position = 2, allowableValues = "range[0,255]")
	private String electricAreaName;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "説明", required = false, position = 3, allowableValues = "range[0,255]")
	private String description;

	/**
	 * 電力会社マスタ
	 */
	@OneToMany(mappedBy = "electricAreaMaster")
	@ApiModelProperty(value = "電力会社マスタ", required = false, position = 4)
	private List<ElectricCompanyMaster> electricCompanyMasterList;

}
