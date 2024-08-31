package me.park.chatting.demochatting.service.out;

import java.util.List;
import me.park.chatting.demochatting.domain.ChatRoom;
import org.springframework.data.domain.PageRequest;

public interface LoadChatRoomPort {
  ChatRoom loadById(Long roomId, PageRequest pageRequest);
  List<ChatRoom> search(PageRequest pageRequest);
}
