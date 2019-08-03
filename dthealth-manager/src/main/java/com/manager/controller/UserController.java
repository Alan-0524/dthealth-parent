package com.manager.controller;


import com.manager.message.MessageReceiver;
import com.manager.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageReceiver messageReceiver;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(Model model) {
        model.addAttribute("name", "Alan");
        for (int i = 0; i < 11; i++) {
            messageSender.send("DTS",Integer.toString(i),Integer.toString(i));
        }
        return "hello";
    }

    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String receive(Model model) {
        model.addAttribute("name", "Alan");
        messageReceiver.receive();
        return "hello";
    }
}
