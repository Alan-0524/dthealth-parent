package com.dthealth.interaction.service;

import com.dthealth.mq.MessageConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class MessageExtraction extends MessageConsumer implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private List<String> topics;
    private Properties props;
    private BlockingQueue<ConsumerRecord<String, Object>> jobContainer;
    private int index;
    private SimpMessagingTemplate template;

    public MessageExtraction(List<String> topics, Properties props, int index, SimpMessagingTemplate template) {
        this.topics = topics;
        this.props = props;
        this.jobContainer = new LinkedTransferQueue<>();
        this.index = index;
        this.template = template;
    }

    @Override
    public void run() {
        try {
            logger.info("Thread: {} start working.........", index);
            super.receive(new KafkaConsumer<>(props), topics, (ConsumerRecords<String, Object> records) -> {
                for (ConsumerRecord<String, Object> record : records) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    this.template.convertAndSendToUser(record.key(), "/topic/physicalIndex", record.value());
                    System.out.println(record.value());
                }
            });
        } catch (Exception e) {
            logger.error("MessageExtraction {}", e.toString());
        } finally {
            Thread.currentThread().interrupt();
        }
    }
}
