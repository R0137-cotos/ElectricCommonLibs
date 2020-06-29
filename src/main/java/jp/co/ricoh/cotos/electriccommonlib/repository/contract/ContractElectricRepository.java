package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectric;

@Repository
public interface ContractElectricRepository extends CrudRepository<ContractElectric, Long> {

	public ContractElectric findByContractId(Long contractId);

	public List<ContractElectric> findByOppSysKeyBn(String oppSysKeyBn);
}
