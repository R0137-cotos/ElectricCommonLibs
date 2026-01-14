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

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力会社名
	 */
	@Column(nullable = false)
	@Schema(description = "電力会社名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String electricCompanyName;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@Schema(description = "説明", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String description;

	/**
	 * 電力エリアマスタ
	 */
	@ManyToOne(optional = true)
	@JoinColumn(name = "electric_area_master_id", referencedColumnName = "id")
	@Schema(description = "電力エリアマスタ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonIgnore
	private ElectricAreaMaster electricAreaMaster;
}
