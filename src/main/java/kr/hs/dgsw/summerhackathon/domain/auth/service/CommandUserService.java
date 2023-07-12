package kr.hs.dgsw.summerhackathon.domain.auth.service;

import kr.hs.dgsw.summerhackathon.domain.auth.presentation.dto.request.CreateUserRequest;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandUserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(CreateUserRequest request) {
        userRepository.save(
                request.toEntity()
        );
    }
}
