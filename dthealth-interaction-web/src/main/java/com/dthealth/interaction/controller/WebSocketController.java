package com.dthealth.interaction.controller;

import com.dthealth.interaction.entity.Message;
import com.dthealth.utility.json.JsonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    private JsonUtility jsonUtility = new JsonUtility();

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/toPlatform")
    public void toPlatform(@Payload String object) {
        // TODO: 9/13/2019  
    }

    @MessageMapping("/toUser")
    public void toUser(@Payload String object) {
        Message message = jsonUtility.jsonToObject(object, Message.class);
        template.convertAndSendToUser(message.getObjectId(), "/topic/message", object);
    }

}
