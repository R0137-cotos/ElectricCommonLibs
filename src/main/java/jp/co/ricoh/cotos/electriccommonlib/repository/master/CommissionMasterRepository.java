package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.CommissionMaster;

@Repository
public interface CommissionMasterRepository extends CrudRepository<CommissionMaster, Long> {

}
