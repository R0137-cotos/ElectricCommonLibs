package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import lombok.Data;

/**
 * 見積番号生成用のオブジェクト
 * 
 * @author tito
 *
 */
@Data
@Entity
public class GeneratedNumber {

	/**
	 * numberだとOracleの予約後と重複するのでgeneratedNumberに。
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_number_seq")
	@SequenceGenerator(name = "customer_number_seq", sequenceName = "customer_number_seq", allocationSize = 1)
	private long generatedNumber;
}
