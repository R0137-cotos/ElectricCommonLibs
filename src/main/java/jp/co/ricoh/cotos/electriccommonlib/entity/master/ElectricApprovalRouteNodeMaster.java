package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.ApprovalRouteNodeMaster.ApproverClass;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricApprovalRouteNodeMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 承認ルートノードマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_approval_route_node_master")
@CotosComplementTarget(entity = ElectricApprovalRouteNodeMaster.class, repository = ElectricApprovalRouteNodeMasterRepository.class)
public class ElectricApprovalRouteNodeMaster extends EntityBaseMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_approval_route_node_master_seq")
	@SequenceGenerator(name = "electric_approval_route_node_master_seq", sequenceName = "electric_approval_route_node_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;
	
	/**
	 * 承認ルートマスタ
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "electric_approval_route_master_id", referencedColumnName = "id")
	@ApiModelProperty(value = "承認ルートマスタ", required = true, position = 2)
	@JsonIgnore
	private ElectricApprovalRouteMaster electricApprovalRouteMaster;
	
	/**
	 * 承認順
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "承認順", required = true, position = 3, allowableValues = "range[0,999]")
	private int approvalOrder;
	
	/**
	 * 承認者種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "承認者種別", required = true, allowableValues = "メイン承認者(\"1\"), 代理承認者(\"2\")", example = "1", position = 4)
	private ApproverClass approverClass;
	
	/**
	 * MoM社員ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "MoM社員ID", required = false, position = 5, allowableValues = "range[0,255]")
	private String momEmployeeId;
}
