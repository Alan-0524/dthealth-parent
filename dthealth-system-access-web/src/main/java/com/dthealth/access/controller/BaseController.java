package com.dthealth.access.controller;

import com.dthealth.dao.entity.ResultResponse;
import com.dthealth.utility.json.JsonUtility;
import com.dthealth.utility.logger.BaseLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

public class BaseController {
    @Autowired
    BaseLogger baseLogger;
    @Autowired
    JsonUtility jsonUtility;

    Object identifyReturnType(String isReturnJson, Model model, ResultResponse resultResponse, String successPage, String failurePage) {
        if (!StringUtils.isEmpty(isReturnJson)) {
            try {
                return new ResponseEntity<>(jsonUtility.objectToJson(resultResponse.getObject()), resultResponse.getStatusCode());
            } catch (JsonProcessingException e) {
                baseLogger.writeError("identifyReturnType", "Json processing error", e.getMessage());
                return new ResponseEntity<>("Internal system error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            model.addAttribute("status", resultResponse.getStatusCode());
            model.addAttribute("body", resultResponse.getObject());
            if (resultResponse.getStatusCode() == HttpStatus.OK) {
                return successPage;
            }
            return failurePage;
        }
    }
}

