package kr.hs.dgsw.summerhackathon.domain.user.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Embeddable;
@DynamicInsert
@Embeddable
public class Cash {
    @ColumnDefault("0")
    private Long cash;

    public void add(Long cash) {
        this.cash+= cash;
    }

    public void subtract(Long cash) {
        this.cash-=cash;
    }
}
