package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricApprovalRouteMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 承認ルートマスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_approval_route_master")
@CotosComplementTarget(entity = ElectricApprovalRouteMaster.class, repository = ElectricApprovalRouteMasterRepository.class)
public class ElectricApprovalRouteMaster extends EntityBaseMaster {

	public enum RouteDiv {

		北日本("1"), 首都圏("2"), 中部("3"), 関西("4"), 西日本("5"), 共通("99");

		private final String text;

		private RouteDiv(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static RouteDiv fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_approval_route_master_seq")
	@SequenceGenerator(name = "electric_approval_route_master_seq", sequenceName = "electric_approval_route_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力エリアマスタ
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "electric_area_master_id", referencedColumnName = "id")
	@ApiModelProperty(value = "電力エリアマスタ", required = true, position = 2)
	@JsonIgnore
	private ElectricAreaMaster electricAreaMaster;

	/**
	 * ルート種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ルート種別", required = true, allowableValues = "北日本(\"1\"), 首都圏(\"2\"), 中部(\"3\"), 関西(\"4\"), 西日本(\"5\"), 共通(\"99\")", example = "1", position = 3)
	private RouteDiv routeDiv;

	/**
	 * 承認ルート名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "MoM社員ID", required = true, position = 4, allowableValues = "range[0,255]")
	private String approvalRouteName;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "説明", required = false, position = 5, allowableValues = "range[0,255]")
	private String description;

	/**
	 * ルート条件式
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ルート条件式", required = false, position = 6, allowableValues = "range[0,]")
	private String routeConditionFormula;

	/**
	 * 条件判定順
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "条件判定順", required = false, position = 7, allowableValues = "range[0,999]")
	private int condDetermineOrder;

	/**
	 * 承認ルートノードマスタ
	 */
	@OneToMany(mappedBy = "electricApprovalRouteMaster")
	@ApiModelProperty(value = "承認ルートノードマスタ", required = true, position = 8)
	private List<ElectricApprovalRouteNodeMaster> ElectricApprovalRouteNodeMasterList;
}
