package me.park.chatting.demochatting.record;

import lombok.Builder;

@Builder
public record ChatMessageCreateCommand(Long roomId, String content, String from) {
}
