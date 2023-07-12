package kr.hs.dgsw.summerhackathon.domain.chat.domain.repository;

import kr.hs.dgsw.summerhackathon.domain.chat.domain.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, Long> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
