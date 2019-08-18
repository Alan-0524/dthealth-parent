package com.dthealth.manager.message;

import com.dthealth.mq.MessageProducer;
import com.dthealth.mq.interfaces.ProducerResultInterface;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ManagerMessageSender extends MessageProducer {
    private static Properties props = new Properties();
    private static String topic = "DTS";

    public void send(String key,String value) {
        props.put("bootstrap.servers", "139.180.163.0:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        super.send("DTS", props, key, value, (metadata, e) -> {
            if(e != null) {
            e.printStackTrace();
        } else {
            System.out.println("The offset of the record we just sent is: " + metadata.offset());
        }
        });
    }
}
