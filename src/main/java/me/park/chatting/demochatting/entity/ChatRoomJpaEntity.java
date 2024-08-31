package me.park.chatting.demochatting.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "chat_rooms")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "chat_room_id")
  private Long chatRoomId;

  //    @BatchSize(size = 10)
  @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private final List<ChatMessageJpaEntity> chatMessageList = new ArrayList<>();

  public void createMessage(ChatMessageJpaEntity chatMessageJpaEntity){
    chatMessageList.add(chatMessageJpaEntity);
  }

}
