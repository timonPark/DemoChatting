package me.park.chatting.demochatting.controller;

import lombok.RequiredArgsConstructor;
import me.park.chatting.demochatting.common.response.SuccessApiResponse;
import me.park.chatting.demochatting.service.ChatRoomCreateCommand;
import me.park.chatting.demochatting.service.ChatRoomListQuery;
import me.park.chatting.demochatting.service.ChatRoomQuery;
import me.park.chatting.demochatting.service.ChatRoomResponse;
import me.park.chatting.demochatting.service.in.ChatRoomCreateUseCase;
import me.park.chatting.demochatting.service.in.ChatRoomLoadUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
class ChatRoomController {
  private final ChatRoomCreateUseCase chatRoomCreateUseCase;
  private final ChatRoomLoadUseCase chatRoomLoadUseCase;

  @PostMapping
  public SuccessApiResponse<?> createChatRoom(){
    ChatRoomCreateCommand chatRoomCreateCommand = ChatRoomCreateCommand.builder()
        .build();
    chatRoomCreateUseCase.createChatRoom(chatRoomCreateCommand);
    return SuccessApiResponse.of();
  }
  @GetMapping("/{roomId}")
  public SuccessApiResponse<?> getChatRoom(@PathVariable Long roomId,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size){
    ChatRoomQuery chatRoomQuery = ChatRoomQuery.builder()
        .id(roomId)
        .page(page)
        .size(size)
        .build();
    ChatRoomResponse chatRoomResponse = chatRoomLoadUseCase.getChatRoomById(chatRoomQuery);
    return SuccessApiResponse.of(chatRoomResponse);
  }
  @GetMapping
  public SuccessApiResponse<?> getChatRoomList( @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size){
    ChatRoomListQuery chatRoomListQuery = ChatRoomListQuery.builder()
        .page(page)
        .size(size)
        .build();
    return SuccessApiResponse.of(chatRoomLoadUseCase.getChatRoomList(chatRoomListQuery));
  }
}
