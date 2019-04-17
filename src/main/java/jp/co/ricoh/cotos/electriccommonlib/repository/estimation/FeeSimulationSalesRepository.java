package jp.co.ricoh.cotos.electriccommonlib.repository.estimation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.FeeSimulationSales;

@Repository
public interface FeeSimulationSalesRepository extends CrudRepository<FeeSimulationSales, Long> {

}