package kr.hs.dgsw.summerhackathon.domain.question.service;

import kr.hs.dgsw.summerhackathon.domain.ask.exception.NotFoundAskException;
import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.question.domain.repository.QuestionRepository;
import kr.hs.dgsw.summerhackathon.domain.question.presentation.dto.request.CreateQuestionRequest;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import kr.hs.dgsw.summerhackathon.domain.user.exception.NotEnoughRewardException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class RegisterQuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Transactional()
    public void execute(
            CreateQuestionRequest request,
            Long userId
    ) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> NotFoundAskException.EXCEPTION);

        if(user.getCash().getCash() < request.getReward()) {
            throw NotEnoughRewardException.EXCEPTION;
        }

        Question question = Question.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .reward(request.getReward())
                .category(request.getCategory())
                .build();

        user.addQuestion(question);
        questionRepository.save(question);
    }
}
