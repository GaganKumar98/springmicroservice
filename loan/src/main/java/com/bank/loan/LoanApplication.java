package com.bank.loan;

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
@OpenAPIDefinition(info = @Info(title = "Loans Microservices Rest Api Documentation", description = "Loans Microservice", version = "v1", contact = @Contact(name = "Abc", email = "abc@abc.com", url = "www.abc.com"), license = @License(name = "Apache 2.0", url = "www.abc.com")), externalDocs = @ExternalDocumentation(description = "Loans Microserices", url = "www.abc.com	"))
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
