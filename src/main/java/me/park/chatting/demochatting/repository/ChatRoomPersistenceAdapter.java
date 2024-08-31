package me.park.chatting.demochatting.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.annotation.PersistenceAdapter;
import me.park.chatting.demochatting.domain.ChatRoom;
import me.park.chatting.demochatting.entity.ChatRoomJpaEntity;
import me.park.chatting.demochatting.service.out.CreateChatRoomPort;

@PersistenceAdapter // 사용자 정의 Component
@RequiredArgsConstructor
class ChatRoomPersistenceAdapter implements CreateChatRoomPort {
  private final SpringDataChatRoomRepository springDataChatRoomRepository;

  @Transactional
  @Override
  public boolean createChatRoom(ChatRoom chatRoom) {
    ChatRoomJpaEntity chatRoomJpaEntity = ChatRoomJpaEntity.builder()
        .build();
    springDataChatRoomRepository.save(chatRoomJpaEntity);
    return true;
  }
}
