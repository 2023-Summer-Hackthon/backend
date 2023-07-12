package kr.hs.dgsw.summerhackathon.domain.chat.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Getter
@Document
@Builder
public class ChatMessage {
    @Id
    private Long id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String senderName;
    private String recipientName;
    private String content;
    private LocalDateTime timestamp;

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
