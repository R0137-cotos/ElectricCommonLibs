package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricApprovalRouteNodeMaster;

@Repository
public interface ElectricApprovalRouteNodeMasterRepository extends CrudRepository<ElectricApprovalRouteNodeMaster, Long> {

}
