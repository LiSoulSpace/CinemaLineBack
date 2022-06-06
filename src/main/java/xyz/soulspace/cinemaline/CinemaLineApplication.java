package xyz.soulspace.cinemaline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class CinemaLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaLineApplication.class, args);
    }

}
