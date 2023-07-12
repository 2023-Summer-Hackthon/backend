package kr.hs.dgsw.summerhackathon.domain.chat.domain;

import jdk.jfr.Name;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Document
@Builder @AllArgsConstructor @NoArgsConstructor
public class ChatMessage {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String senderName;
    private String recipientName;
    private String content;
    private Date timestamp;

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
