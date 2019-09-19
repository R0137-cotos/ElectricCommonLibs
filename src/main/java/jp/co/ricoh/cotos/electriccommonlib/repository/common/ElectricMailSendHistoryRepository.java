package jp.co.ricoh.cotos.electriccommonlib.repository.common;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.co.ricoh.cotos.commonlib.entity.common.MailSendHistory.MailSendType;
import jp.co.ricoh.cotos.electriccommonlib.entity.common.ElectricMailSendHistory;
import jp.co.ricoh.cotos.electriccommonlib.entity.master.ElectricMailControlMaster;

@Repository
public interface ElectricMailSendHistoryRepository extends CrudRepository<ElectricMailSendHistory, Long> {

	public ElectricMailSendHistory findByTargetDataIdAndElectricMailControlMasterAndMailSendType(long targetDataId, ElectricMailControlMaster electricMailControlMaster, MailSendType mailSendType);

	public List<ElectricMailSendHistory> findByElectricMailControlMasterAndMailSendType(ElectricMailControlMaster electricMailControlMaster, MailSendType mailSendType);

}
