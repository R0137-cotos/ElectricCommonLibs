package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.Domain;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力帳票マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_form_master")
@CotosComplementTarget(entity = ElectricFormMaster.class, repository = ElectricFormMasterRepository.class)
public class ElectricFormMaster extends EntityBaseMaster {

	public enum ElectricPlan {

		CO2フリー("1"), それ以外("2"), 無し("99");

		private final String text;

		private ElectricPlan(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ElectricPlan fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum ElectricFileType {

		新規("1"), 変更("2"), 解約("3"), その他("99");

		private final String text;

		private ElectricFileType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ElectricFileType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_form_master_seq")
	@SequenceGenerator(name = "electric_form_master_seq", sequenceName = "electric_form_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力区分", required = true, position = 2, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "商流区分", required = true, position = 3, allowableValues = "直売(\"1\"), 代売(\"2\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 電力プラン
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力プラン", required = true, position = 4, allowableValues = "CO2フリー(\"1\"), それ以外(\"2\"), 無し(\"99\")", example = "1")
	private ElectricPlan electricPlan;

	/**
	 * 解約種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "解約種別", required = true, position = 5, allowableValues = "需要消滅(\"1\"), 購入先変更(\"2\")", example = "1")
	private CancellationDiv cancellationDiv;

	/**
	 * 解約金発生フラグ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "解約金発生フラグ", required = true, position = 6, allowableValues = "range[0,9]")
	private int cancellationMoneyGeneratedFlg;

	/**
	 * 電力用ファイル種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力用ファイル種別", required = true, position = 7, allowableValues = "新規(\"1\"), 変更(\"2\"),解約(\"3\"), その他(\"99\")", example = "1")
	private ElectricFileType electricFileType;

	/**
	 * ドメイン
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "ドメイン", required = true, position = 8)
	private Domain domain;

	@ManyToMany
	@JoinTable(name = "form_ident", joinColumns = @JoinColumn(name = "electric_form_master_id"), inverseJoinColumns = @JoinColumn(name = "electric_form_ident_master_id"))
	@ApiModelProperty(value = "電力帳票マスタ", required = true, position = 9)
	private List<ElectricFormIdentMaster> electricFormIdentMasterList;
}
