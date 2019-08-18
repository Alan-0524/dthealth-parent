package com.dthealth.simulation.service.impl;

import com.dthealth.dao.service.RedisService;
import com.dthealth.simulation.service.CurrentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

@Service
public class CurrentStateServiceImpl implements CurrentStateService {
    @Autowired
    private RedisService redisService;
    private ServerSentEvent<String> serverSentEvent;

    @Override
    public ServerSentEvent<String> loadingCurrentState(String userAccount) {
        String data = redisService.getBodyByKey(userAccount);
        if (null != data) {
            serverSentEvent = ServerSentEvent.<String>builder().data(data).build();
        } else {
            serverSentEvent = ServerSentEvent.<String>builder().data("0").build();
        }
        return serverSentEvent;
    }
}
