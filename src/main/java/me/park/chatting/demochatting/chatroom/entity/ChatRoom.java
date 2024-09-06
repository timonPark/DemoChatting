package me.park.chatting.demochatting.chatroom.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_room")
public class ChatRoom {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  // 채팅방 고유 ID

  @Column(nullable = false, unique = true)
  private String name;  // 채팅방 이름

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;  // 채팅방 생성일시

  @Column(nullable = false)
  private LocalDateTime updatedAt;  // 채팅방 수정일시

  // 기본 생성자
  public ChatRoom() {
  }

  // 생성자
  public ChatRoom(String name) {
    this.name = name;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  // getter 및 setter 메서드
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  // 업데이트 메서드
  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}
