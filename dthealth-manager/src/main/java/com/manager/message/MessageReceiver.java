package com.manager.message;

import com.mq.MessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MessageReceiver {
    @Autowired
    MessageConsumer messageConsumer;

    public void receive() {
        messageConsumer.receive("test-consumer-group", Arrays.asList("DTS"), records -> {
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        });
    }
}
