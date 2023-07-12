package kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AskResponse {
    private String content;
    private String accountId;
}
