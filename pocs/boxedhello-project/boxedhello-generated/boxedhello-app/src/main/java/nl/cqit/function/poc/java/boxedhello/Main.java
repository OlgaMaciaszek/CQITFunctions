package nl.cqit.function.poc.java.boxedhello;

import nl.cqit.function.poc.java.helloworld.controller.HelloWorldClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackageClasses = {HelloWorldClient.class})
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}