package kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.response;

import kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.response.AskResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestionDetailResponse {

    private String title;
    private String content;
    private String category;
    private List<AskResponse> askResponses;


}
