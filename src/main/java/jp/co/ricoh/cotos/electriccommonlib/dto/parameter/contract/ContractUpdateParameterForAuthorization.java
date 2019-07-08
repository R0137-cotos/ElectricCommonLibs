package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jp.co.ricoh.cotos.commonlib.entity.contract.Contract;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingBasicInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;
import lombok.Data;

@Data
public class ContractUpdateParameterForAuthorization {

	/**
	 * 標準用契約DTO
	 */
	Contract contract;

	/**
	 * 電力用契約DTO
	 */
	ContractElectric contractElectric;

	/**
	 * 得意先情報マスタ
	 */
	ClientMaster clientMaster;

	/**
	 * 請求基本情報
	 */
	BillingBasicInformation billingBasicInformation;
}
