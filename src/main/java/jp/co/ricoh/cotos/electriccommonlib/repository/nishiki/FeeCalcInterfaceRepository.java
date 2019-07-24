package jp.co.ricoh.cotos.electriccommonlib.repository.nishiki;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.nishiki.FeeCalcInterface;

@Repository
public interface FeeCalcInterfaceRepository extends CrudRepository<FeeCalcInterface, Long> {

	@Query(value = "SELECT * FROM FEE_CALC_INTERFACE WHERE FEE_CALC_INTERFACE.CTCT_BN = :CTCT_BN", nativeQuery = true)
	public List<FeeCalcInterface> searchByCtctBn(@Param("CTCT_BN") String ctctBn);

}
