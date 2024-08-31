package me.park.chatting.demochatting.repository;

import java.util.Optional;
import me.park.chatting.demochatting.entity.ChatRoomJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface SpringDataChatRoomRepository extends JpaRepository<ChatRoomJpaEntity, Long> {
  @Query("select room from ChatRoomJpaEntity room LEFT JOIN FETCH room.chatMessageList message where room.chatRoomId = :id") // N+1 문제 해결을 위한 Fetch join 사용
  @Override
  Optional<ChatRoomJpaEntity> findById(Long id);
}
