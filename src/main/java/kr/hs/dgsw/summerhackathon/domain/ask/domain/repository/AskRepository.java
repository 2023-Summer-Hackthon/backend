package kr.hs.dgsw.summerhackathon.domain.ask.domain.repository;

import kr.hs.dgsw.summerhackathon.domain.ask.domain.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {

}
