package nl.cqit.function.poc.java.boxedhello.controller;


import nl.cqit.function.poc.java.boxedhello.services.helloworld.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/")
public class BoxedHelloController {

	@Autowired
	HelloWorldService service;

	@GetMapping
	String hello() {
		Person person = new Person("test");
		return service.sayHello(person);
	}

}
