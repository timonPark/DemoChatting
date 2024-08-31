package me.park.chatting.demochatting.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.annotation.UseCase;
import me.park.chatting.demochatting.domain.ChatMessage;
import me.park.chatting.demochatting.domain.ChatRoom.RoomId;
import me.park.chatting.demochatting.record.ChatMessageCreateCommand;
import me.park.chatting.demochatting.service.in.ChatMessageCreateUseCase;
import me.park.chatting.demochatting.service.out.CreateChatMessagePort;

@UseCase // 사용자 정의 Component
@RequiredArgsConstructor
@Transactional
class CreateChatMessageService implements ChatMessageCreateUseCase {
  private final CreateChatMessagePort createChatMessagePort;

  @Override
  public Long createChatMessage(ChatMessageCreateCommand command) {
    ChatMessage chatMessage = ChatMessage.builder()
        .chatRoomId(new RoomId(command.roomId()))
        .content(command.content())
        .writer(command.from())
        .build();
    return createChatMessagePort.createChatMessage(chatMessage);
  }
}
