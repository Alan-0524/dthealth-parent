package app.message;


import com.mq.MessageProducer;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    MessageProducer messageProducer = new MessageProducer();

    public void send(String topic, String key, String value) {
        messageProducer.send(topic, key, value, (metadata, e) -> {
            if (e != null) {
                e.printStackTrace();
            } else {
                System.out.println("The offset of the record we just sent is: " + metadata.offset());
            }
        });
    }
}
