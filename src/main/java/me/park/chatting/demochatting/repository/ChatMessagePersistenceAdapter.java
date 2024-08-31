package me.park.chatting.demochatting.repository;

import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.annotation.PersistenceAdapter;
import me.park.chatting.demochatting.domain.ChatMessage;
import me.park.chatting.demochatting.entity.ChatMessageJpaEntity;
import me.park.chatting.demochatting.entity.ChatRoomJpaEntity;
import me.park.chatting.demochatting.service.out.CreateChatMessagePort;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ChatMessagePersistenceAdapter implements CreateChatMessagePort {
  private final SpringDataChatRoomRepository springDataChatRoomRepository;

  @Override
  @Transactional
  public Long createChatMessage(ChatMessage chatMessage) {
    ChatRoomJpaEntity chatRoomJpaEntity = springDataChatRoomRepository.findById(chatMessage.getChatRoomId().value())
        .orElseThrow(RuntimeException::new);
    ChatMessageJpaEntity chatMessageJpaEntity = ChatMessageJpaEntity.builder()
        .chatRoom(chatRoomJpaEntity)
        .content(chatMessage.getContent())
        .writer(chatMessage.getWriter())
        .build();
    chatRoomJpaEntity.createMessage(chatMessageJpaEntity);
    springDataChatRoomRepository.save(chatRoomJpaEntity);
    return chatMessageJpaEntity.getChatMessageId();
  }
}
