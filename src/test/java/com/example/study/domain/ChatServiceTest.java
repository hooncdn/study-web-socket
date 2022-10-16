package com.example.study.domain;

import com.example.study.service.ChatService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ChatServiceTest {

    @Autowired ChatService chatService;

    @Test
    void createChatRoom() {
        ChatRoom room = chatService.createChatRoom("room");
        List<ChatRoom> rooms = chatService.findAll();

        assertThat(rooms.get(0)).isEqualTo(room);
    }
}