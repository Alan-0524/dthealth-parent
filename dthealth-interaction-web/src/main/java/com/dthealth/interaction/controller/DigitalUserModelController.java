package com.dthealth.interaction.controller;

import com.dthealth.interaction.entity.DigitalUserModel;
import com.dthealth.interaction.service.DigitalUserModelService;
import com.dthealth.utility.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/digitalUserModel")
public class DigitalUserModelController extends BaseController {
    @Autowired
    DigitalUserModelService digitalUserModelService;

    @GetMapping("/findDigitalUserModelByUserId")
    public Object findDigitalUserModelByUserId(@RequestParam(value = "userId", required = false) String userId) {
        return identifyReturnType(digitalUserModelService.findDigitalUserModelByUserId(userId));
    }

    @GetMapping("/addDigitalUserModel")
    public Object addDigitalUserModel(@RequestParam(value = "digitalUserModel", required = false) DigitalUserModel digitalUserModel) {
        return identifyReturnType(digitalUserModelService.addDigitalUserModel(digitalUserModel));
    }

    @GetMapping("/updateDigitalUserModel")
    public Object updateDigitalUserModel(@RequestParam(value = "digitalUserModel", required = false) DigitalUserModel digitalUserModel) {
        return identifyReturnType(digitalUserModelService.updateDigitalUserModel(digitalUserModel));
    }
}
