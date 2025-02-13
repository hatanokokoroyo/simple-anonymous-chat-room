package com.kokoro.chatroom.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatRoomWebSocketBrokerConfigurer implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 使用内存消息代理
        registry.enableSimpleBroker("/topic");
        // 客户端发送消息的请求前缀
        registry.setApplicationDestinationPrefixes("/chat-message");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个STOMP的endpoint，并指定使用SockJS协议
        registry.addEndpoint("/sendMessage").withSockJS();
    }
}
