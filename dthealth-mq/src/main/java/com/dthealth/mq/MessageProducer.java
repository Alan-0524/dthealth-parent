package com.dthealth.mq;


import com.dthealth.mq.interfaces.ProducerResultInterface;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class MessageProducer {
    public void send(String topic, String key, String value, ProducerResultInterface resultInterface) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "139.180.163.0:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<String, String>(topic, key, value), resultInterface);
        producer.close();
    }
}
