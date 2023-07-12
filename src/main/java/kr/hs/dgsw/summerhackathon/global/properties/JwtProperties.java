package kr.hs.dgsw.summerhackathon.global.properties;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {
    private String secretKey;
    private long exp;

    public Key getSigningKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
