package kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatNotificationResponse {
    private String id;
    private String senderId;
    private String senderName;
}
