package kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ChatMessageRequest {
    private String chatId;
    private String recipientId;
    private String recipientName;
    private String content;
    private Date timestamp;

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
