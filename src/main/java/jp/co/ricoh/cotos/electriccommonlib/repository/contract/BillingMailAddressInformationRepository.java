package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.BillingMailAddressInformation;

@Repository
public interface BillingMailAddressInformationRepository extends CrudRepository<BillingMailAddressInformation, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM BILLING_MAIL_ADDRESS_INFORMATION WHERE BILLING_MAIL_ADDRESS_INFORMATION.CLIENT_MASTER_ID = :CLIENT_MASTER_ID", nativeQuery = true)
	public void deleteByClientMasterId(@Param("CLIENT_MASTER_ID")long clientMasterId);
}
