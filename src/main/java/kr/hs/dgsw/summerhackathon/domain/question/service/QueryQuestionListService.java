package kr.hs.dgsw.summerhackathon.domain.question.service;

import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.question.domain.repository.QuestionRepository;
import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.response.QuestionListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryQuestionListService {

    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public List<QuestionListResponse> getQuestionList(int page) {
        Page<Question> questionPage = questionRepository.findAll(PageRequest.of(page - 1, 5));
        return questionPage.stream().map(
                it -> new QuestionListResponse(it.getId(), it.getTitle(), it.getUser().getAccountId(), it.getCategory().getValue())
        ).collect(Collectors.toList());
    }


}
