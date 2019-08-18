package com.dthealth.mq;


import com.dthealth.mq.interfaces.ConsumerOperationInterface;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;

abstract public class MessageConsumer{

    public void receive(KafkaConsumer<String, String> consumer, List<String> topics, ConsumerOperationInterface consumerOperationInterface) {
        consumer.subscribe(topics);
        // 消费者必须持续对Kafka进行轮询，否则会被认为已经死亡，它的分区就会被移交给群组里的其它消费者
        // 在消费者的缓冲区里没有可用数据时会发生阻塞
        // 返回一个记录列表，每条记录包含
        //  1. 记录所属主题的信息
        //  2. 记录所在分区的信息
        //  3. 记录在分区里的偏移量
        //  4. 记录的键值对
        // timeout参数指定多久之后可以返回，不管有没有可用的数据，0会立即返回
        ConsumerRecords<String, String> records;
        try {
            while (true) {
                records = consumer.poll(Duration.ofMillis(100));
                if (records != null) {
                    consumerOperationInterface.operate(records);
                }
            }
        } finally {
            // 网络连接和Socket也会随之关闭
            // 并且立即触发一次再均衡，而不是等待群组协调器发现它不再发送心跳并认定它已死亡
            //  因为那样需要更长的时间，导致整个群组在一段时间内无法读取消息
            consumer.close();
        }
    }
}
