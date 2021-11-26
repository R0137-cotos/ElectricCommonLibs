package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 解約情報
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "cancellation_information_id", referencedColumnName = "id")
	@ApiModelProperty(value = "解約情報", required = true, position = 2)
	@JsonIgnore
	private CancellationInformation cancellationInformation;

	/**
	 * 需要消滅種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "需要消滅種別", required = false, position = 3, allowableValues = "移転(\"1\"), 売却(\"2\"), 閉鎖(\"3\"), 建替え(\"4\"), 使用停止(\"5\"), 低圧⇔高圧(\"6\")", example = "1")
	private DemandDisappearsType demandDisappearsType;

	/**
	 * 他社切替-リコージャパンより削減効果が大きい
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-リコージャパンより削減効果が大きい", required = false, position = 4, allowableValues = "range[0,9]")
	private Integer switchingReductionEffectFlg;

	/**
	 * 他社切替-切替先と取引関係がある
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-切替先と取引関係がある", required = false, position = 5, allowableValues = "range[0,9]")
	private Integer switchingBuisinessRelationFlg;

	/**
	 * 他社切替-リコージャパンの対応に不満
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-リコージャパンの対応に不満", required = false, position = 6, allowableValues = "range[0,9]")
	private Integer switchingComplainFlg;

	/**
	 * 他社切替-不満（営業）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-不満（営業）", required = false, position = 7, allowableValues = "range[0,9]")
	private Integer switchingComplainBusinessFlg;

	/**
	 * 他社切替-不満（コールセンター）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-不満（コールセンター）", required = false, position = 8, allowableValues = "range[0,9]")
	private Integer switchingComplainCcFlg;

	/**
	 * 他社切替-不満（本部）
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-不満（本部）", required = false, position = 9, allowableValues = "range[0,9]")
	private Integer switchingComplainHeadFlg;

	/**
	 * 他社切替-その他
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-その他", required = false, position = 10, allowableValues = "range[0,9]")
	private Integer switchingOtherFlg;

	/**
	 * 他社切替-その他記述
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "他社切替-その他記述", required = false, position = 11, allowableValues = "range[0,255]")
	private String switchingOtherNote;
}
