package nl.cqit.function.poc.java.helloworld.controller;


import nl.cqit.function.poc.java.helloworld.api.HelloWorldApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "helloWorldClient", url = "http://localhost:8080")
public interface HelloWorldService extends HelloWorldApi {
}
