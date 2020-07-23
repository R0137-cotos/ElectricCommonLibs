package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricExpertContract;

@Repository
public interface ElectricExpertContractRepository extends CrudRepository<ElectricExpertContract, Long> {

}
