package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
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

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancellation_information_seq")
	@SequenceGenerator(name = "cancellation_information_seq", sequenceName = "cancellation_information_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * 解約希望日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "解約希望日", required = false, position = 3)
	private Date cancellationHopeDate;

	/**
	 * 送電停止施行指定フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "送電停止施行指定フラグ", required = false, position = 4, allowableValues = "range[0,9]")
	private Integer transmissionStopFlg;

	/**
	 * 指定時刻
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "指定時刻", required = false, position = 5, allowableValues = "range[0,255]")
	private String specifiedTime;

	/**
	 * 解約日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "解約日", required = false, position = 6)
	private Date cancellationDate;

	/**
	 * 解約理由
	 * ※解約理由情報エンティティに移行するため以後、未使用
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "解約理由", required = false, position = 7, allowableValues = "その他(\"1\")", example = "1")
	private CancellationReason cancellationReason;

	/**
	 * その他備考
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "その他備考", required = false, position = 8, allowableValues = "range[0,4000]")
	private String notesOther;

	/**
	 * 解約金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "解約金額", required = false, position = 9, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal cancellationAmount;

	/**
	 * 調整後金額
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "調整後金額", required = false, position = 10, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal adjustmentAmount;

	/**
	 * 清算金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "清算金", required = false, position = 11, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal liquidationAmount;

	/**
	 * 調整後(清算金)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "調整後(清算金)", required = false, position = 12, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal adjustmentLiquidationAmount;

	/**
	 * 違約金
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "違約金", required = false, position = 13, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal penaltyAmount;

	/**
	 * 調整後(違約金)
	 */
	@Column(nullable = true)
	@DecimalMin("0.00")
	@Digits(integer = 17, fraction = 2)
	@ApiModelProperty(value = "調整後(違約金)", required = false, position = 14, allowableValues = "range[0.00,99999999999999999.99]")
	private BigDecimal adjustmentPenaltyAmount;

	/**
	 * 解約金請求フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "解約金請求フラグ", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer cancellationBillingFlg;

	/**
	 * 非請求理由
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "非請求理由", required = false, position = 16, allowableValues = "range[0,4000]")
	private String nonBillingReason;

	/**
	 * 上長確認フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "上長確認フラグ", required = false, position = 17, allowableValues = "range[0,9]")
	private Integer superiorConfirmFlg;

	/**
	 * 解約種別
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "解約種別", required = false, position = 18, allowableValues = "消滅(\"1\"), 他社への切り替え_お客様申込(\"2\"), 他社への切り替え_広域申込(\"3\"), 無し(\"99\")", example = "1")
	private CancellationDiv cancellationDiv;

	/**
	 * 手配結果登録確定日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "手配結果登録確定日", required = false, position = 21)
	private Date registerArrangedDate;

	/**
	 * （解約手続時点）需給（供給）期間 終了日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "（解約手続時点）需給（供給）期間 終了日", required = false, position = 22)
	private Date contractYmdEndAtCancellation;

	/**
	 * 解約詳細情報
	 */
	@OneToOne(mappedBy = "cancellationInformation")
	@ApiModelProperty(value = "解約詳細情報", required = false, position = 23)
	private CancellationDetailInformation cancellationDetailInformation;

	/**
	 * 解約理由情報
	 */
	@OneToOne(mappedBy = "cancellationInformation")
	@ApiModelProperty(value = "解約理由情報", required = false, position = 24)
	private CancellationReasonInformation cancellationReasonInformation;
}
