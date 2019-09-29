package com.dthealth.mq;


import com.dthealth.mq.interfaces.ProducerResultInterface;
import net.sf.json.JSONArray;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

abstract public class MessageProducer{
    private Producer<String, Object> producer;
    public void send(String topic, Properties props, String key, Object value, ProducerResultInterface resultInterface) {
        producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<>(topic, key, value), resultInterface);
        producer.close();
    }
}
