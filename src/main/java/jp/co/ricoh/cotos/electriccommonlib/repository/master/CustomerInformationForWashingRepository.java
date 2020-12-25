package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.master.CustomerInformationForWashing;

@Repository
public interface CustomerInformationForWashingRepository extends CrudRepository<CustomerInformationForWashing, Long> {

}
