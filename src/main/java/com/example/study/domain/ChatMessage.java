package com.example.study.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMessage {

    @Id @GeneratedValue
    private Long id;

    private String sender;
    private String message;

    private Long roomId;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    public void writeMessage(String message) {
        this.message = message;
    }
}
