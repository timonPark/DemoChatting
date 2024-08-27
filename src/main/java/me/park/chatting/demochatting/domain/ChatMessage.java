package me.park.chatting.demochatting.domain;

public class ChatMessage {
  private String content;  // 메시지 내용
  private String sender;   // 발신자 아이디
  private String roomId;   // 채팅방 ID

  // Getters and Setters
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getRoomId() {
    return roomId;
  }

  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }
}

