package kr.hs.dgsw.summerhackathon.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

@Getter
@AllArgsConstructor
public class WelcomeException extends RuntimeException{
    private final HttpStatus httpStatus;

    private final String message;
}
