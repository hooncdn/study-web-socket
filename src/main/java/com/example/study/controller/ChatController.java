package com.example.study.controller;

import com.example.study.domain.ChatMessage;
import com.example.study.domain.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (message.getMessageType().equals(MessageType.ENTER)) {
            message.writeMessage(message.getSender() + " has connected.");
        }

        System.out.println("message = " + message);
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getId(), message);
    }
}
