package kr.hs.dgsw.summerhackathon.domain.ask.domain;


import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Ask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Setter
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
