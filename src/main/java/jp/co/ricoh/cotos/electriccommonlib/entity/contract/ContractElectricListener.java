package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.db.DBUtil;

@Component
public class ContractElectricListener {
	private static final String ID_PREFIX_CUST = "DCI";

	private static DBUtil dbUtil;

	@Autowired
	public void setDBUtil(DBUtil dbUtil) {
		ContractElectricListener.dbUtil = dbUtil;
	}

	/**
	 * 契約番号・恒久契約識別番号を付与する。得意先コードについて、MoM請求売上先サイト情報マスタ上の存在チェックを行う。
	 *
	 * @param contract
	 */
	@PrePersist
	public void appendsContractNumber(ContractElectric contractElectric) {

		/**
		 * お客様識別番号
		 */
		if (contractElectric.getCustomerNumber() == null) {
			long sequenceContract = dbUtil.loadSingleFromSQLFile("sql/nextCustomerNumberSequence.sql", GeneratedNumber.class).getGeneratedNumber();
			contractElectric.setCustomerNumber(ID_PREFIX_CUST + String.format("%08d", sequenceContract) + "00");
		}
	}
}
