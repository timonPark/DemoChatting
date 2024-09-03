package me.park.chatting.demochatting.service.in;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.annotation.UseCase;
import me.park.chatting.demochatting.domain.ChatRoom;
import me.park.chatting.demochatting.service.ChatRoomItemResponse;
import me.park.chatting.demochatting.service.ChatRoomListQuery;
import me.park.chatting.demochatting.service.ChatRoomListReadResponse;
import me.park.chatting.demochatting.service.ChatRoomQuery;
import me.park.chatting.demochatting.service.ChatRoomResponse;
import me.park.chatting.demochatting.service.out.LoadChatRoomPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@UseCase
@RequiredArgsConstructor
class LoadChatRoomService implements ChatRoomLoadUseCase {
  private final LoadChatRoomPort loadChatRoomPort;
  @Override
  public ChatRoomResponse getChatRoomById(ChatRoomQuery chatRoomQuery) {
    PageRequest pageRequest = PageRequest.of(chatRoomQuery.page(), chatRoomQuery.size());
    ChatRoom chatRoom = loadChatRoomPort.loadById(chatRoomQuery.id(), pageRequest);

    return ChatRoomResponse.builder()
        .roomId(chatRoom.getRoomId().value())
        .build();
  }

  @Override
  public ChatRoomListReadResponse getChatRoomList(ChatRoomListQuery query) {
    PageRequest pageRequest = PageRequest.of(query.page(), query.size(), Sort.by("chatRoomId").descending());
    List<ChatRoom> chatRoomList = loadChatRoomPort.search(pageRequest);
    ChatRoomListReadResponse response = ChatRoomListReadResponse.builder()
        .messageList(chatRoomList.stream().map(chatRoom -> ChatRoomItemResponse.builder()
                .roomId(chatRoom.getRoomId().value())
                .build())
            .collect(Collectors.toList()))
        .build();
    return response;
  }
}
