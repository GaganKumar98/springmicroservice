package com.bank.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Schema to hold Customer & Account information")
public class CustomerDto {

	@NotEmpty(message = "Name cannot be Null or Empty")
	@Size(min = 3, max = 30, message = "The length of the customer name should be between 3 and 30")
	@Schema(description = "Name of the Customer", example = "Abc")
	private String name;

	@NotEmpty(message = "Email cannot be Null or Empty")
	@Email(message = "Email should be of valid value")
	@Schema(description = "Email of the Customer", example = "Abc@abc.com")
	private String email;

	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number Should be of 10 Digit")
	@Schema(description = "Mobile Number of the Customer", example = "7788996655")
	private String mobileNumber;

	@Schema(description = "Account details of the Customer")
	private AccountsDto accountsDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AccountsDto getAccountsDto() {
		return accountsDto;
	}

	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String name, String email, String mobileNumber, AccountsDto accountsDto) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.accountsDto = accountsDto;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + ", accountsDto="
				+ accountsDto + "]";
	}

}
