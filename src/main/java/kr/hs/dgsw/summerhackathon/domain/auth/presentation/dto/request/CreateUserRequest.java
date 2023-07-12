package kr.hs.dgsw.summerhackathon.domain.auth.presentation.dto.request;

import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.enums.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

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

    public User toEntity() {
        return User.builder()
                .accountId(accountId)
                .password(BCrypt.hashpw(password, BCrypt.gensalt()))
                .name(name)
                .phoneNumber(phoneNumber)
                .brith(brith)
                .gender(gender)
                .nationality(nationality)
                .build();
    }
}
