package kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class QuestionListResponse {
    private Long questionId;
    private String title;
    private String accountId;
    private String category;
}
