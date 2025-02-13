package com.kokoro.chatroom.websocket;

import com.kokoro.chatroom.websocket.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/chat-message")
    public Message receiveMessage(Message message) {
        return message;
    }
}
