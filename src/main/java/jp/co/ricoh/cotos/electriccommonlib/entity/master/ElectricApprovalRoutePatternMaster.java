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

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * パターン名
	 */
	@Column(nullable = true)
	@Schema(description = "パターン名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String patternName;

	/**
	 * サービスカテゴリ
	 */
	@Column(nullable = false)
	@Schema(description = "サービスカテゴリ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "電力_見積(\"101\"), 電力_契約(\"102\")", example = "101")
	private ServiceCategory serviceCategory;

	/**
	 * 電力会社
	 */
	@Column(nullable = true)
	@Schema(description = "電力会社", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerCompany;

	/**
	 * 粗利率（％）（営業）
	 */
	@Column(nullable = true)
	@Schema(description = "粗利率（％）（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal grossProfitMarginBusiness;

	/**
	 * 粗利率（％）（ＲＪ）
	 */
	@Column(nullable = true)
	@Schema(description = "粗利率（％）（ＲＪ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private BigDecimal grossProfitMarginRj;

	/**
	 * 年間電力料金
	 */
	@Column(nullable = true)
	@Schema(description = "年間電力料金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal annualElectricityRateAfter;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "直売(\"1\"), 媒介(\"2\"), 社内(\"3\"), 取次(\"4\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 電力承認ルートマスタリスト
	 */
	@OneToMany(mappedBy = "electricApprovalRoutePatternMaster")
	@Schema(description = "電力承認ルートマスタ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<ElectricApprovalRouteMaster> ElectricApprovalRouteMasterList;

}
