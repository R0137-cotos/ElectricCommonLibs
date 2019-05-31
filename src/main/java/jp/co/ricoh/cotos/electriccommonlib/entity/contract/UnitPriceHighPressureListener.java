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
public class UnitPriceHighPressureListener {

	private static StandardProperties standardProperties;
	private static RestTemplateCreator restTemplateCreator;

	@Autowired
	public void setStandardProperties(StandardProperties standardProperties) {
		UnitPriceHighPressureListener.standardProperties = standardProperties;
	}

	@Autowired
	public void setStandardProperties(RestTemplateCreator restTemplateCreator) {
		UnitPriceHighPressureListener.restTemplateCreator = restTemplateCreator;
	}

	@PrePersist
	@Transactional
	public void appendCreateUserName(UnitPriceHighPressure unitPriceHighPressure) {

		CotosAuthenticationDetails userInfo = (CotosAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		DummyUserMaster dummyUserMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/master/findDummyUserMaster/" + userInfo.getMomEmployeeId(), DummyUserMaster.class).getBody();
		if (dummyUserMaster != null) {
			unitPriceHighPressure.setCreatedUserName(dummyUserMaster.getEmpName());
			return;
		}

		// 登録者名登録
		MvEmployeeMaster mvEmployeeMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/master/findEmployeeMaster/" + userInfo.getMomEmployeeId(), MvEmployeeMaster.class).getBody();
		unitPriceHighPressure.setCreatedUserName(mvEmployeeMaster.getJobname1() + " " + mvEmployeeMaster.getJobname2());
	}

	@PreUpdate
	@Transactional
	public void addNumberOfChanges(UnitPriceHighPressure unitPriceHighPressure) {

		// 変更回数を増やす
		unitPriceHighPressure.setNumberOfChanges(unitPriceHighPressure.getNumberOfChanges() + 1);
	}
}
