package com.passwordmanager.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
//@EnableJpaRepositories("com.passwordmanager.*")
//@ComponentScan(basePackages = { "com.passwordmanager.*" })
//@EntityScan("com.passwordmanager.*")
public class PasswordManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(PasswordManagerApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("<b>Hello %s!</b>", name);
	}

}
