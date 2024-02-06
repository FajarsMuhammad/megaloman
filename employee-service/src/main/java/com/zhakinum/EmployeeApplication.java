package com.zhakinum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EmployeeApplication {
    private static void runApp(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    public static void main(String[] args) {
        try {
            runApp(args);
        } catch (Exception e) {
            if(e.getClass().getName().contains("SilentExitException")) {
                // https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-devtools
                log.debug("Spring is restarting the main thread - See spring-boot-devtools");
            } else {
                log.error("Application crashed!", e);
            }
        }
    }
}
