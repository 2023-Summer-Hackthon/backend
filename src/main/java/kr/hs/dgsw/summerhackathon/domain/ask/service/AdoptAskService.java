package kr.hs.dgsw.summerhackathon.domain.ask.service;

import kr.hs.dgsw.summerhackathon.domain.ask.domain.Ask;
import kr.hs.dgsw.summerhackathon.domain.ask.domain.repository.AskRepository;
import kr.hs.dgsw.summerhackathon.domain.ask.exception.NotFoundAskException;
import kr.hs.dgsw.summerhackathon.domain.ask.exception.NotFoundQuestionException;
import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.question.domain.repository.QuestionRepository;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import kr.hs.dgsw.summerhackathon.domain.user.domain.repository.UserRepository;
import kr.hs.dgsw.summerhackathon.domain.user.exception.NotFoundUserException;
import kr.hs.dgsw.summerhackathon.global.exception.WelcomeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdoptAskService {

    private final QuestionRepository questionRepository;

    private final AskRepository askRepository;

    private final UserRepository userRepository;

    @Transactional
    public void execute(
            Long questionId,
            Long askId,
            Long userId
    ) {
        Ask ask = askRepository.findById(askId)
                .orElseThrow(() -> NotFoundAskException.EXCEPTION);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> NotFoundUserException.EXCEPTION);
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> NotFoundQuestionException.EXCEPTION);
        if(question.canManage(user)) {
            throw new WelcomeException(HttpStatus.BAD_REQUEST, "권한 없음");
        }
        processReward(question, user, ask);

    }

    private void processReward(Question question, User user, Ask ask) {
        int reward = Integer.parseInt(question.getReward());
        ask.getUser().getCash().add(reward);
        user.getCash().subtract(reward);
    }
}
