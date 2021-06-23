package com.vm.springunitest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

public class HelloResource {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello world";
	}
	
	@GetMapping(value ="/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent() {
		return new Student("abdul", 123);
	}
}
