package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ImportantPointExplainer;

@Repository
public interface ImportantPointExplainerRepository extends CrudRepository<ImportantPointExplainer, Long> {

}
