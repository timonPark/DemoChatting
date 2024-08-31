package me.park.chatting.demochatting.service.out;

import me.park.chatting.demochatting.domain.ChatMessage;

public interface CreateChatMessagePort {
  Long createChatMessage(ChatMessage chatMessage);
}
