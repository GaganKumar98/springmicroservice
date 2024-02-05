package com.bank.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Cards microservice REST API Documentation", description = "Cards microservice REST API Documentation", version = "v1", contact = @Contact(name = "Abc", email = "abc@abc.com", url = "www.abc.com"), license = @License(name = "Apache 2.0", url = "www.abc.com")), externalDocs = @ExternalDocumentation(description = "Cards microservice REST API Documentation", url = "www.abc.com"))
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}

}
