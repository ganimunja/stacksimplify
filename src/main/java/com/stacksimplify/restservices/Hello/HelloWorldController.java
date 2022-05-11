package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld()
	{
		return "Hello World";
	}
	@GetMapping("/helloworldbean")
	public UserDetails HelloWorldBean()
	{
		return new UserDetails("Gani","Goud","hyd");
	}
}
