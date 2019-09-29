package com.dthealth.interaction.service.impl;

import com.dthealth.interaction.entity.User;
import com.dthealth.interaction.repository.QueryCondition;
import com.dthealth.interaction.repository.QueryResult;
import com.dthealth.interaction.repository.UserRepository;
import com.dthealth.interaction.service.UserService;
import com.dthealth.utility.controller.ResultResponse;
import com.dthealth.utility.logger.BaseLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BaseLogger baseLogger;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResultResponse addUser(User user) {
        try {
            if (this.existUser(user)) {
                return new ResultResponse(HttpStatus.IM_USED, "The user account has been already used");
            }
            Date date = new Date();
            SimpleDateFormat dateFormat_min=new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
            user.setCreateTime(date.toString());
            user.setStatus("0");
            User savedUser = userRepository.save(user);
            return new ResultResponse(HttpStatus.OK, savedUser);
        } catch (Exception e) {
            baseLogger.writeError("addUser", e.getMessage());
            return new ResultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error");
        }
    }

    @Override
    public ResultResponse updateUser(User user) {
        User existUser = findUser(user.getId());
        if (null == existUser) {
            return new ResultResponse(HttpStatus.NOT_FOUND, "not found this user");
        }
        try {
            existUser = user;
            User savedUser = userRepository.save(existUser);
            return new ResultResponse(HttpStatus.OK, savedUser);
        } catch (Exception e) {
            baseLogger.writeError("addUser", e.getMessage());
            return new ResultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error");
        }
    }

    @Override
    public ResultResponse deleteUser(User user) {
        if (!existUser(user)) {
            return new ResultResponse(HttpStatus.NOT_FOUND, "not found this user");
        }
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            baseLogger.writeError("deleteUser", e.getMessage());
            return new ResultResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error");
        }
        return new ResultResponse(HttpStatus.OK, "success");
    }

    @Override
    public ResultResponse findAllByPage(int page, int rows, User user) {
        QueryCondition queryCondition = new QueryCondition();
        if (!StringUtils.isEmpty(user)) {
            queryCondition.addPageSearch(QueryCondition.EXACT, "userAccount", user.getUserAccount());
        }
        QueryResult<User> queryResult = userRepository.findByPage(queryCondition, page, rows);
        List<User> list = format(queryResult.getRows());
        queryResult.setRows(list);
        return new ResultResponse(HttpStatus.OK, queryResult);
    }

    @Override
    public ResultResponse findUserById(String id) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addSearch(QueryCondition.EXACT, "id", id);
        User user = userRepository.findOneObject(queryCondition);
        if(null != user){
            return new ResultResponse(HttpStatus.OK, user);
        }
        return new ResultResponse(HttpStatus.NOT_FOUND, "not found this user");
    }

    private List<User> format(List<User> list) {
        StringBuilder stringBuilder;
        User user;
        String shownGender;
        for (int i = 0, j = list.size(); i < j; i++) {
            user = list.get(i);
            stringBuilder = new StringBuilder(user.getFirstName());
            if (!StringUtils.isEmpty(user.getMiddleName())) {
                stringBuilder.append(" ").append(user.getMiddleName());
            }
            stringBuilder.append(" ").append(user.getLastName());
            user.setFullName(stringBuilder.toString());
            shownGender = user.getGender().equals("0")?"female":"male";
            user.setShownGender(shownGender);
            user.setAge("30");
            list.set(i, user);
        }
        return list;
    }

    private boolean existUser(User user) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addSearch(QueryCondition.EXACT, "userAccount", user.getUserAccount());
        return userRepository.exist(queryCondition);
    }

    private User findUser(String id) {
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.addSearch(QueryCondition.EXACT, "id", id);
        return userRepository.findOneObject(queryCondition);
    }
}
