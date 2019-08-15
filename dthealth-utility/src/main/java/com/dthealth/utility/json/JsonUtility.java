package com.dthealth.utility.json;

import com.dthealth.utility.logger.BaseLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonUtility {
    @Autowired
    BaseLogger baseLogger;
    protected final ObjectMapper mapper = new ObjectMapper();

    public String objectToJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
