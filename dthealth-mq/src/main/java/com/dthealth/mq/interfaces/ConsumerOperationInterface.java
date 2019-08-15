package com.dthealth.mq.interfaces;

import org.apache.kafka.clients.consumer.ConsumerRecords;

public interface ConsumerOperationInterface {
    void operate(ConsumerRecords<String, String> records);
}
