package me.park.chatting.demochatting.chat.controller;

import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

@Controller
@RequiredArgsConstructor
public class ChatController {

    final private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chatroom/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, ChatMessage message) {
        System.out.println("--------sendMessage--------");
        System.out.println(message);
        System.out.println("----------------------------");
        messagingTemplate.convertAndSend("/topic/chatroom/" + roomId, message);
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

