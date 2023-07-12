package kr.hs.dgsw.summerhackathon.domain.user.domain;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Embeddable;
@Getter
@DynamicInsert
@Embeddable
public class Cash {
    @ColumnDefault("0")
    private Long cash;

    public void add(long cash) {
        this.cash+= cash;
    }

    public void subtract(long cash) {
        this.cash-=cash;
    }
}
