package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.ContractFormArticleJudgeMaster;

@Repository
public interface ContractFormArticleJudgeMasterRepository extends CrudRepository<ContractFormArticleJudgeMaster, Long> {

	public List<ContractFormArticleJudgeMaster> findAllByOrderByJudgePriorityAsc();

}