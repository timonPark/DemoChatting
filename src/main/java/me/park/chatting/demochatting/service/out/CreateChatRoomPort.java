package me.park.chatting.demochatting.service.out;

import me.park.chatting.demochatting.domain.ChatRoom;

public interface CreateChatRoomPort {
  boolean createChatRoom(ChatRoom chatRoom);
}
