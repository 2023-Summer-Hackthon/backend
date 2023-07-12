package kr.hs.dgsw.summerhackathon.domain.user.exception;

import kr.hs.dgsw.summerhackathon.global.exception.WelcomeException;
import org.springframework.http.HttpStatus;

public class NotFoundUserException extends WelcomeException {
    public static final WelcomeException EXCEPTION = new NotFoundUserException();

    public NotFoundUserException() {
        super(HttpStatus.NOT_FOUND, "유저를 찾지 못했습니다");
    }
}
