package com.example.study.controller;

import com.example.study.domain.ChatRoom;
import com.example.study.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatService chatService;

    @GetMapping("/room/{id}")
    public String room(@PathVariable Long id, Model model) {
        ChatRoom room = chatService.findById(id);
        model.addAttribute("room", room);
        model.addAttribute("randomUsername", UUID.randomUUID().toString());
        return "room";
    }
}
