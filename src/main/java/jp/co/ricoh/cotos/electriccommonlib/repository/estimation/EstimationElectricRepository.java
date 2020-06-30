package jp.co.ricoh.cotos.electriccommonlib.repository.estimation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.EstimationElectric;

@Repository
public interface EstimationElectricRepository extends CrudRepository<EstimationElectric, Long> {

	public EstimationElectric findByEstimationId(Long estimationId);

	public List<EstimationElectric> findByOppSysKeyBn(String oppSysKeyBn);
}