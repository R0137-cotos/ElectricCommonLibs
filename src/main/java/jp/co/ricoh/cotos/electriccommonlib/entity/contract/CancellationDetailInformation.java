package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationDetailInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 解約詳細情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "cancellation_detail_information")
@CotosComplementTarget(entity = CancellationDetailInformation.class, repository = CancellationDetailInformationRepository.class)
public class CancellationDetailInformation extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancellation_detail_information_seq")
	@SequenceGenerator(name = "cancellation_detail_information_seq", sequenceName = "cancellation_detail_information_seq", allocationSize = 1)
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
	 * 廃止申込日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "廃止申込日", required = false, position = 3)
	private Date cancellationEntryDate;

	/**
	 * 変更先電力会社-登録番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "変更先電力会社-登録番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String powerCompanyAfterChangeCode;

	/**
	 * 変更先電力会社-名称
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "変更先電力会社-名称", required = false, position = 5, allowableValues = "range[0,255]")
	private String powerCompanyAfterChangeName;

	/**
	 * 変更先電力会社-不明フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "変更先電力会社-不明フラグ", required = false, position = 6, allowableValues = "range[0,9]")
	private Integer powerCompanyAfterChangeUnknownFlg;

	/**
	 * 変更先電力会社-備考
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "変更先電力会社-備考", required = false, position = 7, allowableValues = "range[0,4000]")
	private String powerCompanyAfterChangeNote;

	/**
	 * 受電設備の解体フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "受電設備の解体フラグ", required = false, position = 8, allowableValues = "range[0,9]")
	private Integer equipmentDismantlingFlg;

	/**
	 * 解体予定日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "解体予定日", required = false, position = 9)
	private Date dismantlingExpectedDate;

	/**
	 * 解体予定時刻
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "解体予定時刻", required = false, position = 10, allowableValues = "range[0,255]")
	private String dismantlingExpectedTime;

	/**
	 * 供給設備の撤去希望日
	 */
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "供給設備の撤去希望日", required = false, position = 11)
	private Date removalHopeDate;

	/**
	 * 供給設備の撤去希望時刻指定有無フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "供給設備の撤去希望時刻指定有無フラグ", required = false, position = 12, allowableValues = "range[0,9]")
	private Integer removalHopeTimeFlg;

	/**
	 * 供給設備の撤去希望時刻
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "供給設備の撤去希望時刻", required = false, position = 13, allowableValues = "range[0,255]")
	private String removalHopeTime;

	/**
	 * 立会可否フラグ
	 */
	@Column(nullable = true)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "立会可否フラグ", required = false, position = 14, allowableValues = "range[0,9]")
	private Integer witnessingFlg;

	/**
	 * 立合者氏名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "立合者氏名", required = false, position = 15, allowableValues = "range[0,255]")
	private String witnessingName;

	/**
	 * 廃止申込書用-企業名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "廃止申込書用-企業名", required = false, position = 16, allowableValues = "range[0,255]")
	private String reportCompanyName;

	/**
	 * 廃止申込書用-事業所名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "廃止申込書用-事業所名", required = false, position = 17, allowableValues = "range[0,255]")
	private String reportOfficeName;

	/**
	 * 廃止申込書用-住所
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "廃止申込書用-住所", required = false, position = 18, allowableValues = "range[0,1000]")
	private String reportAddress;

	/**
	 * 廃止申込書用-担当者氏名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "廃止申込書用-担当者氏名", required = false, position = 19, allowableValues = "range[0,255]")
	private String reportPicName;

	/**
	 * 廃止申込書用-担当者部署
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "廃止申込書用-担当者部署", required = false, position = 20, allowableValues = "range[0,255]")
	private String reportPicDeptName;

	/**
	 * 廃止申込書用-担当者電話番号
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "廃止申込書用-担当者電話番号", required = false, position = 21, allowableValues = "range[0,255]")
	private String reportPicPhoneNumber;

}
