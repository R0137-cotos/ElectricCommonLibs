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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 承認ルート名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "承認ルート名", required = false, position = 2, allowableValues = "range[0,255]")
	private String approvalRouteName;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "説明", required = false, position = 3, allowableValues = "range[0,255]")
	private String description;

	/**
	 * 所属課所コード
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "所属課所コード", required = false, position = 4, allowableValues = "range[0,255]")
	private String affiliationCode;

	/**
	 * 電力承認ルートパターンマスタ
	 */
	@ManyToOne
	@JoinColumn(name = "electric_approval_route_pattern_master_id", referencedColumnName = "id")
	@JsonIgnore
	@ApiModelProperty(value = "電力承認ルートパターンマスタ", required = true, position = 5)
	private ElectricApprovalRoutePatternMaster electricApprovalRoutePatternMaster;

}
