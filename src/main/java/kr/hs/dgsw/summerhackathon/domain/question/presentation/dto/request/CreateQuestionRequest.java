package kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.request;

import kr.hs.dgsw.summerhackathon.domain.question.domain.enums.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateQuestionRequest {
    private String title;
    private String content;
    private Category category;
    private String reward;
}
