package com.yihuisoft.common.util.app;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import java.io.IOException;

/**
 * Long类型转换成String
 * @author laijd
 * @version V4.0.1
 * @date 2019/8/1 21:04
 */
public class JsonLongSerializer extends JsonSerializer<Long> {
    /**
     * Long类型转换成String
     * @param aLong
     * @return
     */
    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(Long.toString(aLong));
    }
}
