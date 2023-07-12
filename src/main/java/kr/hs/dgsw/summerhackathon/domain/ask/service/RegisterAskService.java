package kr.hs.dgsw.summerhackathon.domain.ask.service;

import kr.hs.dgsw.summerhackathon.domain.ask.domain.Ask;
import kr.hs.dgsw.summerhackathon.domain.ask.exception.NotFoundQuestionException;
import kr.hs.dgsw.summerhackathon.domain.ask.presentation.dto.request.CreateAskRequest;
import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.question.domain.repository.QuestionRepository;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterAskService {

    private final QuestionRepository questionRepository;

    @Transactional
    public void execute(
            CreateAskRequest request
    ) {
        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> NotFoundQuestionException.EXCEPTION);

        Ask ask = Ask.builder()
                .content(request.getContent())
                .build();

        question.addAsk(ask);
        question.getUser().addQuestion(question);
    }

}
