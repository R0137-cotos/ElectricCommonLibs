package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricApprovalRouteMaster;

@Repository
public interface ElectricApprovalRouteMasterRepository extends CrudRepository<ElectricApprovalRouteMaster, Long> {

}
