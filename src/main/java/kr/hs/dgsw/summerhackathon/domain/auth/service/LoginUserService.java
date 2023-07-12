package kr.hs.dgsw.summerhackathon.domain.auth.service;

import kr.hs.dgsw.summerhackathon.domain.auth.presentation.dto.response.TokenDto;
import kr.hs.dgsw.summerhackathon.domain.auth.presentation.dto.request.LoginUserRequest;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import kr.hs.dgsw.summerhackathon.global.lib.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginUserService {

    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    @Transactional
    public TokenDto execute(LoginUserRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> new RuntimeException("없는 계정"));

        if (!BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비번 틀림");
        }

        return new TokenDto(
                jwtProvider.execute(request.getAccountId())
        );
    }

}
