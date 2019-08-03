package com.mq;

import com.mq.interfaces.ProducerResultInterface;
import org.apache.kafka.clients.producer.*;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


@Component
public class MessageProducer {
    public void send(String topic, String key, String value, ProducerResultInterface resultInterface) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "40.126.235.26:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<String, String>(topic, key, value), resultInterface);
        producer.close();
    }
}
