package com.pwit.companycrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CompanyCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyCrudApplication.class, args);
	}

}
