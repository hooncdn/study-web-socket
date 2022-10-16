package com.example.study.service;

import com.example.study.domain.ChatRoom;
import com.example.study.repostiory.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;

    @PostConstruct
    @Transactional
    public void create() {
        ChatRoom room = createChatRoom("room");
        chatRoomRepository.save(room);
    }

    @Transactional
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = new ChatRoom(name);
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom findById(Long id) {
        return chatRoomRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
