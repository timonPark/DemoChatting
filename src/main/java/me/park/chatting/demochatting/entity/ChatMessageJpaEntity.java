package me.park.chatting.demochatting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "chat_messages")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "chat_message_id")
  private Long chatMessageId;
  private String content;
  private String writer;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "chat_room_id")
  private ChatRoomJpaEntity chatRoom;
}
