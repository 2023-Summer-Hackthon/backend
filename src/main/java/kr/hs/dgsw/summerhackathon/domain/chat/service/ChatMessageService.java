package kr.hs.dgsw.summerhackathon.domain.chat.service;

import kr.hs.dgsw.summerhackathon.domain.chat.domain.ChatMessage;
import kr.hs.dgsw.summerhackathon.domain.chat.domain.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public long countNewMessages(String senderId, String recipientId) {
        return chatMessageRepository.countBySenderIdAndRecipientId(
                senderId, recipientId);
    }

    public List<ChatMessage> findChatMessages(Long userId, String recipientId) {
        var chatId = chatRoomService.getChatId(userId.toString(), recipientId, false);

        var messages =
                chatId.map(cId -> chatMessageRepository.findByChatId(cId)).orElse(new ArrayList<>());

        return messages;
    }

    public ChatMessage findById(Long id) {
        return chatMessageRepository
                .findById(id)
                .map(chatMessageRepository::save)
                .orElseThrow(() ->
                        new RuntimeException("can't find message (" + id + ")"));
    }
}
