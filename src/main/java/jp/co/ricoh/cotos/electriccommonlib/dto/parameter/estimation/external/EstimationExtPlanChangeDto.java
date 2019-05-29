package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationExtPlanChangeDto extends DtoBase {

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
	private String caseNumer;

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
	private EstimationElectricExtDto estimationElectricExtDto;

	/**
	 * 顧客（見積用）
	 */
	@Valid
	private CustomerEstimationExtDto customerEstimationExtDto;

	/**
	 * 見積担当SA社員
	 */
	@Valid
	private EstimationPicSaEmpExtDto estimationPicSaEmpExtDto;

	/**
	 * 電力専任情報
	 */
	@Valid
	private ElectricExpertEstimationExtDto electricExpertEstimationExtDto;

	/**
	 * 追加編集者
	 */
	@Valid
	private List<EstimationAddedEditorEmpExtDto> estimationAddedEditorEmpExtDtoList;

	/**
	 * 販売店情報
	 */
	@Valid
	private ElectricDealerEstimationExtDto electricDealerEstimationExtDto;

	/**
	 * 料金シミュレーション（本部用）
	 */
	@Valid
	private FeeSimulationHeadExtDto feeSimulationHeadExtDto;

}
