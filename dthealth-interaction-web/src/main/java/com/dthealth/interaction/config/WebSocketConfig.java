package com.dthealth.interaction.config;

import com.dthealth.dao.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Autowired
    RedisService redisService;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/handshake").addInterceptors(new HandshakeInterceptor() {
            @Override
            public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
                ServletServerHttpRequest req = (ServletServerHttpRequest) serverHttpRequest;
                String token = req.getServletRequest().getHeader("token");
                if(StringUtils.isEmpty(token)){
                    return false;
                }
                map.put("user", token);
                return true;
            }

            @Override
            public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
            }
        }).setHandshakeHandler(new DefaultHandshakeHandler() {
            @Override
            protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
                return () -> (String) attributes.get("user");
            }
        }).withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        long[] heartbeat = {10000,10000};
        /**
         *   /topic/greetings, Android subscribe broadcast channel by this channel
         * */
        config.enableSimpleBroker("/topic") //
                .setTaskScheduler(new DefaultManagedTaskScheduler()) // enable heartbeats
                .setHeartbeatValue(heartbeat);
        /**
         *   /queue/toPlatform, corresponded to controller, Android send message to platform by this path
         * */
        config.setApplicationDestinationPrefixes("/queue");//
        /**
         *   /user/topic/greetings , Android subscribe personal channel by this channel
         * */
        config.setUserDestinationPrefix("/user"); //
    }
}
