package kr.hs.dgsw.summerhackathon.domain.question.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Category {
    LANGUAGE("언어"),
    CULTURE("문화"),
    FOOD("음식"),
    HEALTH("건강"),
    TREND("트랜드");

    private final String value;

}
