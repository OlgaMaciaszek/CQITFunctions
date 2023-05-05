package nl.cqit.function.poc.java.boxedhello;

import nl.cqit.function.poc.java.boxedhello.api.model.Person;
import nl.cqit.function.poc.java.boxedhello.impl.BoxedHelloImpl;
import nl.cqit.function.poc.java.helloworld.controller.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class BoxedHelloImplTest {

    @Mock
    private HelloWorldService helloWorldService;

    @InjectMocks
    private BoxedHelloImpl helloWorld;

    @Test
    void greet() {
        // prepare
        Person person = new Person("John").lastName("Doe");
        nl.cqit.function.poc.java.helloworld.api.model.Person mappedPerson
                = new nl.cqit.function.poc.java.helloworld.api.model.Person("John").lastName("Doe");
        doReturn("Hello, John Doe!")
                .when(helloWorldService).sayHello(mappedPerson);

        // execute
        String actual = helloWorld.sayHello(person);

        // verify
        assertThat(actual, is(
                """
                        +------------------+
                        | Hello, John Doe! |
                        +------------------+"""
        ));
    }

    @Test
    void greet_noLastName() {
        // prepare
        Person person = new Person("John");
        nl.cqit.function.poc.java.helloworld.api.model.Person mappedPerson
                = new nl.cqit.function.poc.java.helloworld.api.model.Person("John");
        doReturn("Hello, John!")
                .when(helloWorldService).sayHello(mappedPerson);

        // execute
        String actual = helloWorld.sayHello(person);

        // verify
        assertThat(actual, is(
                """
                        +--------------+
                        | Hello, John! |
                        +--------------+"""
        ));
    }
}