package me.park.chatting.demochatting.service.in;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.annotation.UseCase;
import me.park.chatting.demochatting.domain.ChatRoom;
import me.park.chatting.demochatting.service.ChatRoomCreateCommand;
import me.park.chatting.demochatting.service.out.CreateChatRoomPort;

@UseCase
@RequiredArgsConstructor
@Transactional
class CreateChatRoomService implements ChatRoomCreateUseCase {
  private final CreateChatRoomPort createChatRoomPort;
  @Override
  public boolean createChatRoom(ChatRoomCreateCommand command) {
    ChatRoom chatRoom = ChatRoom.builder()
        .build();
    return createChatRoomPort.createChatRoom(chatRoom);
  }

}
