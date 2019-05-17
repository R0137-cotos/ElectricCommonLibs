package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.Domain;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.VoltageCategory;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationInformation.CancellationDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricFileType;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricFormMaster.ElectricPlan;

@Repository
public interface ElectricFormMasterRepository extends CrudRepository<ElectricFormMaster, Long> {

	public ElectricFormMaster findByVoltageCategoryAndElectricCommercialFlowDivAndElectricPlanAndCancellationDivAndCancellationMoneyGeneratedFlgAndElectricFileTypeAndDomain(VoltageCategory voltageCategory, ElectricCommercialFlowDiv electricCommercialFlowDiv, ElectricPlan electricPlan, CancellationDiv cancellationDiv, Integer cancellationMoneyGeneratedFlg, ElectricFileType electricFileType, Domain domain);

}