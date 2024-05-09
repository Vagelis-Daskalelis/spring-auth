package gr.aueb.cf.springauthsessiion5;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringAuthSession5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthSession5Application.class, args);
    }

}
