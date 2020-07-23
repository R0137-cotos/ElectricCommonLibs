package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricCompanyMaster;

@Repository
public interface ElectricCompanyMasterRepository extends CrudRepository<ElectricCompanyMaster, Long> {

}
