package nl.cqit.function.poc.java.boxedhello.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olga Maciaszek-Sharma
 */
@RestController
@RequestMapping("/")
public class SayHelloController {

	@RequestMapping(
			method = RequestMethod.POST,
			value = "/helloWorld",
			produces = {"application/json", "application/problem+json"},
			consumes = {"application/json"}
	)
	@ResponseStatus(HttpStatus.OK)
	String sayHello(
			@Valid @RequestBody Person person
	) {
		return "Hello, " + person.getFirstName();
	}
}
