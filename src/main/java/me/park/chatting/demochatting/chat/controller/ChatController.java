package me.park.chatting.demochatting.chat.controller;

import me.park.chatting.demochatting.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("--------sendMessage--------");
        System.out.println(message);
        System.out.println("----------------------------");
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
        // WebSocket 세션에 사용자 이름 저장
        System.out.println("----------------------------");
        System.out.println("addUser: " + message.getSender());
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        System.out.println("----------------------------");
        return message;
    }
}

