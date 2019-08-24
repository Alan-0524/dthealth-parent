package com.dthealth.dao.service;

import com.dthealth.dao.entity.SimpleMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisPublisher {
    @Resource
    private RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

    private ChannelTopic channelTopic;

    public void publish(String topic, String content) {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setContent(content);
        channelTopic = new ChannelTopic(topic);
        redisTemplate.convertAndSend(channelTopic.getTopic(), simpleMessage);
    }
}
