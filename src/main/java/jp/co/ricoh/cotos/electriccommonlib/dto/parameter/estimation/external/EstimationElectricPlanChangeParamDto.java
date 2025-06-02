package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.AgencyEstimationInformationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.CustomerEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.ElectricDealerEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.ElectricExpertEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationAddedEditorEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationElectricExtDtoForPlanChange;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationPicSaEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.FeeSimulationHeadExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.LongtermDiscountEstimationInformationExtDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationElectricPlanChangeParamDto {

	/**
	 * 変更元契約ID
	 */
	@NotNull
	@Min(0)
	@ApiModelProperty(value = "契約ID", required = true, position = 3, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 案件番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "案件番号", required = true, position = 4, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "案件名", required = true, position = 5, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * お客様識別番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "お客様識別番号", required = true, position = 6, allowableValues = "range[0,255]")
	private String customerNumber;

	/**
	 * 見積（電力用）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "見積（電力用）", required = true, position = 7)
	private EstimationElectricExtDtoForPlanChange estimationElectric;

	/**
	 * 顧客（見積用）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "顧客（見積用）", required = true, position = 8)
	private CustomerEstimationExtDto customerEstimation;

	/**
	 * 見積担当SA社員
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "見積担当SA社員", required = true, position = 9)
	private EstimationPicSaEmpExtDto estimationPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "電力専任情報", required = true, position = 10)
	private ElectricExpertEstimationExtDto electricExpertEstimation;

	/**
	 * 追加編集者
	 */
	@Valid
	@ApiModelProperty(value = "追加編集者", required = false, position = 11)
	private List<EstimationAddedEditorEmpExtDto> estimationAddedEditorEmpList;

	/**
	 * 販売店情報
	 */
	@Valid
	@ApiModelProperty(value = "販売店情報", required = false, position = 12)
	private ElectricDealerEstimationExtDto electricDealerEstimation;

	/**
	 * 料金シミュレーション（本部用）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "料金シミュレーション（本部用）", required = true, position = 13)
	private FeeSimulationHeadExtDto feeSimulationHead;

	/**
	 * 取次情報
	 */
	@Valid
	@ApiModelProperty(value = "取次情報", required = false, position = 14)
	AgencyEstimationInformationExtDto agencyInformation;

	/**
	 * 長期割引情報
	 */
	@Valid
	@ApiModelProperty(value = "長期割引情報", required = false, position = 15)
	LongtermDiscountEstimationInformationExtDto longtermDiscountInformation;
}