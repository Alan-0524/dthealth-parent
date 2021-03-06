package com.dthealth.cache.service.impl;

import com.dthealth.cache.service.CacheService;
import com.dthealth.dao.service.RedisService;
import com.dthealth.mq.MessageConsumer;
import com.dthealth.mq.interfaces.ConsumerOperationInterface;
import com.dthealth.utility.logger.BaseLogger;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class CacheServiceImpl extends MessageConsumer implements CacheService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private BaseLogger baseLogger;
    private String content = "";
    private StringBuilder stringBuilder = new StringBuilder();
    private static List<String> topics = new ArrayList<String>() {{
        add("DTS");
    }};
    private static Properties props = new Properties();

    @Override
    public void extractAndWrite(){
        baseLogger.writeInfo("info", "Start extracting and writing message into Redis");
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test-consumer-group");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        super.receive(new KafkaConsumer<>(props), topics, new ConsumerOperationInterface() {
            @Override
            public void operate(ConsumerRecords<String, Object> records) throws Exception {
                for (ConsumerRecord<String, Object> record : records) {
                    content = stringBuilder.append(record.value()).append("@@@").append(record.timestamp()).toString();
                    redisService.storeBodyIndex(record.key(), content, 2L);
                    stringBuilder.delete(0, content.length());
                }
            }
        });
    }
}
