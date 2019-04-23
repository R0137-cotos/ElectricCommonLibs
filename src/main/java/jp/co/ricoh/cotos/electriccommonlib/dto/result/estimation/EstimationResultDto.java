package jp.co.ricoh.cotos.electriccommonlib.dto.result.estimation;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EstimationResultDto {

	/**
	 * 見積(標準)
	 */
	@ApiModelProperty(value = "見積(標準)", required = true, position = 1)
	private Estimation estimation;

	/**
	 * 見積(電力)
	 */
	@ApiModelProperty(value = "見積(電力)", required = true, position = 2)
	private EstimationElectric estimationElectric;

}