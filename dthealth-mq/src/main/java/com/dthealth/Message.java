package com.dthealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Message {

    @Autowired
    private MqService mqService;

    public void call() {
        mqService.messageSend();
    }
}
