package nl.cqit.function.poc.java.boxedhello.impl;

import nl.cqit.function.poc.java.boxedhello.api.BoxedHelloApi;
import nl.cqit.function.poc.java.boxedhello.api.model.Person;
import nl.cqit.function.poc.java.boxedhello.services.helloworld.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoxedHelloImpl implements BoxedHelloApi {

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public String sayHello(Person person) {
        String greeting = helloWorldService.sayHello(map(person));
        String horizontalEdge = "+" + "-".repeat(greeting.length() + 2) + "+";
        return horizontalEdge + "\n| " + greeting + " |\n" + horizontalEdge;
    }

    private nl.cqit.function.poc.java.helloworld.api.model.Person map(Person person) {
        return new nl.cqit.function.poc.java.helloworld.api.model
                .Person(person.getFirstName())
                .lastName(person.getLastName());
    }
}
