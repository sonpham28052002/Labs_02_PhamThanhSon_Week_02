package vn.edu.iuh.fit.Back_End.convertes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class ConvertObjects {
    private final JacksonConfigMapper jacksonConfigMapper;

    public ConvertObjects() {
        jacksonConfigMapper = new JacksonConfigMapper();
    }

    public Object formJSON(String json,Class<?> type) throws JsonProcessingException {
            return jacksonConfigMapper.getContext(type).readValue(json,type);
    }

    public List<Object> formArrayJson(String json,Class<?> type) throws JsonProcessingException {
        return jacksonConfigMapper.getContext(type).readValue(json, new TypeReference<List<Object>>() {});
    }


}
