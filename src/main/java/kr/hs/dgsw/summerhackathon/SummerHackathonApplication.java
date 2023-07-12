package kr.hs.dgsw.summerhackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = "kr.hs.dgsw.summerhackathon.domain.chat.domain")
public class SummerHackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SummerHackathonApplication.class, args);
    }

}
