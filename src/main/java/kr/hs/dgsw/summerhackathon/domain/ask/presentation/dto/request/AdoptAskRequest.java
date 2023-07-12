package kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdoptAskRequest {
    private Long questionId;
    private Long askId;
}
