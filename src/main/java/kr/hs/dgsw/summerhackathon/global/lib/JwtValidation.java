package kr.hs.dgsw.summerhackathon.global.lib;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import kr.hs.dgsw.summerhackathon.global.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtValidation {
    private final JwtProperties jwtProperties;

    private final UserRepository userRepository;

    public User execute(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(jwtProperties.getSigningKey(jwtProperties.getSecretKey()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return userRepository.findByAccountId(claims.get("accountId", String.class))
                .orElseThrow(() -> new RuntimeException("d"));
    }
}
