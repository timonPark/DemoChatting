package me.park.chatting.demochatting.domain;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ChatRoom {
  private RoomId roomId;
  private List<ChatMessage> messageList;
  public record RoomId(Long value) {
  }
}
