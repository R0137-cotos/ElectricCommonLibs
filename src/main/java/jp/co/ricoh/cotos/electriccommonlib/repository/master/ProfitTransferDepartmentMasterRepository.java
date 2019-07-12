package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ProfitTransferDepartmentMaster;

@Repository
public interface ProfitTransferDepartmentMasterRepository extends CrudRepository<ProfitTransferDepartmentMaster, Long> {
	
	public List<ProfitTransferDepartmentMaster> findByAffiliationCode(String affiliationCode);

}
