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
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricApprovalRouteMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力承認ルートマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_approval_route_master")
@CotosComplementTarget(entity = ElectricApprovalRouteMaster.class, repository = ElectricApprovalRouteMasterRepository.class)
public class ElectricApprovalRouteMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_approval_route_master_seq")
	@SequenceGenerator(name = "electric_approval_route_master_seq", sequenceName = "electric_approval_route_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 承認ルート名
	 */
	@Column(nullable = true)
	@Schema(description = "承認ルート名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String approvalRouteName;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@Schema(description = "説明", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String description;

	/**
	 * 所属課所コード
	 */
	@Column(nullable = true)
	@Schema(description = "所属課所コード", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 電力承認ルートパターンマスタ
	 */
	@ManyToOne
	@JoinColumn(name = "electric_approval_route_pattern_master_id", referencedColumnName = "id")
	@JsonIgnore
	@Schema(description = "電力承認ルートパターンマスタ", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricApprovalRoutePatternMaster electricApprovalRoutePatternMaster;

}
