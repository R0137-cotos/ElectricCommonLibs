package jp.co.ricoh.cotos.electriccommonlib.check;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;
import jp.co.ricoh.cotos.commonlib.util.HeadersProperties;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.AgencyContractInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingBasicInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingHistoryDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingHistoryUpdateDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.BillingMailAddressInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.CancellationInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ClientInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ClientMasterDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricAttachedFileDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ContractElectricDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricBillingAttachedFileDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricDealerContractDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ElectricExpertContractDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.EntryContentHighPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.EntryContentLowPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.ImportantPointExplainerDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.MailAddressInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.UnitPriceHighPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.UnitPriceLowPressureDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricChangePlanExtInputDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractElectricCreateExtInputDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.ContractInfoChangeExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external.RegisterArrangementResultExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.AgencyEstimationInformationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.ElectricDealerEstimationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.ElectricExpertEstimationDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.EstimationElectricDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.EstimationUpdateParameter;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.FeeSimulationHeadDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.AgencyEstimationInformationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.CustomerEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.ElectricDealerEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.ElectricExpertEstimationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationAddedEditorEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationElectricExtDtoForCreate;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationElectricExtDtoForPlanChange;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationElectricPlanChangeParamDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationExtCreateDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationExtPlanChangeDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.EstimationPicSaEmpExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.FeeSimulationHeadExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.estimation.external.LongtermDiscountEstimationInformationExtDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external.CustomerInformationExtWashingDto;
import jp.co.ricoh.cotos.electriccommonlib.dto.parameter.master.external.CustomerInformationForWashingExtDto;
import jp.co.ricoh.cotos.electriccommonlib.security.bean.ParamterCheckResult;
import lombok.Data;

/**
 *
 * テスト実施用コントローラクラス
 *
 */
@Data
@RestController
@RequestMapping("/checktest/api")
public class TestCheckController {

	@Autowired
	CheckUtil checkUtil;

	private ParamterCheckResult createParameterCheckResult(BindingResult result) {
		ParamterCheckResult paramterCheckResult = new ParamterCheckResult();
		if (result == null)
			return paramterCheckResult;
		try {
			checkUtil.checkEntity(result);
		} catch (ErrorCheckException ex) {
			paramterCheckResult.setErrorInfoList(ex.getErrorInfoList());
			return paramterCheckResult;
		}
		return paramterCheckResult;
	}

	private String loadTopURL(int localServerPort) {
		return "http://localhost:" + localServerPort + "/";
	}

	private RestTemplate initRest(final String header, final HeadersProperties headersProperties) {
		RestTemplate rest = new RestTemplate();
		if (null != header) {
			rest.setInterceptors(Stream.concat(rest.getInterceptors().stream(), Arrays.asList(new ClientHttpRequestInterceptor() {
				@Override
				public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
					System.out.println("initRest Start");
					System.out.println(request.getURI());
					System.out.println(request.getMethod());
					request.getHeaders().add(headersProperties.getAuthorization(), "Bearer " + header);
					System.out.println(request.getHeaders());
					System.out.println("initRest End");
					return execution.execute(request, body);
				}
			}).stream()).collect(Collectors.toList()));
		}
		return rest;
	}

	public String getParamterCheckUrl(Object entity, int localServerPort) {
		final String API_ROOT_HEAD = "checktest/api/ParameterCheck/";
		final String API_ROOT_END = "?isSuccess=true&hasBody=false";
		String entityName = entity.getClass().getSimpleName().replaceAll(".java", "");
		return loadTopURL(localServerPort) + API_ROOT_HEAD + entityName + API_ROOT_END;
	}

	public ParamterCheckResult callParameterCheck(Object entity, HeadersProperties headersProperties, int localServerPort) {
		String WITHIN_PERIOD_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtb21BdXRoIjoie1wiMDNcIjp7XCIyMjEwXCI6XCIwMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI1MFwifSxcIjA1XCI6e1wiMjIxMFwiOlwiMDBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNTBcIn0sXCIwN1wiOntcIjIyMTBcIjpcIjAwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIzMFwiOlwiMTBcIixcIjIyMDBcIjpcIjUwXCJ9LFwiMDFcIjp7XCIyMjEwXCI6XCIwMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI1MFwifSxcIjA0XCI6e1wiMjIxMFwiOlwiMDBcIixcIjIyMjBcIjpcIjAwXCIsXCIyMjMwXCI6XCIxMFwiLFwiMjIwMFwiOlwiNTBcIn0sXCIwNlwiOntcIjIyMTBcIjpcIjAwXCIsXCIyMjIwXCI6XCIwMFwiLFwiMjIzMFwiOlwiMTBcIixcIjIyMDBcIjpcIjUwXCJ9LFwiMDJcIjp7XCIyMjEwXCI6XCIwMFwiLFwiMjIyMFwiOlwiMDBcIixcIjIyMzBcIjpcIjEwXCIsXCIyMjAwXCI6XCI1MFwifX0iLCJvcmlnaW4iOiJodHRwczovL2Rldi5jb3Rvcy5yaWNvaC5jby5qcCIsInNpbmdsZVVzZXJJZCI6InUwMjAxMTI1IiwibW9tRW1wSWQiOiIwMDIyOTc0NiIsImV4cCI6MjUzNDAyMjY4Mzk5LCJhcHBsaWNhdGlvbklkIjoiY290b3NfZGV2In0.DVREQfy-8H2hOAX44ktBfi8IVKB45I43dinEN_a8I5E";
		RestTemplate rest = initRest(WITHIN_PERIOD_JWT, headersProperties);
		ResponseEntity<ParamterCheckResult> parameterCheckResult = rest.postForEntity(getParamterCheckUrl(entity, localServerPort), entity, ParamterCheckResult.class);
		return parameterCheckResult.getBody();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ContractElectricDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ContractElectricDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/MailAddressInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated MailAddressInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EntryContentHighPressureDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EntryContentHighPressureDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EntryContentLowPressureDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EntryContentLowPressureDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ContractElectricAttachedFileDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ContractElectricAttachedFileDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/UnitPriceHighPressureDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated UnitPriceHighPressureDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/UnitPriceLowPressureDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated UnitPriceLowPressureDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/CancellationInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated CancellationInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ImportantPointExplainerDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ImportantPointExplainerDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricExpertContractDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricExpertContractDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricDealerContractDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricDealerContractDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/BillingBasicInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated BillingBasicInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ClientInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ClientInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ClientMasterDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ClientMasterDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/BillingMailAddressInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated BillingMailAddressInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationElectricExtDtoForPlanChange")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationElectricExtDtoForPlanChange dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/CustomerEstimationExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated CustomerEstimationExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationPicSaEmpExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationPicSaEmpExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricExpertEstimationExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricExpertEstimationExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationAddedEditorEmpExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationAddedEditorEmpExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricDealerEstimationExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricDealerEstimationExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/FeeSimulationHeadExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated FeeSimulationHeadExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ContractElectricCreateExtInputDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ContractElectricCreateExtInputDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationExtCreateDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationExtCreateDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationExtPlanChangeDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationExtPlanChangeDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ContractElectricChangePlanExtInputDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ContractElectricChangePlanExtInputDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ContractInfoChangeExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ContractInfoChangeExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationElectricDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationElectricDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricDealerEstimationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricDealerEstimationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/FeeSimulationHeadDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated FeeSimulationHeadDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationUpdateParameter")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationUpdateParameter dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricExpertEstimationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricExpertEstimationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/RegisterArrangementResultExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated RegisterArrangementResultExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/AgencyEstimationInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated AgencyEstimationInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/AgencyContractInformationDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated AgencyContractInformationDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/AgencyEstimationInformationExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated AgencyEstimationInformationExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/LongtermDiscountEstimationInformationExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated LongtermDiscountEstimationInformationExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationElectricExtDtoForCreate")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationElectricExtDtoForCreate dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/BillingHistoryDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated BillingHistoryDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/ElectricBillingAttachedFileDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated ElectricBillingAttachedFileDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/BillingHistoryUpdateDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated BillingHistoryUpdateDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/EstimationElectricPlanChangeParamDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated EstimationElectricPlanChangeParamDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/CustomerInformationForWashingExtDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated CustomerInformationForWashingExtDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ParameterCheck/CustomerInformationExtWashingDto")
	public ParamterCheckResult callParamterCheck(@RequestBody @Validated CustomerInformationExtWashingDto dto, BindingResult result) {
		return createParameterCheckResult(result);
	}
}
