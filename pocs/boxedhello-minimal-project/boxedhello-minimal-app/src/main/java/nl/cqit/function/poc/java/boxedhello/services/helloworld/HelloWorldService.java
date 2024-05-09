package nl.cqit.function.poc.java.boxedhello.services.helloworld;


import nl.cqit.function.poc.java.helloworld.api.HelloWorldApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "helloWorldService", url = "http://localhost:8080", configuration = HelloWorldServiceConfig.class)
public interface HelloWorldService extends HelloWorldApi {
}
