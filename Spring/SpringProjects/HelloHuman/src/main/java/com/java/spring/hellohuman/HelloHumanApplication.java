package com.java.spring.hellohuman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
		
	}
	
	@RequestMapping("/")
	public String index(@RequestParam(value="first_name", required=false) String first_name, @RequestParam(value="last_name", required=false) String last_name, @RequestParam(value="times", required=false) Integer times) {
		
		String full_name;
		if(first_name == null && last_name == null) {
			full_name = "Human";
		} else if (first_name != null && last_name != null) {
			full_name = first_name + " " + last_name;
		} else {
			full_name = first_name == null ? last_name : first_name;
		}
		String result = "\nHello " + full_name + "!";
		if (times == null) {
			return result;
		} else {
			return result.repeat(times);
		}
	}

}
