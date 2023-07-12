package kr.hs.dgsw.summerhackathon.domain.question.service;

import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.question.domain.repository.QuestionRepository;
import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.request.CreateQuestionRequest;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class RegisterQuestionService {

    private final QuestionRepository questionRepository;



    @Transactional
    public void execute(
            CreateQuestionRequest request,
            User user
    ) {
        user.addQuestion(questionRepository.save(
                Question.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .reward(request.getReward())
                        .category(request.getCategory())
                        .build())
        );
    }
}
