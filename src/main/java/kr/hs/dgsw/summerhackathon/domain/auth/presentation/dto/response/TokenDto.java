package kr.hs.dgsw.summerhackathon.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenDto {
    private String accessToken;
}
