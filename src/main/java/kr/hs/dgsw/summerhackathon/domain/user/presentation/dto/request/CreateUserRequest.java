package kr.hs.dgsw.summerhackathon.domain.user.presentation.dto.request;

import kr.hs.dgsw.summerhackathon.domain.user.domain.enums.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUserRequest {
    private String accountId;

    private String password;

    private String name;

    private String phoneNumber;

    private String brith;

    private Gender gender;

    private String nationality;
}
