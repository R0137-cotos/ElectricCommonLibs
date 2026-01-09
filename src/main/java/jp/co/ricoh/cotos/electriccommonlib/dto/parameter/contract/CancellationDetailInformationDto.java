package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "廃止申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date cancellationEntryDate;

	/**
	 * 変更先電力会社-登録番号
	 */
	@Size(max = 255)
	@Schema(description = "変更先電力会社-登録番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerCompanyAfterChangeCode;

	/**
	 * 変更先電力会社-名称
	 */
	@Size(max = 255)
	@Schema(description = "変更先電力会社-名称", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String powerCompanyAfterChangeName;

	/**
	 * 変更先電力会社-不明フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "変更先電力会社-不明フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer powerCompanyAfterChangeUnknownFlg;

	/**
	 * 変更先電力会社-備考
	 */
	@Size(max = 4000)
	@Schema(description = "変更先電力会社-備考", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,4000]")
	private String powerCompanyAfterChangeNote;

	/**
	 * 受電設備の解体フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "受電設備の解体フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer equipmentDismantlingFlg;

	/**
	 * 解体予定日
	 */
	@Temporal(TemporalType.DATE)
	@Schema(description = "解体予定日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date dismantlingExpectedDate;

	/**
	 * 解体予定時刻
	 */
	@Size(max = 255)
	@Schema(description = "解体予定時刻", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String dismantlingExpectedTime;

	/**
	 * 供給設備の撤去希望日
	 */
	@Temporal(TemporalType.DATE)
	@Schema(description = "供給設備の撤去希望日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private Date removalHopeDate;

	/**
	 * 供給設備の撤去希望時刻指定有無フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "供給設備の撤去希望時刻指定有無フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer removalHopeTimeFlg;

	/**
	 * 供給設備の撤去希望時刻
	 */
	@Size(max = 255)
	@Schema(description = "供給設備の撤去希望時刻", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String removalHopeTime;

	/**
	 * 立会可否フラグ
	 */
	@Max(9)
	@Min(0)
	@Schema(description = "立会可否フラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9]")
	private Integer witnessingFlg;

	/**
	 * 立合者氏名
	 */
	@Size(max = 255)
	@Schema(description = "立合者氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String witnessingName;

	/**
	 * 廃止申込書用-企業名
	 */
	@Size(max = 255)
	@Schema(description = "廃止申込書用-企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String reportCompanyName;

	/**
	 * 廃止申込書用-事業所名
	 */
	@Size(max = 255)
	@Schema(description = "廃止申込書用-事業所名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String reportOfficeName;

	/**
	 * 廃止申込書用-住所
	 */
	@Size(max = 1000)
	@Schema(description = "廃止申込書用-住所", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String reportAddress;

	/**
	 * 廃止申込書用-担当者氏名
	 */
	@Size(max = 255)
	@Schema(description = "廃止申込書用-担当者氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String reportPicName;

	/**
	 * 廃止申込書用-担当者部署
	 */
	@Size(max = 255)
	@Schema(description = "廃止申込書用-担当者部署", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String reportPicDeptName;

	/**
	 * 廃止申込書用-担当者電話番号
	 */
	@Size(max = 255)
	@Schema(description = "廃止申込書用-担当者電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String reportPicPhoneNumber;

}
