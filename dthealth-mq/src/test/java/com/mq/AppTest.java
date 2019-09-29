package com.mq;

import com.dthealth.mq.MessageProducer;
import com.dthealth.utility.json.JsonUtility;

public class AppTest extends MessageProducer {
    JsonUtility jsonUtility = new JsonUtility();
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

//    @Test
//    public void testProducer() throws InterruptedException {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "139.180.163.0:9092");
//        props.put("acks", "all");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        BodyIndex bodyIndex;
//        try {
//            while (true) {
//                bodyIndex = new BodyIndex();
//                bodyIndex.setHeartbeatStrength((float) (new Random().nextInt(20) + 130 + (new Random().nextInt(2) + (-1)) * 0.3));
//                bodyIndex.setBloodFat((float) (new Random().nextInt(20) + 100 + (new Random().nextInt(2) + (-1)) * 0.3));
//                bodyIndex.setBloodGlucose((float) (new Random().nextInt(5) + 7 + (new Random().nextInt(2) + (-1)) * 0.3));
//                bodyIndex.setBloodPressure((float) (new Random().nextInt(40) + 60 + (new Random().nextInt(2) + (-1)) * 0.3));
//                bodyIndex.setTemperature((float) (37 + (new Random().nextInt(2) + (-1)) * 0.3));
//                send("DTS", props, "5d53b73492f6e331bc118715", jsonUtility.objectToJson(bodyIndex), new ProducerResultInterface() {
//                    @Override
//                    public void onCompletion(RecordMetadata metadata, Exception e) {
//                        System.out.println(metadata.offset());
//                    }
//                });
//                sleep(700);
//            }
//        } catch (InterruptedException | JsonProcessingException e) {
//            e.printStackTrace();
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
