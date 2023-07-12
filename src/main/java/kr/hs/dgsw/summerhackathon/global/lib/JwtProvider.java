package kr.hs.dgsw.summerhackathon.global.lib;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.hs.dgsw.summerhackathon.global.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    private final JwtProperties jwtProperties;

    public String execute(
            String accountId
    ) {
        Claims claims = Jwts.claims();
        claims.put("accountId", accountId);
        Date now = new Date();
        Map<String, Object> header = new HashMap<>();
        header.put("type", "JWT");

        return Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getExp()))
                .signWith(jwtProperties.getSigningKey(jwtProperties.getSecretKey()), SignatureAlgorithm.HS256)
                .compact();
    }
}
