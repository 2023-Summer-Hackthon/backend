package kr.hs.dgsw.summerhackathon.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserRequest {
    private String accountId;
    private String password;
}
