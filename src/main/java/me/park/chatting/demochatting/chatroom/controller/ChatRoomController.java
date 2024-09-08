package me.park.chatting.demochatting.chatroom.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.chatroom.dto.ChatRoomRequestDto;
import me.park.chatting.demochatting.chatroom.entity.ChatRoom;
import me.park.chatting.demochatting.chatroom.service.ChatRoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

  private final ChatRoomService chatRoomService;

  // 채팅방 생성
  @PostMapping
  public ChatRoom createRoom(@RequestBody ChatRoomRequestDto chatRoomRequestDto) {
    return chatRoomService.createRoom(chatRoomRequestDto.getName());
  }

  // 전체 채팅방 조회
  @GetMapping
  public List<ChatRoom> findAllRooms() {
    return chatRoomService.findAllRooms();
  }
}
