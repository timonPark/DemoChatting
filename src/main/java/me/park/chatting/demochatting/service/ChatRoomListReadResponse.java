package me.park.chatting.demochatting.service;

import java.util.List;
import lombok.Builder;

@Builder
public record ChatRoomListReadResponse(List<ChatRoomItemResponse> messageList, boolean hasNext) {
}
