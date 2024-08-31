package me.park.chatting.demochatting.repository;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.annotation.PersistenceAdapter;
import me.park.chatting.demochatting.domain.ChatRoom;
import me.park.chatting.demochatting.entity.ChatRoomJpaEntity;
import me.park.chatting.demochatting.service.out.LoadChatRoomPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

@PersistenceAdapter
@RequiredArgsConstructor
class ChatRoomLoadPersistenceAdapter implements LoadChatRoomPort {
  private final SpringDataChatRoomRepository springDataChatRoomRepository;
  @Override
  public ChatRoom loadById(Long roomId, PageRequest pageRequest) {
    ChatRoomJpaEntity chatRoomJpaEntity = springDataChatRoomRepository.findById(roomId)
        .orElseThrow(RuntimeException::new);
    return ChatRoom.builder()
        .roomId(new ChatRoom.RoomId(chatRoomJpaEntity.getChatRoomId()))
        .build();
  }

  @Override
  public List<ChatRoom> search(PageRequest pageRequest) {
    Slice<ChatRoomJpaEntity> chatRoomJpaEntityList = springDataChatRoomRepository.findAllBy(pageRequest);
    return chatRoomJpaEntityList.stream()
        .map(chatRoomJpaEntity -> ChatRoom.builder()
            .roomId(new ChatRoom.RoomId(chatRoomJpaEntity.getChatRoomId()))
            .build())
        .collect(Collectors.toList());
  }
}
