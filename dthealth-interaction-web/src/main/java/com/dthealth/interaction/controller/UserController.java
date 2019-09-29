package com.dthealth.interaction.controller;

import com.dthealth.interaction.entity.User;
import com.dthealth.interaction.service.UserService;
import com.dthealth.utility.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @GetMapping("/findAllByPage")
    public Object findAllByPage(@RequestParam(value = "page", required = false) int page,
                                @RequestParam(value = "rows", required = false) int rows,
                                @RequestParam(value = "user", required = false) User user) {
        return identifyReturnType(userService.findAllByPage(page-1, rows, user));
    }

    @GetMapping("/findUserById")
    public Object findUserById(@RequestParam(value = "id", required = false) String id){
        return identifyReturnType(userService.findUserById(id));
    }

    @PostMapping("/saveUser")
    public Object saveUser(User user){
        return identifyReturnType(userService.updateUser(user));
    }
}
