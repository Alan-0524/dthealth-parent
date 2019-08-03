package app.message;

import com.mq.MessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MessageReceiver {

    private MessageConsumer messageConsumer = new MessageConsumer();

    public void receive() {
        messageConsumer.receive("test-consumer-group", Arrays.asList("DTS"), records -> {
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        });
    }
}
