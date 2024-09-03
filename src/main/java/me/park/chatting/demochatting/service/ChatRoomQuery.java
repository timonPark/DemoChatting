package me.park.chatting.demochatting.service;

import lombok.Builder;

@Builder
public record ChatRoomQuery(Long id, int page, int size) {
}
