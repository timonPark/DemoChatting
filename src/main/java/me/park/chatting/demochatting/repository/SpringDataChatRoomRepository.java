package me.park.chatting.demochatting.repository;

import me.park.chatting.demochatting.entity.ChatRoomJpaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataChatRoomRepository extends JpaRepository<ChatRoomJpaEntity, Long> {
  Slice<ChatRoomJpaEntity> findAllBy(Pageable pageable);
}
