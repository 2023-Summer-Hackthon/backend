package kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateAskRequest {
    private Long questionId;
    private String content;
}
