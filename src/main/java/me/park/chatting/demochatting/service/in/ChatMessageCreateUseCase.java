package me.park.chatting.demochatting.service.in;

import me.park.chatting.demochatting.record.ChatMessageCreateCommand;

public interface ChatMessageCreateUseCase {
  Long createChatMessage(ChatMessageCreateCommand command);
}
