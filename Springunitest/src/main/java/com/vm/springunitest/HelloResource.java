package com.vm.springunitest;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloResource {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello world";
	}
}
