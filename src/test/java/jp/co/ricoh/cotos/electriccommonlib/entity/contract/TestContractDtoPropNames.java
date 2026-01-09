package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;

import io.swagger.v3.core.util.ReflectionUtils;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;

public class TestContractDtoPropNames {

	private static final String CONTRACT_DTO_PARAM_PACKAGE = "jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract";

	@Test
	public void Dtoの全項目が対となるEntityに存在することを確認() {

		Reflections reflections = new Reflections(CONTRACT_DTO_PARAM_PACKAGE);
		Set<Class<? extends DtoBase>> allContractDtoParamClasses = reflections.getSubTypesOf(DtoBase.class);

		for (Class<?> dtoClazz : allContractDtoParamClasses) {

			// 補完対象のクラスか？
			CotosComplementTarget cotosComplementTarget = dtoClazz.getDeclaredAnnotation(CotosComplementTarget.class);

			// 補完対象出ない場合は、対となるエンティティでないと判断
			if (cotosComplementTarget == null) {
				System.out.println("対象外： " + dtoClazz.getName());
				continue;
			}

			System.out.println("対象： " + dtoClazz.getName());

			Class<?> entityClazz = cotosComplementTarget.entity();

			List<String> entityFieldNames = ReflectionUtils.getDeclaredFields(entityClazz).stream().map(field -> field.getName()).collect(Collectors.toList());
			List<String> dtoFieldNames = ReflectionUtils.getDeclaredFields(dtoClazz).stream().map(field -> field.getName()).collect(Collectors.toList());

			dtoFieldNames.stream().forEach(fieldName -> {
				Assert.assertTrue(dtoClazz.getName() + "の" + fieldName + "が対応するエンティティに存在することを確認", entityFieldNames.contains(fieldName));
			});
		}
	}
}
