package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jp.co.ricoh.cotos.commonlib.dto.parameter.contract.ContractDto;
import lombok.Data;

/**
 * 契約を登録・更新するためのキー項目クラスを表します。
 */
@Data
public class ContractUpdateParameter {

	/**
	 * 標準用契約DTO
	 */
	ContractDto contractDto;

	/**
	 * 電力用契約DTO
	 */
	ContractElectricDto contractElectricDto;
	
	/**
	 * 得意先情報マスタ
	 */
	ClientMasterDto clientMasterDto;
	
	/**
	 * 請求基本情報
	 */
	BillingBasicInformationDto billingBasicInformationDto;
}