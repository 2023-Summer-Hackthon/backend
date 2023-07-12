package kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenDto {
    private String accessToken;
}
