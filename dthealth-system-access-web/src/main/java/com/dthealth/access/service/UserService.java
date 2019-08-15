package com.dthealth.access.service;

import com.dthealth.dao.entity.ResultResponse;
import com.dthealth.dao.entity.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ResultResponse login(String userAccount, String password, HttpServletResponse response);

    User findByUserAccount(String userAccount);

    ResultResponse signUp(User user);
}
