package com.dthealth.dao.service;



public interface TokenService {
    String generateToken(boolean userAgent, String userAccount);

//    void save(String token, User user) throws JsonProcessingException;

    String storeToken(String userAccount, String role, long seconds) throws Exception;

    String getBodyByToken(String token);

    boolean hasKey(String token);

    void deleteByKey(String key);
}
