package jp.co.ricoh.cotos.electriccommonlib.repository.estimation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.estimation.AgencyEstimationInformation;

@Repository
public interface AgencyEstimationInformationRepository extends CrudRepository<AgencyEstimationInformation, Long> {

}
