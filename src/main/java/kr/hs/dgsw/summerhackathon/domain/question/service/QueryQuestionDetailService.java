package kr.hs.dgsw.summerhackathon.domain.question.service;

import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.question.domain.repository.QuestionRepository;
import kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.response.AskResponse;
import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.response.QuestionDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryQuestionDetailService {

    private final QuestionRepository questionRepository;

    @Transactional
    public QuestionDetailResponse execute(long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("질문 못차음"));

        return new QuestionDetailResponse(
                question.getTitle(),
                question.getContent(),
                question.getCategory().getValue(),
                question.getAsks().stream().map(it -> new AskResponse(it.getContent(), it.getUser().getAccountId())).collect(Collectors.toList())
                );
    }

}
