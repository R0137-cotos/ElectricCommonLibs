package jp.co.ricoh.cotos.electriccommonlib.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumptionTaxUtilityTest {

	@Autowired
	private ConsumptionTaxUtility testTarget;

	@Test
	public void 有効消費税率の取得() throws Exception {
		Assert.assertEquals("消費税率が取得できること", BigDecimal.valueOf(10L), testTarget.getBigDecimalTaxRate());
	}

	@Test
	public void 税込額の取得() {

		// 税抜額と税込額のMap
		Map<BigDecimal, BigDecimal> expectedActualMap = new HashMap<>();
		expectedActualMap.put(new BigDecimal(100), new BigDecimal(110));
		expectedActualMap.put(new BigDecimal(1000), new BigDecimal(1100));
		expectedActualMap.put(new BigDecimal(10000), new BigDecimal(11000));
		expectedActualMap.put(new BigDecimal(250), new BigDecimal(275));
		expectedActualMap.put(new BigDecimal(2500), new BigDecimal(2750));
		expectedActualMap.put(new BigDecimal(25000), new BigDecimal(27500));
		expectedActualMap.put(new BigDecimal(128), new BigDecimal(140));
		expectedActualMap.put(new BigDecimal(1280), new BigDecimal(1408));
		expectedActualMap.put(new BigDecimal(12800), new BigDecimal(14080));
		expectedActualMap.put(new BigDecimal(1024), new BigDecimal(1126));
		expectedActualMap.put(new BigDecimal(10240), new BigDecimal(11264));
		expectedActualMap.put(new BigDecimal(3096), new BigDecimal(3405));
		expectedActualMap.put(new BigDecimal(63259), new BigDecimal(69584));

		expectedActualMap.entrySet().parallelStream().forEach(map -> Assert.assertEquals("税込額が期待値通りに取得できること", map.getValue(), testTarget.calcConsumptionInTax(map.getKey())));
	}

	@Test
	public void 税抜額の取得() {

		// 税抜額と税込額のMap
		Map<BigDecimal, BigDecimal> expectedActualMap = new HashMap<>();
		expectedActualMap.put(new BigDecimal(100), new BigDecimal(91));
		expectedActualMap.put(new BigDecimal(1000), new BigDecimal(910));
		expectedActualMap.put(new BigDecimal(10000), new BigDecimal(9091));
		expectedActualMap.put(new BigDecimal(250), new BigDecimal(228));
		expectedActualMap.put(new BigDecimal(2500), new BigDecimal(2273));
		expectedActualMap.put(new BigDecimal(25000), new BigDecimal(22728));
		expectedActualMap.put(new BigDecimal(128), new BigDecimal(117));
		expectedActualMap.put(new BigDecimal(1280), new BigDecimal(1164));
		expectedActualMap.put(new BigDecimal(12800), new BigDecimal(11637));
		expectedActualMap.put(new BigDecimal(1024), new BigDecimal(931));
		expectedActualMap.put(new BigDecimal(10240), new BigDecimal(9310));
		expectedActualMap.put(new BigDecimal(3096), new BigDecimal(2815));
		expectedActualMap.put(new BigDecimal(63259), new BigDecimal(57509));

		expectedActualMap.entrySet().parallelStream().forEach(map -> Assert.assertEquals("税込額が期待値通りに取得できること", map.getValue(), testTarget.calcConsumptionOutTax(map.getKey())));
	}

	@Test
	public void 消費税額の取得() {
		// 税抜額と消費税額のMap
		Map<BigDecimal, BigDecimal> expectedActualMap = new HashMap<>();
		expectedActualMap.put(new BigDecimal(100), new BigDecimal(10));
		expectedActualMap.put(new BigDecimal(1000), new BigDecimal(100));
		expectedActualMap.put(new BigDecimal(10000), new BigDecimal(1000));
		expectedActualMap.put(new BigDecimal(250), new BigDecimal(25));
		expectedActualMap.put(new BigDecimal(2500), new BigDecimal(250));
		expectedActualMap.put(new BigDecimal(25000), new BigDecimal(2500));
		expectedActualMap.put(new BigDecimal(128), new BigDecimal(12));
		expectedActualMap.put(new BigDecimal(1280), new BigDecimal(128));
		expectedActualMap.put(new BigDecimal(12800), new BigDecimal(1280));
		expectedActualMap.put(new BigDecimal(1024), new BigDecimal(102));
		expectedActualMap.put(new BigDecimal(10240), new BigDecimal(1024));
		expectedActualMap.put(new BigDecimal(3096), new BigDecimal(309));
		expectedActualMap.put(new BigDecimal(63259), new BigDecimal(6325));

		expectedActualMap.entrySet().parallelStream().forEach(map -> Assert.assertEquals("消費税額が期待値通りに取得できること", map.getValue(), testTarget.calcConsumptionformOutTax(map.getKey())));

		// 税込額と消費税額のMap
		expectedActualMap.clear();
		expectedActualMap.put(new BigDecimal(100), new BigDecimal(9));
		expectedActualMap.put(new BigDecimal(1000), new BigDecimal(90));
		expectedActualMap.put(new BigDecimal(10000), new BigDecimal(909));
		expectedActualMap.put(new BigDecimal(250), new BigDecimal(22));
		expectedActualMap.put(new BigDecimal(2500), new BigDecimal(227));
		expectedActualMap.put(new BigDecimal(25000), new BigDecimal(2272));
		expectedActualMap.put(new BigDecimal(128), new BigDecimal(11));
		expectedActualMap.put(new BigDecimal(1280), new BigDecimal(116));
		expectedActualMap.put(new BigDecimal(12800), new BigDecimal(1163));
		expectedActualMap.put(new BigDecimal(1024), new BigDecimal(93));
		expectedActualMap.put(new BigDecimal(10240), new BigDecimal(930));
		expectedActualMap.put(new BigDecimal(3096), new BigDecimal(281));
		expectedActualMap.put(new BigDecimal(63259), new BigDecimal(5750));

		expectedActualMap.entrySet().parallelStream().forEach(map -> Assert.assertEquals("消費税額が期待値通りに取得できること", map.getValue(), testTarget.calcConsumptionfromInTax(map.getKey())));
	}
}
