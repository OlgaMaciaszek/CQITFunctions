package nl.cqit.function.poc.java.impl;

import nl.cqit.function.poc.java.api.HelloWorldApi;
import nl.cqit.function.poc.java.api.model.Person;

public class HelloWorldImpl implements HelloWorldApi {

    @Override
    public String sayHello(Person person) {
        if (person.getLastName() == null) {
            return "Hello, %s!".formatted(person.getFirstName());
        }
        return "Hello, %s %s!".formatted(person.getFirstName(), person.getLastName());
    }
}
