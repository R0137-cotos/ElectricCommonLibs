package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ProfitTransferDepartmentMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 粗利振替先部門マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "profit_transfer_department_master")
@CotosComplementTarget(entity = ProfitTransferDepartmentMaster.class, repository = ProfitTransferDepartmentMasterRepository.class)
public class ProfitTransferDepartmentMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profit_transfer_department_master_seq")
	@SequenceGenerator(name = "profit_transfer_department_master_seq", sequenceName = "profit_transfer_department_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販社コード(3桁)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "販社コード", required = false, position = 2, allowableValues = "range[0,255]")
	private String hanshCode;

	/**
	 * 販社＋課所コード(7桁)
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "販社＋課所コード(7桁)", required = true, position = 3, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 振替先部門コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "振替先部門コード", required = true, position = 4, allowableValues = "range[0,255]")
	private String transferDepCode;

	/**
	 * 振替先部門名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "振替先部門名", required = true, position = 5, allowableValues = "range[0,255]")
	private String transferDepName;

}
