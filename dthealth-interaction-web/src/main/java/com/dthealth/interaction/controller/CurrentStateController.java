package com.dthealth.interaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrentStateController {

    @RequestMapping("/loadCurrentState/{id}")
    public String loadCurrentState(@PathVariable String id, Model model) {
        model.addAttribute("id",id);
        return "dynamic_line";
    }
}
