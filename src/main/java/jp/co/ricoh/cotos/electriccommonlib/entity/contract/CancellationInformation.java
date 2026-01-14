package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 解約情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "cancellation_information")
@CotosComplementTarget(entity = CancellationInformation.class, repository = CancellationInformationRepository.class)
public class CancellationInformation extends EntityBase {

	public enum CancellationReason {

		倒産("1"), 会社統合("2"), 事業所閉鎖("3"), 強制解約("4"), 未払い("5"), 約款に違反し申し出ても是正されない("6");

		private final String text;

		private CancellationReason(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static CancellationReason fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum CancellationAmountType {

		満額請求("1"), 減額請求("2"), 免除("3");

		private final String text;

		private CancellationAmountType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static CancellationAmountType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancellation_information_seq")
	@SequenceGenerator(name = "cancellation_information_seq", sequenceName = "cancellation_information_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 解約希望日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@Schema(description = "解約希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationHopeDate;

	/**
	 * 送電停止施行指定フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "送電停止施行指定フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer transmissionStopFlg;

	/**
	 * 指定時刻
	 */
	@Column(nullable = true)
	@Schema(description = "指定時刻", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String specifiedTime;

	/**
	 * 解約日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@Schema(description = "解約日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationDate;

	/**
	 * 解約理由
	 * ※解約理由情報エンティティに移行するため以後、未使用
	 */
	@Column(nullable = true)
	@Schema(description = "解約理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "その他(\"1\")", example = "1")
	private CancellationReason cancellationReason;

	/**
	 * その他備考
	 */
	@Column(nullable = true)
	@Schema(description = "その他備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String notesOther;

	/**
	 * 解約金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "解約金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal cancellationAmount;

	/**
	 * 調整後金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "調整後金額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal adjustmentAmount;

	/**
	 * 清算金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "清算金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal liquidationAmount;

	/**
	 * 調整後(清算金)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "調整後(清算金)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal adjustmentLiquidationAmount;

	/**
	 * 違約金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "違約金", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal penaltyAmount;

	/**
	 * 調整後(違約金)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@Schema(description = "調整後(違約金)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal adjustmentPenaltyAmount;

	/**
	 * 解約金請求フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "解約金請求フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer cancellationBillingFlg;

	/**
	 * 非請求理由
	 */
	@Column(nullable = true)
	@Schema(description = "非請求理由", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String nonBillingReason;

	/**
	 * 上長確認フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@Schema(description = "上長確認フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer superiorConfirmFlg;

	/**
	 * 解約種別
	 */
	@Column(nullable = true)
	@Schema(description = "解約種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "消滅(\"1\"), 他社への切り替え_お客様申込(\"2\"), 他社への切り替え_広域申込(\"3\"), 無し(\"99\")", example = "1")
	private CancellationDiv cancellationDiv;

	/**
	 * 手配結果登録確定日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@Schema(description = "手配結果登録確定日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date registerArrangedDate;

	/**
	 * （解約手続時点）需給（供給）期間 終了日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@Schema(description = "（解約手続時点）需給（供給）期間 終了日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date contractYmdEndAtCancellation;

	/**
	 * 解約金額分類
	 */
	@Column(nullable = true)
	@Schema(description = "解約金額分類", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "満額請求(\"1\"), 減額請求(\"2\"), 免除(\"3\")")
	private CancellationAmountType cancellationAmountType;

	/**
	 * 解約詳細情報
	 */
	@OneToOne(mappedBy = "cancellationInformation")
	@Schema(description = "解約詳細情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationDetailInformation cancellationDetailInformation;

	/**
	 * 解約理由情報
	 */
	@OneToOne(mappedBy = "cancellationInformation")
	@Schema(description = "解約理由情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private CancellationReasonInformation cancellationReasonInformation;
}
