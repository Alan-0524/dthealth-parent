package com.dthealth.manager.message;


import com.dthealth.mq.MessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class ManagerMessageReceiver extends MessageConsumer {

    private static List<String> topics = new ArrayList<String>() {{
        add("DTS");
    }};
    private static Properties props = new Properties();

    public void receive() {
        props.setProperty("bootstrap.servers", "139.180.163.0:9092");
        props.setProperty("group.id", "test-consumer-group");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        super.receive(new KafkaConsumer<>(props), topics, records -> {
            for (ConsumerRecord record :records) {

            }
        });

    }
//    @Autowired
//    MessageConsumer<String> messageConsumer;
//
//    public void receive() {
//        messageConsumer.receive("test-consumer-group", Arrays.asList("DTS"), new ConsumerOperationInterface() {
//            @Override
//            public void operate(ConsumerRecords records) {
//
//            }
//        });
//
//    }
}
