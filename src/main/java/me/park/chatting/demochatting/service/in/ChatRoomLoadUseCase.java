package me.park.chatting.demochatting.service.in;

import me.park.chatting.demochatting.service.ChatRoomListQuery;
import me.park.chatting.demochatting.service.ChatRoomListReadResponse;
import me.park.chatting.demochatting.service.ChatRoomQuery;
import me.park.chatting.demochatting.service.ChatRoomResponse;

public interface ChatRoomLoadUseCase {
  ChatRoomResponse getChatRoomById(ChatRoomQuery chatRoomQuery);
  ChatRoomListReadResponse getChatRoomList(ChatRoomListQuery query);
}
