package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation;
import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;
import lombok.Data;

@Data
public class EstimationUpdateParameterForAuthorization {

	/**
	 * 標準用見積DTO
	 */
	Estimation estimation;

	/**
	 * 電力用見積DTO
	 */
	EstimationElectric estimationElectric;
}
