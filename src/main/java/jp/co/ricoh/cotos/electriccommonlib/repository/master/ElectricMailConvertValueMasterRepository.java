package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricMailControlMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricMailConvertValueMaster;

@Repository
public interface ElectricMailConvertValueMasterRepository extends CrudRepository<ElectricMailConvertValueMaster, Long> {

	public List<ElectricMailConvertValueMaster> findByElectricMailControlMaster(ElectricMailControlMaster eletricmailControlMaster);

}
