package com.dthealth.interaction.service.impl;

import com.dthealth.dao.service.RedisService;
import com.dthealth.interaction.service.CurrentStateService;
import com.dthealth.utility.logger.BaseLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class CurrentStateServiceImpl implements CurrentStateService {
    @Autowired
    RedisService redisService;
    @Autowired
    private BaseLogger baseLogger;
    private static List<String> topics = new ArrayList<String>() {{
        add("DTS");
    }};
    private static Properties props = new Properties();
    private Map<String, String> map;

    @Override
    public String loadingCurrentHeartbeat(String id) {
        String value = "";
        try {
            value = redisService.getBodyByKey(id + "-heartbeat");
        } catch (Exception e) {
            baseLogger.writeError("loadingCurrentHeartbeat",e.getMessage());
        }
        return value;
    }

    @Override
    public String loadingOtherIndex(String id) {
        String value = "";
        try {
            value = redisService.getBodyByKey(id + "-index");
        } catch (Exception e) {
            baseLogger.writeError("loadingCurrentHeartbeat",e.getMessage());
        }
        return value;
    }

//    @Override
//    public String getCurrentState(String userAccount, String type) {
//        return map.get(userAccount + "-" + type);
//    }
//
//    @Override
//    public void loadingMessage() {
//        map = new HashMap<>(20000);
//        baseLogger.writeInfo("info", "Start loading message...........");
//        props.setProperty("bootstrap.servers", "139.180.163.0:9092");
//        props.setProperty("group.id", "test-consumer-group");
//        props.setProperty("enable.auto.commit", "true");
//        props.setProperty("auto.commit.interval.ms", "1000");
//        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        super.receive(new KafkaConsumer<>(props), topics, records -> {
//            for (ConsumerRecord<String, String> record : records) {
//                map.put(record.key(), record.value()+"@@@"+record.timestamp());
//            }
//        });
//    }
}
