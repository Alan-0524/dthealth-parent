package com.dthealth.mq.entities;

import com.dthealth.mq.MessageProducer;
import com.dthealth.mq.interfaces.ProducerResultInterface;
import com.dthealth.utility.json.JsonUtility;
import net.sf.json.JSONArray;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Thread_otherIndex extends MessageProducer implements Runnable {
    JsonUtility jsonUtility = new JsonUtility();
    private String id;

    public Thread_otherIndex(String id) {
        this.id = id;
    }

    BodyIndex bodyIndex;

    @Override
    public void run() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "139.180.163.0:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try {
            while (true) {
                bodyIndex = new BodyIndex();
                bodyIndex.setBloodFat((float) (new Random().nextInt(20) + 100 + (new Random().nextInt(2) + (-1)) * 0.3));
                bodyIndex.setBloodGlucose((float) (new Random().nextInt(5) + 7 + (new Random().nextInt(2) + (-1)) * 0.3));
                bodyIndex.setBloodPressure((float) (new Random().nextInt(40) + 60 + (new Random().nextInt(2) + (-1)) * 0.3));
                bodyIndex.setTemperature((float) (37 + (new Random().nextInt(2) + (-1)) * 0.3));
                send("DTS", props, id + "-index", JSONArray.fromObject(bodyIndex).toString(), new ProducerResultInterface() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception e) {
                        System.out.println(metadata.offset());
                    }
                });
                sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
