package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricAreaMaster;

@Repository
public interface ElectricAreaMasterRepository extends CrudRepository<ElectricAreaMaster, Long> {

}
