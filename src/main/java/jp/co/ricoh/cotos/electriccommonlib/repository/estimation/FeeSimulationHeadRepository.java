package jp.co.ricoh.cotos.electriccommonlib.repository.estimation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationHead;

@Repository
public interface FeeSimulationHeadRepository extends CrudRepository<FeeSimulationHead, Long> {

	public List<FeeSimulationHead> findBySimNumberMainAndSimNumberSub(String simNumberMain, String simNumberSub);
}