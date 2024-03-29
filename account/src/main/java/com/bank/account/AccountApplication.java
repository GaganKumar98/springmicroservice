package com.bank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.bank.account.dto.AccountContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = { AccountContactInfoDto.class })
@OpenAPIDefinition(info = @Info(title = "Account Microservices Rest Api Documentation", description = "Account Microservice", version = "v1", contact = @Contact(name = "Abc", email = "abc@abc.com", url = "www.abc.com"), license = @License(name = "Apache 2.0", url = "www.abc.com")), externalDocs = @ExternalDocumentation(description = "Account Microserices", url = "www.abc.com	"))
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
