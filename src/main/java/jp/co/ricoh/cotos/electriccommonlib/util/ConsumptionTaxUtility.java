package jp.co.ricoh.cotos.electriccommonlib.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.dto.parameter.common.CommonMasterSearchParameter;
import jp.co.ricoh.cotos.commonlib.dto.result.CommonMasterDetailResult;
import jp.co.ricoh.cotos.commonlib.dto.result.CommonMasterResult;
import jp.co.ricoh.cotos.commonlib.entity.EnumType.ServiceCategory;
import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;
import jp.co.ricoh.cotos.commonlib.logic.findcommonmaster.FindCommonMaster;

/**
 * 消費税取得・計算Utility
 */
@Component
public class ConsumptionTaxUtility {

	@Autowired
	private FindCommonMaster findCommonMaster;

	@Autowired
	private CheckUtil checkUtil;

	/** 消費税率 */
	private static String TAX_RATE;

	/**
	 * 消費税率の取得<br>
	 * ※Bean生成直後のタイミングでのみ動く想定<br>
	 * 
	 * @throws Exception
	 */
	@PostConstruct
	public void findTaxRate() throws Exception {
		if (StringUtils.isBlank(TAX_RATE)) {
			TAX_RATE = getTaxRateFromCommonMaster();
		}
	}

	/**
	 * 消費税率を返却する
	 * 
	 * @return 消費税率
	 */
	public String getTaxRate() {
		return TAX_RATE;
	}

	/**
	 * 消費税率をBigDecimal型で返却する
	 * 
	 * @return BigDecimal型の消費税率
	 */
	public BigDecimal getBigDecimalTaxRate() {
		return new BigDecimal(TAX_RATE);
	}

	/**
	 * 税抜額から消費税込額を取得
	 * 
	 * @param outAmount
	 *            税抜額
	 * @return 税込額
	 * @throws Exception
	 */
	public BigDecimal calcConsumptionInTax(BigDecimal outAmount) {
		return outAmount.add(calcConsumptionformOutTax(outAmount));
	}

	/**
	 * 税込額から消費税抜額を取得
	 * 
	 * @param inAmount
	 *            税込額
	 * @return 税抜額
	 * @throws Exception
	 */
	public BigDecimal calcConsumptionOutTax(BigDecimal inAmount) {
		return inAmount.add(calcConsumptionfromInTax(inAmount).negate());
	}

	/**
	 * 税抜額から消費税額を取得
	 * 
	 * @param outAmount
	 *            税抜額
	 * @return 消費税額
	 * @throws Exception
	 */
	public BigDecimal calcConsumptionformOutTax(BigDecimal outAmount) {
		return outAmount.multiply(getBigDecimalTaxRate().movePointRight(-2)).setScale(0, RoundingMode.DOWN);
	}

	/**
	 * 税込額から消費税額を取得
	 * 
	 * @param inAmount
	 *            税込額
	 * @return 消費税額
	 * @throws Exception
	 */
	public BigDecimal calcConsumptionfromInTax(BigDecimal inAmount) {
		return inAmount.multiply(getBigDecimalTaxRate()).divide(getBigDecimalTaxRate().add(BigDecimal.valueOf(100)), 0, RoundingMode.DOWN);
	}

	/**
	 * 汎用マスタから消費税率を取得する
	 * 
	 * @return 消費税率
	 * @throws ErrorCheckException
	 */
	private String getTaxRateFromCommonMaster() throws ErrorCheckException {
		CommonMasterSearchParameter parameter = new CommonMasterSearchParameter();
		parameter.setServiceCategory(ServiceCategory.共通);
		List<CommonMasterResult> commonMasterResultList = findCommonMaster.findCommonMaster(parameter);
		if (CollectionUtils.isEmpty(commonMasterResultList)) {
			List<ErrorInfo> error = checkUtil.addErrorInfo(new ArrayList<ErrorInfo>(), "MasterDoesNotExist", new String[] { "汎用マスタ" });
			throw new ErrorCheckException(error);
		}
		CommonMasterDetailResult taxRate = commonMasterResultList.stream().filter(commonMaster -> "sales_tax_rate".equals(commonMaster.getColumnName())).map(commonMaster -> commonMaster.getCommonMasterDetailResultList().stream().findFirst().get()).findFirst().get();
		return taxRate.getCodeValue();
	}
}
