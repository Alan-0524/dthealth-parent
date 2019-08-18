package com.dthealth.dao.service.impl;

import com.dthealth.dao.entity.BodyIndex;
import com.dthealth.dao.service.RedisService;
import com.dthealth.dao.utility.RedisUtility;
import com.dthealth.utility.json.JsonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisUtility redisUtility;
    @Autowired
    private JsonUtility jsonUtility;

    //生成token(格式为token:设备-加密的用户帐号-时间-六位随机数)
    public String generateToken(boolean userAgent, String userAccount) {
        StringBuilder token = new StringBuilder("token:");

        if (userAgent) {
            token.append("MOBILE-");
        } else {
            token.append("PC-");
        }
        //加密的用户名
        token.append(userAccount).append("-");
        //时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())).append("-");
        //六位随机字符串
        token.append(new Random().nextInt(999999 - 111111 + 1) + 111111);
        return token.toString();
    }


    //    //把token存到redis中
//    public void save(String token, User user) throws JsonProcessingException {
//        String json = mapper.writeValueAsString(user);
//        if (token.startsWith("token:PC")) {
//            redisUtility.setWithExpiry(token, json, 60 * 60);
//        } else {
//            redisUtility.set(token, json, 3 * 60 * 60);
//        }
//    }
    @Override
    public String storeToken(String userAccount, String role, long seconds) throws Exception {
        String uuid = UUID.randomUUID().toString();
        String value = userAccount + "-" + role;
        redisUtility.set(uuid, value, seconds);
        return uuid;
    }

    @Override
    public void storeBodyIndex(String userAccount, String bodyIndex, long seconds) throws Exception {
        redisUtility.set(userAccount, bodyIndex, seconds);
    }

    @Override
    public String getBodyByKey(String key) {
        return (String) redisUtility.get(key);
    }

    @Override
    public boolean hasKey(String token) {
        return redisUtility.hasKey(token);
    }

    @Override
    public void deleteByKey(String key) {
        redisUtility.del(key);
    }
}
