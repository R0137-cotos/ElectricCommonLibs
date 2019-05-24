package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile;

@Repository
public interface ContractElectricAttachedFileRepository extends CrudRepository<ContractElectricAttachedFile, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM CONTRACT_ELECTRIC_ATTACHED_FILE WHERE CONTRACT_ELECTRIC_ATTACHED_FILE.CONTRACT_ELECTRIC_ID = :CONTRACT_ELECTRIC_ID", nativeQuery = true)
	public void deleteByContractElectricId(@Param("CONTRACT_ELECTRIC_ID")long contractElectricId);
}
