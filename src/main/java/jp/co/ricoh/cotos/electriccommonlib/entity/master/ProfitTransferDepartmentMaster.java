package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 販社コード(3桁)
	 */
	@Column(nullable = true)
	@Schema(description = "販社コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String hanshCode;

	/**
	 * 販社＋課所コード(7桁)
	 */
	@Column(nullable = false)
	@Schema(description = "販社＋課所コード(7桁)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 振替先部門コード
	 */
	@Column(nullable = false)
	@Schema(description = "振替先部門コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String transferDepCode;

	/**
	 * 振替先部門名
	 */
	@Column(nullable = false)
	@Schema(description = "振替先部門名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String transferDepName;

}
