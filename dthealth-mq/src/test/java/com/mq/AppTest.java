package com.mq;

import com.dthealth.mq.MessageConsumer;
import com.dthealth.mq.MessageProducer;
import com.dthealth.mq.interfaces.ConsumerOperationInterface;
import com.dthealth.mq.interfaces.ProducerResultInterface;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AppTest {

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
//    @Test
//    public void testProducer() {
//        for (int i = 0; i < 11; i++) {
//            messageProducer.send("test", Integer.toString(i), Integer.toString(i), new ProducerResultInterface() {
//                @Override
//                public void onCompletion(RecordMetadata metadata, Exception e) {
//                    System.out.println(metadata.offset());
//                }
//            });
//        }
//    }
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
