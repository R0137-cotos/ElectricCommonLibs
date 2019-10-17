package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricAppropriation;

@Repository
public interface ElectricAppropriationRepository extends CrudRepository<ElectricAppropriation, Long> {

	public List<ElectricAppropriation> findByContractElectricId(Long contractElectricId);

	public List<ElectricAppropriation> findByElectricTradingCompanyIdAndBillingYearMonth(String electricTradingCompanyId, String billingYearMonth);

	public List<ElectricAppropriation> findByElectricTradingCompanyIdAndBillingYearMonth(String electricTradingCompanyId, List<String> billingYearMonth);

}
