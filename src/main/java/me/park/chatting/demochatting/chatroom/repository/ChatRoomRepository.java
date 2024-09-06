package me.park.chatting.demochatting.chatroom.repository;

import java.util.Optional;
import me.park.chatting.demochatting.chatroom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
  Optional<ChatRoom> findByName(String name);
}
