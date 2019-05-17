package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ClientMaster;

@Repository
public interface ClientMasterRepository extends CrudRepository<ClientMaster, Long> {

	public ClientMaster findByClientCode(String clientCode);
}
