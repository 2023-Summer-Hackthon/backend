package kr.hs.dgsw.summerhackathon.domain.user.service;

import kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.request.CreateUserRequest;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommandUserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(CreateUserRequest request) {
        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()))
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .brith(request.getBrith())
                        .gender(request.getGender())
                        .nationality(request.getNationality())
                        .build()
        );
    }
}
