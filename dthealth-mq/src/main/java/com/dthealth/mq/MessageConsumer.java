package com.dthealth.mq;


import com.dthealth.mq.interfaces.ConsumerOperationInterface;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

@Component
public class MessageConsumer {

    public void receive(String groupId, List<String> topics, ConsumerOperationInterface consumerOperationInterface) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "139.180.163.0:9092");
        props.setProperty("group.id", groupId);
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(topics);
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            if (records != null) {
                consumerOperationInterface.operate(records);
            }
        }
    }
}
