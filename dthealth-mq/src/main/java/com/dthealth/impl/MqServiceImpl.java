package com.dthealth.impl;

import com.dthealth.MqService;
import org.springframework.stereotype.Service;

@Service("mqService")
public class MqServiceImpl implements MqService {
    @Override
    public void messageSend() {
        System.out.print("messageSend");
    }

    @Override
    public void messageTransactionalSend() {
        System.out.print("messageTransactionalSend");
    }
}
