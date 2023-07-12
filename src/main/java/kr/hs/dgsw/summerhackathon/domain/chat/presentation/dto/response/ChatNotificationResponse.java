package kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ChatNotificationResponse {
    private String id;
    private String senderId;
    private String senderName;
}
