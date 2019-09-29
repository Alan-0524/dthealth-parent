package com.dthealth.interaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MessageExtractionScheduler {
    @Autowired
    private SimpMessagingTemplate template;
    private static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

    private static List<String> topics = new ArrayList<String>() {{
        add("DTS");
    }};
    private static Properties props = new Properties();

    public void runTasks(){
        props.setProperty("bootstrap.servers", "139.180.163.0:9092");
        props.setProperty("group.id", "test-consumer-group");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        fixedThreadPool.execute(new MessageExtraction(topics,props,0,template));
    }
}
