package cn.amosli.betterman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BetterManApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterManApplication.class, args);
    }

}
