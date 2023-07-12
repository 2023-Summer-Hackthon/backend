package kr.hs.dgsw.summerhackathon.domain.chat.service;

import kr.hs.dgsw.summerhackathon.domain.chat.domain.ChatMessage;
import kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.request.ChatMessageRequest;
import kr.hs.dgsw.summerhackathon.domain.chat.presentation.dto.response.ChatNotificationResponse;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessMessageService {

    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    private final UserRepository userRepository;
    private final SimpMessagingTemplate messagingTemplate;
    public void execute(
            Long userId,
            ChatMessageRequest request
    ) {
        sendMessage(userId, request);
    }

    public void sendMessage(Long userId, ChatMessageRequest request) {
        String senderId = userId.toString();
        var chatId = chatRoomService.getChatId(senderId, request.getRecipientId(), true)
                .orElseThrow();

        request.setChatId(chatId);

        ChatMessage chatMessage = createChatMessage(chatId, senderId, request, userId);
        ChatMessage saved = chatMessageService.save(chatMessage);

        sendNotification(saved);
    }

    private ChatMessage createChatMessage(
            String chatId, String senderId, ChatMessageRequest request, Long userId
    ) {
        return ChatMessage.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(request.getRecipientId())
                .senderName(userRepository.findById(userId).get().getName())
                .recipientName(request.getRecipientName())
                .content(request.getContent())
                .timestamp(request.getTimestamp())
                .build();
    }

    private void sendNotification(ChatMessage chatMessage) {
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                new ChatNotificationResponse(
                        chatMessage.getId(),
                        chatMessage.getSenderId(),
                        chatMessage.getSenderName()
                )
        );
    }

}
