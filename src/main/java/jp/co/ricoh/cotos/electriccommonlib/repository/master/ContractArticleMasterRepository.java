package jp.co.ricoh.cotos.electriccommonlib.repository.master;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.EnumType.ElectricCommercialFlowDiv;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ContractArticleMaster;

@Repository
public interface ContractArticleMasterRepository extends CrudRepository<ContractArticleMaster, Long> {

	public List<ContractArticleMaster> findByElectricCommercialFlowDivAndArticlePatternId(ElectricCommercialFlowDiv electricCommercialFlowDiv, Long articlePatternId);

}