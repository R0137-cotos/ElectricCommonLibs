package jp.co.ricoh.cotos.electriccommonlib.repository.nishiki;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.nishiki.InstrumentInfoHighVolt;

@Repository
public interface InstrumentInfoHighVoltRepository extends CrudRepository<InstrumentInfoHighVolt, Long> {

}
