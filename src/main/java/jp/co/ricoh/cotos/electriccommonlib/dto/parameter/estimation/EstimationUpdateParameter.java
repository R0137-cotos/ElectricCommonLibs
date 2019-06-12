package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
	@NotNull
	EstimationDto estimationDto;

	/**
	 * 電力用見積DTO
	 */
	@Valid
	@NotNull
	EstimationElectricDto estimationElectricDto;
}