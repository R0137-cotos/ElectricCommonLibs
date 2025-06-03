package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ElectricAppropriation;

@Repository
public interface ElectricAppropriationRepository extends CrudRepository<ElectricAppropriation, Long> {

	public List<ElectricAppropriation> findByContractElectricId(Long contractElectricId);

	public List<ElectricAppropriation> findByElectricTradingCompanyIdAndBillingYearMonth(String electricTradingCompanyId, String billingYearMonth);

	@Query(value = "SELECT * FROM electric_appropriation WHERE electric_trading_company_id = :electricTradingCompanyId AND billing_year_month IN :billingYearMonths", nativeQuery = true)
	public List<ElectricAppropriation> findByElectricTradingCompanyIdAndBillingYearMonth(@Param("electricTradingCompanyId") String electricTradingCompanyId, @Param("billingYearMonths") List<String> billingYearMonths);

}
