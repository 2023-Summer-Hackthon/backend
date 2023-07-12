package kr.hs.dgsw.summerhackathon.global.exception;

import kr.hs.dgsw.summerhackathon.global.exception.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(WelcomeException.class)
    public ResponseEntity<ExceptionResponse> welcomeException(WelcomeException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ExceptionResponse(e.getMessage()));
    }
}
