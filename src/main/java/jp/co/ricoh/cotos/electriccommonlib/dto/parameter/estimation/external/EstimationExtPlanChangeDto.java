package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationExtPlanChangeDto {

	/**
	 * 変更元契約ID
	 */
	@Min(0)
	@ApiModelProperty(value = "契約ID", required = true, position = 3, allowableValues = "range[0,9223372036854775807]")
	private long originContractId;

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
	 * 見積（電力用）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "見積（電力用）", required = true, position = 6)
	private EstimationElectricExtDtoForPlanChange estimationElectric;

	/**
	 * 顧客（見積用）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "顧客（見積用）", required = true, position = 7)
	private CustomerEstimationExtDto customerEstimation;

	/**
	 * 見積担当SA社員
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "見積担当SA社員", required = true, position = 8)
	private EstimationPicSaEmpExtDto estimationPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "電力専任情報", required = true, position = 9)
	private ElectricExpertEstimationExtDto electricExpertEstimation;

	/**
	 * 追加編集者
	 */
	@Valid
	@ApiModelProperty(value = "追加編集者", required = false, position = 10)
	private List<EstimationAddedEditorEmpExtDto> estimationAddedEditorEmpList;

	/**
	 * 販売店情報
	 */
	@Valid
	@ApiModelProperty(value = "販売店情報", required = false, position = 11)
	private ElectricDealerEstimationExtDto electricDealerEstimation;

	/**
	 * 料金シミュレーション（本部用）
	 */
	@Valid
	@NotNull
	@ApiModelProperty(value = "料金シミュレーション（本部用）", required = true, position = 12)
	private FeeSimulationHeadExtDto feeSimulationHead;
	
	/**
	 * 取次情報
	 */
	@Valid
	@ApiModelProperty(value = "取次情報", required = false, position = 13)
	AgencyEstimationInformationExtDto agencyInformation;
	
	/**
	 * 長期割引情報
	 */
	@Valid
	@ApiModelProperty(value = "長期割引情報", required = false, position = 14)
	LongtermDiscountEstimationInformationExtDto longtermDiscountInformation;

}
