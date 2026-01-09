package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationReasonInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 解約理由情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "cancellation_reason_information")
@CotosComplementTarget(entity = CancellationReasonInformation.class, repository = CancellationReasonInformationRepository.class)
public class CancellationReasonInformation extends EntityBase {

	public enum DemandDisappearsType {

		移転("1"), 売却("2"), 閉鎖("3"), 建替え("4"), 使用停止("5"), 低圧ー高圧("6", "低圧⇔高圧"), 事業譲渡("7");

		private final String text;
		private final String label;

		private DemandDisappearsType(final String text, final String label) {
			this.text = text;
			this.label = label;
		}

		private DemandDisappearsType(final String text) {
			this.text = text;
			this.label = null;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		public String getLabel() {
			if (StringUtils.isNotEmpty(this.label)) {
				return this.label;
			} else {
				return this.name();
			}
		}

		@JsonCreator
		public static DemandDisappearsType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancellation_reason_information_seq")
	@SequenceGenerator(name = "cancellation_reason_information_seq", sequenceName = "cancellation_reason_information_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 解約情報
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "cancellation_information_id", referencedColumnName = "id")
	@Schema(description = "解約情報", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private CancellationInformation cancellationInformation;

	/**
	 * 需要消滅種別
	 */
	@Column(nullable = true)
	@Schema(description = "需要消滅種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "移転(\"1\"), 売却(\"2\"), 閉鎖(\"3\"), 建替え(\"4\"), 使用停止(\"5\"), 低圧⇔高圧(\"6\")", example = "1")
	private DemandDisappearsType demandDisappearsType;

	/**
	 * 他社切替-リコージャパンより削減効果が大きい
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-リコージャパンより削減効果が大きい", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingReductionEffectFlg;

	/**
	 * 他社切替-切替先と取引関係がある
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-切替先と取引関係がある", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingBuisinessRelationFlg;

	/**
	 * 他社切替-リコージャパンの対応に不満
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-リコージャパンの対応に不満", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingComplainFlg;

	/**
	 * 他社切替-不満（営業）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-不満（営業）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingComplainBusinessFlg;

	/**
	 * 他社切替-不満（コールセンター）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-不満（コールセンター）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingComplainCcFlg;

	/**
	 * 他社切替-不満（本部）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-不満（本部）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingComplainHeadFlg;

	/**
	 * 他社切替-その他
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "他社切替-その他", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer switchingOtherFlg;

	/**
	 * 他社切替-その他記述
	 */
	@Column(nullable = true)
	@Schema(description = "他社切替-その他記述", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String switchingOtherNote;
}
