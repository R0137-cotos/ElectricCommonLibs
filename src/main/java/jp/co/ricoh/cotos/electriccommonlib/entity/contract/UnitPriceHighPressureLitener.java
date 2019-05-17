package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.ricoh.cotos.commonlib.entity.master.MvEmployeeMaster;
import jp.co.ricoh.cotos.electriccommonlib.util.RestTemplateCreator;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;

public class UnitPriceHighPressureLitener {

	@Autowired
	StandardProperties standardProperties;

	@Autowired
	RestTemplateCreator restTemplateCreator;

	@PrePersist
	@Transactional
	public void appendCreateUserName(UnitPriceHighPressure unitPriceHighPressure) {

		// 登録者名登録
		MvEmployeeMaster mvEmployeeMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/findEmployeeMaster/" + unitPriceHighPressure.getCreatedUserId(), MvEmployeeMaster.class).getBody();
		unitPriceHighPressure.setCreatedUserName(mvEmployeeMaster.getJobname1() + " " + mvEmployeeMaster.getJobname2());
	}

	@PreUpdate
	public void addNumberOfChanges(UnitPriceHighPressure unitPriceHighPressure) {

		// 変更回数を増やす
		unitPriceHighPressure.setNumberOfChanges(unitPriceHighPressure.getNumberOfChanges() + 1);
	}
}
