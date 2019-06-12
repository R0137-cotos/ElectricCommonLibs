package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import javax.validation.Valid;

import jp.co.ricoh.cotos.commonlib.dto.parameter.estimation.EstimationDto;
import lombok.Data;

/**
 * 見積を登録・更新するためのキー項目クラスを表します。
 */
@Data
public class EstimationUpdateParameter {

	/**
	 * 標準用見積DTO
	 */
	@Valid
	EstimationDto estimationDto;

	/**
	 * 電力用見積DTO
	 */
	@Valid
	EstimationElectricDto estimationElectricDto;
}