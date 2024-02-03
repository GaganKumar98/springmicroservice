package com.bank.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity {

	@Column(name ="customer_id")
	private Long customerId;
	
	@Id
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="branch_address")
	private String branchAddress;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

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

	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(Long customerId, Long accountNumber, String accountType, String branchAddress) {
		super();
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchAddress = branchAddress;
	}

	@Override
	public String toString() {
		return "Accounts [customerId=" + customerId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", branchAddress=" + branchAddress + "]";
	}
	
	
}
