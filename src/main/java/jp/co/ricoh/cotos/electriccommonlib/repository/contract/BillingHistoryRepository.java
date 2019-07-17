package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingHistory;

@Repository
public interface BillingHistoryRepository extends CrudRepository<BillingHistory, Long> {
	
	@Query(value = "SELECT * FROM BILLING_HISTORY WHERE SEND_MY_RICOH = :SEND_MY_RICOH", nativeQuery = true)
	public List<BillingHistory> searchBySendMyRicoh(@Param("SEND_MY_RICOH")String sendMyRicoh);	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE BILLING_HISTORY SET SEND_MY_RICOH = '1' WHERE ID = :ID", nativeQuery = true)
	public void updateSendMyRicohById(@Param("ID")long id);
	
}
