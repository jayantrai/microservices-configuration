package com.example.microservicesConfiguration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {
	
	// accessing property file using @Value annotation to display the value
	// if there is no value in the properties file, we can set default value using colon
	// the application will not fail 
	@Value("${my.greeting: default value}")
	private String greetingMessage;
	
	// another method 
	@Value("some static message")
	private String staticMessage;
	
	
	// if we want a list of values
	@Value("${my.list.values}")
	private List<String> listValues;
	
	 // to evaluate it as an expression
//	@Value("#{${dbValue}}")
//	private Map<String, String> dbValues;
//	
	@Autowired
	private DbSettings dbSettings;
	
	public GreetingController() {
		
	}
	
	@Autowired
	private Environment env;
	
	@GetMapping("/greeting")
	public String greeting() {
		return "my.greeting: " + greetingMessage + " db.connection: " + dbSettings.getConnection();
	}
	
	@GetMapping("/envdetails")
	public String[] envDetails() {
		return env.getActiveProfiles();
	}
}
