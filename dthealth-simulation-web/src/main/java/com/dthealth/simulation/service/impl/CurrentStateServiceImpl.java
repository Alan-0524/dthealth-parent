package com.dthealth.simulation.service.impl;

import com.dthealth.mq.MessageConsumer;
import com.dthealth.simulation.service.CurrentStateService;
import com.dthealth.utility.logger.BaseLogger;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CurrentStateServiceImpl extends MessageConsumer implements CurrentStateService {
    @Autowired
    private BaseLogger baseLogger;
    private static List<String> topics = new ArrayList<String>() {{
        add("DTS");
    }};
    private static Properties props = new Properties();
    private Map<String, String> map;

//    @Override
//    public ServerSentEvent<String> loadingCurrentState(String userAccount) {
//        String data = redisService.getBodyByKey(userAccount);
//        if (null != data) {
//            serverSentEvent = ServerSentEvent.<String>builder().data(data).build();
//        } else {
//            serverSentEvent = ServerSentEvent.<String>builder().data("0").build();
//        }
//        return serverSentEvent;
//    }

    @Override
    public String getCurrentState(String userAccount, String type) {
        return map.get(userAccount + "-" + type);
    }

    @Override
    public void loadingMessage() {
        map = new HashMap<>(20000);
        baseLogger.writeInfo("info", "Start loading message...........");
        props.setProperty("bootstrap.servers", "139.180.163.0:9092");
        props.setProperty("group.id", "test-consumer-group");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        super.receive(new KafkaConsumer<>(props), topics, records -> {
            for (ConsumerRecord<String, String> record : records) {
                map.put(record.key(), record.value()+"@@@"+record.timestamp());
            }
        });
    }
}
