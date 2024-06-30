package top.anyel.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootOrmRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOrmRestApiApplication.class, args);
    }

}
