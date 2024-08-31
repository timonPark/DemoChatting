package me.park.chatting.demochatting.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ChatMessage{
  private ChatId chatId;
  private String writer;
  private String content;
  private ChatRoom.RoomId chatRoomId;
  public record ChatId(Long value) {
  }
}

