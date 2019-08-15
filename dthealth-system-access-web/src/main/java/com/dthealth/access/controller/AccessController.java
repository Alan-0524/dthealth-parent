package com.dthealth.access.controller;


import com.dthealth.access.service.UserService;
import com.dthealth.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


@Controller
public class AccessController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/to-sign-in")
    public String toSignIn(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "sign-in";
    }

//    @RequestMapping("/do-sign-in")
//    public Object doSignIn(HttpServletResponse response,String isReturnJson, String userAccount, String password, Model model) {
//        return identifyReturnType(isReturnJson, model, userService.login(userAccount, password,response), "home", "failure");
//    }

    @RequestMapping("/to-sign-up")
    public String toSignUp(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "sign-up";
    }

    @RequestMapping("/do-sign-up")
    public Object doSignUp(@ModelAttribute(value = "user") User user, String isReturnJson, Model model){
        return identifyReturnType(isReturnJson, model, userService.signUp(user), "sign-in", "failure");
    }

    @RequestMapping("/home")
    public String home(Model model) {
        return "home";
    }


//    @GetMapping("/device")
//    public void login(Device device) {
//        if (device.isMobile()) {
//            logger.info("Hello mobile user!");
//        } else if (device.isTablet()) {
//            logger.info("Hello tablet user!");
//        } else {
//            logger.info("Hello desktop user!");
//        }
//    }
}
