package nl.cqit.function.poc.java;

import nl.cqit.function.poc.java.api.HelloWorldApi;
import nl.cqit.function.poc.java.api.model.Person;
import nl.cqit.function.poc.java.impl.HelloWorldImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HelloWorldImplTest {

    private final HelloWorldApi helloWorld = new HelloWorldImpl();

    @Test
    void greet() {
        // prepare
        Person person = new Person("John").lastName("Doe");

        // execute
        String actual = helloWorld.sayHello(person);

        // verify
        assertThat(actual, is("Hello, John Doe!"));
    }

    @Test
    void greet_noLastName() {
        // prepare
        Person person = new Person("John");

        // execute
        String actual = helloWorld.sayHello(person);

        // verify
        assertThat(actual, is("Hello, John!"));
    }
}