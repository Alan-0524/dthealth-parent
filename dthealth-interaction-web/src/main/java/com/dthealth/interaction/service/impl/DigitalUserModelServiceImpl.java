package com.dthealth.interaction.service.impl;

import com.dthealth.interaction.entity.DigitalUserModel;
import com.dthealth.interaction.repository.DigitalUserModelRepository;
import com.dthealth.interaction.repository.QueryCondition;
import com.dthealth.interaction.service.DigitalUserModelService;
import com.dthealth.utility.controller.ResultResponse;
import com.dthealth.utility.logger.BaseLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DigitalUserModelServiceImpl implements DigitalUserModelService {
    @Autowired
    BaseLogger baseLogger;
    @Autowired
    DigitalUserModelRepository digitalUserModelRepository;

    @Override
    public ResultResponse findDigitalUserModelByUserId(String userId) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addSearch(QueryCondition.EXACT, "userId", userId);
        DigitalUserModel digitalUserModel = digitalUserModelRepository.findOneObject(queryCondition);
        if (null != digitalUserModel) {
            return new ResultResponse(HttpStatus.OK, digitalUserModel);
        }
        return new ResultResponse(HttpStatus.NOT_FOUND, "not found this user model");
    }

    @Override
    public ResultResponse addDigitalUserModel(DigitalUserModel digitalUserModel) {
        try {
            if (existUserModel(digitalUserModel.getUserId())) {
                return new ResultResponse(HttpStatus.IM_USED, "The digital user model has already existed");
            }
            digitalUserModelRepository.save(digitalUserModel);
            return new ResultResponse(HttpStatus.OK, digitalUserModelRepository);
        } catch (Exception e) {
            baseLogger.writeError("addDigitalUserModel", e.getMessage());
            return new ResultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error");
        }
    }

    @Override
    public ResultResponse updateDigitalUserModel(DigitalUserModel digitalUserModel) {
        DigitalUserModel savedDigitalUserModel = findOneDigitalUserModel(digitalUserModel.getId());
        if(savedDigitalUserModel == null){
            return new ResultResponse(HttpStatus.NOT_FOUND, "not found this user model");
        }
        try {
            savedDigitalUserModel = digitalUserModel;
            DigitalUserModel model = digitalUserModelRepository.save(savedDigitalUserModel);
            return new ResultResponse(HttpStatus.OK, model);
        }catch (Exception e){
            baseLogger.writeError("updateDigitalUserModel", e.getMessage());
            return new ResultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error");
        }
    }

    private boolean existUserModel(String userId) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addSearch(QueryCondition.EXACT, "userId", userId);
        return digitalUserModelRepository.exist(queryCondition);
    }

    private DigitalUserModel findOneDigitalUserModel(String id){
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addSearch(QueryCondition.EXACT, "id", id);
        return digitalUserModelRepository.findOneObject(queryCondition);
    }
}
