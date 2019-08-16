//package com.dthealth.access.service.impl;
//
//import com.dthealth.access.service.UserService;
//import com.dthealth.dao.entity.User;
//import com.dthealth.dao.service.TokenService;
//import com.dthealth.dao.service.UserRepositoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private UserRepositoryService userRepositoryService;
//
//
//    @Override
//    public ResultResponse login(String userAccount, String password, HttpServletResponse response) {
//        User storedUser = this.findByUserAccount(userAccount);
//        if (null == storedUser) {
//            return new ResultResponse(HttpStatus.BAD_REQUEST, "The user does not exist");
//        }
//        String inputPassword = bCryptPasswordEncoder.encode(password);
//        if (inputPassword.equals(storedUser.getPassword())) {
//            String token = tokenService.generateToken(false, storedUser.getUserAccount());
//            Cookie cookie = new Cookie("token",token);
//            cookie.setMaxAge(24 * 60 * 60);
//            response.addCookie(cookie);
////            tokenService.save(token, storedUser);
//            return new ResultResponse(HttpStatus.OK, token);
//        }
//        return new ResultResponse(HttpStatus.BAD_REQUEST, "Username or password are incorrect");
//    }
//
//    @Override
//    public User findByUserAccount(String userAccount) {
//        return userRepositoryService.findByUserAccount(userAccount);
//    }
//
//    @Override
//    public ResultResponse signUp(User user) {
//        if (null == userRepositoryService.findByUserAccount(user.getUserAccount())) {
//            String password = bCryptPasswordEncoder.encode(user.getPassword());
//            user.setPassword(password);
//            userRepositoryService.save(user);
//            return new ResultResponse(HttpStatus.OK, user);
//        } else {
//            return new ResultResponse(HttpStatus.IM_USED, "The user has already exist");
//        }
//    }
//}
