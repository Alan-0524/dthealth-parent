package com.dthealth.manager.controller;


import com.dthealth.manager.message.ManagerMessageReceiver;
import com.dthealth.manager.message.ManagerMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    ManagerMessageSender managerMessageSender;

    @Autowired
    ManagerMessageReceiver managerMessageReceiver;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
//    @RequestMapping(value = "/send", method = RequestMethod.GET)
//    public String send(Model model) {
//        model.addAttribute("name", "Alan");
//        for (int i = 0; i < 11; i++) {
//            messageSender.send("DTS",Integer.toString(i),Integer.toString(i));
//        }
//        return "hello";
//    }
//
//    @RequestMapping(value = "/receive", method = RequestMethod.GET)
//    public String receive(Model model) {
//        model.addAttribute("name", "Alan");
////        messageReceiver.receive();
//        return "hello";
//    }

}
