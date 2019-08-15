package com.dthealth.utility.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseLogger {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public void writeInfo(String name,String message) {
        logger.info("----------> {}: {}",name,message);
    }

    public void writeError(String function,String errorType,String message) {
        logger.error("----------> Error at {} function, Type: {} , error message: {}",function,errorType,message);
    }
    public void writeError(String function,String message) {
        logger.error("----------> Error at {} function, error message: {}",function,message);
    }
}
