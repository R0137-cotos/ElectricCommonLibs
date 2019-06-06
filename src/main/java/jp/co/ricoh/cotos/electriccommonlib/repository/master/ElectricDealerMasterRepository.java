package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricDealerMaster;

@Repository
public interface ElectricDealerMasterRepository extends CrudRepository<ElectricDealerMaster, Long> {

	public ElectricDealerMaster findByHnbitnCd(String hnbitnCd);
}
