package com.mq;

import com.dthealth.dao.entity.BodyIndex;
import com.dthealth.mq.MessageProducer;
import com.dthealth.mq.interfaces.ProducerResultInterface;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.Properties;
import java.util.Random;

public class AppTest extends MessageProducer {

    //      @Test
//      public void testLong(){
//          System.out.println(4L);
//      }
//    MessageConsumer messageConsumer = new MessageConsumer();
//
//
//    MessageProducer messageProducer = new MessageProducer();
//
//    /**
//     * Rigorous Test :-)
//     */
//    @Test
//    public void shouldAnswerWithTrue() {
//        assertTrue(true);
//    }
//
    @Test
    public void testProducer() throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "139.180.163.0:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        BodyIndex bodyIndex;
        while (true) {
            bodyIndex = new BodyIndex();
            Random random = new Random();

            super.send("DTS", props, "long.an.0524@gmail.com", String.valueOf(new Random().nextInt()), new ProducerResultInterface() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    System.out.println(metadata.offset());
                }
            });
            Thread.sleep(1000L);
        }
    }
//
//    @Test
//    public void testConsumer(){
//        messageConsumer.receive("test-consumer-group", Arrays.asList("test"), new ConsumerOperationInterface(){
//            @Override
//            public void operate(ConsumerRecords<String, String> records) {
//                for (ConsumerRecord<String, String> record : records)
//                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        });
//    }
}
