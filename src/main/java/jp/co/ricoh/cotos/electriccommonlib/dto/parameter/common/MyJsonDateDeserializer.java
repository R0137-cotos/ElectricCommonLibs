package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.common;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;

public class MyJsonDateDeserializer extends JsonDeserializer<Date>
{
	
	@Autowired
	CheckUtil checkUtil;
	
    @Override
    public Date deserialize(JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String date = jsonParser.getText();
        try {
            return format.parse(date);
        } catch (Exception e) {
        	List<ErrorInfo> errorInfoList = new ArrayList<>();
        	throw new ErrorCheckException(checkUtil.addErrorInfo(errorInfoList, "IllegalFormatError", new String[] { "供給開始月", "yyyy/MM" }));
        }

    }

}