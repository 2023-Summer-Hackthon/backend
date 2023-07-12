package kr.hs.dgsw.summerhackathon.domain.user.exception;

import kr.hs.dgsw.summerhackathon.global.exception.WelcomeException;
import org.springframework.http.HttpStatus;

public class NotEnoughRewardException extends WelcomeException {

    public static final WelcomeException EXCEPTION = new NotEnoughRewardException();

    public NotEnoughRewardException() {
        super(HttpStatus.BAD_REQUEST, "현재 가지고 있는 캐시가 충분하지 않습니다");
    }
}
