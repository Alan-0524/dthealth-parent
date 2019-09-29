package com.dthealth.interaction.service;

import com.dthealth.interaction.entity.User;
import com.dthealth.utility.controller.ResultResponse;

public interface UserService {
    ResultResponse addUser(User user);

    ResultResponse updateUser(User user);

    ResultResponse deleteUser(User user);

    ResultResponse findAllByPage(int page, int rows,User user);

    ResultResponse findUserById(String id);
}
