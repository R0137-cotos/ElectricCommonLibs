package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationDetailInformation;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationDetailInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = CancellationDetailInformation.class, repository = CancellationDetailInformationRepository.class)
public class CancellationDetailInformationDto extends DtoBase {

	/**
	 * 廃止申込日
	 */
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "廃止申込日", required = false, position = 3)
	private Date cancellationEntryDate;

	/**
	 * 変更先電力会社-登録番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "変更先電力会社-登録番号", required = false, position = 4, allowableValues = "range[0,255]")
	private String powerCompanyAfterChangeCode;

	/**
	 * 変更先電力会社-名称
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "変更先電力会社-名称", required = false, position = 5, allowableValues = "range[0,255]")
	private String powerCompanyAfterChangeName;

	/**
	 * 変更先電力会社-不明フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "変更先電力会社-不明フラグ", required = false, position = 6, allowableValues = "range[0,9]")
	private Integer powerCompanyAfterChangeUnknownFlg;

	/**
	 * 変更先電力会社-備考
	 */
	@Size(max = 4000)
	@ApiModelProperty(value = "変更先電力会社-備考", required = false, position = 7, allowableValues = "range[0,4000]")
	private String powerCompanyAfterChangeNote;

	/**
	 * 受電設備の解体フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "受電設備の解体フラグ", required = false, position = 8, allowableValues = "range[0,9]")
	private Integer equipmentDismantlingFlg;

	/**
	 * 解体予定日
	 */
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "解体予定日", required = false, position = 9)
	private Date dismantlingExpectedDate;

	/**
	 * 解体予定時刻指定有無フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "解体予定時刻指定有無フラグ", required = false, position = 10, allowableValues = "range[0,9]")
	private Integer dismantlingExpectedTimeFlg;

	/**
	 * 解体予定時刻
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "解体予定時刻", required = false, position = 11, allowableValues = "range[0,255]")
	private String dismantlingExpectedTime;

	/**
	 * 供給設備の撤去希望日
	 */
	@Temporal(TemporalType.DATE)
	@ApiModelProperty(value = "供給設備の撤去希望日", required = false, position = 12)
	private Date removalHopeDate;

	/**
	 * 供給設備の撤去希望時刻指定有無フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "供給設備の撤去希望時刻指定有無フラグ", required = false, position = 13, allowableValues = "range[0,9]")
	private Integer removalHopeTimeFlg;

	/**
	 * 供給設備の撤去希望時刻
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "供給設備の撤去希望時刻", required = false, position = 14, allowableValues = "range[0,255]")
	private String removalHopeTime;

	/**
	 * 立会可否フラグ
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "立会可否フラグ", required = false, position = 15, allowableValues = "range[0,9]")
	private Integer witnessingFlg;

	/**
	 * 立合者氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "立合者氏名", required = false, position = 16, allowableValues = "range[0,255]")
	private String witnessingName;

	/**
	 * 廃止申込書用-企業名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-企業名", required = false, position = 17, allowableValues = "range[0,255]")
	private String reportCompanyName;

	/**
	 * 廃止申込書用-事業所名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-事業所名", required = false, position = 18, allowableValues = "range[0,255]")
	private String reportOfficeName;

	/**
	 * 廃止申込書用-住所
	 */
	@Size(max = 1000)
	@ApiModelProperty(value = "廃止申込書用-住所", required = false, position = 19, allowableValues = "range[0,1000]")
	private String reportAddress;

	/**
	 * 廃止申込書用-担当者氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-担当者氏名", required = false, position = 20, allowableValues = "range[0,255]")
	private String reportPicName;

	/**
	 * 廃止申込書用-担当者部署
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-担当者部署", required = false, position = 21, allowableValues = "range[0,255]")
	private String reportPicDeptName;

	/**
	 * 廃止申込書用-担当者電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-担当者電話番号", required = false, position = 22, allowableValues = "range[0,255]")
	private String reportPicPhoneNumber;

	/**
	 * 廃止申込書用-電気主任技術者氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-電気主任技術者氏名", required = false, position = 23, allowableValues = "range[0,255]")
	private String reportLicensedEngineerName;

	/**
	 * 廃止申込書用-電気主任技術者電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-電気主任技術者電話番号", required = false, position = 24, allowableValues = "range[0,255]")
	private String reportLicensedEngineerTel;

	/**
	 * 廃止申込書用-電気主任技術者所属名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "廃止申込書用-電気主任技術者所属名", required = false, position = 25, allowableValues = "range[0,255]")
	private String reportLicensedEngineerDep;
}
