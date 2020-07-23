package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.FfmAccount;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.FfmAccount.Id;

@Repository
public interface FfmAccountRepository extends CrudRepository<FfmAccount, Id> {

}