package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.Domain;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
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
	
	public enum CancellationDiv {

		消滅("1"), 他社への切り替え_お客様申込("2"), 他社への切り替え_広域申込("3"), 無し("99");

		private final String text;

		private CancellationDiv(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static CancellationDiv fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_form_master_seq")
	@SequenceGenerator(name = "electric_form_master_seq", sequenceName = "electric_form_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "高圧(\"1\"), 低圧(\"2\")", example = "1")
	private VoltageCategory voltageCategory;

	/**
	 * 商流区分
	 */
	@Column(nullable = false)
	@Schema(description = "商流区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "直売(\"1\"), 代売(\"2\")", example = "1")
	private ElectricCommercialFlowDiv electricCommercialFlowDiv;

	/**
	 * 電力プラン
	 */
	@Column(nullable = false)
	@Schema(description = "電力プラン", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "CO2フリー(\"1\"), それ以外(\"2\"), 無し(\"99\")", example = "1")
	private ElectricPlan electricPlan;

	/**
	 * 解約種別
	 */
	@Column(nullable = false)
	@Schema(description = "解約種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "需要消滅(\"1\"), 購入先変更(\"2\"), 無し(\"99\")", example = "1")
	private CancellationDiv cancellationDiv;

	/**
	 * 解約金発生フラグ
	 */
	@Column(nullable = false)
	@Schema(description = "解約金発生フラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int cancellationMoneyGeneratedFlg;

	/**
	 * 電力用ファイル種別
	 */
	@Column(nullable = false)
	@Schema(description = "電力用ファイル種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "新規(\"1\"), 変更(\"2\"),解約(\"3\"), その他(\"99\")", example = "1")
	private ElectricFileType electricFileType;

	/**
	 * ドメイン
	 */
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	@Schema(description = "ドメイン", requiredMode = Schema.RequiredMode.REQUIRED)
	private Domain domain;

	/**
	 * 帳票パターンID
	 */
	@Column
	@Schema(description = "帳票パターンID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Long formPatternId;

	@ManyToMany
	@JoinTable(name = "form_ident", joinColumns = @JoinColumn(name = "electric_form_master_id"), inverseJoinColumns = @JoinColumn(name = "electric_form_ident_master_id"))
	@Schema(description = "電力帳票マスタ", requiredMode = Schema.RequiredMode.REQUIRED)
	private List<ElectricFormIdentMaster> electricFormIdentMasterList;
}
