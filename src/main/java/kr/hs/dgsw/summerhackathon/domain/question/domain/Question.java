package kr.hs.dgsw.summerhackathon.domain.question.domain;

import kr.hs.dgsw.summerhackathon.domain.ask.domain.Ask;
import kr.hs.dgsw.summerhackathon.domain.question.domain.enums.Category;
import kr.hs.dgsw.summerhackathon.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String reward;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ask> asks = new HashSet<>();

    public void addAsk(Ask ask) {
        ask.setQuestion(this);
        asks.add(ask);
    }
}
