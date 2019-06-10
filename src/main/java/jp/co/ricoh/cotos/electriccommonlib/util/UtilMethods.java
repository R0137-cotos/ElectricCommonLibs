package jp.co.ricoh.cotos.electriccommonlib.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;
import jp.co.ricoh.cotos.commonlib.logic.message.MessageUtil;

@Component
public class UtilMethods {
	
	@Autowired
	CheckUtil checkUtil;
	
	@Autowired
	MessageUtil messageUtil;
	
	/**
	 * dtoのnullチェック
	 * 
	 * @param dto
	 * @param errorInfoList
	 * @return errorInfoList
	 */
	public List<ErrorInfo> emptyFieldsCheck(Object dto, List<ErrorInfo> errorInfoList) {
		List<Field> fields = Arrays.asList(dto.getClass().getDeclaredFields()).stream().map(f -> {
			f.setAccessible(true);
			return f;
		}).collect(Collectors.toList());

		fields.stream().filter(f -> {
			try {
				return null == f.get(dto);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}).forEach(f -> {
			String fieldOrigNm = Optional.of(f.toString()).filter(o -> o.contains(".")).map(o -> {
				return Optional.of(o.split(Pattern.quote("."))).map(m -> m[m.length - 1]).get();
			}).orElse(f.toString());
			checkUtil.addErrorInfo(errorInfoList, "ParameterEmptyError", new String[] { messageUtil.convertSingleValue(fieldOrigNm) });
		});

		return errorInfoList;
	}

}
