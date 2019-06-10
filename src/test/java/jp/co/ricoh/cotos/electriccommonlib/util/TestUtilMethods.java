package jp.co.ricoh.cotos.electriccommonlib.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ElectricDealerContractChangePlanExtDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestUtilMethods {
	
	@Autowired
	UtilMethods utilMethods;

	@Test
	public void DTOのnullチェックができること() {
		
		ElectricDealerContractChangePlanExtDto electricContractExtDto = new ElectricDealerContractChangePlanExtDto();
		List<ErrorInfo> errorInfoList = new ArrayList<>();
		errorInfoList = utilMethods.emptyFieldsCheck(electricContractExtDto, errorInfoList);
		Assert.assertEquals(9, errorInfoList.size());
	}
}
