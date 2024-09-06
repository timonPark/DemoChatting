package me.park.chatting.demochatting.chatroom.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.chatroom.entity.ChatRoom;
import me.park.chatting.demochatting.chatroom.service.ChatRoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatrooms")
public class ChatRoomController {

  private final ChatRoomService chatRoomService;

  // 채팅방 생성
  @PostMapping
  public ChatRoom createRoom(@RequestParam String name) {
    return chatRoomService.createRoom(name);
  }

  // 전체 채팅방 조회
  @GetMapping
  public List<ChatRoom> findAllRooms() {
    return chatRoomService.findAllRooms();
  }
}
