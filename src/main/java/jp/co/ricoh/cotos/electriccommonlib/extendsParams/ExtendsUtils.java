package jp.co.ricoh.cotos.electriccommonlib.extendsParams;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.axis.utils.StringUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class ExtendsUtils {

	/**
	 * 拡張項目に値を設定して返します。
	 * @param extendItem 拡張項目のJSON文字列
	 * @param valueMap 設定するキーバリューのマップ
	 * @param update 既存の値を上書きするかどうか
	 * @return
	 */
	public String fillExtendText(String extendItem, LinkedHashMap<String, String> valueMap, boolean update) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		ObjectNode objectNode;
		try {
			if (!StringUtils.isEmpty(extendItem)) {
				objectNode = mapper.readTree(extendItem).deepCopy();
			} else {
				objectNode = mapper.createObjectNode();
			}
			if (valueMap != null) {
				valueMap.entrySet().forEach(e -> {
					if (update || objectNode.findValue(e.getKey()) == null) {
						objectNode.put(e.getKey(), e.getValue());
					}
				});
			}
			return mapper.writeValueAsString(objectNode);
		} catch (IOException e1) {
			e1.printStackTrace();
			return extendItem;
		}
	}

}
