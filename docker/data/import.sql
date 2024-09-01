create table chat_rooms
(
    chat_room_id bigint AUTO_INCREMENT not null
        primary key
);

create table chat_messages
(
    chat_message_id bigint AUTO_INCREMENT not null
        primary key,
    chat_room_id    bigint       null,
    content         varchar(255) null,
    writer          varchar(255) null,
    constraint FKbcsxusjp1v4rd8879fhvq8ssb
        foreign key (chat_room_id) references chat_rooms (chat_room_id)
);

