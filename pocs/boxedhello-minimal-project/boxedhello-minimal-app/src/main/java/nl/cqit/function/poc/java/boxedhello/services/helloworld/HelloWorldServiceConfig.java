package nl.cqit.function.poc.java.boxedhello.services.helloworld;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author Olga Maciaszek-Sharma
 */
public class HelloWorldServiceConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
