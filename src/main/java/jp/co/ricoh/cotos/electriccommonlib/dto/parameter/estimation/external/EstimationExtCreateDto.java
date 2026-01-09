package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationExtCreateDto {

	/**
	 * 案件番号
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 案件名
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "案件名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String caseTitle;

	/**
	 * 見積（電力用）
	 */
	@Valid
	@NotNull
	@Schema(description = "見積（電力用）", requiredMode = Schema.RequiredMode.REQUIRED)
	private EstimationElectricExtDtoForCreate estimationElectric;

	/**
	 * 顧客（見積用）
	 */
	@Valid
	@NotNull
	@Schema(description = "顧客（見積用）", requiredMode = Schema.RequiredMode.REQUIRED)
	private CustomerEstimationExtDto customerEstimation;

	/**
	 * 見積担当SA社員
	 */
	@Valid
	@NotNull
	@Schema(description = "見積担当SA社員", requiredMode = Schema.RequiredMode.REQUIRED)
	private EstimationPicSaEmpExtDto estimationPicSaEmp;

	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@Schema(description = "電力専任情報", requiredMode = Schema.RequiredMode.REQUIRED)
	private ElectricExpertEstimationExtDto electricExpertEstimation;

	/**
	 * 追加編集者
	 */
	@Valid
	@Schema(description = "追加編集者", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private List<EstimationAddedEditorEmpExtDto> estimationAddedEditorEmpList;

	/**
	 * 販売店情報
	 */
	@Valid
	@Schema(description = "販売店情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private ElectricDealerEstimationExtDto electricDealerEstimation;

	/**
	 * 料金シミュレーション（本部用）
	 */
	@Valid
	@NotNull
	@Schema(description = "料金シミュレーション（本部用）", requiredMode = Schema.RequiredMode.REQUIRED)
	private FeeSimulationHeadExtDto feeSimulationHead;

	/**
	 * 取次情報
	 */
	@Valid
	@Schema(description = "取次情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private AgencyEstimationInformationExtDto agencyInformation;

	/**
	 * 長期割引情報
	 */
	@Valid
	@Schema(description = "長期割引情報", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	private LongtermDiscountEstimationInformationExtDto longtermDiscountInformation;

}
