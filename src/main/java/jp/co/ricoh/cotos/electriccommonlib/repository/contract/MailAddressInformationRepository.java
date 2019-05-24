package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MailAddressInformation;

@Repository
public interface MailAddressInformationRepository extends CrudRepository<MailAddressInformation, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM MAIL_ADDRESS_INFORMATION WHERE MAIL_ADDRESS_INFORMATION.CONTRACT_ELECTRIC_ID = :CONTRACT_ELECTRIC_ID", nativeQuery = true)
	public void deleteByContractElectricId(@Param("CONTRACT_ELECTRIC_ID")long contractElectricId);
}
