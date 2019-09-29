package com.dthealth.interaction.service;

import com.dthealth.interaction.entity.DigitalUserModel;
import com.dthealth.utility.controller.ResultResponse;

public interface DigitalUserModelService {
    ResultResponse findDigitalUserModelByUserId(String userId);
    ResultResponse addDigitalUserModel(DigitalUserModel digitalUserModel);
    ResultResponse updateDigitalUserModel(DigitalUserModel digitalUserModel);
}
