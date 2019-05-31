package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.entity.master.DummyUserMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.MvEmployeeMaster;
import jp.co.ricoh.cotos.commonlib.security.CotosAuthenticationDetails;
import jp.co.ricoh.cotos.electriccommonlib.util.RestTemplateCreator;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;

@Component
public class UnitPriceLowPressureListener {

	private static StandardProperties standardProperties;
	private static RestTemplateCreator restTemplateCreator;

	@Autowired
	public void setStandardProperties(StandardProperties standardProperties) {
		UnitPriceLowPressureListener.standardProperties = standardProperties;
	}

	@Autowired
	public void setStandardProperties(RestTemplateCreator restTemplateCreator) {
		UnitPriceLowPressureListener.restTemplateCreator = restTemplateCreator;
	}

	@PrePersist
	@Transactional
	public void appendCreateUserName(UnitPriceLowPressure unitPriceLowPressure) {

		CotosAuthenticationDetails userInfo = (CotosAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		DummyUserMaster dummyUserMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/master/findDummyUserMaster/" + userInfo.getMomEmployeeId(), DummyUserMaster.class).getBody();
		if (dummyUserMaster != null) {
			unitPriceLowPressure.setCreatedUserName(dummyUserMaster.getEmpName());
			return;
		}

		// 登録者名登録
		MvEmployeeMaster mvEmployeeMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/master/findEmployeeMaster/" + userInfo.getMomEmployeeId(), MvEmployeeMaster.class).getBody();
		unitPriceLowPressure.setCreatedUserName(mvEmployeeMaster.getJobname1() + " " + mvEmployeeMaster.getJobname2());
	}

	@PreUpdate
	@Transactional
	public void addNumberOfChanges(UnitPriceLowPressure unitPriceLowPressure) {

		// 変更回数を増やす
		unitPriceLowPressure.setNumberOfChanges(unitPriceLowPressure.getNumberOfChanges() + 1);
	}
}
