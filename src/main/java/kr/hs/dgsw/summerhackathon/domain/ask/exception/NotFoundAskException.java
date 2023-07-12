package kr.hs.dgsw.summerhackathon.domain.ask.exception;

import kr.hs.dgsw.summerhackathon.global.exception.WelcomeException;
import org.springframework.http.HttpStatus;

public class NotFoundAskException extends WelcomeException{
    public static final WelcomeException EXCEPTION = new NotFoundAskException();

    public NotFoundAskException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않는 대답");
    }
}
