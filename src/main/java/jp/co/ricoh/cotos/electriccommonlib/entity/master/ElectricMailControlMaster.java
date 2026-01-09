package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.entity.EnumType.ServiceCategory;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricMailControlMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力通知メール制御マスタを表すEntity
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "electric_mail_control_master")
@CotosComplementTarget(entity = ElectricMailControlMaster.class, repository = ElectricMailControlMasterRepository.class)
public class ElectricMailControlMaster extends EntityBaseMaster {

	public enum ElectricNotificationTimingType {

		対象日イコール("0"), 対象日以降("1"), 期間("2"), 無し("3");

		private final String text;

		private ElectricNotificationTimingType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ElectricNotificationTimingType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_mail_control_master_seq")
	@SequenceGenerator(name = "electric_mail_control_master_seq", sequenceName = "electric_mail_control_master_seq", allocationSize = 1)
	@Schema(description = "電力通知メール制御マスタID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 対象ドメイン
	 */
	@Column(nullable = false)
	@NotNull
	@Schema(description = "対象ドメイン", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "電力_見積(\"101\"), 電力_契約(\"102\")", example = "102")
	private ServiceCategory serviceCategory;

	/**
	 * 対象トランザクションテーブル名
	 */
	@Column(nullable = true)
	@Schema(description = "対象トランザクションテーブル名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String targetTransactionTableName;

	/**
	 * 対象カラム名
	 */
	@Column(nullable = true)
	@Schema(description = "対象カラム名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String targetColumnName;

	/**
	 * 通知日差分(日)
	 */
	@Column(nullable = true)
	@Schema(description = "通知日差分(日)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer notificationDateDifference;

	/**
	 * 通知日差分(月)
	 */
	@Column(nullable = true)
	@Schema(description = "通知日差分(月)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Integer notificationMonthsDifference;

	/**
	 * 通知日差分区分
	 */
	@Column(nullable = true)
	@Schema(description = "通知日差分区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer notificationDifferenceType;

	/**
	 * 通知日タイミング区分
	 */
	@Column(nullable = false)
	@Schema(description = "通知日タイミング区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "対象日イコール(\"0\"), 対象日以降(\"1\"), 期間(\"2\"), 無し(\"3\")", example = "1")
	private ElectricNotificationTimingType electricNotificationTimingType;

	/**
	 * 宛先テーブル区分（To）
	 */
	@Column(nullable = true)
	@Schema(description = "宛先テーブル名区分（To）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactTableTypeTo;

	/**
	 * 宛先テーブル区分（Cc）
	 */
	@Column(nullable = true)
	@Schema(description = "宛先テーブル区分（Cc）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactTableTypeCc;

	/**
	 * 宛先テーブル区分（Bcc）
	 */
	@Column(nullable = true)
	@Schema(description = "宛先テーブル区分（Bcc）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String contactTableTypeBcc;

	/**
	 * 条件式追加フラグ
	 */
	@Column(nullable = false)
	@Schema(description = "条件式追加フラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int extendsQueryFlg;

	/**
	 * 条件式
	 */
	@Column(nullable = true)
	@Schema(description = "条件式", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String extendsQuery;

	/**
	 * 送信タイミング
	 */
	@Column(nullable = true)
	@Schema(description = "送信タイミング", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String mailSendTiming;

	/**
	 * 送信タイミング区分
	 */
	@Column(nullable = true)
	@Schema(description = "送信タイミング区分", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer mailSendTimingType;

	/**
	 * 追加取得電力通知メール制御マスタID
	 */
	@Column(nullable = true)
	@Schema(description = "追加取得電力通知メール制御マスタID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9999999999999999999]")
	private Long additionalMailControlMasterId;

	/**
	 * メールテンプレートマスタID
	 */
	@Column(nullable = false)
	@Schema(description = "メールテンプレートマスタID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9999999999999999999]")
	private long mailTemplateMasterId;
}
