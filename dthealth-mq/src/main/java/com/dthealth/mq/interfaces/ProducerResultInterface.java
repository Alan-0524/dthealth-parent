package com.dthealth.mq.interfaces;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public interface ProducerResultInterface extends Callback {
    void onCompletion(RecordMetadata metadata, Exception e);
}
