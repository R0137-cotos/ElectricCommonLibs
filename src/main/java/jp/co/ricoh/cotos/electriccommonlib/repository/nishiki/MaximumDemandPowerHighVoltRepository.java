package jp.co.ricoh.cotos.electriccommonlib.repository.nishiki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.nishiki.MaximumDemandPowerHighVolt;

@Repository
public interface MaximumDemandPowerHighVoltRepository extends CrudRepository<MaximumDemandPowerHighVolt, Long> {

}
