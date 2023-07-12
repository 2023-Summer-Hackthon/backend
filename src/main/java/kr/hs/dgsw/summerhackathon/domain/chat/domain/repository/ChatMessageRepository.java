package kr.hs.dgsw.summerhackathon.domain.chat.domain.repository;

import kr.hs.dgsw.summerhackathon.domain.chat.domain.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {
    Long countBySenderIdAndRecipientId(
            String senderId, String recipientId);

    List<ChatMessage> findByChatId(String chatId);
}
