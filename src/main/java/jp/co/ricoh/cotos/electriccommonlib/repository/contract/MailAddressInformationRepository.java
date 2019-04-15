package jp.co.ricoh.cotos.electriccommonlib.repository.contract;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.electriccommonlib.entity.contract.MailAddressInformation;

@Repository
public interface MailAddressInformationRepository extends CrudRepository<MailAddressInformation, Long> {

}
