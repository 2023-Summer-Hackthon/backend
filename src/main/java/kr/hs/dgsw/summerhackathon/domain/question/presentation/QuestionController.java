package kr.hs.dgsw.summerhackathon.domain.question.presentation;

import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.response.QuestionDetailResponse;
import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.response.QuestionListResponse;
import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.request.CreateQuestionRequest;
import kr.hs.dgsw.summerhackathon.domain.question.service.QueryQuestionDetailService;
import kr.hs.dgsw.summerhackathon.domain.question.service.QueryQuestionListService;
import kr.hs.dgsw.summerhackathon.domain.question.service.RegisterQuestionService;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.global.annotation.AuthGuard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {

    private final RegisterQuestionService registerQuestionService;
    private final QueryQuestionListService queryQuestionListService;
    private final QueryQuestionDetailService queryQuestionDetailService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @AuthGuard
    public void registerQuestion(
            @RequestBody CreateQuestionRequest request,
            @RequestAttribute User user
    ) {
        registerQuestionService.execute(request, user);
    }

    @GetMapping("/list/{page}")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestionListResponse> getQuestionList(
            @PathVariable("page")  int page
    ) {
        return queryQuestionListService.getQuestionList(page);
    }

    @GetMapping("/{questionId}")
    public QuestionDetailResponse getDetailQuestion(
            @PathVariable("questionId") long questionId
    ) {
        return queryQuestionDetailService.execute(questionId);
    }
}
