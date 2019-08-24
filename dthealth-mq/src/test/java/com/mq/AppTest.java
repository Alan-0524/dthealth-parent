package com.mq;

import com.dthealth.dao.entity.BodyIndex;
import com.dthealth.mq.MessageProducer;
import com.dthealth.mq.interfaces.ProducerResultInterface;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.Properties;
import java.util.Random;


public class AppTest extends MessageProducer {

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
//        System.out.println("starting......");
//        Map<String,String> map = new HashMap<>(20000000);
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            map.put(i+"","sssssssssss");
//        }
//        map.put("00000000","sssssssssss");
//        System.out.println(System.currentTimeMillis()-startTime);
//        startTime = System.currentTimeMillis();
//        String s = map.get("60");
//        System.out.println(s);
//        System.out.println(System.currentTimeMillis()-startTime);
//        map.clear();
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
            //    private String bloodPressure;
//    private String heartbeat;
//    private String bloodFat;
//    private String glucose;
//    private String temperature;
            super.send("DTS", props, "long.an.0524@gmail.com-heartbeat", String.valueOf(new Random().nextInt(5)+60), new ProducerResultInterface() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    System.out.println(metadata.offset());
                }
            });
            Thread.sleep(new Random().nextInt(20)+850);
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
