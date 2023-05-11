package nl.cqit.function.poc.java.boxedhello.controller;


import nl.cqit.function.poc.java.boxedhello.impl.BoxedHelloImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class BoxedHelloController extends BoxedHelloImpl {

}
