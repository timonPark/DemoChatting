CREATE TABLE chat_room (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,   -- 채팅방 고유 ID (Primary Key)
                           name VARCHAR(255) NOT NULL UNIQUE,      -- 채팅방 이름 (중복 불가)
                           created_at TIMESTAMP NOT NULL,          -- 채팅방 생성일시
                           updated_at TIMESTAMP NOT NULL           -- 채팅방 수정일시
);

