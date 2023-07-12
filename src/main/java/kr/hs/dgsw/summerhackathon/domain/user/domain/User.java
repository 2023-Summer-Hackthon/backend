package kr.hs.dgsw.summerhackathon.domain.user.domain;

import kr.hs.dgsw.summerhackathon.domain.ask.domain.Ask;
import kr.hs.dgsw.summerhackathon.domain.question.domain.Question;
import kr.hs.dgsw.summerhackathon.domain.user.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@Entity
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;

    private String password;

    private String name;

    private String phoneNumber;

    private String brith;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nationality;

    @Embedded
    private Cash cash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Question> questions = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Ask> asks = new HashSet<>();

    public void addQuestion(Question question) {
        question.setUser(this);
        questions.add(question);
    }

    public void addAsk(Ask ask) {
        ask.setUser(this);
        asks.add(ask);
    }
}
