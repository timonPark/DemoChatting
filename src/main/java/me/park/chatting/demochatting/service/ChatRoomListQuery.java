package me.park.chatting.demochatting.service;

import lombok.Builder;

@Builder
public record ChatRoomListQuery(int page, int size) {
}
