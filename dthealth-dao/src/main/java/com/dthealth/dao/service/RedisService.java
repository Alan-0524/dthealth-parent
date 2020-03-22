package com.dthealth.dao.service;

public interface RedisService {

	String storeToken(String userAccount, String role, long seconds) throws Exception;

	void storeBodyIndex(String userAccount, String bodyIndex, long seconds) throws Exception;

	String getBodyByKey(String key);

	boolean hasKey(String token);

	void deleteByKey(String key);
}
