package kr.hs.dgsw.summerhackathon.domain.chat.presentation;

import kr.hs.dgsw.summerhackathon.domain.chat.domain.ChatMessage;
import kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.request.ChatMessageRequest;
import kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.response.ChatNotificationResponse;
import kr.hs.dgsw.summerhackathon.domain.chat.service.ChatMessageService;
import kr.hs.dgsw.summerhackathon.domain.chat.service.ChatRoomService;
import kr.hs.dgsw.summerhackathon.domain.chat.service.ProcessMessageService;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import kr.hs.dgsw.summerhackathon.global.annotation.AuthGuard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;
    private final UserRepository userRepository;
    private final ProcessMessageService processMessageService;

    @MessageMapping("/chat")
    @AuthGuard
    public void processMessage(
            /*@Payload ChatMessage chatMessage*/
            @Payload ChatMessageRequest request,
            @RequestAttribute Long userId
    ) {

        processMessageService.sendMessage(userId, request);
    }

    @GetMapping("/messages/{recipientId}")
    @AuthGuard
    public ResponseEntity<?> findChatMessages ( @RequestAttribute Long userId,
                                                @PathVariable String recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(userId, recipientId));
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<?> findMessage ( @PathVariable Long id) {
        return ResponseEntity
                .ok(chatMessageService.findById(id));
    }

}
