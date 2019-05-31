package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import java.util.ArrayList;

import javax.persistence.PrePersist;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.entity.master.DummyUserMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.MvEmployeeMaster;
import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;
import jp.co.ricoh.cotos.electriccommonlib.util.RestTemplateCreator;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;

@Component
public class ElectricExpertEstimationListener {

	private static CheckUtil checkUtil;
	private static StandardProperties standardProperties;
	private static RestTemplateCreator restTemplateCreator;

	@Autowired
	public void setCheckUtil(CheckUtil checkUtil) {
		ElectricExpertEstimationListener.checkUtil = checkUtil;
	}

	@Autowired
	public void setStandardProperties(StandardProperties standardProperties) {
		ElectricExpertEstimationListener.standardProperties = standardProperties;
	}

	@Autowired
	public void setStandardProperties(RestTemplateCreator restTemplateCreator) {
		ElectricExpertEstimationListener.restTemplateCreator = restTemplateCreator;
	}

	/**
	 * 社員情報マスタを電力専任情報トランザクションに紐づけます。
	 * 
	 * @param estimationPicSaEmp
	 */
	@PrePersist
	@Transactional
	public void appendsEmployeeFields(ElectricExpertEstimation electricExpertEstimation) {
		DummyUserMaster dummyUserMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/master/findDummyUserMaster/" + electricExpertEstimation.getMomEmpId(), DummyUserMaster.class).getBody();
		if (dummyUserMaster != null) {
			electricExpertEstimation.setName(dummyUserMaster.getEmpName());
			return;
		}

		MvEmployeeMaster employeeMaster = restTemplateCreator.getRestTemplate().getForEntity(standardProperties.getMaster() + "/master/findEmployeeMaster/" + electricExpertEstimation.getMomEmpId(), MvEmployeeMaster.class).getBody();

		if (employeeMaster == null) {
			String[] regexList = { "電力専任情報マスタ" };
			throw new ErrorCheckException(checkUtil.addErrorInfo(new ArrayList<ErrorInfo>(), "MasterDoesNotExist", regexList));
		}

		electricExpertEstimation.setName(employeeMaster.getJobname1() + employeeMaster.getJobname2());
		electricExpertEstimation.setMailAddress(employeeMaster.getMailAddress());
		electricExpertEstimation.setPhoneNumber(employeeMaster.getPhoneNumber());
		electricExpertEstimation.setAffiliationCode(employeeMaster.getRingsHanshCd() + employeeMaster.getRingsSectCd());
		electricExpertEstimation.setBelongs(employeeMaster.getOrgBaseName());
	}

}
