package com.bank.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Accounts", description = "Schema to hold Accounts information")
public class AccountsDto {

	@NotEmpty(message = "Account Number cannot be Null or Empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Account should be of 10 Digit")
	@Schema(description = "Account Number of the Customer")
	private Long accountNumber;

	@NotEmpty(message = "Account type Cannot be Null or Empty")
	@Schema(description = "Account Type of the Customer")
	private String accountType;

	@NotEmpty(message = "Account Branch Address cannot be Null or Empty")
	@Schema(description = "Branch Address of the Bank")
	private String branchAddress;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public AccountsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountsDto(Long accountNumber, String accountType, String branchAddress) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchAddress = branchAddress;
	}

}
