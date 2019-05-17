package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.HighContractCalendarMaster;

@Repository
public interface HighContractCalendarMasterRepository extends CrudRepository<HighContractCalendarMaster, Long> {

	public List<HighContractCalendarMaster> findByElectricCompanyNameAndSupplyStartYm(String electricCompanyName, String supplyStartYm);

}
