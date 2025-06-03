package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.math.BigDecimal;
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
import jp.co.ricoh.cotos.commonlib.entity.EnumType.ServiceCategory;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricApprovalRoutePatternMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力承認ルートパターンマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_approval_route_pattern_master")
@CotosComplementTarget(entity = ElectricApprovalRouteMaster.class, repository = ElectricApprovalRoutePatternMasterRepository.class)
public class ElectricApprovalRoutePatternMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_approval_route_pattern_master_seq")
	@SequenceGenerator(name = "electric_approval_route_pattern_master_seq", sequenceName = "electric_approval_route_pattern_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * パターン名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "パターン名", required = false, position = 2, allowableValues = "range[0,255]")
	private String patternName;

	/**
	 * サービスカテゴリ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "サービスカテゴリ", required = true, allowableValues = "電力_見積(\"101\"), 電力_契約(\"102\")", example = "101", position = 3)
	private ServiceCategory serviceCategory;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "電力会社", required = false, position = 4, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 粗利率（％）（営業）
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "粗利率（％）（営業）", required = false, position = 5)
	private BigDecimal grossProfitMarginBusiness;

	/**
	 * 粗利率（％）（ＲＪ）
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "粗利率（％）（ＲＪ）", required = false, position = 6)
	private BigDecimal grossProfitMarginRj;

	/**
	 * 年間電力料金
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "年間電力料金", required = false, position = 7, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal annualElectricityRateAfter;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "商流区分", required = true, position = 8, allowableValues = "直売(\"1\"), 媒介(\"2\"), 社内(\"3\"), 取次(\"4\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 電力承認ルートマスタリスト
	 */
	@OneToMany(mappedBy = "electricApprovalRoutePatternMaster")
	@ApiModelProperty(value = "電力承認ルートマスタ", required = false, position = 9)
	private List<ElectricApprovalRouteMaster> ElectricApprovalRouteMasterList;

}
