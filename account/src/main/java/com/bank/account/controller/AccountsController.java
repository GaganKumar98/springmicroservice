package com.bank.account.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.constants.AccountsConstants;
import com.bank.account.dto.AccountContactInfoDto;
import com.bank.account.dto.CustomerDto;
import com.bank.account.dto.ErrorResponseDto;
import com.bank.account.dto.ResponseDto;
import com.bank.account.service.IAccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Tag(name = "CRUD REST APIs for Accounts", description = "CRUD REST API's - CREATE,READ,UPDATE,FETCH & DELETE accounts details")
@RestController
@RequestMapping("/api")
@Validated
public class AccountsController {

	@Value("${build.version}")
	private String buildVersion;

	@Autowired
	private Environment environment;

	@Autowired
	private AccountContactInfoDto accountContactInfoDto;

	@Autowired
	private IAccountsService accountsService;

	@Operation(summary = "Create Account", description = "REST API to create the new Customer & Account")
	@ApiResponse(responseCode = "201", description = "HTTP Status Created")
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccounts(@Valid @RequestBody CustomerDto customerDto) {
		accountsService.createAccounts(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}

	@Operation(summary = "Fetch Account Details REST API", description = "REST API to fetch Customer &  Account details based on a mobile number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchAccountDetails(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number Should be of 10 Digit") String mobileNumber) {
		CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}

	@Operation(summary = "Update Account Details REST API", description = "REST API to update Customer &  Account details based on a account number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
		boolean isUpdated = accountsService.updateAccount(customerDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		}

		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
				.body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
	}

	@Operation(summary = "Delete Account & Customer Details REST API", description = "REST API to delete Customer &  Account details based on a mobile number")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "417", description = "Expectation Failed"),
			@ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam

	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number Should be of 10 Digit") String mobileNumber) {
		boolean isDeleted = accountsService.deleteAccounts(mobileNumber);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
				.body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
	}

	@Operation(summary = "Build Info", description = "REST API to get the build info")
	@ApiResponse(responseCode = "200", description = "HTTP Status Ok")
	@GetMapping("buildinfo")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}

	@Operation(summary = "Java Version", description = "REST API to get the Java Version")
	@ApiResponse(responseCode = "200", description = "HTTP Status Ok")
	@GetMapping("javaversion")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("Path"));
	}

	@Operation(summary = "Contact Info", description = "REST API to get the Contact Info")
	@ApiResponse(responseCode = "200", description = "HTTP Status Ok")
	@GetMapping("contactinfo")
	public ResponseEntity<AccountContactInfoDto> getContactInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(accountContactInfoDto);
	}
}
