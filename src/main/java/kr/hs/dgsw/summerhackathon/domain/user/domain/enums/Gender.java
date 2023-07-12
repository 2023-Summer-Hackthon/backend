package kr.hs.dgsw.summerhackathon.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE("남자"),
    FEMALE("여지");

    private final String value;
}
