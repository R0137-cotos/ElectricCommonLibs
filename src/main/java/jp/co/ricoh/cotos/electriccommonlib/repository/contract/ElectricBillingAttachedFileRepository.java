package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricBillingAttachedFile;

@Repository
public interface ElectricBillingAttachedFileRepository extends CrudRepository<ElectricBillingAttachedFile, Long> {

}
