package me.park.chatting.demochatting.service.in;

import me.park.chatting.demochatting.service.ChatRoomCreateCommand;

public interface ChatRoomCreateUseCase {
  boolean createChatRoom(ChatRoomCreateCommand command);
}
