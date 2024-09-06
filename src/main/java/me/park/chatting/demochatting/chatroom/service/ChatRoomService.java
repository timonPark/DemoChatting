package me.park.chatting.demochatting.chatroom.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.chatroom.entity.ChatRoom;
import me.park.chatting.demochatting.chatroom.repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

  private final ChatRoomRepository chatRoomRepository;

  // 채팅방 생성
  public ChatRoom createRoom(String name) {
    return chatRoomRepository.save(new ChatRoom(name));
  }

  // 채팅방 전체 조회
  public List<ChatRoom> findAllRooms() {
    return chatRoomRepository.findAll();
  }

  // 채팅방 이름으로 조회
  public Optional<ChatRoom> findByName(String name) {
    return chatRoomRepository.findByName(name);
  }
}
