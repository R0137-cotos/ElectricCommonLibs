package jp.co.ricoh.cotos.electriccommonlib.repository.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.common.CaseManagerForUpdate;

@Repository
public interface CaseManagerForUpdateRepository extends CrudRepository<CaseManagerForUpdate, Long> {

}
