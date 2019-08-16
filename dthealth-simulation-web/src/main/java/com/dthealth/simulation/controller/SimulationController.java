package com.dthealth.simulation.controller;


import com.dthealth.simulation.message.MessageReceiver;
import com.dthealth.simulation.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimulationController {

    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageReceiver messageReceiver;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

}
