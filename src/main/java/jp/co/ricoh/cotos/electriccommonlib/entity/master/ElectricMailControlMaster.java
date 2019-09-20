package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "電力通知メール制御マスタID", required = true, position = 1, allowableValues = "range[0,9999999999999999999]")
	private long id;

	/**
	 * 対象ドメイン
	 */
	@Column(nullable = false)
	@NotNull
	@ApiModelProperty(value = "対象ドメイン", required = true, allowableValues = "電力_見積(\"101\"), 電力_契約(\"102\")", example = "102", position = 2)
	private ServiceCategory serviceCategory;

	/**
	 * 対象トランザクションテーブル名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "対象トランザクションテーブル名", required = false, position = 3, allowableValues = "range[0,255]")
	private String targetTransactionTableName;

	/**
	 * 対象カラム名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "対象カラム名", required = false, position = 4, allowableValues = "range[0,255]")
	private String targetColumnName;

	/**
	 * 通知日差分(日)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "通知日差分(日)", required = false, position = 5)
	private Integer notificationDateDifference;

	/**
	 * 通知日差分(月)
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "通知日差分(月)", required = false, position = 6)
	private Integer notificationMonthsDifference;

	/**
	 * 通知日差分区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "通知日差分区分", required = false, position = 7, allowableValues = "range[0,9]")
	private Integer notificationDifferenceType;

	/**
	 * 通知日タイミング区分
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "通知日タイミング区分", required = true, allowableValues = "対象日イコール(\"0\"), 対象日以降(\"1\"), 期間(\"2\"), 無し(\"3\")", example = "1", position = 8)
	private ElectricNotificationTimingType electricNotificationTimingType;

	/**
	 * 宛先テーブル区分（To）
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "宛先テーブル名区分（To）", required = false, position = 9, allowableValues = "range[0,255]")
	private String contactTableTypeTo;

	/**
	 * 宛先テーブル区分（Cc）
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "宛先テーブル区分（Cc）", required = false, position = 10, allowableValues = "range[0,255]")
	private String contactTableTypeCc;

	/**
	 * 宛先テーブル区分（Bcc）
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "宛先テーブル区分（Bcc）", required = false, position = 11, allowableValues = "range[0,255]")
	private String contactTableTypeBcc;

	/**
	 * 条件式追加フラグ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "条件式追加フラグ", required = true, position = 12, allowableValues = "range[0,9]")
	private int extendsQueryFlg;

	/**
	 * 条件式
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "条件式", required = false, position = 13, allowableValues = "range[0,255]")
	private String extendsQuery;

	/**
	 * 送信タイミング
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "送信タイミング", required = false, position = 14, allowableValues = "range[0,255]")
	private String mailSendTiming;

	/**
	 * 送信タイミング区分
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "送信タイミング区分", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer mailSendTimingType;

	/**
	 * 追加取得電力通知メール制御マスタID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "追加取得電力通知メール制御マスタID", required = false, position = 16, allowableValues = "range[0,9999999999999999999]")
	private long additionalMailControlMasterId;

	/**
	 * メールテンプレートマスタID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "メールテンプレートマスタID", required = true, position = 17, allowableValues = "range[0,9999999999999999999]")
	private long mailTemplateMasterId;
}
