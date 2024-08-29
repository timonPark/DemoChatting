package me.park.chatting.demochatting.controller;

import me.park.chatting.demochatting.domain.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  @MessageMapping("/sendMessage")
  @SendTo("/topic")
  public ChatMessage sendMessage(ChatMessage message) {
    // 메시지를 브로드캐스팅할 준비를 합니다.
    // 클라이언트가 지정한 채팅방(roomId)으로 메시지를 전송합니다.
    return message;
  }
}
